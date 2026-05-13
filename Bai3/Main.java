package Bai3;

class Circle {
    double radius;
    double area() {
        return Math.PI * radius * radius;
    }
    double circumference() {
        return 2 * Math.PI * radius;
    }
}

public class Main {
    public static void main(String[] args) {
        Circle[] danhSachHinhTron = new Circle[5];

        for (int i = 0; i < danhSachHinhTron.length; i++) {
            danhSachHinhTron[i] = new Circle();
            danhSachHinhTron[i].radius = (i + 1) * 2;
        }

        double tongDienTich = 0;

        System.out.println("--- Thông tin các hình tròn trong mảng ---");
        for (int i = 0; i < danhSachHinhTron.length; i++) {
            double dt = danhSachHinhTron[i].area();
            System.out.println("Hình tròn " + (i + 1) + " (r=" + danhSachHinhTron[i].radius + ") có DT: " + dt);
            
            tongDienTich = tongDienTich + dt;
        }

        System.out.println("------------------------------------------");
        System.out.println("=> TỔNG DIỆN TÍCH CỦA TẤT CẢ CÁC HÌNH: " + tongDienTich);
    }
}