package ru.dorogov.jdbc;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
