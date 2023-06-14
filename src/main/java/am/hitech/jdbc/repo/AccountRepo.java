package am.hitech.jdbc.repo;

import am.hitech.jdbc.util.DataSourse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountRepo {
    Connection connection = DataSourse.getConnection();


    public void transfer(int from, int to, int amount ) {


        String addBalance =  "UPDATE `account` SET balance =  balance+?  WHERE user_id = ?";
        String deductBalance = "UPDATE `account` SET balance =  balance-?  WHERE user_id = ?";

        try {

            connection.setAutoCommit(false);

            PreparedStatement statement = connection.prepareStatement(addBalance);
            statement.setInt(1,amount);
            statement.setInt(2, to);
            statement.executeUpdate();

            statement = connection.prepareStatement(deductBalance);
            statement.setInt(1,amount);
            statement.setInt(2, from);
            statement.executeUpdate();

            connection.commit();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

    }

}
