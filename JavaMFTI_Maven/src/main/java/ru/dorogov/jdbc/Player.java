package ru.dorogov.jdbc;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.ToString;
import org.springframework.stereotype.Component;

@ToString
@Entity
@Component
public class Player {
    @Id
    String login;
    Integer balance;
    @ManyToOne(targetEntity = Game.class)
    @JoinColumn(name = "game")
    Game game;
}


