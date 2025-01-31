package ru.dorogov.jdbc;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Entity
@ToString
@Component
public class Game {
    @Id
    String name;
    Integer cost;
    Integer count;

    void s () {
        System.out.println("a");
    }
}
