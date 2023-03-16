package br.com.shibataTI.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author
 */
public class ConnectionFactory {

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1/bdshibata", "root", "");
        } catch (SQLException erroSql) {
            throw new RuntimeException(erroSql);

        }
    }
}
