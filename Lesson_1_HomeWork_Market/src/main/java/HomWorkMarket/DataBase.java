package HomWorkMarket;

import org.sqlite.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class DataBase {

    private static final String CON_STR = "jdbc:sqlite:C:/Java_2/teachers.db";
    private static DataBase instance;
    private static Connection conn;
    public static Statement stmt;
    public static PreparedStatement pstmt;

    public List<User> selectUser() {
        List<User> users = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            resultSet = stmt.executeQuery("SELECT * FROM users;");
            Object object = resultSet.getObject("id");
            System.out.println("resultSet: " + resultSet);
            System.out.println("object: " + object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static synchronized DataBase getInstance(){
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;

    }

    private DataBase() {
        try {
            DriverManager.registerDriver(new JDBC());
            conn = DriverManager.getConnection(CON_STR);
            System.out.println("Connected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  void createTableShoppedProductList() {
        try {
            stmt = conn.createStatement();
            stmt.execute("CREATE TABLE if not exists 'ShoppedProduct' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'price' INT, 'quantity' INT);");
            System.out.println("Таблица создана или уже существует.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  void InsertProductInTableProductInDataBase(Buyer buyer) {
        try {
            for (Product product : buyer.shoppedList) {
                pstmt = conn.prepareStatement("INSERT INTO 'ShoppedProduct' (name, price, quantity) VALUES (?, ?, ?)");
                pstmt.setString(1, product.getName());
                pstmt.setString(2, String.valueOf(product.getPrice()));
                pstmt.setString(3, String.valueOf(product.getQuantity()));
                pstmt.executeUpdate();
                System.out.println("Элемент добавлен");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  void selectFrom() {
        try {
                pstmt = conn.prepareStatement("SELECT * FROM ShoppedProduct");
                ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("" + rs.getRow() + ". " +
                        "id = " + rs.getInt("id") +
                        ", name = " + rs.getString("name")+
                        ", price = " + rs.getInt("price")+
                        ", quantity = " + rs.getInt("quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  void deleteTableShoppedProduct() {
        try {
            stmt = conn.createStatement();
            stmt.execute("DROP TABLE IF EXISTS 'ShoppedProduct';");
            System.out.println("Таблица удалена.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}


