package ru.dorogov.reflection;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class MyConfig {

    Integer defaultForInt() {
        return 23;
    }

    String defaultForString () {
        return "AAAAA";
    }

}

