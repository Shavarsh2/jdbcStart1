package am.hitech.jdbc.repo;

import am.hitech.jdbc.model.Adress;
import am.hitech.jdbc.util.DataSourse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdressRepo {
    Connection connection = DataSourse.getConnection();

    public int creatAdress(Adress adress){
        String query = "insert into `adress` values(0,?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,adress.getCountry());
            statement.setString(2,adress.getCity());
            statement.setString(3,adress.getStreet());
            statement.setInt(4,adress.getHome());
            statement.setInt(5,adress.getUserId());

            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int deleteAdress(int id){
        String query = "DELETE FROM `adress` WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);

            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int updateAdress(Adress adress){
        String query = "UPDATE `adress` SET country = ?,city = ? WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,adress.getCountry());
            statement.setString(2,adress.getCity());
            statement.setInt(3,adress.getUserId());

            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Adress getById(int id) {
        String query = "select * from `adress` where id ="+ id;
        Adress adress = null;
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(query);
            adress = buildAdress(resultSet);
            return adress;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Adress> getAllAdress() {
        String query = "select * from `adress`";
        List<Adress> list;
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(query);
            list = buildListAdress(resultSet);
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Adress buildAdress(ResultSet resultSet) {
        Adress adress = null;
        try {
            while (resultSet.next()) {
                adress = new Adress();
                adress.setId(resultSet.getInt("id"));
                adress.setCountry(resultSet.getString("country"));
                adress.setCity(resultSet.getString("city"));
                adress.setStreet(resultSet.getString("street"));
                adress.setHome(resultSet.getInt("home"));
                adress.setUserId(resultSet.getInt("user_id"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return adress;
    }


    private List<Adress> buildListAdress(ResultSet resultSet) {
        List<Adress> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String country = resultSet.getString("country");
                String city = resultSet.getString("city");
                String street = resultSet.getString("street");
                int home = resultSet.getInt("home");
                int userId = resultSet.getInt("user_id");
                list.add(new Adress(id, country, city, street, home, userId));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
