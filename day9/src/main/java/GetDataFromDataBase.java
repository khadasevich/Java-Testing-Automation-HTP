import databasesetup.CreateConnection;
import databasesetup.PropertiesParser;
import statements.PrepStatement;
import statements.SimpleStatement;
import tables.User;
import utilities.CreateUserCredentials;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class GetDataFromDataBase {

    public static void main(String[] args) throws SQLException {
        CreateConnection connectionCreator = new CreateConnection();
        Connection connection = connectionCreator.createConnection();
        SimpleStatement simpleStatement = new SimpleStatement(connection);
        Properties prop = PropertiesParser.getProperties("queries.properties");
        Map<String, String> users = CreateUserCredentials.getListOfUsers(10);

        simpleStatement.executeUpdateStatement(prop.getProperty("DROP"));
        simpleStatement.executeUpdateStatement(prop.getProperty("CREATE"));
        PrepStatement prepStatement = new PrepStatement(connection, prop.getProperty("INSERT"));
        users.forEach((k, v) -> {
            try {
                prepStatement.executeUpdateStatement(k, v);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        ResultSet rs = simpleStatement.executeStatement(prop.getProperty("SELECT"));
        printUsers(rs);
        prepStatement.closeStatement();
        simpleStatement.closeStatement();
        connectionCreator.closeConnection();
    }

    private static void printUsers(ResultSet rs) throws SQLException {
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            users.add(new User(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3)));
        }
        for (User user : users) {
            System.out.println(user.toString());
        }
    }
}