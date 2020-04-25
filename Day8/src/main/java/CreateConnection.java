import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

class CreateConnection {

    static Connection createConnection(String file) throws SQLException {
        Properties prop = PropertiesParser.getProperties(file);
        return PropertiesParser.getDataSource(prop).getConnection();
    }
}
