import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    private static String ask(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }

    private static int askInt(String prompt) {
        while (true) {
            try {
                return Integer.parseInt(ask(prompt));
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
        System.out.println("1. Add book");
        System.out.println("2. Add magazine");
        System.out.println("3. Register student member");
        System.out.println("4. Register staff member");
        System.out.println("5. Display all items");
        System.out.println("6. Display all members");
        System.out.println("7. Borrow item");
        System.out.println("8. Return item");
        System.out.println("9. Polymorphism demo");
        System.out.println("0. Exit");
    }

    public static void main(String[] args) {
        Library library = new Library();
        int choice;
        do {
            showMenu();
            choice = askInt("Enter choice: ");
            switch (choice) {
                case 1:
                    library.addItem(new Book(ask("Item ID: "), ask("Title: "), ask("Author: ")));
                    System.out.println("Book added.");
                    break;
                case 2:
                    library.addItem(new Magazine(ask("Item ID: "), ask("Title: "), askInt("Issue number: ")));
                    System.out.println("Magazine added.");
                    break;
                case 3:
                    library.addMember(new StudentMember(ask("Name: "), ask("Student ID: "), ask("Program: ")));
                    System.out.println("Student member registered.");
                    break;
                case 4:
                    library.addMember(new StaffMember(ask("Name: "), ask("Staff ID: "), ask("Department: ")));
                    System.out.println("Staff member registered.");
                    break;
                case 5:
                    library.displayAllItems();
                    break;
                case 6:
                    library.displayAllMembers();
                    break;
                case 7:
                    library.borrowItem(ask("Member ID: "), ask("Item ID: "));
                    break;
                case 8:
                    library.returnItem(ask("Member ID: "), ask("Item ID: "), askInt("Days late (0 if on time): "));
                    break;
                case 9:
                    library.demonstratePolymorphism();
                    break;
                case 0:
                    System.out.println("Thank you. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }
}