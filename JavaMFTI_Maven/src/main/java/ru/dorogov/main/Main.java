package ru.dorogov.main;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import ru.dorogov.jdbc.*;

import javax.sql.DataSource;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        try {
            DbSelector.connection = DriverManager.getConnection("jdbc:h2:.\\Office");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ApplicationContext applicationContex = new AnnotationConfigApplicationContext("ru.dorogov.jdbc");
        DbSelector dbSelector = applicationContex.getBean(DbSelector.class);
        List<Employee> emps = dbSelector.findAll(Employee.class);
        emps.forEach(System.out::println);
        System.out.println("----");
    }
}

//
//    @Bean
//    DataSource dataSource() {
//        JdbcDataSource jdbcDataSource = new JdbcDataSource();
//        jdbcDataSource.setURL("jdbc:h2:.\\Office");
//        return jdbcDataSource;
//    }
//
//    public static void main(String[] args) {
//        ApplicationContext applicationContext = SpringApplication.run(Starter.class);
//        EmployeeRepo repo = applicationContext.getBean(EmployeeRepo.class);
//        List<Employee> list = repo.findAll();
//        list.forEach(System.out::println);
//    }
//}