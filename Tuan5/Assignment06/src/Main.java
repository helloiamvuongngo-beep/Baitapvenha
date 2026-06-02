import model.Reader;
import model.CardHolder;
import model.StudentReader;
import model.FacultyReader;
import model.SeniorReader;
import model.GuestReader;
import model.Library;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        StudentReader student = new StudentReader("SV001", "Nguyen Van An", "31/12/2026");
        FacultyReader faculty = new FacultyReader("GV001", "Tran Thi Binh", "01/06/2028");
        SeniorReader senior = new SeniorReader("NCT001", "Le Hoang Phuoc", "CC2024001", "31/12/2030");
        GuestReader guest = new GuestReader("KH001", "Pham Van Guest");

        library.addReader(student);
        library.addReader(faculty);
        library.addReader(senior);
        library.addReader(guest);

        System.out.println("=== 1. DANH SACH TAT CA DOC GIA (DYNAMIC BINDING) ===");
        library.printAllReaders();

        System.out.println("\n=== 2. TINH TONG PHI PHAT CUA DOC GIA (POLYMORPHISM) ===");
        int daysLate = 5;
        double totalLateFee = library.calculateTotalLateFee(daysLate);
        System.out.println("Tong phi phat tre han " + daysLate + " ngay la: " + totalLateFee + " VND");

        System.out.println("\n=== 3. TIM KIEM DOC GIA THEO TEN ===");
        String searchName = "binh";
        Reader foundReader = library.findReaderByName(searchName);
        if (foundReader != null) {
            System.out.println("Tim thay doc gia phu hop: " + foundReader.getInfo());
        } else {
            System.out.println("Khong tim thay doc gia co ten chua: " + searchName);
        }

        System.out.println("\n=== 4. LOC DOC GIA NGUOI CA TUOI (DOWNCASTING) ===");
        library.printSeniorReaders();

        System.out.println("\n=== 5. GIA HAN THE CHO CAC CON CUA CARDHOLDER (LSP COMPLIANT) ===");
        List<CardHolder> cardHolders = new ArrayList<>();
        cardHolders.add(student);
        cardHolders.add(faculty);
        cardHolders.add(senior);
        library.renewAllCardHolders(cardHolders, 6);

        System.out.println("\n=== 6. BAO CAO PHI PHAT CHO CA BON DOC GIA (POLYMORPHISM & LSP VERIFICATION) ===");
        library.printFeeReport(library.getReaders(), daysLate);
    }
}
