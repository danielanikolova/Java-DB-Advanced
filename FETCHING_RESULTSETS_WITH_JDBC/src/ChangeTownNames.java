import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ChangeTownNames {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USER = "root";
    private static final String PASSWORD = "0907";

    public static void main(String[] args) throws SQLException{

        Scanner scanner = new Scanner(System.in);

        String countryName= scanner.nextLine();

        String setNamesUpperQuery = "Update towns set name = Upper(name)\n" +
                "where country = ? ;";
        String getAffectedTowns = "Select name from towns\n" +
                "where country = ?;";

        try (
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        ){
            PreparedStatement upperTownTames = connection.prepareStatement(setNamesUpperQuery);
            upperTownTames.setString(1, countryName);
            int countAffectedTowns = upperTownTames.executeUpdate();

            if (countAffectedTowns<=0){
                System.out.println("No town names were affected.");
            }else {
                PreparedStatement selectAffectedTownNames = connection.prepareStatement(getAffectedTowns);
                selectAffectedTownNames.setString(1, countryName);
                ResultSet affectedTowns = selectAffectedTownNames.executeQuery();

                System.out.printf("%d town names were affected.\n", countAffectedTowns);

                ArrayList<String> towns = new ArrayList<>();

                while (affectedTowns.next()){
                   towns.add(affectedTowns.getString("name"));
                }

                System.out.println(towns.toString());


            }

            }
        catch (SQLException e){
            e.printStackTrace();
        }





    }

}
