import java.util.*;

public class LibraryManager {

    public void processAllBorrowable(List<Borrowable> items) {
        System.out.println("=== BORROWABLE ITEM STATUS ===");
        for (Borrowable item : items) {
            String s = item.isAvailable()
                ? "Available"
                : "Borrowed by " + item.getBorrowerId();
            System.out.println("  -> " + s);
        }
    }

    public void notifyAll(List<Notifiable> users, String message) {
        System.out.println("=== SENDING NOTIFICATIONS ===");
        for (Notifiable user : users) {
            user.sendNotification(message);
        }
    }

    public static void main(String[] args) {
        LibraryManager mgr = new LibraryManager();

        List<Borrowable> items = new ArrayList<>();
        Book b1 = new Book("B001", "Clean Code", "Robert Martin");
        Book b2 = new Book("B002", "Design Patterns", "GoF");
        b1.borrowBy("R001", "2024-09-01");
        items.add(b1); items.add(b2);
        mgr.processAllBorrowable(items);

        List<Notifiable> readers = new ArrayList<>();
        readers.add(new Reader("R001", "Ngo Doan Duc Vuong"));
        readers.add(new Reader("R002", "Trinh Gia Bao"));
        mgr.notifyAll(readers, "Thu vien se dong cua ngay 20/9.");
    }
}
