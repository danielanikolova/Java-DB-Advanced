import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.Scanner;

public class IncreaseMinionsAge {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USER = "root";
    private static final String PASSWORD = "0907";

    public static void main(String[] args) throws SQLException{

        Scanner scanner = new Scanner(System.in);

        int[] positions = Arrays.stream(scanner.nextLine()
                .split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();

        String setNewAgeQuery = "Update minions m\n" +
                "\tset age = age+1, \n" +
                "\tname = Concat(Upper(LEFT(m.name,1)),LOWER(SUBSTRING(m.name,2,LENGTH(m.name))))\n" +
                "\twhere m.minion_id = ?;";

        String getNewDataQuery = "select m.name, m.age from minions m";

        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){

            PreparedStatement resultStatement = connection.prepareStatement(setNewAgeQuery);

            for (int i = 0; i < positions.length ; i++) {

                int position = positions[i];

                resultStatement.setInt(1, position);

               resultStatement.executeUpdate();

            }

            resultStatement.close();

            PreparedStatement dataToPrint = connection.prepareStatement(getNewDataQuery);

            ResultSet toPrint = dataToPrint.executeQuery();

            while (toPrint.next()){
                System.out.printf("%s %d\n", toPrint.getString("name"), toPrint.getInt("age"));
            }



        }





    }

}
