package ru.dorogov.main;

import lombok.SneakyThrows;
import org.h2.jdbcx.JdbcDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import ru.dorogov.jdbc.Employee;
import ru.dorogov.jdbc.EmployeeRepo;
import ru.dorogov.workers.Department;

import javax.sql.DataSource;
import java.util.List;

@SpringBootApplication
@ComponentScan("ru.dorogov.web")
public class Starter {

    @SneakyThrows
    public static void main(String[] args) {
        SpringApplication.run(Starter.class);
    }
}