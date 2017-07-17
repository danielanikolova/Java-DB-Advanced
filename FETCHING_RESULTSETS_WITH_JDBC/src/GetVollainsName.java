import java.sql.*;

public class GetVollainsName {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USER = "root";
    private static final String PASSWORD = "0907";

    public static void main(String[] args) throws SQLException{

      String resultQuery = "select v.name, count(mv.minion_id) "+
              "as minion_count from villains as v " +
              "inner join minions_villains as mv "+
              "on v.villain_id = mv.villain_id " +
                "group by mv.villain_id " +
                "having minion_count > 3 "+
                "order by minion_count desc;";

      try(
              Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)

              ){

          PreparedStatement resultStatement = connection.prepareStatement(resultQuery);

          ResultSet result = resultStatement.executeQuery();

          while (result.next()){
              String name = result.getString("name");
              int count = result.getInt("minion_count");
              System.out.printf("%s %d", name, count);
          }


      }catch (SQLException e){
          e.printStackTrace();
      }





    }
}
