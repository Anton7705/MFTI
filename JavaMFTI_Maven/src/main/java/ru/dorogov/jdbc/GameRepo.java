package ru.dorogov.jdbc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

public interface GameRepo extends JpaRepository<Game, String> {
}
