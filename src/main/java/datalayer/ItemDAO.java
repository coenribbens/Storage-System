package datalayer;

import model.ItemCreation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maxim
 */
public class ItemDAO {

    private static ItemDAO instance;

    private ItemDAO() {

    }

    public static ItemDAO getInstance() {
        if (instance == null) {
            instance = new ItemDAO();
        }
        return instance;
    }

    public ArrayList<ItemCreation> getAllItems() {
        ArrayList<ItemCreation> items = new ArrayList<>();
        Connection conn = null;
        try {
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement statement = conn.prepareStatement("SELECT `ID`, `itemName`, `dop`, `price`, `notes` FROM `items`");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("itemName");
                String dop = resultSet.getString("dop");
                Float price = resultSet.getFloat("price");
                String notes = resultSet.getString("notes");

                ItemCreation i = new ItemCreation(id, dop, name, price, notes);
                items.add(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MysqlDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MysqlDAO.getInstance().closeConnection(conn);
        }
        return items;
    }
    //For adding items in the database//
    
    public void addItem(ItemCreation i) {
        Connection conn = null;
        try {
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement statement = conn.prepareStatement("" + "INSERT INTO `items` (`itemName`, `dop`, `price`, `notes`) " + "VALUES   (?, ?, ?, ?)");
            statement.setString(1, i.getName());
            statement.setString(2, i.getPurchasedate());
            statement.setFloat(3, i.getPrice());
            statement.setString(4, i.getNotes());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MysqlDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MysqlDAO.getInstance().closeConnection(conn);
        }
    }
}
