package model;

public class FacultyReader extends CardHolder {
    public FacultyReader(String readerId, String fullName, String cardExpiryDate) {
        super(readerId, fullName, cardExpiryDate);
    }

    @Override
    public int getMaxBorrowLimit() {
        return 5;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return 5000.0 * daysLate;
    }

    @Override
    public String getInfo() {
        return "[GV] " + readerId + " | " + fullName + " | Han muon: " + getMaxBorrowLimit() + " cuon | Han the: " + cardExpiryDate;
    }
}
