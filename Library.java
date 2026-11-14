import java.util.ArrayList;


public class Library {
    private ArrayList<LibraryItem> items = new ArrayList<>();
    private ArrayList<Person> members = new ArrayList<>();

    public void addItem(LibraryItem item) { items.add(item); }
    public void addMember(Person member) { members.add(member); }

    public LibraryItem findItem(String id) {
        for (LibraryItem item : items) {
            if (item.getItemId().equalsIgnoreCase(id)) return item;
        }
        return null;
    }

    public Person findMember(String id) {
        for (Person p : members) {
            if (p.getId().equalsIgnoreCase(id)) return p;
        }
        return null;
    }

    public void displayAllItems() {
        if (items.isEmpty()) { System.out.println("No items in the library."); return; }
        System.out.println("ID         | Type      | Title                        | Status");
        System.out.println("-----------------------------------------------------------------");
        for (LibraryItem item : items) item.displayInfo();   
    }

    public void displayAllMembers() {
        if (members.isEmpty()) { System.out.println("No members registered."); return; }
        System.out.println("ID       | Role      | Name               | Loans");
        System.out.println("-----------------------------------------------------------------");
        for (Person p : members) p.displayInfo();            
    }

    public void borrowItem(String memberId, String itemId) {
        Person member = findMember(memberId);
        LibraryItem item = findItem(itemId);
        if (member == null) { System.out.println("Member not found."); return; }
        if (item == null) { System.out.println("Item not found."); return; }
        if (!item.isAvailable()) { System.out.println("Sorry, this item is already borrowed."); return; }
        if (!member.canBorrow()) {
            System.out.println(member.getName() + " has reached the limit of " + member.getMaxLoans() + " items.");
            return;
        }
        item.borrowItem();
        member.getBorrowedItems().add(item);
        System.out.println(member.getName() + " borrowed \"" + item.getTitle()
                + "\". Due in " + item.getLoanPeriodDays() + " days.");
    }

    public void returnItem(String memberId, String itemId, int daysLate) {
        Person member = findMember(memberId);
        LibraryItem item = findItem(itemId);
        if (member == null || item == null || !member.getBorrowedItems().contains(item)) {
            System.out.println("This member did not borrow that item.");
            return;
        }
        item.returnItem();
        member.getBorrowedItems().remove(item);
        double fine = item.calculateFine(daysLate);
        System.out.println("\"" + item.getTitle() + "\" returned by " + member.getName() + ".");
        System.out.printf("Late fine: RM%.2f%n", fine);
    }

    
    public void demonstratePolymorphism() {
        System.out.println("--- Polymorphism demo: same method call, different behaviour ---");
        for (LibraryItem item : items) {          
            System.out.printf("%-28s -> loan period: %2d days, fine for 5 days late: RM%.2f%n",
                    item.getTitle(), item.getLoanPeriodDays(), item.calculateFine(5));
        }
        for (Person p : members) {                
            System.out.printf("%-18s (%s) -> maximum loans: %d%n", p.getName(), p.getRole(), p.getMaxLoans());
        }
    }
}