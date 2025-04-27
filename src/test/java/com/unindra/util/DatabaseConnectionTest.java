package com.unindra.util; 


import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.zaxxer.hikari.HikariDataSource;

public class DatabaseConnectionTest {

    @Test
    void testConnection() throws SQLException{
        HikariDataSource hikariDataSource = AppContext.getDataSource();

        Connection connection = hikariDataSource.getConnection();

        assertNotNull(connection);

        connection.close();
        hikariDataSource.close();
    }
    
}
