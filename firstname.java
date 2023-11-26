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

