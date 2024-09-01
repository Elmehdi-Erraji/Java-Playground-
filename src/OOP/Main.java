package src.OOP;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.DateTimeException;
import java.time.LocalDate;


public class Main {

    private static serc.OOP.UserService userService = new serc.OOP.UserService();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int mainChoice;
        do {
            System.out.println("\nMain Menu:");
            System.out.println("1. User Management");
            System.out.println("2. Carbon Consumption");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            try {
                mainChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (mainChoice) {
                    case 1:
                        userManagementMenu();
                        break;
                    case 2:
                        carbonConsumptionMenu();
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
                mainChoice = -1; // Reiterate the loop
            }
        } while (mainChoice != 3);
    }

    private static void userManagementMenu() {
        int userChoice;
        do {
            System.out.println("\nUser Management Menu:");
            System.out.println("1. Create User");
            System.out.println("2. View User");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            try {
                userChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (userChoice) {
                    case 1:
                        createUser();
                        break;
                    case 2:
                        viewUser();
                        break;
                    case 3:
                        updateUser();
                        break;
                    case 4:
                        deleteUser();
                        break;
                    case 5:
                        return; // Back to Main Menu
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
                userChoice = -1; // Reiterate the loop
            }
        } while (userChoice != 5);
    }

    private static void carbonConsumptionMenu() {
        int carbonChoice;
        do {
            System.out.println("\nCarbon Consumption Menu:");
            System.out.println("1. Add Carbon Record");
            System.out.println("2. View Carbon Consumption Report");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");

            try {
                carbonChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (carbonChoice) {
                    case 1:
                        addCarbonRecord();
                        break;
                    case 2:
                        viewConsumptionReport();
                        break;
                    case 3:
                        return; // Back to Main Menu
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
                carbonChoice = -1; // Reiterate the loop
            }
        } while (carbonChoice != 3);
    }

    private static void createUser() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = getValidInteger();
        User user = userService.createUser(name, age);
        System.out.println("User created with ID: " + user.getUserId());
    }

    private static void viewUser() {
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        User user = userService.getUserById(userId);
        if (user != null) {
            System.out.println("User ID: " + user.getUserId());
            System.out.println("Name: " + user.getName());
            System.out.println("Age: " + user.getAge());
            System.out.println("Carbon Records: " + user.getCarbonRecords());
        } else {
            System.out.println("User not found.");
        }
    }

    private static void updateUser() {
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new age: ");
        int newAge = getValidInteger();
        boolean success = userService.updateUser(userId, newName, newAge);
        if (success) {
            System.out.println("User updated.");
        } else {
            System.out.println("User not found.");
        }
    }

    private static void deleteUser() {
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        boolean success = userService.deleteUser(userId);
        if (success) {
            System.out.println("User deleted.");
        } else {
            System.out.println("User not found.");
        }
    }

    private static void addCarbonRecord() {
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        User user = userService.getUserById(userId);
        if (user != null) {
            LocalDate startDate = getValidDate("Enter start date (yyyy-mm-dd): ");
            LocalDate endDate = getValidDate("Enter end date (yyyy-mm-dd): ");
            System.out.print("Enter amount of carbon consumed: ");
            double amount = getValidDouble();
            userService.addCarbonRecord(userId, startDate, endDate, amount);
            System.out.println("Carbon record added.");
        } else {
            System.out.println("User not found.");
        }
    }

    private static void viewConsumptionReport() {
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        User user = userService.getUserById(userId);
        if (user != null) {
            System.out.print("Enter report type (daily, weekly, monthly): ");
            String reportType = scanner.nextLine();
            userService.generateConsumptionReport(user, reportType);
        } else {
            System.out.println("User not found.");
        }
    }

    private static int getValidInteger() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Clear invalid input
            }
        }
    }

    private static double getValidDouble() {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
        }
    }

    private static LocalDate getValidDate(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return LocalDate.parse(scanner.nextLine());
            } catch (DateTimeException e) {
                System.out.println("Invalid date format. Please enter date in yyyy-mm-dd format.");
            }
        }
    }
}
