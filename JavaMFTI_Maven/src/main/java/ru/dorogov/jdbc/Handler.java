package ru.dorogov.jdbc;

import java.lang.reflect.Field;
import java.sql.ResultSet;

public interface Handler {
    void make (Field f, Object resObject, ResultSet res, String columnName);
    Class<?> getType();
}
