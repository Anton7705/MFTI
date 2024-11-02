package ru.dorogov.web1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutUsController {
    @GetMapping("/about")
    public String about (Model model) {
        model.addAttribute("title", "Добро пожаловать в DorogovGames - место, где игроки всех мастей найдут информацию о самых интересных играх, свежие новости, рецензии, гайды и многое другое!\n" +
                "\nПо всем вопросам, связанным с работой сайта и покупки игр обращайтесь к нашему админу в телеграмм чате @FakeAccount");
        return "about";
    }
}
