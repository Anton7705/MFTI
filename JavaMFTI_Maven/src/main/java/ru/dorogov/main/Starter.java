package ru.dorogov.main;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ru.dorogov.web")
public class Starter {

    @SneakyThrows
    public static void main(String[] args) {
        SpringApplication.run(Starter.class);
    }
}