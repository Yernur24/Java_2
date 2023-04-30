package kzz.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBConnection {
    private static Connection connection;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/dbnarxoz",
                    "root",
                    "");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static ArrayList<Items> getItems(){
        ArrayList<Items> items = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM items");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Items item = new Items();
                item.setId(resultSet.getInt("id"));
                item.setName(resultSet.getString("name"));
                item.setDescription(resultSet.getString("description"));
                item.setPrice(resultSet.getDouble("price"));
                items.add(item);
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return items;
    }
    public static void addItem(Items items) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT into items (name, description, price) " +
                            "values (?, ?, ?)");
            statement.setString(1, items.getName());
            statement.setString(2, items.getDescription());
            statement.setDouble(3, items.getPrice());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void UpdateItem(Items items) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "update items " + "set name = ?," + "description = ?, " + "price = ?" +
                            "where id = ?");
            statement.setString(1, items.getName());
            statement.setString(2, items.getDescription());
            statement.setDouble(3, items.getPrice());
            statement.setLong(4, items.getId());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Items getItem(int id ){
        Items items = null;
        try {
            PreparedStatement statement = connection.prepareStatement(""+
                    "SELECT * FROM items WHERE id = ? LIMIT 1");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                items = new Items();
                items.setId(resultSet.getInt("id"));
                items.setName(resultSet.getString("name"));
                items.setDescription(resultSet.getString("description"));
                items.setPrice(resultSet.getDouble("price"));
            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return items;
    }

    public static void DeleteItem(int id){
        try {
            PreparedStatement statement = connection.prepareStatement(""+ "DELETE FROM items WHERE id = ?");
            statement.setInt(1,id);
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Users getUser(String email){
        Users users = null;
        try {
            PreparedStatement statement = connection.prepareStatement(" "+ "SELECT * FROM users WHERE email = ?");
            statement.setString(1,email);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                users = new Users();
                users.setId(resultSet.getLong("id"));
                users.setEmail(resultSet.getString("email"));
                users.setPassword(resultSet.getString("password"));
                users.setFullName(resultSet.getString("full_Name"));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }
}
//    public static void RegisterUser(User user) {
//        try {
//            PreparedStatement statement = connection.prepareStatement(
//                    "INSERT into users " +
//                            "(email, password, full_name) " +
//                            "values (?, ?, ?)");
//            statement.setString(1, user.getEmail());
//            statement.setString(2, user.getPassword());
//            statement.setString(3, user.getFullName());
//            statement.executeUpdate();
//            statement.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
