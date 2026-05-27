import model.Book;
import model.Lecturer;
import model.Library;
import model.Student;
import model.Reader;
import model.DigitalAccount;
import model.StudentAccount;
import model.LecturerAccount;
import model.GuestAccount;
import model.LibraryCard;
public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("B001", "Lap trinh Java", "Nguyen Manh", 2022, 10);
        Book b2 = new Book("B002", "CTDL va GT",    "Tran Hung",   2021, 5);

        Reader sv = new Student("R001", "Le Van C", "c@student.edu", "The thuong");
        Reader gv = new Lecturer("R002", "Pham Thi D", "d@uni.edu", "CNTT");


        Library lib = new Library();
        lib.addBook(b1);
        lib.addBook(b2);
        lib.addReader(sv);
        lib.addReader(gv);

        lib.showAllBooks();
        lib.showAllReaders();
        lib.showLateFees(7);

        System.out.println("\nHan muon:");
        Reader[] readers = { sv, gv };
        for (Reader r : readers) {
            System.out.println(r.getFullName() + ": " + r.getMaxBorrow() + " cuon");
        }

        System.out.println("\n========== KIEM CHUNG TAI KHOAN SO ==========");
        DigitalAccount studentAcc = new StudentAccount((Student) sv, "pass123");
        System.out.println("--- Thu tai eBook: StudentAccount ---");
        for (int i = 0; i < 4; i++) {
            studentAcc.requestDownload(i);
        }

        DigitalAccount lecturerAcc = new LecturerAccount((Lecturer) gv);
        System.out.println("\n--- Thu tai eBook: LecturerAccount ---");
        for (int i = 0; i < 5; i++) {
            lecturerAcc.requestDownload(i);
        }

        DigitalAccount guestAcc = new GuestAccount("Khach Vang Lai");
        System.out.println("\n--- Thu tai eBook: GuestAccount ---");
        for (int i = 0; i < 2; i++) {
            guestAcc.requestDownload(i);
        }
        
        DigitalAccount cardAcc = new LibraryCard("Nguyen Van A", "RFID999");
        System.out.println("\n--- Thu tai eBook: LibraryCard ---");
        for (int i = 0; i < 3; i++) {
            cardAcc.requestDownload(i);
        }
    }
}
