package ru.dorogov.jdbc;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import ru.dorogov.reflection.A;
import ru.dorogov.reflection.MyConfig;

import javax.sql.DataSource;

@SpringBootApplication
public class Main {
    @Bean
    DataSource dataSource() {
        JdbcDataSource jdbcDataSource= new JdbcDataSource();
        jdbcDataSource.setURL("jdbc:h2:.\\Office");
        return jdbcDataSource;
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("ru.dorogov.jdbc");
        DbSelector dbSelector = ctx.getBean(DbSelector.class);
        System.out.println(dbSelector.findAll(Employee.class));
//        ApplicationContext applicationContext = SpringApplication.run(Main.class);
//        System.out.println(applicationContext.getBean("dataSource"));
//        EmployeeRepo repo = applicationContext.getBean(EmployeeRepo.class);
//        List<Employee> emp = repo.findAll();
//        emp.forEach(System.out::println);

    }
}
