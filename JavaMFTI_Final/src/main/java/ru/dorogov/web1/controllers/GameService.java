package ru.dorogov.web1.controllers;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.dorogov.web1.exceptions.GameDoesNotExistException;
import ru.dorogov.web1.repo.GameRepo;
import ru.dorogov.web1.tables.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    @Autowired
    GameRepo gameRepo;

    List<Game> toList(Integer id) {
        Optional<Game> game = gameRepo.findById(id);
        ArrayList<Game> list = new ArrayList<>();
        game.ifPresent(list::add);
        return list;
    }

    public String allGames (Model model) {
        model.addAttribute("games", gameRepo.findAll());
        return "gameMain";
    }

    public String gameRoot (Model model) {
        model.addAttribute("games", gameRepo.findAll());
        return "gameMainRoot";
    }

    public String gameInfoRoot (Integer id, Model model) {
        model.addAttribute("gameInf", toList(id));
        return "gameInfoRoot";
    }

    public String gameEdit (Integer id, Model model) {
        model.addAttribute("gameInf", toList(id));
        return "gameEditRoot";
    }

    @Transactional
    public String gameUpdateRoot (Game game,String name,Integer price) {
        game.setName(name);
        game.setPrice(price);
        gameRepo.save(game);
        return "redirect:/root";
    }

    @Transactional
    public String gameDeleteRoot (Game game) {
        gameRepo.delete(game);
        return "redirect:/root";
    }


    public String gameChangeRoot (String name,Integer price) {
        Game game = new Game(name, price);
        gameRepo.save(game);
        return "redirect:/root";
    }
}
