package ru.dorogov.jdbc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class DbSelector {
    @Autowired
    public static Connection connection;

    private HashMap<Class<?>, Handler> hashMap = new HashMap<>();

    @Autowired
    public DbSelector(ApplicationContext context) {
        hashMap.put(String.class, context.getBean(StringHandler.class));
        hashMap.put(Integer.class, context.getBean(IntegerHandler.class));
    }

    private String getTableName(Class<?> clz) {
        MyTable annotation = clz.getAnnotation(MyTable.class);
        if (annotation != null) {
            return annotation.value();
        } return clz.getSimpleName();
    }

    private String getColumnName(Field f) {
        if (f.isAnnotationPresent(ColumnName.class)) {
            ColumnName columnNameAnnotation = f.getAnnotation(ColumnName.class);
            return columnNameAnnotation.value();
        } else return f.getName();
    }


    public <T> List<T> findAll(Class<T> clz) {
        String tableName = getTableName(clz);
        String columnName;
        Field fields[] = clz.getDeclaredFields();
        List<T> resList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet res = statement.executeQuery("Select * from " + tableName);
            while (res.next()) {
                T resObject = clz.newInstance();
                resList.add(resObject);
                for (Field f : fields) {
                    columnName = getColumnName(f);
                    Handler handler = hashMap.get(f.getType());
                    if (handler != null) {
                        handler.make(f, resObject, res, columnName);
                    } else f.set(resObject, res.getObject(columnName));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return resList;
    }
}
