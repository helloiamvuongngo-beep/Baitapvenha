import model.Book;
import model.Lecturer;
import model.Library;
import model.Student;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book b1 = new Book("B001", "Lap trinh Java co ban", "Tran Van A", 2020, 10);
        Book b2 = new Book("B002", "Cau truc du lieu & GT", "Nguyen Thi B", 2019, 5);
        Book b3 = new Book("B003", "Co so du lieu", "Le Van C", 2021, 8);

        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);

        Student s1 = new Student("SV001", "Nguyen Van Hung", "hung@sv.edu.vn", "The thuong");
        Student s2 = new Student("SV002", "Tran Thi Mai", "mai@sv.edu.vn", "The uu tien");

        library.addReader(s1);
        library.addReader(s2);

        Lecturer l1 = new Lecturer("GV001", "TS. Pham Quoc Bao", "bao@hcmute.edu.vn", "CNTT");
        Lecturer l2 = new Lecturer("GV002", "ThS. Le Ngoc Lan", "lan@hcmute.edu.vn", "Dien - Dien tu");

        library.addReader(l1);
        library.addReader(l2);

        library.showAllBooks();
        System.out.println();
        library.showAllReaders();

        System.out.println("\n========== KIEM CHUNG KE THUA ==========");
        System.out.printf("%-20s %-30s %s%n", "Loai", "Ho ten", "Muon toi da");
        System.out.println("-".repeat(58));
        System.out.printf("%-20s %-30s %d cuon%n", "Student",  s1.getFullName(), s1.getMaxBorrow());
        System.out.printf("%-20s %-30s %d cuon%n", "Student",  s2.getFullName(), s2.getMaxBorrow());
        System.out.printf("%-20s %-30s %d cuon%n", "Lecturer", l1.getFullName(), l1.getMaxBorrow());
        System.out.printf("%-20s %-30s %d cuon%n", "Lecturer", l2.getFullName(), l2.getMaxBorrow());
    }
}
