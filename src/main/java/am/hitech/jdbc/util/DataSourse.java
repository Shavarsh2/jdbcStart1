package am.hitech.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSourse {
    private static Connection connection;
    private   String url = "";//final
    private   String username = "";//final
    private   String password = "";//final


    public DataSourse(String url,String username,String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    //"jdbc:mysql://localhost:3306/group1"
    //"root"
    //""
    public  Connection getConnection(){
        try {
            if(connection == null || connection.isClosed()){
                Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url,username,password);
            }
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
