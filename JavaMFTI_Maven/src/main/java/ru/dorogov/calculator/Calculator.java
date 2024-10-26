package ru.dorogov.calculator;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Component
@ToString
public class Calculator {
    @Autowired
    @Qualifier("generate")
    Supplier<DTO> generate;

    @Autowired
    Map<String, BinaryOperator<Integer>> map;

    @Autowired
    List<Function> lst;

    @Autowired(required = false)
    Consumer<DTO> consumer;

    public void calc () {
        DTO obj = generate.get();
        obj.res = map.get(obj.op).apply(obj.x, obj.y);
        consumer.accept(obj);
    }
}
