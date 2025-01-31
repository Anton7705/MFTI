package ru.dorogov.jdbc;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SQLMethods {
    @Autowired
    static PlayerRepo playerRepo;

//    @Transactional
    public static void m1 () {
        List<Player> emp = playerRepo.findAll();
        emp.forEach(System.out::println);
    }
}
