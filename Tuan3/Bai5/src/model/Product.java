package model;

import util.ProductValidator;

public class Product {
    private String productCode;
    private String name;
    private double price;
    private int quantity;
    
    private Category category;
    private boolean isDiscontinued;

    private static int counter = 1;
    private static int totalProducts = 0;
    private static double totalRevenue = 0;

    public Product() {
        this.productCode = String.format("P-%04d", counter++);
        this.name = "Unknown";
        this.price = 0.0;
        this.quantity = 0;
        this.isDiscontinued = false;
        totalProducts++;
    }

    public Product(String name, double price) {
        this();
        setName(name);
        setPrice(price);
    }

    public Product(String name, double price, int quantity) {
        this(name, price);
        setQuantity(quantity);
    }

    public String getProductCode() {
        return productCode;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Category getCategory() {
        return category;
    }

    public boolean isDiscontinued() {
        return isDiscontinued;
    }

    public void setName(String name) {
        if (ProductValidator.isValidName(name)) {
            this.name = name;
        } else {
            System.out.println("Lỗi: Tên sản phẩm không hợp lệ (không rỗng, dài >= 2).");
        }
    }

    public void setPrice(double price) {
        if (ProductValidator.isValidPrice(price)) {
            this.price = price;
        } else {
            System.out.println("Lỗi: Giá sản phẩm phải >= 0.");
        }
    }

    public void setQuantity(int quantity) {
        if (ProductValidator.isValidQuantity(quantity)) {
            this.quantity = quantity;
        } else {
            System.out.println("Lỗi: Số lượng sản phẩm phải >= 0.");
        }
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void sell(int amount) {
        if (isDiscontinued) {
            System.out.println("Lỗi: Sản phẩm " + productCode + " đã ngừng kinh doanh, không thể bán.");
            return;
        }
        if (amount > 0 && amount <= quantity) {
            quantity -= amount;
            totalRevenue += amount * price;
            System.out.println("Đã bán " + amount + " sản phẩm " + name + ". Thu về: " + (amount * price));
        } else {
            System.out.println("Lỗi: Số lượng bán không hợp lệ hoặc vượt quá tồn kho.");
        }
    }

    public void restock(int amount) {
        if (isDiscontinued) {
            System.out.println("Lỗi: Sản phẩm " + productCode + " đã ngừng kinh doanh, không thể nhập hàng.");
            return;
        }
        if (amount > 0) {
            quantity += amount;
            System.out.println("Đã nhập thêm " + amount + " sản phẩm " + name + ". Tồn kho hiện tại: " + quantity);
        } else {
            System.out.println("Lỗi: Số lượng nhập phải lớn hơn 0.");
        }
    }

    public void displayInfo() {
        System.out.println("--- Thông tin sản phẩm ---");
        System.out.println("Mã SP: " + productCode);
        System.out.println("Tên SP: " + name);
        System.out.println("Giá: " + price);
        System.out.println("Số lượng tồn: " + quantity);
        if (category != null) {
            System.out.println("Danh mục: " + category.getCategoryName());
        }
        System.out.println("Trạng thái: " + (isDiscontinued ? "Ngừng kinh doanh" : "Đang kinh doanh"));
        System.out.println("--------------------------");
    }

    public void applyPromotion(double discountPercent) {
        if (discountPercent > 0 && discountPercent <= 100) {
            this.price = this.price * (1 - discountPercent / 100.0);
            System.out.println("Sản phẩm " + name + " đã được giảm " + discountPercent + "%. Giá mới: " + this.price);
        } else {
            System.out.println("Lỗi: Phần trăm giảm giá không hợp lệ.");
        }
    }

    /*
     * Suy nghĩ về phương thức discontinue():
     * Khi một sản phẩm bị "hủy" (ngừng kinh doanh), nó không biến mất khỏi lịch sử.
     * Thuộc tính totalProducts có thể hiểu theo 2 nghĩa:
     * 1. Tổng số loại sản phẩm ĐÃ TỪNG được tạo ra -> Không nên giảm.
     * 2. Tổng số loại sản phẩm ĐANG CÒN kinh doanh -> Nên giảm.
     * 
     * Lựa chọn ở đây: Mình xem totalProducts là "tổng số sản phẩm hiện đang được bán", 
     * nên khi ngừng kinh doanh, mình sẽ giảm totalProducts để báo cáo phản ánh chính xác số mặt hàng còn bán.
     * Mình thêm một cờ isDiscontinued để ngăn chặn việc sell() và restock() sau khi hủy.
     */
    public void discontinue() {
        if (!isDiscontinued) {
            this.isDiscontinued = true;
            if (totalProducts > 0) {
                totalProducts--;
            }
            System.out.println("Sản phẩm " + name + " đã ngừng kinh doanh.");
        }
    }

    public static int getTotalProducts() {
        return totalProducts;
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }

    public static String getStoreReport() {
        return String.format("=== BÁO CÁO CỬA HÀNG ===\nTổng số sản phẩm đang kinh doanh: %d\nTổng doanh thu: %.2f\n========================", totalProducts, totalRevenue);
    }

    public static void applyGlobalPromotion(Product[] products, double discountPercent) {
        System.out.println("--- Áp dụng giảm giá " + discountPercent + "% cho toàn bộ danh sách ---");
        for (Product p : products) {
            if (p != null && !p.isDiscontinued()) {
                p.applyPromotion(discountPercent);
            }
        }
    }
}
