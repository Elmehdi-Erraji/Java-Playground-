package src.DS.study;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Overlap class representing a start and end date
class Overlap {
    private LocalDate startDate;
    private LocalDate endDate;

    public Overlap(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return "Reservation from " + startDate + " to " + endDate;
    }
}

// User class holding a list of reservations
class User {
    private List<Overlap> reservations;

    public User() {
        this.reservations = new ArrayList<>();
    }

    public List<Overlap> getReservations() {
        return reservations;
    }

    // Add a reservation to the user's list
    public void addReservation(Overlap reservation) {
        reservations.add(reservation);
    }
}

public class Main {
    public static void main(String[] args) {
        User user = new User();

        // Add some existing reservations
        user.addReservation(new Overlap(LocalDate.of(2024, 9, 1), LocalDate.of(2024, 9, 5)));
        user.addReservation(new Overlap(LocalDate.of(2024, 9, 10), LocalDate.of(2024, 9, 15)));
        user.addReservation(new Overlap(LocalDate.of(2024, 9, 20), LocalDate.of(2024, 9, 25)));

        // Print existing reservations
        System.out.println("Existing Reservations:");
        for (Overlap r : user.getReservations()) {
            System.out.println(r);
        }

        // Example of a new reservation to check
        Overlap newReservation = new Overlap(LocalDate.of(2024, 9, 6), LocalDate.of(2024, 9, 9));

        // Check if the new reservation overlaps with existing ones
        boolean canReserve = canMakeReservation(user, newReservation);

        if (canReserve) {
            System.out.println("Reservation is possible! Adding new reservation.");
            user.addReservation(newReservation);
        } else {
            System.out.println("Reservation overlaps with existing dates. Cannot add reservation.");
        }
    }

    // Method to check if the new reservation overlaps with any existing reservations
    public static boolean canMakeReservation(User user, Overlap newReservation) {
        for (Overlap existingReservation : user.getReservations()) {
            // Overlap condition: If the new reservation starts before the existing one ends,
            // and ends after the existing one starts, they overlap.
            if (newReservation.getStartDate().isBefore(existingReservation.getEndDate()) &&
                    newReservation.getEndDate().isAfter(existingReservation.getStartDate())) {
                return false; // Overlap detected
            }
        }
        return true; // No overlap
    }
}
