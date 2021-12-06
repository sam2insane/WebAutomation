package seleniumbasic;

import java.sql.*;
import java.util.ArrayList;

public class DBUtils {

    public static ArrayList<String> getDataFromDatabase(String query, String columnName) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<String> arrayList = new ArrayList<String>();


        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebaybooks", "root", "89Beak92");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);


            while (resultSet.next()) {
                String name = resultSet.getString(columnName);

                arrayList.add(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return arrayList;

    }


}