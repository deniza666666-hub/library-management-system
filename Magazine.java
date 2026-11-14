public class Magazine extends LibraryItem {
    private int issueNumber;

    public Magazine(String itemId, String title, int issueNumber) {
        super(itemId, title);
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() { return issueNumber; }
    public void setIssueNumber(int issueNumber) { this.issueNumber = issueNumber; }

    @Override
    public int getLoanPeriodDays() { return 7; }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate > 0 ? daysLate * 0.20 : 0.0;   
    }

    @Override
    public String getItemType() { return "Magazine"; }

    @Override
    public void displayInfo() {              
        super.displayInfo();
        System.out.println("           Issue No: " + issueNumber + " | Loan period: " + getLoanPeriodDays() + " days");
    }
}