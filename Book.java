public class Book extends LibraryItem {
    private String author;

    public Book(String itemId, String title, String author) {
        super(itemId, title);
        this.author = author;
    }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    @Override
    public int getLoanPeriodDays() { return 14; }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate > 0 ? daysLate * 0.50 : 0.0;   
    }

    @Override
    public String getItemType() { return "Book"; }

    @Override
    public void displayInfo() {              
        super.displayInfo();
        System.out.println("           Author: " + author + " | Loan period: " + getLoanPeriodDays() + " days");
    }
}