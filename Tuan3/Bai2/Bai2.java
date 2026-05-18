package Tuan3.Bai2;

class Rectangle {
    double width;
    double height;

    Rectangle() {
        width = 1;
        height = 1;
    }

    Rectangle(double side) {
        width = side;
        height = side;
    }

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    Rectangle(Rectangle other) {
        this.width = other.width;
        this.height = other.height;
    }

    double getArea() {
        return width * height;
    }

    double getPerimeter() {
        return (width + height) * 2;
    }

    boolean isSquare() {
        return width == height;
    }

    void scale(double factor) {
        this.width = this.width * factor;
        this.height = this.height * factor;
    }
}

public class Bai2 {

    public static void main(String[] args) {
        Rectangle hinh1 = new Rectangle();
        System.out.println("--- Hình 1 (Không tham số) ---");
        System.out.println("Kích thước: " + hinh1.width + " x " + hinh1.height);
        System.out.println("Diện tích: " + hinh1.getArea());
        System.out.println("Chu vi: " + hinh1.getPerimeter());
        System.out.println("Có phải hình vuông? " + (hinh1.isSquare() ? "Phải" : "Không"));

        Rectangle hinh2 = new Rectangle(5);
        System.out.println("\n--- Hình 2 (1 tham số side = 5) ---");
        System.out.println("Diện tích: " + hinh2.getArea());
        System.out.println("Có phải hình vuông? " + (hinh2.isSquare() ? "Phải" : "Không"));

        Rectangle hinh3 = new Rectangle(4, 6);
        System.out.println("\n--- Hình 3 (2 tham số 4 x 6) ---");
        System.out.println("Diện tích: " + hinh3.getArea());
        System.out.println("Chu vi: " + hinh3.getPerimeter());
        System.out.println("Có phải hình vuông? " + (hinh3.isSquare() ? "Phải" : "Không"));

        Rectangle hinh4 = new Rectangle(hinh3);
        System.out.println("\n--- Hình 4 (Sao chép từ Hình 3) ---");
        System.out.println("Kích thước ban đầu: " + hinh4.width + " x " + hinh4.height);

        hinh4.scale(2);
        System.out.println("Kích thước sau khi phóng to gấp 2 lần: " + hinh4.width + " x " + hinh4.height);
        System.out.println("Diện tích mới: " + hinh4.getArea());
    }
}
/* Đề bài: Tại sao không thể có 2 constructor cùng nhận 1 tham số double? Hãy thử và giải thích lỗi.
 
  1. ĐOẠN CODE THỬ NGHIỆM CỐ TÌNH GÂY LỖI:
 class Rectangle {
  double width;
  double height;
 
 // Constructor A: Nhận 1 tham số double
 Rectangle(double side) {
 
  this.width = side;
  this.height = side;
  }
 
// Constructor B: Cố tình viết thêm 1 hàm nữa cũng nhận 1 tham số double
 Rectangle(double width) {
  this.width = width;
  this.height = 1.0;
 }
 }
  2. THÔNG BÁO LỖI THỰC TẾ TỪ TRÌNH BIÊN DỊCH JAVA:
 - Lỗi hiển thị trong VS Code: 
  "Duplicate method Rectangle(double) in type Rectangle"
 - Lỗi khi chạy bằng Terminal (javac): 
  "error: constructor Rectangle(double) is already defined in class Rectangle"
  3. GIẢI THÍCH NGUYÊN NHÂN LỖI:
  - Nguyên nhân 1 (Java không nhìn tên biến): 
    Khi thực hiện nạp chồng phương thức (Overloading), Java chỉ phân biệt các hàm 
    dựa vào KIỂU DỮ LIỆU và SỐ LƯỢNG của tham số, chứ hoàn toàn KHÔNG QUAN TÂM 
    đến tên biến bạn đặt là 'side' hay 'width'. Đối với trình biên dịch, cả hai 
    constructor trên đều có chung một nhận diện là: Rectangle(double).
  - Nguyên nhân 2 (Gây ra sự mập mờ - Ambiguity): 
    Giả sử nếu Java cho phép viết như vậy, thì khi xuống hàm main() ta gọi lệnh:
    Rectangle hinh = new Rectangle(5.0);
    Lúc này máy tính sẽ bị "lú" vì không thể xác định được số 5.0 kia là đang muốn 
   truyền vào 'side' của Constructor A hay 'width' của Constructor B. 
   Để ngăn chặn sự mập mờ này, Java bắt lỗi ngay từ vòng biên dịch.
 */