package lab11;

import java.sql.*;
import java.util.Properties;

public class mysql_Query{

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

                // Create Connection
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

            // SQL QUERY
            String query =
                    "SELECT * FROM coffee WHERE coffee_name LIKE 'D%'";

            // Create Statement
            Statement st = dbConnection.createStatement();

            // Execute Query
            ResultSet rs = st.executeQuery(query);

            // Display Records
            while (rs.next()) {

                int id = rs.getInt("id");
                String coffee_name =
                        rs.getString("coffee_name");
                int price = rs.getInt("price");

                System.out.format(
                        "\n%d %s %d",
                        id,
                        coffee_name,
                        price);
            }

            // Close Connections
            rs.close();
            st.close();
            dbConnection.close();

        } catch (Exception e) {

            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
}