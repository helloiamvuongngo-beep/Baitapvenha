package model;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Reader> readers;
    private LateFeePolicy feePolicy;

    public Library() {
        this.books = new ArrayList<>();
        this.readers = new ArrayList<>();
        this.feePolicy = new StandardFeePolicy();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addReader(Reader reader) {
        readers.add(reader);
    }

    public void setFeePolicy(LateFeePolicy policy) {
        this.feePolicy = policy;
    }

    /*
     * Thiet ke nay tuan thu Nguyen ly Dong/Mo (Open/Closed Principle - OCP).
     * Khi can thay doi hoac bo sung mot chinh sach tinh phi phat tre han moi, ta chi can tao mot lop moi
     * trien khai interface LateFeePolicy (Open for extension) ma khong can phai chinh sua bat ky
     * logic cot loi nao ben trong lop Library hay cac lop Reader (Closed for modification).
     */
    public double calculateTotalFee(int daysLate) {
        double total = 0;
        for (Reader r : readers) {
            double baseFee = r.calculateLateFee(daysLate);
            double adjustedFee = feePolicy.applyPolicy(baseFee);
            System.out.printf("  %-20s | Base: %6.0f | Sau CS: %6.0f VND%n", r.getFullName(), baseFee, adjustedFee);
            total += adjustedFee;
        }
        System.out.printf("Tong phi phat (%s): %.0f VND%n", feePolicy.getPolicyName(), total);
        return total;
    }
}
