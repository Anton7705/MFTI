package ru.dorogov.jdbc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

public interface PlayerRepo extends JpaRepository<Player, String> {

//    List<Employee> findAllByDepartmentID(String s);


//    @Query(value = "Select * from Player where Balance = ?1 AND Login = ?2", nativeQuery = true)
//    List<Player> MySQL(Integer i1, String s1);
}
