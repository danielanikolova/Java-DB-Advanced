import java.sql.*;
import java.util.ArrayList;

public class PrintAllMinionNames {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USER = "root";
    private static final String PASSWORD = "0907";

    public static void main(String[] args) throws SQLException{


        String getMinionsNamesQuery = "select name from minions;";

        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD

        ))
        {
            PreparedStatement getMinionsNames = connection.prepareStatement(getMinionsNamesQuery);
            ResultSet minions = getMinionsNames.executeQuery();


            ArrayList<String> minionsInList = new ArrayList<>();

            while (minions.next()){
                minionsInList.add(minions.getString("name"));
            }
            getMinionsNames.close();


            for (int i = 0, j = minionsInList.size()-1 ; i <minionsInList.size()/2+1 ; i++, j--) {
                System.out.println(minionsInList.get(i));
                if (j == i){
                    break;
                }
                else {
                    System.out.println(minionsInList.get(j));
                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }




    }

}
