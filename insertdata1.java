import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class SampleDataAndQueries {
    // ... (other methods)

    public static void insertSampleData() {
        try (Connection connection = DatabaseConnection.connect()) {
            // Insert 50 data rows into OrderTable
            for (int i = 1; i <= 50; i++) {
                insertOrderData(connection, i, generateUniqueProductName(), generateRandomPrice());
            }

            // Insert 50 data rows into CustomerTable
            for (int i = 1; i <= 50; i++) {
                insertCustomerData(connection, i, generateUniqueCustomerName(), generateRandomRegion());
            }

            // Insert 50 data rows into SalesTable
            for (int i = 1; i <= 50; i++) {
                insertSalesData(connection, i, i % 10 + 1, i % 5 + 1);
            }

            System.out.println("Sample data inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String generateUniqueProductName() {
        String[] products = {"Laptop", "Smartphone", "Headphones", "Camera", "Smartwatch", "Tablet", "Printer", "Monitor"};
        return products[(int) (Math.random() * products.length)] + "_" + getRandomString(4);
    }

    private static String generateUniqueCustomerName() {
        String[] firstNames = {"John", "Jane", "Robert", "Emily", "Michael", "Emma", "Daniel", "Sophia"};
        String[] lastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "García"};

        String firstName = firstNames[(int) (Math.random() * firstNames.length)];
        String lastName = lastNames[(int) (Math.random() * lastNames.length)];

        return firstName + " " + lastName + "_" + getRandomString(4);
    }

    private static double generateRandomPrice() {
        return Math.round((10.0 + Math.random() * 90.0) * 100.0) / 100.0; // Random price between 10.0 and 100.0
    }

    private static String generateRandomRegion() {
        String[] regions = {"North", "South", "East", "West", "Central"};
        return regions[(int) (Math.random() * regions.length)];
    }

    private static String getRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            result.append(characters.charAt(random.nextInt(characters.length())));
        }

        return result.toString();
    }

    // ... (other methods)
}
