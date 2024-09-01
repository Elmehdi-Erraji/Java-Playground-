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
        return String.format("%04d", (int)(Math.random() * 10000)); // Generates a 4-digit unique ID
    }
}
