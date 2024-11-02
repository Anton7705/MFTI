package ru.dorogov.web1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.dorogov.web1.repo.ArticleRepo;
import ru.dorogov.web1.repo.GameRepo;
import ru.dorogov.web1.tables.Article;
import ru.dorogov.web1.tables.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class GameController {
    @Autowired
    GameRepo gameRepo;

    List<Game> toList(Integer id) {
        Optional<Game> game = gameRepo.findById(id);
        ArrayList<Game> list = new ArrayList<>();
        game.ifPresent(list::add);
        return list;
    }

    @GetMapping("/game")
    public String allGames (Model model) {
        model.addAttribute("games", gameRepo.findAll());
        return "gameMain";
    }

    @GetMapping("/game/addRoot")
    public String addGameRoot (Model model) {
        return "gameAddRoot";
    }

    @PostMapping("/game/addRoot")
    public String gameChangeRoot (@RequestParam("name") String name,
                                     @RequestParam("price") Integer price) {
        Game game = new Game(name, price);
        gameRepo.save(game);
        return "redirect:/root";
    }

    @GetMapping("/gameRoot")
    public String gameRoot (Model model) {
        model.addAttribute("games", gameRepo.findAll());
        return "gameMainRoot";
    }

    @GetMapping("/gameInfoRoot/{id}")
    public String gameInfoRoot (@PathVariable(value = "id") Integer id, Model model) {
        if (!gameRepo.existsById(id)) {
            return "homeRoot";
        }
        model.addAttribute("gameInf", toList(id));
        return "gameInfoRoot";
    }

    @GetMapping("/game/{id}/edit")
    public String gameEdit (@PathVariable(value = "id") Integer id, Model model) {
        if (!gameRepo.existsById(id)) {
            return "homeRoot";
        }
        model.addAttribute("gameInf", toList(id));
        return "gameEditRoot";
    }

    @PostMapping("/game/{id}/edit")
    public String gameUpdateRoot (@RequestParam("name") String name,
                                     @RequestParam("price") Integer price,@PathVariable(value = "id") Integer id) {
        Game game = gameRepo.findById(id).orElseThrow();
        game.setName(name);
        game.setPrice(price);
        gameRepo.save(game);
        return "redirect:/root";
    }

    @GetMapping("/game/{id}/remove")
    public String gameDeleteRoot (@PathVariable(value = "id") Integer id) {
        Game game = gameRepo.findById(id).orElseThrow();
        gameRepo.delete(game);
        return "redirect:/root";
    }

    @GetMapping("/game/{id}")
    public String methodForFuture () {
        return "gameBuyingForFuture";
    }
}
