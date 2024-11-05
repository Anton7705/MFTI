package ru.dorogov.web1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GameDoesNotExistException extends RuntimeException {
    public GameDoesNotExistException(Integer id) {
        super("Game " + id + " does not exist.");
    }
}
