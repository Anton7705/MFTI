package ru.dorogov.web1;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebStarter {

    @SneakyThrows
    public static void main(String[] args) {
        SpringApplication.run(WebStarter.class);
    }
}