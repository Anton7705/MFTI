package ru.dorogov.jdbc;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.ToString;

@ToString
@Entity
@MyTable("Employee")
public class Employee {
    @Id
    @ColumnName("id")
    Integer id12;
    @ColumnName("name")
    String name12;
    @ColumnName("departmentID")
    String departmentID2;
}


