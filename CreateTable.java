import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public static void createTables() {
        try (Connection connection = DatabaseConnection.connect();
             Statement statement = connection.createStatement()) {

            // Create Order Table
            String createOrderTableQuery = "CREATE TABLE IF NOT EXISTS OrderTable (orderId INT, productName VARCHAR(255), price DOUBLE)";
            statement.execute(createOrderTableQuery);

            // Create Customer Table
            String createCustomerTableQuery = "CREATE TABLE IF NOT EXISTS CustomerTable (customerId INT, customerName VARCHAR(255), region VARCHAR(255))";
            statement.execute(createCustomerTableQuery);

            // Create Sales Table
            String createSalesTableQuery = "CREATE TABLE IF NOT EXISTS SalesTable (orderId INT, customerId INT, quantity INT)";
            statement.execute(createSalesTableQuery);

            System.out.println("Tables created successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Run this main method to create tables
        createTables();
    }
}
