package lab11;

import java.sql.*;
import java.util.Properties;

public class Mysql_Update {

    public static void main(String[] args) {

        try {

            Connection dbConnection = null;

            try {

                // Load Driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Database URL
                String url = "jdbc:mysql://localhost:3306/test";

                // Username and Password
                Properties info = new Properties();
                info.put("user", "root");
                info.put("password", "Anusha@12");

                // Connection
                dbConnection =
                        DriverManager.getConnection(url, info);

                if (dbConnection != null) {

                    System.out.println(
                            "Successfully connected to MySQL database test");
                }

            } catch (SQLException ex) {

                System.out.println(
                        "An error occurred while connecting MySQL database");

                ex.printStackTrace();
            }

            // UPDATE QUERY
            String query2 =
                    "UPDATE coffee SET price = 950 WHERE id = 102";

            PreparedStatement preparedStmt1 =
                    dbConnection.prepareStatement(query2);

            preparedStmt1.executeUpdate();

            preparedStmt1.close();

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

                System.out.println(
                        id + " " + coffee_name + " " + price);
            }

            // CLOSE CONNECTIONS
            rs.close();
            st.close();
            dbConnection.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}