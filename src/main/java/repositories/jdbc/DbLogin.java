package repositories.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//TRAINER: For security reasons, this class should be ignored in your .gitignore file.
public class DbLogin {
    public static String url = "jdbc:mysql://localhost:3306/games";
    public static String username = "root";
    public static String password = "";

    public static Connection createConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(DbLogin.url
                , DbLogin.username
                , DbLogin.password);
    }
}
