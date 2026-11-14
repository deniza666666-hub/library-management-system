public class StudentMember extends Person {
    private String program;

    public StudentMember(String name, String id, String program) {
        super(name, id);
        this.program = program;
    }

    public String getProgram() { return program; }
    public void setProgram(String program) { this.program = program; }

    @Override
    public int getMaxLoans() { return 3; }

    @Override
    public String getRole() { return "Student"; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("         Program: " + program);
    }
}