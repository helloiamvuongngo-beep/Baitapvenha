package Tuan3.Bai1;

class Book {
    String title;
    String author;
    int year;
    double price;
    
    Book() {
        title = "Unknown";
        author = "Unknown";
        year = 2000;
        price = 0;
    }

    Book(String title, String author, int year, double price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.year = 2026;       
        this.price = 100000;    
    }

    void displayInfo() {
        System.out.println("Sách: [" + title + "] - Tác giả: [" + author + "] - Năm: [" + year + "] - Giá: [" + price + "]");
    }

    void applyDiscount(double percent) {
        price = price - (price * percent / 100);
        System.out.println("=> Đã áp dụng giảm giá " + percent + "% cho cuốn '" + title + "'");
    }
}
public class Bai1 {
    public static void main(String[] args) {
        
        Book sach1 = new Book();
        System.out.println("--- Sách 1 (Dùng Constructor mặc định) ---");
        sach1.displayInfo();

        Book sach2 = new Book("Số Đỏ", "Vũ Trọng Phụng", 1936, 75000);
        System.out.println("\n--- Sách 2 (Dùng Constructor 4 tham số) ---");
        sach2.displayInfo();

        Book sach3 = new Book("Tắt Đèn", "Ngô Tất Tố");
        System.out.println("\n--- Sách 3 (Dùng Constructor 2 tham số - Điểm cộng) ---");
        sach3.displayInfo();

        sach3.applyDiscount(10);
        System.out.print("Thông tin sách 3 sau khi giảm giá: ");
        sach3.displayInfo();
    }
}