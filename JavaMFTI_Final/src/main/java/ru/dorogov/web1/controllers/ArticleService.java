package ru.dorogov.web1.controllers;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.dorogov.web1.exceptions.ArticleDoesNotExistException;
import ru.dorogov.web1.repo.ArticleRepo;
import ru.dorogov.web1.repo.GameRepo;
import ru.dorogov.web1.tables.Article;
import ru.dorogov.web1.tables.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    @Autowired
    ArticleRepo articleRepo;

    List<Article> toList(Integer id) {
        Optional<Article> article = articleRepo.findById(id);
        ArrayList<Article> list = new ArrayList<>();
        article.ifPresent(list::add);
        return list;
    }


    public String article (Model model) {
        model.addAttribute("articles", articleRepo.findAll());
        return "articleMain";
    }

    public String articleChangeRoot (String title,String body, Integer score) {
        Article article = new Article(title, body, score);
        articleRepo.save(article);
        return "redirect:/root";
    }

    @Transactional
    public String articleUpdateRoot (Article article, String title,
                                     String body, Integer score) {
        article.setScore(score);
        article.setBody(body);
        article.setTitle(title);
        articleRepo.save(article);
        return "redirect:/root";
    }

    @Transactional
    public String articleDeleteRoot (Article article) {
        articleRepo.delete(article);
        return "redirect:/root";
    }

    public String articleInfo (Integer id, Model model) {
        model.addAttribute("articleInf", toList(id));
        return "articleInfo";
    }

    public String articleInfoRoot (Model model) {
        model.addAttribute("articles", articleRepo.findAll());
        return "articleMainRoot";
    }

    public String articleInfoRootId (Integer id, Model model) {
        model.addAttribute("articleInf", toList(id));
        return "articleInfoRoot";
    }

    public String articleEdit (Integer id, Model model) {
        model.addAttribute("articleInf", toList(id));
        return "articleEditRoot";
    }
}
