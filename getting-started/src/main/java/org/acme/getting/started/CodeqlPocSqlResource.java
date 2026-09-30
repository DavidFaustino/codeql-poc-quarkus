package org.acme.getting.started;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

// Synthetic CodeQL retest control only. Do not deploy this branch.
@Path("/codeql-poc")
public class CodeqlPocSqlResource {
    @GET
    public String lookup(@QueryParam("category") String category) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:derby:memory:poc");
             PreparedStatement statement = connection.prepareStatement("SELECT name FROM items WHERE category = ?")) {
            statement.setString(1, category);
            statement.executeQuery();
            return "checked";
        }
    }
}
