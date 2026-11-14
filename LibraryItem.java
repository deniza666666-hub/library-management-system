public abstract class LibraryItem implements Borrowable {
    private String itemId;
    private String title;
    private boolean available;

    public LibraryItem(String itemId, String title) {
        this.itemId = itemId;
        this.title = title;
        this.available = true;
    }

    
    public String getItemId() { return itemId; }
    public void setItemId(String itemId) { this.itemId = itemId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    @Override
    public boolean isAvailable() { return available; }

    @Override
    public void borrowItem() { available = false; }

    @Override
    public void returnItem() { available = true; }

    
    public abstract int getLoanPeriodDays();
    public abstract double calculateFine(int daysLate);
    public abstract String getItemType();

    
    public void displayInfo() {
        System.out.printf("%-10s | %-9s | %-28s | %s%n",
                itemId, getItemType(), title, available ? "Available" : "Borrowed");
    }
}