import java.sql.*;
import java.util.Scanner;

public class IncreaseAgeStoredProcedure {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USER = "root";
    private static final String PASSWORD = "0907";

    public static void main(String[] args) throws SQLException{

        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());


        String selectQuery = "select * from minions where minion_id = ?";
        String procedure = "call usp_get_older(?);";

        try(Connection connection = DriverManager.getConnection(URL,USER, PASSWORD)){
            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);

            selectStatement.setInt(1, input);
            ResultSet result = selectStatement.executeQuery();

            if (result.next()){

                CallableStatement callableStatement = connection.prepareCall(procedure);

                callableStatement.setInt(1, input);
                callableStatement.executeQuery();

               callableStatement.close();

                result = selectStatement.executeQuery();

                if (result.next()){
                    System.out.printf("%s %d\n", result.getString("name"),
                            result.getInt("age"));
                }
               result.close();
            }
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }


    }

}
