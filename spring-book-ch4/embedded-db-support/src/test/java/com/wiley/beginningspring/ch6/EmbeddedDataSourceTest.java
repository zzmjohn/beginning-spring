package com.wiley.beginningspring.ch6;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

public class EmbeddedDataSourceTest {
    private DataSource dataSource;

    @Before
    public void setUp() {
        dataSource = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema.sql")
                .addScript("classpath:data.sql").build();
    }

    @Test
    public void testDataAccessLogic() throws SQLException {
        Connection connection = dataSource.getConnection();
        Assert.assertFalse(connection.isClosed());
        connection.close();
        Assert.assertTrue(connection.isClosed());
    }

    @After
    public void tearDown() {
        ((EmbeddedDatabase)dataSource).shutdown();
    }
}
