package serc.OOP;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;

import src.OOP.User;
public class UserService {
    private HashMap<String, User> users = new HashMap<>();
    private HashMap<String, HashMap<LocalDate, Double>> carbonRecords = new HashMap<>();

    public User createUser(String name, int age) {
        User user = new User(name, age);
        users.put(user.getUserId(), user);
        carbonRecords.put(user.getUserId(), new HashMap<>());
        return user;
    }

    public User getUserById(String userId) {
        return users.get(userId);
    }

    public boolean updateUser(String userId, String newName, int newAge) {
        User user = users.get(userId);
        if (user != null) {
            user.setName(newName);
            user.setAge(newAge);
            return true;
        }
        return false;
    }

    public boolean deleteUser(String userId) {
        if (users.remove(userId) != null) {
            carbonRecords.remove(userId);
            return true;
        }
        return false;
    }

    public void addCarbonRecord(String userId, LocalDate startDate, LocalDate endDate, double amount) {
        HashMap<LocalDate, Double> records = carbonRecords.get(userId);
        if (records != null) {
            if (startDate.isAfter(endDate)) {
                System.out.println("Start date cannot be after end date.");
                return;
            }
            LocalDate date = startDate;
            while (!date.isAfter(endDate)) {
                records.put(date, records.getOrDefault(date, 0.0) + amount);
                date = date.plusDays(1);
            }
        } else {
            System.out.println("User not found.");
        }
    }

    public void generateConsumptionReport(User user, String reportType) {
        HashMap<LocalDate, Double> records = carbonRecords.get(user.getUserId());
        if (records != null) {
            LocalDate today = LocalDate.now();
            LocalDate startDate = null;
            LocalDate endDate = null;

            switch (reportType.toLowerCase()) {
                case "daily":
                    startDate = today;
                    endDate = today;
                    break;
                case "weekly":
                    startDate = today.minusWeeks(1);
                    endDate = today;
                    break;
                case "monthly":
                    startDate = today.minusMonths(1);
                    endDate = today;
                    break;
                default:
                    System.out.println("Invalid report type.");
                    return;
            }

            double total = 0.0;
            LocalDate date = startDate;
            while (!date.isAfter(endDate)) {
                total += records.getOrDefault(date, 0.0);
                date = date.plusDays(1);
            }

            System.out.println("Total carbon consumption from " + startDate + " to " + endDate + ": " + total);
        } else {
            System.out.println("No records found for this user.");
        }
    }

    public void displayUserCarbonRecords(String userId) {
        HashMap<LocalDate, Double> records = carbonRecords.get(userId);
        if (records != null) {
            for (LocalDate date : records.keySet()) {
                System.out.println("Date: " + date + ", Amount: " + records.get(date));
            }
        } else {
            System.out.println("No carbon records found for this user.");
        }
    }
}
