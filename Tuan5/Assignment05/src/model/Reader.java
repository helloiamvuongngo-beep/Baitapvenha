package model;

public abstract class Reader {
    private String readerID;
    private String fullName;
    private String email;

    public Reader(String readerID, String fullName, String email) {
        this.readerID = readerID;
        this.fullName = fullName;
        this.email = email;
    }

    public String getReaderID() { return readerID; }
    public void setReaderID(String readerID) { this.readerID = readerID; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public abstract int getMaxBorrow();

    public abstract double calculateLateFee(int daysLate);

    public abstract String getInfo();
}
