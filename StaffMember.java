public class StaffMember extends Person {
    private String department;

    public StaffMember(String name, String id, String department) {
        super(name, id);
        this.department = department;
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    @Override
    public int getMaxLoans() { return 5; }

    @Override
    public String getRole() { return "Staff"; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("         Department: " + department);
    }
}