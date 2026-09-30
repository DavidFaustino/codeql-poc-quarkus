package org.acme.getting.started;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// Synthetic CodeQL control only. Do not deploy this branch.
@Path("/codeql-poc")
public class CodeqlPocSqlResource {
    @GET
    public String lookup(@QueryParam("category") String category) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:derby:memory:poc");
             Statement statement = connection.createStatement()) {
            statement.executeQuery("SELECT name FROM items WHERE category = '" + category + "'");
            return "checked";
        }
    }
}
