import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class AddMinions {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USER = "root";
    private static final String PASSWORD = "0907";


    public static void main(String[] args) throws SQLException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String [] minionInfo = reader.readLine().split("\\s");
        String minionName = minionInfo[1];
        Integer minionAge = Integer.parseInt(minionInfo[2]);
        String townName = minionInfo[3];

        String [] villainInfo = reader.readLine().split(" ");
        String villainName = villainInfo[1];

        String selectTownQuery = "SELECT * FROM towns WHERE name = ?";
        String selectVillainQuery = "SELECT * FROM villains WHERE name = ?";

        String selectMinionQuery = "SELECT * FROM minions WHERE name = ?";

        String insertTownQuery = "INSERT INTO towns(name) VALUE (?)";
        String insertIntoVillainQuery = "INSERT INTO villain(name, evilness_factor) VALUE(?, 'evil')";

        String insertMinionQuery = "INSERT INTO minions(name, age, town_id) VALUES (?,?,?)";

        String insertMapTableQuery = "INSERT INTO minions_villains(minion_id, villain_id) VALUES (?,?)";

        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);


        ){
            PreparedStatement townStatement = connection.prepareStatement(selectTownQuery);
            townStatement.setString(1, townName);
            ResultSet townResult = townStatement.executeQuery();


            if (!townResult.next()){
                PreparedStatement insertTownStatement = connection.prepareStatement(insertTownQuery);
                insertTownStatement.setString(1, townName);
                insertTownStatement.executeUpdate();
                System.out.printf("Town %s was added to the database.\n", townName );
                insertTownStatement.close();
            }
            int townId=0;
            ResultSet townResultUpdated = townStatement.executeQuery();

            if (townResultUpdated.next()){
                townId = townResultUpdated.getInt("town_id");
            }

            townStatement.close();

            PreparedStatement selectVillainStatement = connection.prepareStatement(selectVillainQuery);
            selectVillainStatement.setString(1, villainName);

            ResultSet villainResult = selectVillainStatement.executeQuery();

            if (!villainResult.next()){
                PreparedStatement insertVillainStatement = connection.prepareStatement(insertIntoVillainQuery);
                insertVillainStatement.setString(1, villainName);
                insertVillainStatement.executeUpdate();
                insertVillainStatement.close();
            }

            ResultSet villainResultUpdate = selectVillainStatement.executeQuery();
           int villainId =0;
            if (villainResultUpdate.next()){
                villainId = villainResultUpdate.getInt("villain_id");
                System.out.printf("Villain %s was added to the database.\n", villainName);
            }

            selectVillainStatement.close();

            PreparedStatement insertMinionStatement = connection.prepareStatement(insertMinionQuery);
            insertMinionStatement.setString(1, minionName);
            insertMinionStatement.setInt(2, minionAge);
            insertMinionStatement.setInt(3, townId);
            insertMinionStatement.executeUpdate();

            insertMinionStatement.close();

            PreparedStatement selectMinionStatement = connection.prepareStatement(selectMinionQuery);
            selectMinionStatement.setString(1, minionName);
            ResultSet minionResult = selectMinionStatement.executeQuery();

            int minionId =0;
            if (minionResult.next()){
                 minionId = minionResult.getInt("minion_id");

            }

            selectMinionStatement.close();

            PreparedStatement insertMapTableStatement = connection.prepareStatement(insertMapTableQuery);
            insertMapTableStatement.setInt(1,minionId);
            insertMapTableStatement.setInt(2, villainId);

            insertMapTableStatement.executeUpdate();

            System.out.printf("Successfully added %s to be minion of %s\n",minionName, villainName );

        }catch (SQLException e){

        }


    }



}
