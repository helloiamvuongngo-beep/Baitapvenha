import model.Category;
import model.Product;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== KHỞI TẠO SẢN PHẨM ===");
        
        Category electronics = new Category("C01", "Điện tử");
        Category groceries = new Category("C02", "Tạp hóa");

        Product p1 = new Product();
        p1.setCategory(electronics);
        
        Product p2 = new Product("Laptop", 1500.0);
        p2.setCategory(electronics);
        
        Product p3 = new Product("Bim bim", 2.5, 100);
        p3.setCategory(groceries);
        
        Product p4 = new Product("Nước ngọt", 1.2, 50);
        p4.setCategory(groceries);

        System.out.println("\n=== KIỂM TRA MÃ SẢN PHẨM TỰ ĐỘNG ĐÚNG ĐỊNH DẠNG ===");
        Product[] products = {p1, p2, p3, p4};
        for (Product p : products) {
            String code = p.getProductCode();
            boolean isCorrectFormat = code.matches("P-\\d{4}");
            System.out.println("Sản phẩm: " + p.getName() + " - Mã SP: " + code + " -> Đúng định dạng (P-XXXX): " + (isCorrectFormat ? "Có" : "Không"));
        }

        System.out.println("\n=== THÔNG TIN CHI TIẾT SẢN PHẨM ===");
        p1.displayInfo();
        p2.displayInfo();
        p3.displayInfo();
        p4.displayInfo();

        System.out.println("\n=== NGHIỆP VỤ BÁN HÀNG VÀ NHẬP HÀNG ===");
        p2.restock(10);
        p2.sell(2);
        
        p3.sell(20);
        p4.sell(5);

        System.out.println("\n=== KIỂM TRA VALIDATION ===");
        p1.setName("");
        p1.setPrice(-10);
        p1.sell(1000); 

        System.out.println("\n=== PHẦN MỞ RỘNG: KHUYẾN MÃI ===");
        p3.applyPromotion(10); 
        Product.applyGlobalPromotion(new Product[]{p2, p4}, 5);

        System.out.println("\n=== PHẦN MỞ RỘNG: NGỪNG KINH DOANH ===");
        p1.discontinue();
        p1.sell(1); 

        System.out.println("\n=== BÁO CÁO CUỐI CÙNG ===");
        System.out.println(Product.getStoreReport());
    }
}
