package ru.dorogov.web1.controllers;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.dorogov.web1.exceptions.ArticleDoesNotExistException;
import ru.dorogov.web1.repo.ArticleRepo;
import ru.dorogov.web1.tables.Article;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ArticleController {
    @Autowired
    ArticleRepo articleRepo;

    List<Article> toList(Integer id) {
        Optional<Article> article = articleRepo.findById(id);
        ArrayList<Article> list = new ArrayList<>();
        article.ifPresent(list::add);
        return list;
    }

    @GetMapping("/article")
    public String article (Model model) {
        model.addAttribute("articles", articleRepo.findAll());
        return "articleMain";
    }

    @GetMapping("/article/addRoot")
    public String articleRoot (Model model) {
        return "articleAddRoot";
    }

    @PostMapping("/article/addRoot")
    public String articleChangeRoot (@RequestParam("title") String title,
                                     @RequestParam("body") String body,
                                     @RequestParam("score") Integer score) {
        Article article = new Article(title, body, score);
        articleRepo.save(article);
        return "redirect:/root";
    }

    @Transactional
    @PostMapping("/article/{id}/edit")
    public String articleUpdateRoot (@RequestParam("title") String title,
                                     @RequestParam("body") String body,
                                     @RequestParam("score") Integer score,@PathVariable(value = "id") Integer id) {
        Article article = articleRepo.findById(id).orElseThrow();
        article.setScore(score);
        article.setBody(body);
        article.setTitle(title);
        articleRepo.save(article);
        return "redirect:/root";
    }

    @Transactional
    @PostMapping("/article/{id}/remove")
    public String articleDeleteRoot (@PathVariable(value = "id") Integer id) {
        Article article = articleRepo.findById(id).orElseThrow(() -> new ArticleDoesNotExistException(id));
        articleRepo.delete(article);
        return "redirect:/root";
    }


    @GetMapping("/article/{id}")
    public String articleInfo (@PathVariable(value = "id") Integer id, Model model) {
        if (!articleRepo.existsById(id)) {
            return "home";
        }
        model.addAttribute("articleInf", toList(id));
        return "articleInfo";
    }

    @GetMapping("/articleMainRoot")
    public String articleInfoRoot (Model model) {
        model.addAttribute("articles", articleRepo.findAll());
        return "articleMainRoot";
    }

    @GetMapping("/articleInfoRoot/{id}")
    public String articleInfoRootId (@PathVariable(value = "id") Integer id, Model model) {
        if (!articleRepo.existsById(id)) {
            return "homeRoot";
        }
        model.addAttribute("articleInf", toList(id));
        return "articleInfoRoot";
    }

    @GetMapping("/article/{id}/edit")
    public String articleEdit (@PathVariable(value = "id") Integer id, Model model) {
        if (!articleRepo.existsById(id)) {
            return "homeRoot";
        }
        model.addAttribute("articleInf", toList(id));
        return "articleEditRoot";
    }
}
