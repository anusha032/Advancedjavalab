package lab11;

import java.sql.*;

public class JDBCCONNECTION {

    public static void main(String[] args) {

        try {

            // Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Database Connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test",
                    "root",
                    "Anusha@12");

            System.out.println("Successfully connected to MySQL database test");

            // SELECT QUERY
            String query = "SELECT * FROM coffee";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            // DISPLAY RECORDS
            while (rs.next()) {

                int id = rs.getInt("id");
                String coffeeName = rs.getString("coffee_name");
                int price = rs.getInt("price");

                System.out.println(
                        id + ", " + coffeeName + ", " + price);
            }

            // CLOSE CONNECTIONS
            
            
            
            
            
            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}