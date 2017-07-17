import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class RemoveVillain {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USER = "root";
    private static final String PASSWORD = "0907";

    public static void main(String[] args) throws SQLException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer villainId = Integer.parseInt(reader.readLine());

        String deleteFromMapTable = "DELETE FROM minions_villains WHERE villain_id = ?";
        String deleteFromVillain = "DELETE FROM villains WHERE villain_id = ?";
        String selectVillain = "SELECT * FROM villains WHERE villain_id = ?";

        try (
                Connection connection = DriverManager.getConnection(URL,USER, PASSWORD)
                ){

            PreparedStatement selectVillainStatement = connection.prepareStatement(selectVillain);
            selectVillainStatement.setInt(1,villainId);

            ResultSet villainResult = selectVillainStatement.executeQuery();
            if (villainResult.next()){
                String villainName = villainResult.getString("name");

                PreparedStatement deleteFromMapStatement = connection.prepareStatement(deleteFromMapTable);
                deleteFromMapStatement.setInt(1,villainId);

                int minionsCount = deleteFromMapStatement.executeUpdate();
                deleteFromMapStatement.close();

                PreparedStatement deleteVillainStatement = connection.prepareStatement(deleteFromVillain);

                deleteVillainStatement.setInt(1, villainId);
                deleteVillainStatement.executeUpdate();
                deleteVillainStatement.close();

                System.out.printf("%s was deleted", villainName);
                System.out.printf("%d minions released", minionsCount);

            }else {
                System.out.println("No such villain was found");
            }
            selectVillainStatement.close();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
