package ru.dorogov.jdbc;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.util.List;

@SpringBootApplication
public class Main {

    @Bean
    DataSource dataSource() {
        JdbcDataSource jdbcDataSource= new JdbcDataSource();
        jdbcDataSource.setURL("jdbc:h2:.\\Office");
        return jdbcDataSource;
    }


    public static void main(String[] args) {
        DBCreationScript.createDB();
        ApplicationContext applicationContext = SpringApplication.run(Main.class);
        SQLMethods.playerRepo = applicationContext.getBean(PlayerRepo.class);
        SQLMethods.m1();
//        PlayerRepo repo = applicationContext.getBean(PlayerRepo.class);
//        Player player = repo.findById("Tom").get();
//        repo.delete(player);
//        List<Player> emp = repo.findAll();
//        emp.forEach(System.out::println);

    }
}
