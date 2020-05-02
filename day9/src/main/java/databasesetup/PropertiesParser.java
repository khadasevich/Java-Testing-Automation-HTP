package databasesetup;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class PropertiesParser {

    public static Properties getProperties(String path) {
        File file = new File((Objects.requireNonNull(PropertiesParser.class.getClassLoader()
                .getResource(path))).getFile());
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream(file)) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return properties;
    }

    public static MysqlDataSource getDataSource(Properties prop) {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName(prop.getProperty("HOST"));
        dataSource.setPort(Integer.parseInt(prop.getProperty("PORT")));
        dataSource.setUser(prop.getProperty("USER"));
        dataSource.setPassword(prop.getProperty("PWD"));
        dataSource.setDatabaseName(prop.getProperty("NAME"));
        return dataSource;
    }
}
