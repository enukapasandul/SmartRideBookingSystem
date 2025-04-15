import java.util.*;

public class SmartRideBookingSystem {
    private final Queue<Integer> bookings; // FIFO for ticket processing
    private final Stack<Integer> cancellations; // LIFO for cancellations

    public SmartRideBookingSystem() {
        this.bookings = new LinkedList<>();
        this.cancellations = new Stack<>();
    }

    // Enqueue new booking (FIFO)
    public void bookTicket(int passengerId) {
        bookings.add(passengerId);
        System.out.println("Ticket booked for Passenger " + passengerId);
    }

    // Dequeue the earliest booking (FIFO)
    public void processBooking() throws IllegalStateException {
        if (bookings.isEmpty()) {
            throw new IllegalStateException("No bookings to process");
        }
        int passenger = bookings.poll();
        System.out.println("Processed booking for Passenger " + passenger);
    }

    // Push cancellation to stack (LIFO)
    public void cancelTicket(int passengerId) throws IllegalArgumentException {
        if (!bookings.contains(passengerId)) {
            throw new IllegalArgumentException("Invalid passenger ID");
        }
        bookings.remove(passengerId);
        cancellations.push(passengerId);
        System.out.println("Cancelled ticket for Passenger " + passengerId + " (LIFO)");
    }

    // Pop last cancellation (LIFO)
    public void undoCancellation() throws IllegalStateException {
        if (cancellations.isEmpty()) {
            throw new IllegalStateException("No cancellations to undo");
        }
        int passenger = cancellations.pop();
        bookings.add(passenger);
        System.out.println("Reinstated ticket for Passenger " + passenger);
    }

    // Merge Sort for passenger data (O(n log n))
    public List<Integer> sortBookingsAscending() {
        List<Integer> sortedList = new ArrayList<>(bookings);
        Collections.sort(sortedList); // Uses TimSort (hybrid of Merge Sort + Insertion Sort)
        return sortedList;
    }

    // Bubble Sort (O(n²) - for demonstration)
    public List<Integer> sortBookingsDescending() {
        List<Integer> sortedList = new ArrayList<>(bookings);
        for (int i = 0; i < sortedList.size() - 1; i++) {
            for (int j = 0; j < sortedList.size() - i - 1; j++) {
                if (sortedList.get(j) < sortedList.get(j + 1)) {
                    Collections.swap(sortedList, j, j + 1);
                }
            }
        }
        return sortedList;
    }
}