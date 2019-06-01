package db;

import libraries.Configs;
import libraries.Const;
import users.User;

import java.sql.*;

public class DataBaseHandler extends Configs {
    Connection dbConnection;
    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException{
        String connectionString ="jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);
        return dbConnection;
    }

    public void signUpUser(User user){
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USERS_FIRSTNAME + "," +
                Const.USERS_LASTNAME + "," + Const.USERS_USERNAME + "," +
                Const.USERS_PASSWORD + "," + Const.USERS_LOCATION + "," +
                Const.USERS_GENDER + ")" + "VALUES(?, ?, ?, ?, ?, ?)";

    }

    public ResultSet getUser(User user) {// массив пользователей
        ResultSet resSet = null;
        String select = "SELECT * FROM" + Const.USER_TABLE + "WHERE "
+ Const.USERS_USERNAME + "=? AND"  + Const.USERS_PASSWORD + "=?" ;
        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getUserName());
            prSt.setString(2, user.getPassword());
         resSet=prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }
}
