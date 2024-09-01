package src.OOP;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String name;
    private int age;
    private List<Carbon> carbonRecords;

    // Constructor to initialize user object with a generated userId
    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.carbonRecords = new ArrayList<Carbon>();
        this.userId = generateUniqueId();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Carbon> getCarbonRecords() {
        return carbonRecords;
    }

    public void addCarbonRecord(Carbon carbon) {
        carbonRecords.add(carbon);
    }

    private String generateUniqueId(){
        return String.format("%04d", (int)(Math.random() * 10000)); // Corrected typo
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create a User object
        User user = new User("Alice", 30);

        // Display user details
        System.out.println("User created:");
        System.out.println("Name: " + user.getName());
        System.out.println("Age: " + user.getAge());
        System.out.println("User ID: " + user.getUserId());

        // Create some Carbon records
        Carbon record1 = new Carbon("2024-09-01", 50.0);
        Carbon record2 = new Carbon("2024-09-02", 30.5);

        // Add Carbon records to the user
        user.addCarbonRecord(record1);
        user.addCarbonRecord(record2);

        // Display Carbon records
        System.out.println("\nCarbon Records:");
        for (Carbon carbon : user.getCarbonRecords()) {
            System.out.println("Date: " + carbon.getDate() + ", Amount: " + carbon.getAmount());
        }
    }
}
