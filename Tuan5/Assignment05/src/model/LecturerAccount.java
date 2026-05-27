package model;

public class LecturerAccount extends DigitalAccount {
    private String email;

    public LecturerAccount(Lecturer lecturer) {
        super(lecturer.getReaderID(), lecturer.getFullName());
        this.email = lecturer.getEmail();
    }

    @Override
    public boolean authenticate(String credential) {
        String[] parts = credential.split(":");
        if (parts.length == 2) {
            String inputEmail = parts[0];
            String inputOtp = parts[1];
            return inputEmail.equals(this.email) && "123456".equals(inputOtp);
        }
        return false;
    }

    @Override
    public int getDownloadLimit() {
        return -1;
    }
}
