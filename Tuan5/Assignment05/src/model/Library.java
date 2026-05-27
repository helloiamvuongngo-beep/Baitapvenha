package model;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Reader> readers;

    public Library() {
        books = new ArrayList<>();
        readers = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addReader(Reader reader) {
        readers.add(reader);
    }

    public void showAllBooks() {
        System.out.println("========== DANH SACH SACH ==========");
        if (books.isEmpty()) {
            System.out.println("(Chua co sach nao.)");
        } else {
            for (int i = 0; i < books.size(); i++) {
                System.out.println("--- Sach " + (i + 1) + " ---");
                System.out.println(books.get(i));
            }
        }
    }

    public void showAllReaders() {
        System.out.println("=== DANH SACH DOC GIA ===");
        for (Reader r : readers) {
            System.out.println(r.getInfo());
        }
    }

    public void showLateFees(int daysLate) {
        System.out.println("=== PHI PHAT TRE HAN (" + daysLate + " ngay) ===");
        for (Reader r : readers) {
            System.out.printf("%-25s | Fee: %,.0f VND%n",
                r.getFullName(), r.calculateLateFee(daysLate));
        }
    }
}
