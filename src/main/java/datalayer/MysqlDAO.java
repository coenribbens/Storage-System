package datalayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MysqlDAO {

    private static MysqlDAO instance;
    private String dbname = "testwebsite";
    private String user = "item";
    private String pass = "item";

    private MysqlDAO() {

    }

    public static MysqlDAO getInstance() {
        if (instance == null) {
            instance = new MysqlDAO();
        }
        return instance;

    }

    //Create connection object with MySQL JDBC driver
    public Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost/" + dbname, user, pass);
            return connection;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MysqlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //Close connection if connection exists
    public void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(MysqlDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
