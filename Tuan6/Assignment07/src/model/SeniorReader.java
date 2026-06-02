package model;

public class SeniorReader extends Reader {
    public SeniorReader(String readerId, String fullName) {
        super(readerId, fullName);
    }

    @Override
    public int getMaxBorrowLimit() {
        return 4;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return 0.0;
    }

    @Override
    public String getInfo() {
        return "[NCT] " + readerId + " | " + fullName + " | Han muon: " + getMaxBorrowLimit() + " cuon";
    }

    @Override
    protected boolean checkSpecialCondition(Book book) {
        return true;
    }

    @Override
    protected String getSpecialConditionMessage() {
        return "";
    }

    @Override
    protected void onBorrowSuccess(Book book) {
        super.onBorrowSuccess(book);
        System.out.println("  -> Da ghi nhan: Nguoi cao tuoi \u2014 khong thu phi phat");
    }
}
