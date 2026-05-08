package lab11;

import java.sql.*;
import java.util.Properties;

public class Mysql_Delete {

    public static void main(String[] args) {

        try {

            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Database Connection
            Connection dbConnection = null;

            String url = "jdbc:mysql://localhost:3306/test";

            Properties info = new Properties();
            info.put("user", "root");
            info.put("password", "Anusha@12");

            dbConnection = DriverManager.getConnection(url, info);

            if (dbConnection != null) {

                System.out.println(
                        "Successfully connected to MySQL database test");
            }

            // DELETE RECORD
            String query3 =
                    "DELETE FROM coffee WHERE id = 264";

            PreparedStatement preparedStmt2 =
                    dbConnection.prepareStatement(query3);

            preparedStmt2.executeUpdate();

            preparedStmt2.close();

            // SELECT QUERY
            String query = "SELECT * FROM coffee";

            Statement st = dbConnection.createStatement();

            ResultSet rs = st.executeQuery(query);

            // DISPLAY RECORDS
            while (rs.next()) {

                int id = rs.getInt("id");
                String coffee_name =
                        rs.getString("coffee_name");
                int price = rs.getInt("price");

                System.out.format(
                        "\n%d, %s, %d",
                        id,
                        coffee_name,
                        price);
            }

            // CLOSE CONNECTION
            rs.close();
            st.close();
            dbConnection.close();

        } catch (Exception e) {

            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
}