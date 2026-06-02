package model;

public class FacultyReader extends Reader {
    public FacultyReader(String readerId, String fullName) {
        super(readerId, fullName);
    }

    @Override
    public int getMaxBorrowLimit() {
        return 5;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return 1000.0 * daysLate;
    }

    @Override
    public String getInfo() {
        return "[GV] " + readerId + " | " + fullName + " | Han muon: " + getMaxBorrowLimit() + " cuon";
    }

    @Override
    protected boolean checkSpecialCondition(Book book) {
        return true;
    }

    @Override
    protected String getSpecialConditionMessage() {
        return "";
    }
}
