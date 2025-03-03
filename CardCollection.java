import java.util.*;
class Card {
 private String symbol;
 private String value;
 public Card(String symbol, String value) {
 this.symbol = symbol;
 this.value = value;
 }
 public String getSymbol() {
 return symbol;
 }
 @Override
 public String toString() {
 return "Card{" + "symbol='" + symbol + '\'' + ", value='" + value + '\'' + '}';
 }
}
public class CardCollection {
 private static Collection<Card> cards = new ArrayList<>();
 private static Scanner scanner = new Scanner(System.in);
 public static void main(String[] args) {
 while (true) {
 System.out.println("\nCard Collection System");
 System.out.println("1. Add Card");
 System.out.println("2. Display All Cards");
 System.out.println("3. Search Cards by Symbol");
 System.out.println("4. Exit");
 System.out.print("Choose an option: ");
 int choice = scanner.nextInt();
 scanner.nextLine();
 switch (choice) {
 case 1:
 addCard();
 break;
 case 2:
 displayCards();
 break;
 case 3:
 searchBySymbol();
 break;
 case 4:
 System.exit(0);
 default:
 System.out.println("Invalid option. Try again.");
 }
 }
 }
 private static void addCard() {
 System.out.print("Enter Card Symbol: ");
 String symbol = scanner.nextLine();
 System.out.print("Enter Card Value: ");
 String value = scanner.nextLine();
 cards.add(new Card(symbol, value));
 System.out.println("Card added successfully.");
 }
 private static void displayCards() {
 if (cards.isEmpty()) {
 System.out.println("No cards to display.");
 } else {
 for (Card card : cards) {
    System.out.println(card);
 }
 }
 }
 private static void searchBySymbol() {
 System.out.print("Enter Symbol to search: ");
 String symbol = scanner.nextLine();
 boolean found = false;

 for (Card card : cards) {
 if (card.getSymbol().equalsIgnoreCase(symbol)) {
 System.out.println(card);
 found = true;
 }
 }
 if (!found) {
 System.out.println("No cards found with the given symbol.");
 }
 }
}
