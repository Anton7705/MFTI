package ru.dorogov.web;


import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dorogov.geometry.Point;

@RestController
public class HelloRest {

    @GetMapping("/datahello")
    public Point handle() {
        return new Point(1,2 );
    }
}
