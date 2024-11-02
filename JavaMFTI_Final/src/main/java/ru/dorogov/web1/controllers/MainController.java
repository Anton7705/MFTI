package ru.dorogov.web1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.dorogov.web1.repo.ArticleRepo;

@Controller
public class MainController {


    @GetMapping("/")
    public String home (Model model) {
        model.addAttribute("title", "DorogovGames");
        return "home";
    }

    @GetMapping("/root")
    public String homeRoot (Model model) {
        model.addAttribute("title", "DorogovGames");
        return "homeRoot";
    }

}
