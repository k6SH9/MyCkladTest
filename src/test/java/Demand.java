import java.sql.*;
import java.util.Date;

public class Demand {
    String name;
    int count;
    int price;
    Date date;

    private static final String login = "postgres";
    private static final String password = "root";
    private static final String URL = "jdbc:postgresql://localhost:5432/ProductBD/";

    Connection connection = null;
    Statement statement = null;

    public Demand(String name, int count, int price, Date date) {
        this.name = name;
        this.count = count;
        this.price = price;
        this.date = date;

        java.sql.Date newdate = new java.sql.Date(date.getTime());

        try {
            connection = DriverManager.getConnection(URL, login, password);
        } catch (SQLException e) {
            System.out.println("Введенны неверные данные");
        }

        try {
            assert false;
            Statement statement = connection.createStatement();
            String sql = "UPDATE product SET count = count - ?, buyprice = ?, datesale = ? WHERE name = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, count);
            preparedStatement.setInt(2, price);
            preparedStatement.setDate(3, newdate);
            preparedStatement.setString(4, name);

            preparedStatement.execute();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }




    }
}
