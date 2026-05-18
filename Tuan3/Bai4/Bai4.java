package Tuan3.Bai4;

class Employee {
    private int id;
    private String name;
    private double salary;

    private static int employeeCount = 0;
    private static int nextId = 1000;
    public static String companyName = "TechCorp";
    private static double totalSalary = 0;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        
        this.id = nextId;     
        nextId++;              
        employeeCount++;    
        totalSalary += salary; 
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        totalSalary = totalSalary - this.salary + salary;
        this.salary = salary;
    }

    public static int getEmployeeCount() {
        return employeeCount;
    }

    public static double getTotalSalary() {
        return totalSalary;
    }

    public static double getAverageSalary() {
        if (employeeCount == 0) {
            return 0;
        }
        return totalSalary / employeeCount;
    }

    public static void changeCompanyName(String newName) {
        companyName = newName;
    }

    public void raiseSalary(double percent) {
        double salaryIncrease = this.salary * (percent / 100); 
        this.salary += salaryIncrease;                      
        totalSalary += salaryIncrease;                        
    }
}

public class Bai4 {
    public static void main(String[] args) {
        
        Employee nv1 = new Employee("Nguyễn Văn A", 10000000); 
        Employee nv2 = new Employee("Trần Thị B", 12000000); 
        Employee nv3 = new Employee("Lê Văn C", 15000000);    

        System.out.println("--- Kiểm tra danh sách ID nhân viên ---");
        System.out.println("Nhân viên 1 -> ID: " + nv1.getId() + " | Tên: " + nv1.getName());
        System.out.println("Nhân viên 2 -> ID: " + nv2.getId() + " | Tên: " + nv2.getName());
        System.out.println("Nhân viên 3 -> ID: " + nv3.getId() + " | Tên: " + nv3.getName());

        System.out.println("\n--- Thống kê ban đầu của công ty [" + Employee.companyName + "] ---");
        System.out.println("Tổng số nhân viên: " + Employee.getEmployeeCount() + " người");
        System.out.printf("Tổng số tiền lương phải trả: %.0f VNĐ\n", Employee.getTotalSalary());
        System.out.printf("Mức lương trung bình: %.2f VNĐ\n", Employee.getAverageSalary());

        System.out.println("\n--- Thực hiện thay đổi lương NV1 từ 10 triệu lên 14 triệu bằng Setter ---");
        nv1.setSalary(14000000); 
        System.out.printf("Tổng lương toàn công ty sau cập nhật: %.0f VNĐ\n", Employee.getTotalSalary());
        System.out.printf("Mức lương trung bình mới: %.2f VNĐ\n", Employee.getAverageSalary());

        System.out.println("\n--- Thực hiện tăng lương NV2 thêm 10% bằng phương thức raiseSalary ---");
        nv2.raiseSalary(10);
        System.out.printf("Lương mới của riêng NV2: %.0f VNĐ\n", nv2.getSalary());
        System.out.printf("Tổng lương toàn công ty sau khi tăng %%: %.0f VNĐ\n", Employee.getTotalSalary());

        System.out.println("\n--- Thực hiện đổi tên công ty bằng phương thức static ---");
        Employee.changeCompanyName("TechCorp Global");
        System.out.println("Tên mới của công ty: " + Employee.companyName);
    }
}

/*
Đề bài: Nếu trong main ta không tạo object nào, gọi Employee.getAverageSalary() 
có chạy được không? Tại sao?

1. Trả lời:
Hoàn toàn CHẠY ĐƯỢC bình thường và không xảy ra bất kỳ lỗi hệ thống nào.

2. Giải thích nguyên nhân:
- Bản chất của từ khóa static: Phương thức getAverageSalary() được định nghĩa là một 
phương thức static. Trong Java, những gì thuộc về static sẽ gắn liền trực tiếp với 
tên Lớp (Class) chứ không hề phụ thuộc vào các đối tượng cụ thể (Object). Vì vậy, 
ta có quyền gọi lệnh Employee.getAverageSalary() bất kỳ lúc nào mà không cần tạo ra đối tượng
bằng từ khóa 'new'.
- An toàn logic thuật toán: Khi không tạo bất kỳ một đối tượng nhân viên nào, biến dữ liệu 
tổng số nhân viên (employeeCount) ban đầu bằng 0 và tổng lương (totalSalary) bằng 0. 
Trong phần xử lý code của hàm getAverageSalary(), chúng ta đã chu đáo viết sẵn một câu lệnh 
điều kiện chặn lỗi: nếu employeeCount == 0 thì lập tức trả về giá trị số 0. Nhờ lệnh kiểm tra
này, chương trình được bảo vệ an toàn, không bị dính vào lỗi toán học nghiêm trọng là phép toán
chia cho số 0 (lỗi gây treo hoặc crash ứng dụng).
*/