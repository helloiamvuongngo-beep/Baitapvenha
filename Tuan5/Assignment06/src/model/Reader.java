package model;

public abstract class Reader {
    protected String readerId;
    protected String fullName;

    public Reader(String readerId, String fullName) {
        this.readerId = readerId;
        this.fullName = fullName;
    }

    public String getReaderId() {
        return readerId;
    }

    public String getFullName() {
        return fullName;
    }

    public abstract String getInfo();

    public abstract double calculateLateFee(int daysLate);

    public abstract int getMaxBorrowLimit();
}
