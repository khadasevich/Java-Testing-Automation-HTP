import databasesetup.CreateConnection;
import statements.PrepStatement;
import statements.SimpleStatement;
import tables.User;
import utilities.CreateUserCredentials;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetDataFromDataBase {

    public static void main(String[] args) throws SQLException {
        CreateConnection connectionCreator = new CreateConnection();
        Connection connection = connectionCreator.createConnection();
        SimpleStatement simpleStatement = new SimpleStatement(connection);
        String selectFromUsers = "SELECT * FROM users;";
        String dropTable = "DROP TABLE users;";
        String createTable = "CREATE TABLE IF NOT EXISTS `users` (\n" +
                "  `user_id` int(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `user_login` varchar(255) NOT NULL,\n" +
                "  `user_password` varchar(40) NOT NULL,\n" +
                "  PRIMARY KEY (`user_id`)\n" +
                ");";
        String insertUsers = "INSERT INTO `users` (`user_login`, `user_password`) " +
                "VALUES (?, ?);";
        simpleStatement.executeUpdateStatement(dropTable);
        simpleStatement.executeUpdateStatement(createTable);
        PrepStatement prepStatement = new PrepStatement(connection, insertUsers);
        Map<String, String> users = CreateUserCredentials.getListOfUsers(10);
        users.forEach((k, v) -> {
            try {
                prepStatement.executeUpdateStatement(k, v);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        ResultSet rs = simpleStatement.executeStatement(selectFromUsers);
        printUsers(rs);
        prepStatement.closeStatement();
        simpleStatement.closeStatement();
        connectionCreator.closeConnection();
    }

    private static void printSingleResult(ResultSet rs) throws SQLException {
        if (rs.next()) {
            System.out.println(rs.getString(1));
        }
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