package statements;

import java.sql.SQLException;
import java.sql.Statement;

public abstract class BaseStatement {

    public void closeStatement(Statement statement) throws SQLException {
        statement.close();
    }
}
