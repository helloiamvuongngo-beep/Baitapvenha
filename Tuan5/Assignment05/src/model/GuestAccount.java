package model;

public class GuestAccount extends DigitalAccount {
    
    public GuestAccount(String displayName) {
        super("GUEST-" + System.currentTimeMillis(), displayName);
    }

    @Override
    public boolean authenticate(String credential) {
        return this.displayName.equalsIgnoreCase(credential);
    }

    @Override
    public int getDownloadLimit() {
        return 1;
    }
}
