package com.mycompany.hospitalplanner.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
/**
 *
 * @author Elias
 */
public class DatabaseConnectionManager {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/hospitalapp";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "admin";

    private static final DataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(JDBC_URL);
        config.setUsername(USERNAME);
        config.setPassword(PASSWORD);
        dataSource = new HikariDataSource(config);
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
