import tables.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class GetDataFromDataBase {


    public static void main(String[] args) throws SQLException {
        String file = "D:\\students\\y.Mal\\Java-Testing-Automation-HTP\\Day8\\src\\main\\resources\\db.properties";

        Connection connection = CreateConnection.createConnection(file);


        String query = "SHOW TABLES";
        String query1 = "SELECT * FROM Categories WHERE CategoryID = ?";
        String query2 = "SELECT * FROM Categories";

        executeStatement(connection, query);

        execPreparedStatement(connection, query1, 2);

        loadCategories(connection, query2);

        connection.close();
    }

    private static void executeStatement(Connection connection, String query) throws SQLException {
        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery(query);

        if (rs.next()) {
            System.out.println(rs.getString(1));
        }
    }

    private static void execPreparedStatement(Connection connection, String query, int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setInt(1, id);

        try (ResultSet rs = statement.executeQuery()) {

            if (rs.next()) {
                System.out.println(rs.getString(2));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void loadCategories(Connection connection, String query) throws SQLException {
        List<Category> categories = new ArrayList<>();
        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) {
            categories.add(new Category(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3)));
        }

        for (Category cat: categories) {
            System.out.println(cat.toString());

        }
    }


}
