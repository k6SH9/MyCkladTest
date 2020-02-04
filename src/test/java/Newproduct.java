import java.sql.*;

public class Newproduct{
    private static final String login = "postgres";
    private static final String password = "root";
    private static final String URL = "jdbc:postgresql://localhost:5432/ProductBD/";

    Connection connection = null;
    Statement statement = null;
    String name;
    public Newproduct(String name){
        this.name = name;

        try {
            connection = DriverManager.getConnection(URL, login, password);
        } catch (SQLException e) {
            System.out.println("Введенны неверные данные");
        }

        try {
            assert false;
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO  product(\"name\") VALUES (?);";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);

            preparedStatement.execute();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
