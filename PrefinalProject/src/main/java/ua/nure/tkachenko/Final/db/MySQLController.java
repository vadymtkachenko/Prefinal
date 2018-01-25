package ua.nure.tkachenko.Final.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class MySQLController {
    private static final String DATASOURCE_NAME = "jdbc/railwaydb";
    private static DataSource dataSource;
    static {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup(DATASOURCE_NAME);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        return connection;
    }
// метод возвращения Connection в пул
}
