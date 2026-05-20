import model.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ThuVien thuVien = new ThuVien();
        ThuThu thuThu = new ThuThu("NV01", "Trần Thủ Thư", thuVien);
        
        thuVien.themSach(new Sach("S01", "Lập trình Java Căn bản", "Quách Tuấn Ngọc", 2023, 2));
        thuVien.themSach(new Sach("S02", "Cấu trúc dữ liệu", "Nguyễn Đức Nghĩa", 2021, 1));
        thuVien.themSach(new Sach("S03", "Clean Code", "Robert C. Martin", 2019, 5));
        
        thuVien.themDocGia(new DocGia("DG01", "Ngô Đoàn Đức Vương", "vuong@email.com", LoaiThe.SINH_VIEN));
        thuVien.themDocGia(new DocGia("DG02", "Giảng Viên Nguyễn Văn A", "gv@email.com", LoaiThe.GIANG_VIEN));

        Scanner scanner = new Scanner(System.in);
        int choice;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        do {
            System.out.println("\n=================================");
            System.out.println("   HỆ THỐNG QUẢN LÝ THƯ VIỆN     ");
            System.out.println("=================================");
            System.out.println("1. Hiển thị danh sách sách");
            System.out.println("2. Hiển thị danh sách độc giả");
            System.out.println("3. Tìm kiếm sách (Tên/Tác giả)");
            System.out.println("4. Cho mượn sách");
            System.out.println("5. Nhận trả sách");
            System.out.println("6. Liệt kê phiếu mượn quá hạn");
            System.out.println("7. Xem thống kê (Thử thách)");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng (0-7): ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = -1;
            }

            switch (choice) {
                case 1:
                    System.out.println("\n--- DANH SÁCH SÁCH TRONG KHO ---");
                    for (Sach s : thuVien.getDanhSachSach()) {
                        System.out.println(s.getMaSach() + " - " + s.getTenSach() + " | Tác giả: " + s.getTacGia() + " | Còn lại: " + s.getSoLuongTrongKho());
                    }
                    break;
                case 2:
                    System.out.println("\n--- DANH SÁCH ĐỘC GIẢ ---");
                    for (DocGia d : thuVien.getDanhSachDocGia()) {
                        System.out.println(d.getMaDocGia() + " - " + d.getHoTen() + " | Đang mượn: " + d.getSoSachDangMuon() + "/" + d.getLoaiThe().getSoSachToiDa());
                    }
                    break;
                case 3:
                    System.out.print("Nhập từ khóa (Tên sách hoặc Tác giả): ");
                    String tuKhoa = scanner.nextLine();
                    List<Sach> kqTimKiem = thuVien.timKiemSach(tuKhoa);
                    if (kqTimKiem.isEmpty()) {
                        System.out.println("Không tìm thấy sách nào phù hợp.");
                    } else {
                        System.out.println("Kết quả tìm kiếm:");
                        for (Sach s : kqTimKiem) {
                            System.out.println(s.getMaSach() + " - " + s.getTenSach() + " | Tác giả: " + s.getTacGia());
                        }
                    }
                    break;
                case 4:
                    System.out.println("\n--- TẠO PHIẾU MƯỢN SÁCH ---");
                    System.out.print("Nhập mã phiếu mượn mới (VD: PM01): ");
                    String maPhieu = scanner.nextLine();
                    System.out.print("Nhập mã độc giả: ");
                    String maDocGia = scanner.nextLine();
                    System.out.print("Nhập mã sách: ");
                    String maSach = scanner.nextLine();
                    System.out.print("Số ngày hẹn trả: ");
                    try {
                        int days = Integer.parseInt(scanner.nextLine());
                        thuThu.choMuonSach(maPhieu, maDocGia, maSach, days);
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Lỗi: Số ngày mượn phải là số!");
                    }
                    break;
                case 5:
                    System.out.println("\n--- NHẬN TRẢ SÁCH ---");
                    System.out.print("Nhập mã phiếu mượn cần trả: ");
                    String maPhieuTra = scanner.nextLine();
                    System.out.print("Nhập ngày trả thực tế (dd/MM/yyyy) hoặc ấn Enter để lấy ngày hôm nay: ");
                    String dateInput = scanner.nextLine();
                    LocalDate ngayTra;
                    if (dateInput.trim().isEmpty()) {
                        ngayTra = LocalDate.now();
                    } else {
                        try {
                            ngayTra = LocalDate.parse(dateInput, formatter);
                        } catch (DateTimeParseException e) {
                            System.out.println("❌ Lỗi định dạng ngày. Sử dụng ngày hôm nay.");
                            ngayTra = LocalDate.now();
                        }
                    }
                    thuThu.nhanTraSach(maPhieuTra, ngayTra);
                    break;
                case 6:
                    System.out.print("Nhập ngày hiện tại để kiểm tra quá hạn (dd/MM/yyyy) hoặc ấn Enter để lấy hôm nay: ");
                    String checkDateInput = scanner.nextLine();
                    LocalDate checkDate;
                    if (checkDateInput.trim().isEmpty()) {
                        checkDate = LocalDate.now();
                    } else {
                        try {
                            checkDate = LocalDate.parse(checkDateInput, formatter);
                        } catch (DateTimeParseException e) {
                            checkDate = LocalDate.now();
                        }
                    }
                    thuThu.lietKePhieuQuaHan(checkDate);
                    break;
                case 7:
                    System.out.println("\n--- THỐNG KÊ (THỬ THÁCH) ---");
                    Sach sachTop = thuVien.thongKeSachMuonNhieuNhat();
                    if (sachTop != null) {
                        System.out.println("Sách được mượn nhiều nhất: " + sachTop.getTenSach());
                    } else {
                        System.out.println("Chưa có dữ liệu mượn sách.");
                    }
                    DocGia docGiaTop = thuVien.thongKeDocGiaMuonNhieuNhat();
                    if (docGiaTop != null) {
                        System.out.println("Độc giả mượn nhiều sách nhất: " + docGiaTop.getHoTen());
                    }
                    break;
                case 0:
                    System.out.println("Đang thoát hệ thống...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        } while (choice != 0);

        scanner.close();
    }
}
