import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InitialSetup {

    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "0907";


    public static void main(String[] args) throws SQLException {

        String createQuery = "CREATE DATABASE minions_db;";
        String useQuery = "USE minions_db";

        String minionsTable = "CREATE TABLE minions ( " +
                "minion_id int PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(50), " +
                "age INT, " +
                "town_id INT, " +
                "CONSTRAINT fk_town_minions FOREIGN KEY (town_id) REFERENCES towns (town_id));";

        String vilionsTable = "CREATE TABLE villains( villain_id INT  pRIMARY KEY AUTO_INCREMENT, "+
                "name VARCHAR (50), " +
                "evilness_factor VARCHAR(20));";


        String townsTable = "CREATE TABLE towns( " +
                "town_id int PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(50),"+
                "country VARCHAR(50));";

        String mapTable = "CREATE TABLE minions_villains(minion_id INT, "+
                "villain_id INT, "+
                "PRIMARY KEY (minion_id, villain_id), "+
                "FOREIGN KEY (minion_id) REFERENCES  minions (minion_id), "+
                "FOREIGN KEY (villain_id) REFERENCES villains(villain_id));";

        String insertVillain = "INSERT INTO villains (name, evilness_factor) "+
                "VALUES ('Grue', 'good'),('Ivo', 'bad'),('Jonh', 'evil'),('Jan', 'bad'),('Horse', 'super evil');";
        String insertMinions = "INSERT INTO minions (name, age, town_id) "+
                "VALUES ('Rob', 5, 1),('Stuard', 4, 3),('Bob', 7, 5),('Mat', 2, 4),('Buffy', 1, 2);";
        String insertIntoTowns = "INSERT INTO towns (name, country) "+
                "VALUES ('London', 'US'),('Sofia', 'BG'),('New York', 'USA'),('Paris', 'France'),('Rim', 'Italy');";
        String insertMaps = "INSERT INTO minions_villains " +
                "VALUES (1,3),(2,4),(5,1),(3,4),(4,2),(1,4),(4,4),(5,5),(4,5),(3,5),(2,5),(1,5);";




        try (
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
        ) {

            statement.executeUpdate(createQuery);
            statement.executeUpdate(useQuery);
            statement.executeUpdate(townsTable);
            statement.executeUpdate(minionsTable);
            statement.executeUpdate(vilionsTable);
            statement.executeUpdate(mapTable);

            statement.executeUpdate(insertVillain);
            statement.executeUpdate(insertIntoTowns);
            statement.executeUpdate(insertMinions);
            statement.executeUpdate(insertMaps);



        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
