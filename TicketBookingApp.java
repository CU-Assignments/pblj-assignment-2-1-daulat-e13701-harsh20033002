import java.util.*;
class TicketBookingSystem {
 private final int totalSeats;
 private final boolean[] seats;
 public TicketBookingSystem(int totalSeats) {
 this.totalSeats = totalSeats;
 this.seats = new boolean[totalSeats];
 }
 public synchronized boolean bookSeat(int seatNumber, String customerName) {
 if (seatNumber < 0 || seatNumber >= totalSeats) {
 System.out.println("Invalid seat number: " + seatNumber);
 return false;
 }
 if (!seats[seatNumber]) {
 seats[seatNumber] = true;
 System.out.println("Seat " + seatNumber + " booked successfully by " +
customerName);
 return true;
 } else {
 System.out.println("Seat " + seatNumber + " is already booked.");
 return false;
 }
 }
}
class BookingThread extends Thread {
 private final TicketBookingSystem system;
 private final int seatNumber;
 private final String customerName;
 public BookingThread(TicketBookingSystem system, int seatNumber, String
customerName, int priority) {
 this.system = system;
 this.seatNumber = seatNumber;
 this.customerName = customerName;
 setPriority(priority);
 }
 @Override
 public void run() {
 system.bookSeat(seatNumber, customerName);
 }
}
public class TicketBookingApp {
 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 TicketBookingSystem system = new TicketBookingSystem(10);
 System.out.print("Enter number of users: ");
 int numUsers = scanner.nextInt();
 scanner.nextLine();
 Thread[] threads = new Thread[numUsers];
 for (int i = 0; i < numUsers; i++) {
 System.out.print("Enter name for user " + (i + 1) + ": ");
 String name = scanner.nextLine();
 System.out.print("Enter seat number for " + name + ": ");
 int seatNumber = scanner.nextInt();
 System.out.print("Enter priority (1-10, where 10 is highest) for " + name + ": ");
 int priority = scanner.nextInt();
 scanner.nextLine();
 threads[i] = new BookingThread(system, seatNumber, name, priority);
 }
 for (Thread thread : threads) {
 thread.start();
 }
 for (Thread thread : threads) {
    try {
    thread.join();
    } catch (InterruptedException e) {
    e.printStackTrace();
    }
    }
    scanner.close();
    }
   }