package ru.dorogov.web1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dorogov.web1.tables.Game;

public interface GameRepo extends JpaRepository<Game, Integer> {
}
