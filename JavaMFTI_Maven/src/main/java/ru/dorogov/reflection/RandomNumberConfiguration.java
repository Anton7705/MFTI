package ru.dorogov.reflection;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RandomNumberConfiguration {

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void checkAndAddRandomBean() {
        String[] beanNames = applicationContext.getBeanNamesForType(RandomNumber.class);
        boolean randomBeanExists = false;

        for (String beanName : beanNames) {
            if ("randomNumber".equals(beanName)) {
                randomBeanExists = true;
                break;
            }
        }

        if (!randomBeanExists) {
            applicationContext.getAutowireCapableBeanFactory().initializeBean(new RandomNumber(), "randomNumbe");
        }
    }
}


