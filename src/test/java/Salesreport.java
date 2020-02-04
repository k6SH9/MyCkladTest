import java.sql.*;
import java.sql.Statement;
import java.util.Date;

public class Salesreport {
    String name;
    Date date;

    private static final String login = "postgres";
    private static final String password = "root";
    private static final String URL = "jdbc:postgresql://localhost:5432/ProductBD/";

    Connection connection = null;


    public Salesreport(String name, Date date) {
        this.name = name;
        this.date = date;

        java.sql.Date newdate = new java.sql.Date(date.getTime());

        Statement statement = null;

        try {
            connection = DriverManager.getConnection(URL, login, password);
        } catch (SQLException e) {
            System.out.println("Введенны неверные данные");
        }

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM product");
            while(resultSet.next()){

                int id = resultSet.getInt(1);
                String name1 = resultSet.getString(2);
                int price = resultSet.getInt(3);
                System.out.printf("%d. %s - %d \n", id, name1, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}