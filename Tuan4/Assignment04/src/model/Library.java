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

    public void printBooks() {
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

    public void printReaders() {
        System.out.println("========== DANH SACH DOC GIA ==========");
        if (readers.isEmpty()) {
            System.out.println("(Chua co doc gia nao.)");
        } else {
            for (int i = 0; i < readers.size(); i++) {
                System.out.println("--- Doc gia " + (i + 1) + " ---");
                System.out.println(readers.get(i));
            }
        }
    }
}
