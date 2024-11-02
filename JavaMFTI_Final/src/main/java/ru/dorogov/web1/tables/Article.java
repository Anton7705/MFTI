package ru.dorogov.web1.tables;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    public Article(String title, String body, Integer score) {
        this.title = title;
        this.body = body;
        this.score = score;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String title;
    @Column(length = 1000)
    String body;
    Integer score;

    public void setScore(Integer score) {
        if (score >= 1 && score<=5) {
            this.score = score;
        }
    }
}
