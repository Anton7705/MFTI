package ru.dorogov.jdbc;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;


public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    List<Employee> findAllByDepartmentID(String s);


    @Query(value = "Select * from Employee where departmentID = ?1 AND name = ?2", nativeQuery = true)
    List<Employee> MySQL(String s1, String s2);
}
