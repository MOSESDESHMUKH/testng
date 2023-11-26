public class UniqueFirstNames {

    public static void main(String[] args) {
        String[] uniqueFirstNames = {
            "Liam", "Olivia", "Noah", "Emma", "Oliver", "Ava", "Elijah", "Sophia", "Lucas", "Isabella",
            "Mia", "Jackson", "Aiden", "Aria", "Grayson", "Amelia", "Sebastian", "Harper", "Ethan", "Evelyn"
        };

        // Print the unique first names
        for (String firstName : uniqueFirstNames) {
            System.out.println(firstName);
        }
    }
}

public class LastNameGenerator {
    public static String[] generateUniqueLastNames() {
        return new String[]{
            "Smith", "Johnson", "Williams", "Brown", "Jones",
            "Miller", "Davis", "García", "Rodriguez", "Martinez",
            "Hernandez", "Lopez", "Gonzalez", "Wilson", "Anderson",
            "Thomas", "Taylor", "Moore", "Clark", "Lewis"
        };
    }

    public static void main(String[] args) {
        String[] uniqueLastNames = generateUniqueLastNames();

        // Print the generated last names
        System.out.println("Generated Unique Last Names:");
        for (String lastName : uniqueLastNames) {
            System.out.println(lastName);
        }
    }
}

public static void findDuplicateRecords() {
        try (Connection connection = DatabaseConnection.connect();
             Statement statement = connection.createStatement()) {

            // Example: Find duplicate records in OrderTable based on productName
            String duplicateRecordsQuery = "SELECT productName, COUNT(*) FROM OrderTable GROUP BY productName HAVING COUNT(*) > 1";
            ResultSet resultSet = statement.executeQuery(duplicateRecordsQuery);

            System.out.println("Duplicate records in OrderTable:");
            while (resultSet.next()) {
                System.out.println("Product Name: " + resultSet.getString("productName"));
                System.out.println("Count: " + resultSet.getInt(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

 public static void findProductWithMaxPrice() {
        try (Connection connection = DatabaseConnection.connect();
             Statement statement = connection.createStatement()) {

            // Example: Find the product with the maximum price in OrderTable
            String maxPriceProductQuery = "SELECT * FROM OrderTable WHERE price = (SELECT MAX(price) FROM OrderTable)";
            ResultSet resultSet = statement.executeQuery(maxPriceProductQuery);

            System.out.println("Product with Max Price:");
            while (resultSet.next()) {
                System.out.println("Product Name: " + resultSet.getString("productName"));
                System.out.println("Price: " + resultSet.getDouble("price"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

public static void findMostSoldProduct() {
        try (Connection connection = DatabaseConnection.connect();
             Statement statement = connection.createStatement()) {

            // Example: Find the most sold product in SalesTable
            String mostSoldProductQuery = "SELECT productName, SUM(quantity) AS totalSold FROM SalesTable GROUP BY productName ORDER BY totalSold DESC LIMIT 1";
            ResultSet resultSet = statement.executeQuery(mostSoldProductQuery);

            System.out.println("Most Sold Product:");
            while (resultSet.next()) {
                System.out.println("Product Name: " + resultSet.getString("productName"));
                System.out.println("Total Sold: " + resultSet.getInt("totalSold"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


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
            String createSalesTableQuery = "CREATE TABLE IF NOT EXISTS SalesTable (" +
                    "productName VARCHAR(255), " +
                    "region VARCHAR(255), " +
                    "quantity INT, " +
                    "FOREIGN KEY (productName) REFERENCES OrderTable(productName), " +
                    "FOREIGN KEY (region) REFERENCES CustomerTable(region))";
            statement.execute(createSalesTableQuery);

            System.out.println("Tables created successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//Missing index for constraint 'salestable_ibfk_1' in the referenced table 'ordertable'
//You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'INDEX idx_productName (productName))' at line 1

