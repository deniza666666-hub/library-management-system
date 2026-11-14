import java.util.ArrayList;

public abstract class Person {
    private String name;
    private String id;
    private ArrayList<LibraryItem> borrowedItems = new ArrayList<>();

    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public ArrayList<LibraryItem> getBorrowedItems() { return borrowedItems; }

    public boolean canBorrow() { return borrowedItems.size() < getMaxLoans(); }

    
    public abstract int getMaxLoans();
    public abstract String getRole();

    public void displayInfo() {
        System.out.printf("%-8s | %-9s | %-18s | Borrowed: %d/%d%n",
                id, getRole(), name, borrowedItems.size(), getMaxLoans());
    }
}