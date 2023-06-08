package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KdbQueryAPI {
    // Database connection details
    private static final String JDBC_DRIVER = "c.o.d.jdbc";
    private static final String DB_URL = "jdbc:q:localhost:5001";

    // Database credentials
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public List<String[]> executeQuery(String date, String venue, String messageType) {
        StringBuilder queryBuilder = new StringBuilder("select from tableName");

        if (date != null || venue != null || messageType != null) {
            queryBuilder.append(" where");
        }

        if (date != null) {
            queryBuilder.append(" Date = `").append(date).append("`");
        }

        if (venue != null) {
            if (date != null) {
                queryBuilder.append(" and");
            }
            queryBuilder.append(" Venue = `").append(venue).append("`");
        }

        if (messageType != null) {
            if (date != null || venue != null) {
                queryBuilder.append(" and");
            }
            queryBuilder.append(" MessageType = `").append(messageType).append("`");
        }

        String query = queryBuilder.toString();
        List<String[]> results = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String[] row = new String[]{
                        resultSet.getString("Date"),
                        resultSet.getString("ID"),
                        resultSet.getString("MessageType"),
                        resultSet.getString("Venue")
                };
                results.add(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
            // Handle any errors or throw an exception
        }

        return results;
    }
}
