package ru.dorogov.jdbc;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.sql.ResultSet;

@Component
public class IntegerHandler implements Handler{
    @SneakyThrows
    public void make(Field f, Object resObject, ResultSet res, String columnName) {
        f.set(resObject, res.getInt(columnName));
    }

    @Override
    public Class<Integer> getType() {
        return Integer.class;
    }
}
