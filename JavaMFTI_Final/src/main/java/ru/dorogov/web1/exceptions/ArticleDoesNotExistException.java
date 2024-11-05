package ru.dorogov.web1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ArticleDoesNotExistException extends RuntimeException{
    public ArticleDoesNotExistException(Integer id){
        super("Article " + id + " does not exist.");
    }
}