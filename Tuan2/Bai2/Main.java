package Bai2;

class Rectangle {
    double width; 
    double height;

    double area() {
        return width * height;
    }

    double perimeter() {
        return (width + height) * 2;
    }

    boolean isSquare() {
        if (width == height) {
            return true;
        } else {
            return false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        
        Rectangle hcn1 = new Rectangle();
        hcn1.width = 5.0;
        hcn1.height = 10.0;

        System.out.println("--- Hình chữ nhật 1 ---");
        System.out.println("Diện tích: " + hcn1.area());
        System.out.println("Chu vi: " + hcn1.perimeter());
        System.out.println("Có phải hình vuông không? " + (hcn1.isSquare() ? "Phải" : "Không"));
        Rectangle hcn2 = new Rectangle();
        hcn2.width = 4.0;
        hcn2.height = 4.0;

        System.out.println("\n--- Hình chữ nhật 2 ---");
        System.out.println("Diện tích: " + hcn2.area());
        System.out.println("Chu vi: " + hcn2.perimeter());
        System.out.println("Có phải hình vuông không? " + (hcn2.isSquare() ? "Phải" : "Không"));
    }
}