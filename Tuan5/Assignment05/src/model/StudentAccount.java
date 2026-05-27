package model;

public class StudentAccount extends DigitalAccount {
    private Student student;
    private String password;

    public StudentAccount(Student student, String password) {
        super(student.getReaderID(), student.getFullName());
        this.student = student;
        this.password = password;
    }

    @Override
    public boolean authenticate(String credential) {
        String expectedCredential = student.getEmail() + ":" + password;
        return expectedCredential.equals(credential);
    }

    @Override
    public int getDownloadLimit() {
        return 3;
    }
}
