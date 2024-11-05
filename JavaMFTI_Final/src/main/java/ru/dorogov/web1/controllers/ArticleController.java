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

    @Autowired
    ArticleService articleService;

    @GetMapping("/article")
    public String article (Model model) {
        return articleService.article(model);
    }

    @GetMapping("/article/addRoot")
    public String articleRoot () {
        return "articleAddRoot";
    }

    @PostMapping("/article/addRoot")
    public String articleChangeRoot (@RequestParam("title") String title,
                                     @RequestParam("body") String body,
                                     @RequestParam("score") Integer score) {
        return articleService.articleChangeRoot(title, body, score);
    }

    @Transactional
    @PostMapping("/article/{id}/edit")
    public String articleUpdateRoot (@RequestParam("title") String title,
                                     @RequestParam("body") String body,
                                     @RequestParam("score") Integer score,@PathVariable(value = "id") Integer id) {
        Article article = articleRepo.findById(id).orElseThrow(() -> new ArticleDoesNotExistException(id));
        return articleService.articleUpdateRoot(article,title,body,score);
    }

    @Transactional
    @PostMapping("/article/{id}/remove")
    public String articleDeleteRoot (@PathVariable(value = "id") Integer id) {
        Article article = articleRepo.findById(id).orElseThrow(() -> new ArticleDoesNotExistException(id));
        return articleService.articleDeleteRoot(article);
    }


    @GetMapping("/article/{id}")
    public String articleInfo (@PathVariable(value = "id") Integer id, Model model) {
        if (!articleRepo.existsById(id)) {
            return "home";
        }
        return articleService.articleInfo(id, model);
    }

    @GetMapping("/articleMainRoot")
    public String articleInfoRoot (Model model) {
        return articleService.articleInfoRoot(model);
    }

    @GetMapping("/articleInfoRoot/{id}")
    public String articleInfoRootId (@PathVariable(value = "id") Integer id, Model model) {
        if (!articleRepo.existsById(id)) {
            return "homeRoot";
        }
        return articleService.articleInfoRootId(id, model);
    }

    @GetMapping("/article/{id}/edit")
    public String articleEdit (@PathVariable(value = "id") Integer id, Model model) {
        if (!articleRepo.existsById(id)) {
            return "homeRoot";
        }
        return articleService.articleEdit(id, model);
    }
}
