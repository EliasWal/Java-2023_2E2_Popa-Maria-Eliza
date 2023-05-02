
package com.mycompany.lab8;

/**
 *
 * @author Elias
 */

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.sql.*;

public class DatabasePool {
    private static ComboPooledDataSource cpds = new ComboPooledDataSource();
    
    static {
        try {
            cpds.setDriverClass("org.Oracle.Driver");
            cpds.setJdbcUrl("jdbc:postgres:://localhost/testdb");
            cpds.setUser("JAVA");
            cpds.setPassword("USER");
        } catch (PropertyVetoException e) {
            System.out.println(e);
        }
    }
    
    public static Connection getConnection() throws SQLException {
        return cpds.getConnection();
    }
}