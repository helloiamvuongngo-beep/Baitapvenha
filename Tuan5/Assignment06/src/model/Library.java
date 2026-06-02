package model;

import java.util.ArrayList;
import java.util.List;

/*
 * PHAN TICH VI PHAM NGUYEN LY LSP (Liskov Substitution Principle):
 * 1. Thiet ke cu dinh nghia phuong thuc renewCard(int months) truc tiep tren lop cha abstract Reader.
 *    Nhu vay, theo LSP, moi lop con ke thua Reader deu phai co kha nang thuc thi va thay the cho Reader 
 *    ma khong lam thay doi tinh dung dan cua chuong trinh.
 * 2. Ham renewAllReaders(List<Reader> readers, int months) ky vong rang bat ky Reader nao trong danh sach
 *    cung ho tro va thuc hien thanh cong viec gia han the (renewCard).
 * 3. Tuy nhien, GuestReader (khach vang lai doc tai cho) hoan toan khong co the de gia han, do do lop nay 
 *    phai throw UnsupportedOperationException. Khi ham renewAllReaders gap mot GuestReader, no se bi crash
 *    giua chung, lam pha vo ky vong va lam giam do tin cay cua he thong. Day la su vi pham nghiem trong nguyen ly LSP.
 */
public class Library {
    private List<Reader> readers;

    public Library() {
        this.readers = new ArrayList<>();
    }

    public void addReader(Reader reader) {
        readers.add(reader);
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void printAllReaders() {
        for (Reader r : readers) {
            System.out.println(r.getInfo());
        }
    }

    public double calculateTotalLateFee(int daysLate) {
        double total = 0.0;
        for (Reader r : readers) {
            total += r.calculateLateFee(daysLate);
        }
        return total;
    }

    public Reader findReaderByName(String keyword) {
        for (Reader r : readers) {
            if (r.getFullName().toLowerCase().contains(keyword.toLowerCase())) {
                return r;
            }
        }
        return null;
    }

    public void printSeniorReaders() {
        for (Reader r : readers) {
            if (r instanceof SeniorReader) {
                SeniorReader sr = (SeniorReader) r;
                /*
                 * GIAI THICH VE DOWNCASTING:
                 * Ta khong the goi truc tiep r.getSeniorCardNumber() qua bien kieu Reader r vi kieu khai bao
                 * tinh (static type) cua r la Reader. Lop Reader khong dinh nghia phuong thuc getSeniorCardNumber()
                 * ma chi co cac phuong thuc chung nhu getInfo() hay calculateLateFee(). Do do, ta can dung 
                 * instanceof de kiem tra neu doi tuong thuc te la SeniorReader va downcast sang kieu SeniorReader 
                 * de truy cap cac phuong thuc rieng cua no mot cach an toan.
                 */
                System.out.println(sr.getInfo() + " | Ma the NCT: " + sr.getSeniorCardNumber());
            }
        }
    }

    public void renewAllCardHolders(List<CardHolder> holders, int months) {
        for (CardHolder holder : holders) {
            holder.renewCard(months);
        }
    }

    public void printFeeReport(List<Reader> readers, int daysLate) {
        System.out.println("=== BAO CAO PHI PHAT TRE HAN (" + daysLate + " ngay) ===");
        for (Reader r : readers) {
            System.out.printf("  %-20s | Phi phat: %6.0f VND%n", r.getFullName(), r.calculateLateFee(daysLate));
        }
    }
}
