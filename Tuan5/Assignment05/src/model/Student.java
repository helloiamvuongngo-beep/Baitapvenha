package model;

public class Student extends Reader {
    private String cardType;

    public Student(String readerID, String fullName, String email, String cardType) {
        super(readerID, fullName, email);
        this.cardType = cardType;
    }

    public String getCardType() { return cardType; }
    public void setCardType(String cardType) { this.cardType = cardType; }

    @Override
    public int getMaxBorrow() {
        return 3;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return 2000.0 * daysLate;
    }

    @Override
    public String getInfo() {
        return "[SV] " + getReaderID() + " | " + getFullName()
             + " | Email: " + getEmail()
             + " | Han muon: " + getMaxBorrow() + " cuon";
    }
}
