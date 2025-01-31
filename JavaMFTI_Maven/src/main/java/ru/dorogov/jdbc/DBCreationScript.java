package ru.dorogov.jdbc;

import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class DBCreationScript {

    public static void createDB() {
        try (Connection con = DriverManager.getConnection("jdbc:h2:.\\Office")) {
            Statement stm = con.createStatement();
            stm.executeUpdate("DROP TABLE Game IF EXISTS");
            stm.executeUpdate("CREATE TABLE Game(NAME VARCHAR(255) PRIMARY KEY, COST INT, COUNT INT)");
            stm.executeUpdate("INSERT INTO Game VALUES('Call of duty 1', 100, 5)");
            stm.executeUpdate("INSERT INTO Game VALUES('Asassins creed',110, 6)");
            stm.executeUpdate("INSERT INTO Game VALUES('Witcher',115, 7)");

            stm.executeUpdate("DROP TABLE Player IF EXISTS");
            stm.executeUpdate("CREATE TABLE Player(LOGIN VARCHAR(255) PRIMARY KEY, BALANCE INT, GAME VARCHAR(255))");
            stm.executeUpdate("INSERT INTO Player VALUES('Bob', 500, 'Call of duty 1')");
            stm.executeUpdate("INSERT INTO Player VALUES('Tom', 400, 'Call of duty 1')");
            stm.executeUpdate("INSERT INTO Player VALUES('Alex', 300, 'Asassins creed')");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
