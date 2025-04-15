public class Main {
    public static void main(String[] args) {
        SmartRideBookingSystem system = new SmartRideBookingSystem();

        try {
            system.bookTicket(101);
            system.bookTicket(102);
            // FIFO: 101 processed first
            system.processBooking();
            // LIFO cancellation
            system.cancelTicket(102);
            // Reinstates 102
            system.undoCancellation();
            System.out.println("Sorted (Ascending): " + system.sortBookingsAscending());
            // Invalid ID (throws Exception)
            system.cancelTicket(999);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}