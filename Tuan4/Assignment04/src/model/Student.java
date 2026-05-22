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
    public String toString() {
        return super.toString()
             + "\nLoai the   : " + cardType + " (Sinh vien)";
    }
}
