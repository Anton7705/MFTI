package ru.dorogov.reflection;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ResseterPostProcessor implements BeanPostProcessor {
    @Autowired
    ApplicationContext applicationContext;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(Default.class)) {
            String defName = bean.getClass().getAnnotation(Default.class).value();
            Object object = applicationContext.getBean(defName);
            Resetter.reset(object, bean);
            return bean;
        }
        return bean;
    }

}
