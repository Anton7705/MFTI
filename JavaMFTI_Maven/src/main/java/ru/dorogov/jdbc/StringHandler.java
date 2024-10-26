package ru.dorogov.jdbc;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.sql.ResultSet;

@Component
public class StringHandler implements Handler {
    @SneakyThrows
    public void make(Field f, Object resObject, ResultSet res, String columnName) {
        f.set(resObject, res.getString(columnName));
    }

    @Override
    public Class<String> getType() {
        return String.class;
    }
}
