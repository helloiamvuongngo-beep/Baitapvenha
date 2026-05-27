package Tuan3.Bai3;

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        
        if (balance < 0) {
            System.out.println("Cảnh báo: Số dư tài khoản không được âm! Đã tự động gán bằng 0.");
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountHolder(String accountHolder) {
        if (accountHolder != null && !accountHolder.trim().isEmpty()) {
            this.accountHolder = accountHolder;
        } else {
            System.out.println("Lỗi: Tên chủ tài khoản mới không hợp lệ (không được để trống)!");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Nạp thành công " + amount + " VNĐ.");
        } else {
            System.out.println("Lỗi: Số tiền nạp phải lớn hơn 0!");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Lỗi: Số tiền rút phải lớn hơn 0!");
        } else if (amount > this.balance) {
            System.out.println("Lỗi: Số dư tài khoản không đủ để thực hiện giao dịch rút tiền!");
        } else {
            this.balance -= amount;
            System.out.println("Rút thành công " + amount + " VNĐ.");
        }
    }

    public void transfer(BankAccount other, double amount) {
        if (amount <= 0) {
            System.out.println("Lỗi: Số tiền chuyển khoản phải lớn hơn 0!");
        } else if (amount > this.balance) {
            System.out.println("Lỗi: Số dư không đủ để thực hiện chuyển khoản!");
        } else {
            this.balance -= amount;     
            other.balance += amount;    
            System.out.println("Chuyển khoản thành công " + amount + " VNĐ tới tài khoản của " + other.getAccountHolder());
        }
    }

    public void displayInfo() {
        String maskedNumber = "****";
        if (accountNumber != null && accountNumber.length() >= 4) {
            maskedNumber = "****" + accountNumber.substring(accountNumber.length() - 4);
        } else if (accountNumber != null) {
            maskedNumber = accountNumber;
        }
        System.out.println("Tài khoản: [" + maskedNumber + "] - Chủ TK: [" + accountHolder + "] - Số dư: [" + balance + " VNĐ]");
    }
}

public class Bai3 {
    public static void main(String[] args) {
        
        System.out.println("--- 1. Thử nghiệm khởi tạo tài khoản hợp lệ ---");
        BankAccount tk1 = new BankAccount("123456789", "Ngô Đoàn Đức Vương", 5000000);
        tk1.displayInfo();

        System.out.println("\n--- 2. Thử nghiệm tính năng nạp và rút tiền thông thường ---");
        tk1.deposit(200000); 
        tk1.displayInfo();
        tk1.withdraw(150000);
        tk1.displayInfo();

        System.out.println("\n--- 3. Thử nghiệm các trường hợp lỗi dữ liệu đầu vào ---");
        System.out.print("Test lỗi nạp tiền âm: ");
        tk1.deposit(-50000);
        
        System.out.print("Test lỗi rút tiền âm: ");
        tk1.withdraw(-20000);
        
        System.out.print("Test lỗi rút tiền vượt quá số dư hiện tại: ");
        tk1.withdraw(9000000);

        System.out.println("\n--- 4. Thử nghiệm khởi tạo tài khoản có số dư âm ban đầu ---");
        BankAccount tk2 = new BankAccount("987654321", "Trần Thị B", -100000);
        tk2.displayInfo();

        System.out.println("\n--- 5. Thử nghiệm tính năng chuyển tiền (Phần mở rộng điểm cộng) ---");
        tk1.transfer(tk2, 200000);
        System.out.print("Thông tin tk1 sau khi chuyển tiền: ");
        tk1.displayInfo();
        System.out.print("Thông tin tk2 sau khi nhận tiền: ");
        tk2.displayInfo();
    }
}

/*
Đề bài: Tại sao số tài khoản không nên có phương thức setter?

Trong lập trình hướng đối tượng nói chung và nghiệp vụ hệ thống ngân hàng thực tế nói riêng, 
số tài khoản (accountNumber) là một thuộc tính mang tính chất định danh duy nhất (Unique Identifier) 
dùng để phân biệt các khách hàng. Việc không tạo phương thức setter cho số tài khoản là bắt buộc 
vì các lý do sau:

1. Đảm bảo tính toàn vẹn dữ liệu (Data Integrity): Số tài khoản giống như mã số căn cước 
của chiếc tài khoản đó, một khi đã cấp phát thành công thì giá trị này phải cố định. 
Nếu có hàm setter, lập trình viên có thể vô tình hoặc cố ý thay đổi nó trong lúc hệ thống 
đang vận hành, dẫn đến việc dữ liệu bị sai lệch, trùng lặp hoặc mất liên kết với lịch sử giao dịch cũ.

2. Tính bảo mật và an toàn hệ thống (Security): Tiền bạc và giao dịch luôn gắn liền với 
số tài khoản. Việc chặn quyền sửa đổi trực tiếp (không cấp setter) ngăn chặn các cuộc tấn công
thay đổi thông tin đích hoặc lỗi logic làm dòng tiền chạy sai tài khoản khi ứng dụng đang chạy.

3. Sát với thực tế đời sống: Ngoài đời thực, không bao giờ có thể tự ý "đổi tên" hay "sửa chữ số" 
trên số tài khoản ngân hàng hiện tại của mình được. Nếu muốn một số tài khoản khác, quy trình thực tế 
là phải đăng ký đóng tài khoản cũ và tạo hẳn một tài khoản mới hoàn toàn. Do đó, mã nguồn 
không nên cung cấp tính năng này để phản ánh đúng thực tế nghiệp vụ.
*/
