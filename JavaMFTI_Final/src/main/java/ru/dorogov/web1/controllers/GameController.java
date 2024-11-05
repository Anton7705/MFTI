package ru.dorogov.web1.controllers;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.dorogov.web1.exceptions.GameDoesNotExistException;
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

    @Autowired
    GameService gameService;

    @GetMapping("/game")
    public String allGames (Model model) {
        return gameService.allGames(model);
    }

    @GetMapping("/game/addRoot")
    public String addGameRoot () {
        return "gameAddRoot";
    }

    @PostMapping("/game/addRoot")
    public String gameChangeRoot (@RequestParam("name") String name,
                                     @RequestParam("price") Integer price) {
        return gameService.gameChangeRoot(name, price);
    }

    @GetMapping("/gameRoot")
    public String gameRoot (Model model) {
        return gameService.gameRoot(model);
    }

    @GetMapping("/gameInfoRoot/{id}")
    public String gameInfoRoot (@PathVariable(value = "id") Integer id, Model model) {
        if (!gameRepo.existsById(id)) {
            return "homeRoot";
        }
        return gameService.gameInfoRoot(id, model);
    }

    @GetMapping("/game/{id}/edit")
    public String gameEdit (@PathVariable(value = "id") Integer id, Model model) {
        if (!gameRepo.existsById(id)) {
            return "homeRoot";
        }
        return gameService.gameEdit(id, model);
    }

    @Transactional
    @PostMapping("/game/{id}/edit")
    public String gameUpdateRoot (@RequestParam("name") String name,
                                     @RequestParam("price") Integer price,@PathVariable(value = "id") Integer id) {
        Game game = gameRepo.findById(id).orElseThrow(() -> new GameDoesNotExistException(id));
        return gameService.gameUpdateRoot(game, name, price);
    }

    @Transactional
    @PostMapping("/game/{id}/remove")
    public String gameDeleteRoot (@PathVariable(value = "id") Integer id) {
        Game game = gameRepo.findById(id).orElseThrow(() -> new GameDoesNotExistException(id));
        return gameService.gameDeleteRoot(game);
    }

    @GetMapping("/game/{id}")
    public String methodForFuture () {
        return "gameBuyingForFuture";
    }
}
