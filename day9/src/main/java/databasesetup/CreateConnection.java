package databasesetup;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class CreateConnection {

    Connection connection;
    Properties prop;

    public CreateConnection() throws SQLException {
        this.prop = PropertiesParser.getProperties("database.properties");
        this.connection = PropertiesParser.getDataSource(prop).getConnection();
    }

    public Connection createConnection() {
        return connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}
