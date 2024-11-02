package ru.dorogov.web1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dorogov.web1.tables.Article;


public interface ArticleRepo extends JpaRepository<Article, Integer> {
}
