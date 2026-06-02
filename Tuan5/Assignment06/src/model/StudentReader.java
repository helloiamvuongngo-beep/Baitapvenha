package model;

public class StudentReader extends CardHolder {
    public StudentReader(String readerId, String fullName, String cardExpiryDate) {
        super(readerId, fullName, cardExpiryDate);
    }

    @Override
    public int getMaxBorrowLimit() {
        return 3;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return 2000.0 * daysLate;
    }

    @Override
    public String getInfo() {
        return "[SV] " + readerId + " | " + fullName + " | Han muon: " + getMaxBorrowLimit() + " cuon | Han the: " + cardExpiryDate;
    }
}
