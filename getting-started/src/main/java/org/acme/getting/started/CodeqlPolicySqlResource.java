package org.acme.getting.started;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

// Synthetic policy control only. Do not merge or deploy this branch.
@Path("/codeql-policy-poc")
public class CodeqlPolicySqlResource {
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
