package am.hitech.jdbc.repo;

import am.hitech.jdbc.model.NumberUser;
import am.hitech.jdbc.model.User;
import am.hitech.jdbc.util.DataSourse;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepo {
    Connection connection = DataSourse.getConnection();

    public Map<Integer, User> getAllNumberMap() {
        String query = "SELECT * FROM `user` ,`phone_numbers` WHERE user.id = phone_numbers.user_id";
        Map<Integer, User> map = new HashMap<>();
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String fName = resultSet.getString("first_name");
                String lName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                int age = resultSet.getInt("age");
                int a = resultSet.getInt("number");
                map.put(a, new User(id, fName, lName, email, age));
            }
            return map;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<NumberUser> getAllNumber() {
        String query = "SELECT first_name,last_name,NUMBER FROM `user` u LEFT JOIN `phone_numbers` pn ON u.id = pn.user_id";
        List<NumberUser> list = new ArrayList<>();
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(query);
            while (resultSet.next()) {
                String fName = resultSet.getString("first_name");
                String lName = resultSet.getString("last_name");
                int a = resultSet.getInt("number");
                list.add(new NumberUser(fName, lName, a));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User getByIdWeb() {
        String query = "select * from `user` where id = 1";
        User user = null;
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(query);
            user = buildUser(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public int deleteEmail(String email) {
        String query = "delete from `user` where email = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);

            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int updateUserPass(User user) {
        String query = "UPDATE `user` SET password = ? WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getPassword());
            statement.setInt(2, user.getId());

            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int updateUser(User user) {
        String query = "UPDATE `user` SET first_name = ?,last_name = ? WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setInt(3,user.getId());

            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int creatUserV2(User user) {
        String query = "insert into `user` values(0,?,?,?,?,?,NULL,NULL)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setInt(4, user.getAge());
            statement.setString(5, user.getPassword());

            return statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int creatUser(User user) {
        String query = "insert into `user` values(" + user.getId() + ",'" + user.getFirstName() + "','" + user.getLastName() + "','" + user.getEmail() + "'," + user.getAge() + ")";
        try {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User findEmail(String name) { //list veradarcni **
        String query = "SELECT * FROM `user` WHERE email = '" + name + "'";
        User user = null;
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(query);
            user = buildUser(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public List<User> getMaxAge18() {
        String query = "SELECT * FROM `user` WHERE age > 18";
        List<User> list;
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(query);
            list = buildListUser(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public User getbyPassToken(String pass) {
        String query = "select * from `user` where password_token = '" + pass + "'";
        User user2 = null;
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(query);
            user2 = buildUser(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user2;

    }

    public User getById(int id) {
        String query = "select * from `user` where id = " + id;
        User user = null;
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(query);
            user = buildUser(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public User getByUsername(String username) {
        String query = "select * from `user` where email ='" + username + "'";
        User user = null;
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(query);
            user = buildUser(resultSet);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    private User buildUser(ResultSet resultSet) {
        User user = null;
        try {
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                user.setAge(resultSet.getInt("age"));
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return user;
    }

    private List<User> buildListUser(ResultSet resultSet) {
        List<User> list = new ArrayList<>();

        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                int age = resultSet.getInt("age");
                list.add(new User(id, firstName, lastName, email, age));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
