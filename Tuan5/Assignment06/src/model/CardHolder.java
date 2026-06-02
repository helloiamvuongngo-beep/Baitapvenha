package model;

public abstract class CardHolder extends Reader {
    protected String cardExpiryDate;

    public CardHolder(String readerId, String fullName, String cardExpiryDate) {
        super(readerId, fullName);
        this.cardExpiryDate = cardExpiryDate;
    }

    public String getCardExpiryDate() {
        return cardExpiryDate;
    }

    public void setCardExpiryDate(String cardExpiryDate) {
        this.cardExpiryDate = cardExpiryDate;
    }

    public void renewCard(int months) {
        System.out.println("Gia han the cua " + getFullName() + " them " + months + " thang.");
    }

    @Override
    public String getInfo() {
        return readerId + " | " + fullName + " | Han the: " + cardExpiryDate;
    }
}
