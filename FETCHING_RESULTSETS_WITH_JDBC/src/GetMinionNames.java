import java.sql.*;
import java.util.Scanner;

public class GetMinionNames {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USER = "root";
    private static final String PASSWORD = "0907";

    public static void main(String[] args) throws SQLException{

        Scanner scanner = new Scanner(System.in);

        int villainId = Integer.parseInt(scanner.nextLine());

        String selectVillainName = "select name from villains\n" +
                "where villains.villain_id = ?";


        String selectMinionNames = "select mv.villain_id, m.name, m.age, v.name as villain_name from minions as m\n" +
                "inner join minions_villains as mv on m.minion_id = mv.minion_id\n" +
                "inner join villains as v on mv.villain_id = v.villain_id\n" +
                "where v.villain_id = ?;";


        try(
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)

                ){
            PreparedStatement villainNameStatement = connection.prepareStatement(selectVillainName);
            villainNameStatement.setInt(1,villainId);
            ResultSet resultVillainName = villainNameStatement.executeQuery();


            if (!resultVillainName.next()){
                System.out.printf("No villain with ID %d exists in the database.", villainId);

            }

            else {
                String villainName = resultVillainName.getString("name");
                PreparedStatement minionNamesStatement = connection.prepareStatement(selectMinionNames);
                minionNamesStatement.setInt(1, villainId);
                ResultSet minionNames = minionNamesStatement.executeQuery();

                if (!minionNames.next()) {
                    System.out.printf("Villain: %s. <no minions>", villainName);
                }else {
                    System.out.printf("Villain: %s\n", villainName);
                    int count = 1;

                    while (minionNames.next()){

                        String minionName = minionNames.getString("name");
                        int minionAge = minionNames.getInt("age");

                        System.out.printf("%d. %s %s\n", count, minionName, minionAge);

                        count++;
                    }
                    minionNames.close();
                }



            }

        }catch (SQLException e){
                    e.printStackTrace();
        }

    }
}
