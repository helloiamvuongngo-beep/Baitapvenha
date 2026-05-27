package model;

public class LibraryCard extends DigitalAccount {
    private String rfidCode;

    public LibraryCard(String cardOwner, String rfidCode) {
        super("CARD-" + rfidCode, cardOwner);
        this.rfidCode = rfidCode;
    }

    @Override
    public boolean authenticate(String credential) {
        return this.rfidCode.equals(credential);
    }

    @Override
    public int getDownloadLimit() {
        return 2;
    }
}
