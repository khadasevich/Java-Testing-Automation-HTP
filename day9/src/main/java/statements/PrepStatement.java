package statements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrepStatement extends BaseStatement {

    Connection connection;
    PreparedStatement statement;
    String query;

    public PrepStatement(Connection connection, String query) {
        this.connection = connection;
        this.query = query;
    }

    public void getPreparedStatement() throws SQLException {
        this.statement = connection.prepareStatement(query);
    }

    public void executeUpdateStatement(String login, String password) throws SQLException {
        getPreparedStatement();
        statement.setString(1, login);
        statement.setString(2, password);
        statement.executeUpdate();
    }

    public void closeStatement() throws SQLException {
        super.closeStatement(this.statement);
    }
}
