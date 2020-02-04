import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    private static final String name = "postgres";
    private static final String password = "root";
    private static final String URL = "jdbc:postgresql://localhost:5432/ProductBD/";


    public static void main(String[] args) throws SQLException, IOException, ParseException {
        Connection connection = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            connection = DriverManager.getConnection(URL, name, password);
        } catch (SQLException e) {
            System.out.println("Введенны неверные данные");
        }

        System.out.println("Введите команду: ");
        String command = reader.readLine();

        if(command.equals("newproduct")) {
            System.out.println("Введите имя для Базы данных: ");
            String newproducts = reader.readLine();
            Newproduct newproduct = new Newproduct(newproducts);
        } else if(command.equals("purchase")){

            System.out.println("Введите имя базы данных для закупки ");
            String nameBD = reader.readLine();

            System.out.println("Введите количество закупаемого товара ");
            int countBD = Integer.parseInt(reader.readLine());

            System.out.println("Введите цену закупаемого продукта ");
            int priceBD = Integer.parseInt(reader.readLine());

            System.out.println("Введите дату закупки ");
            String date = reader.readLine();
            SimpleDateFormat data = new SimpleDateFormat("dd-MM-yy");
            Date date1 = data.parse(date);
            Purchase purchase = new Purchase(nameBD, countBD, priceBD, date1);

        } else  if (command.equals("demand") || command.equals("Demand")){
            System.out.println("Введите имя продукта для продажи ");
            String name  = reader.readLine();

            System.out.println("Введите количество продоваемого товара ");
            int count = Integer.parseInt(reader.readLine());

            System.out.println("Введите цену продажи ");
            int price = Integer.parseInt(reader.readLine());

            System.out.println("Введите дату продажи ");
            String date = reader.readLine();
            SimpleDateFormat data = new SimpleDateFormat("dd MM yy");
            Date date1 = data.parse(date);

            Demand demand = new Demand(name, count, price, date1);


        } else if (command.equals("Salereport") || command.equals("salereport")){
            System.out.println("Введите имя продукта ");
            String name = reader.readLine();

            System.out.println("Введите дату продажи ");
            String date = reader.readLine();
            SimpleDateFormat data = new SimpleDateFormat("dd MM yy");
            Date date1 = data.parse(date);

            Salesreport salesreport = new Salesreport(name, date1);

        }





        else {
            System.out.println("Комманда не найдена. Для отображения всех комманд пропишите help");
        }

        connection.close();
    }
}
