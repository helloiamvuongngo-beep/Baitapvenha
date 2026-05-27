package model;

public class Lecturer extends Reader {
    private String department;

    public Lecturer(String readerID, String fullName, String email, String department) {
        super(readerID, fullName, email);
        this.department = department;
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    @Override
    public int getMaxBorrow() {
        return 5;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return 1000.0 * daysLate;
    }

    @Override
    public String getInfo() {
        return "[GV] " + getReaderID() + " | " + getFullName()
             + " | Email: " + getEmail()
             + " | Han muon: " + getMaxBorrow() + " cuon";
    }
}
