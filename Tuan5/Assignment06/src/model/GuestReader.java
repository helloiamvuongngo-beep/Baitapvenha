package model;

public class GuestReader extends Reader {
    public GuestReader(String readerId, String fullName) {
        super(readerId, fullName);
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return 1000.0 * daysLate;
    }

    @Override
    public int getMaxBorrowLimit() {
        return 0;
    }

    @Override
    public String getInfo() {
        return "[Khach] " + readerId + " | " + fullName + " [Doc tai cho]";
    }
}
