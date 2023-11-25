import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
    public static void insertSampleData() {
        try (Connection connection = DatabaseConnection.connect()) {
            // Insert data into OrderTable
            insertOrderData(connection, 1, "ProductA", 50.0);

            // Insert data into CustomerTable
            insertCustomerData(connection, 1, "John Doe", "North");

            // Insert data into SalesTable
            insertSalesData(connection, 1, 1, 10);

            System.out.println("Sample data inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertOrderData(Connection connection, int orderId, String productName, double price) throws SQLException {
        String insertOrderDataQuery = "INSERT INTO OrderTable (orderId, productName, price) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertOrderDataQuery)) {
            preparedStatement.setInt(1, orderId);
            preparedStatement.setString(2, productName);
            preparedStatement.setDouble(3, price);
            preparedStatement.executeUpdate();
        }
    }

    private static void insertCustomerData(Connection connection, int customerId, String customerName, String region) throws SQLException {
        String insertCustomerDataQuery = "INSERT INTO CustomerTable (customerId, customerName, region) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertCustomerDataQuery)) {
            preparedStatement.setInt(1, customerId);
            preparedStatement.setString(2, customerName);
            preparedStatement.setString(3, region);
            preparedStatement.executeUpdate();
        }
    }

    private static void insertSalesData(Connection connection, int orderId, int customerId, int quantity) throws SQLException {
        String insertSalesDataQuery = "INSERT INTO SalesTable (orderId, customerId, quantity) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSalesDataQuery)) {
            preparedStatement.setInt(1, orderId);
            preparedStatement.setInt(2, customerId);
            preparedStatement.setInt(3, quantity);
            preparedStatement.executeUpdate();
        }
    }

    public static void main(String[] args) {
        // Run this main method to insert sample data
        insertSampleData();
    }
}
