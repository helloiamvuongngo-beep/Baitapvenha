package Bai1;

class Book {
    String title;
    String author;
    double price;
    boolean inStock;

    void printInfo() {
        System.out.println("---------------------------");
        System.out.println("Tên sách: " + title);
        System.out.println("Tác giả: " + author);
        System.out.println("Giá: " + price + " VNĐ");
        System.out.println("Còn hàng: " + (inStock ? "Có" : "Hết"));
    }

    void applyDiscount(double percent) {
        price = price - (price * percent / 100);
        System.out.println("=> Đã áp dụng giảm giá " + percent + "% cho cuốn " + title);
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));

        Book b1 = new Book();
        b1.title = "Dế Mèn Phiêu Lưu Ký";
        b1.author = "Tô Hoài";
        b1.price = 50000;
        b1.inStock = true;

        Book b2 = new Book();
        b2.title = "Lão Hạc";
        b2.author = "Nam Cao";
        b2.price = 40000;
        b2.inStock = false;

        Book b3 = new Book();
        b3.title = "Java Cơ Bản";
        b3.author = "Giáo Trình CNTT";
        b3.price = 100000;
        b3.inStock = true;

        b1.printInfo();
        b1.applyDiscount(10);
        System.out.println("Giá sau khi giảm: " + b1.price);

        b2.printInfo();
        b2.applyDiscount(10);
        System.out.println("Giá sau khi giảm: " + b2.price);

        b3.printInfo();
        b3.applyDiscount(10);
        System.out.println("Giá sau khi giảm: " + b3.price);
    }
}