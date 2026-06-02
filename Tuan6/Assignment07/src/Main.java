import model.Book;
import model.Reader;
import model.StudentReader;
import model.FacultyReader;
import model.SeniorReader;
import model.BorrowResult;
import model.Library;
import model.CharityFeePolicy;
import model.WaivedFeePolicy;

public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("B01", "Giao trinh Java Core", "Tac gia A", 2023, 3, false);
        Book b2 = new Book("B02", "Huong dan Design Patterns", "Tac gia B", 2024, 2, false);
        Book b3 = new Book("B03", "Khao co hoc co dai (Rare)", "Tac gia C", 2015, 1, true);

        Reader student = new StudentReader("SV01", "Nguyen Van An");
        Reader faculty = new FacultyReader("GV01", "Tran Thi Binh");
        Reader senior = new SeniorReader("NCT01", "Le Hoang Phuoc");

        Library library = new Library();
        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);
        library.addReader(student);
        library.addReader(faculty);
        library.addReader(senior);

        System.out.println("=== THU NGHIEM QUY TRINH MUON SACH (TEMPLATE METHOD) ===");

        System.out.println("1. Sinh vien muon sach tham khao hiem:");
        BorrowResult res1 = student.processBorrow(b3);
        System.out.println("   Ket qua: " + res1.getMessage());

        System.out.println("\n2. Sinh vien muon sach thuong:");
        BorrowResult res2 = student.processBorrow(b1);
        System.out.println("   Ket qua: " + res2.getMessage());

        System.out.println("\n3. Nguoi cao tuoi muon sach tham khao hiem:");
        BorrowResult res3 = senior.processBorrow(b3);
        System.out.println("   Ket qua: " + res3.getMessage());

        System.out.println("\n4. Sinh vien muon them cac sach khac de dat gioi han:");
        student.processBorrow(b1);
        student.processBorrow(b2);
        System.out.println("   Muon them cuon thu 4:");
        BorrowResult res4 = student.processBorrow(b2);
        System.out.println("   Ket qua: " + res4.getMessage());

        System.out.println("\n=== THU NGHIEM TINH PHI PHAT (STRATEGY PATTERN) ===");

        System.out.println("Kich ban 1: Giu nguyen mac dinh (Thang binh thuong)");
        library.calculateTotalFee(7);

        System.out.println("\nKich ban 2: Thang tu thien - giam 50%");
        library.setFeePolicy(new CharityFeePolicy());
        library.calculateTotalFee(7);

        System.out.println("\nKich ban 3: Mien phi phat (thang khai truong)");
        library.setFeePolicy(new WaivedFeePolicy());
        library.calculateTotalFee(7);
    }
}
