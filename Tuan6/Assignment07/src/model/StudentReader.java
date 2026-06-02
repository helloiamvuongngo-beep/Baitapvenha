package model;

public class StudentReader extends Reader {
    public StudentReader(String readerId, String fullName) {
        super(readerId, fullName);
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
        return "[SV] " + readerId + " | " + fullName + " | Han muon: " + getMaxBorrowLimit() + " cuon";
    }

    @Override
    protected boolean checkSpecialCondition(Book book) {
        return !book.isReferenceOnly();
    }

    @Override
    protected String getSpecialConditionMessage() {
        return "Sach tham khao chi doc tai cho \u2014 sinh vien khong duoc mang ve";
    }
}
