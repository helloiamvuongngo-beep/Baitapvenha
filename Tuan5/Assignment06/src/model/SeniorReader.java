package model;

/*
 * Tra loi cau hoi ly thuyet:
 * 1. Khi SeniorReader.getInfo() goi super.getInfo(), phien ban getInfo() cua lop cha CardHolder 
 *    (trien khai thuc te ke thua tu Reader) se duoc goi.
 * 2. Day KHONG phai la dynamic binding (lien ket dong) ma la static binding (lien ket tinh).
 * 3. Vi viec su dung tu khoa 'super' cho phep trinh bien dich (compiler) xac dinh truc tiep 
 *    va duy nhat phuong thuc can goi cua lop cha ngay tai thoi diem bien dich (compile-time), 
 *    khong can phu thuoc vao kieu runtime thuc te cua doi tuong.
 */
public class SeniorReader extends CardHolder {
    private String seniorCardNumber;

    public SeniorReader(String readerId, String fullName, String seniorCardNumber, String cardExpiryDate) {
        super(readerId, fullName, cardExpiryDate);
        this.seniorCardNumber = seniorCardNumber;
    }

    public String getSeniorCardNumber() {
        return seniorCardNumber;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return 0.0;
    }

    @Override
    public int getMaxBorrowLimit() {
        return Integer.MAX_VALUE;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " | Ma the: " + seniorCardNumber + " [NCT - MIEN PHAT]";
    }
}
