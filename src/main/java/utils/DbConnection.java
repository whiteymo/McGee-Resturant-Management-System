package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class DbConnection {

    public static Connection con;

    public static Connection myConnection(){
        try {
            if (con.isValid(0)) {
                return con;

            } else {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodsystem", "root", "");

                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}