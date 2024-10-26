package ru.dorogov.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Configuration
public class Con {

    @Bean
    Connection connection () throws SQLException {
        return DriverManager.getConnection("jdbc:h2:.\\Office");
    }
}
