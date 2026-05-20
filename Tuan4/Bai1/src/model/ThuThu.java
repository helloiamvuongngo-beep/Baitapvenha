package model;

import util.TienPhat;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ThuThu {
    private String maThuThu;
    private String hoTen;
    private ThuVien thuVien;

    public ThuThu(String maThuThu, String hoTen, ThuVien thuVien) {
        this.maThuThu = maThuThu;
        this.hoTen = hoTen;
        this.thuVien = thuVien;
    }

    public PhieuMuon choMuonSach(String maPhieu, String maDocGia, String maSach, int soNgayMuon) {
        DocGia docGia = thuVien.timDocGiaTheoMa(maDocGia);
        Sach sach = thuVien.timSachTheoMa(maSach);

        if (docGia == null) {
            System.out.println("❌ Lỗi: Không tìm thấy độc giả!");
            return null;
        }
        if (sach == null) {
            System.out.println("❌ Lỗi: Không tìm thấy sách!");
            return null;
        }

        // Ràng buộc số lượng sách theo loại thẻ (Bài 3)
        if (!docGia.coTheMuonThem()) {
            System.out.println("❌ Lỗi: Độc giả đã mượn tối đa số sách cho phép (" + docGia.getLoaiThe().getSoSachToiDa() + " cuốn)!");
            return null;
        }
        
        // Ràng buộc mượn sách trừ kho (Bài 3)
        if (!sach.kiemTraConHang()) {
            System.out.println("❌ Lỗi: Sách này đã hết trong kho!");
            return null;
        }

        sach.giamSoLuongKho();
        docGia.tangSoSachDangMuon();
        
        PhieuMuon phieu = new PhieuMuon(maPhieu, docGia, sach, LocalDate.now(), soNgayMuon);
        thuVien.themPhieuMuon(phieu);
        
        System.out.println("✅ Mượn sách thành công! Mã phiếu: " + maPhieu);
        return phieu;
    }

    // Yêu cầu nâng cao (Bài 3): Trả sách cộng lại kho và truyền ngày trả thực tế để tính phạt
    public void nhanTraSach(String maPhieu, LocalDate ngayTraThucTe) {
        PhieuMuon phieu = thuVien.timPhieuTheoMa(maPhieu);
        if (phieu == null) {
            System.out.println("❌ Lỗi: Không tìm thấy mã phiếu mượn!");
            return;
        }
        if (phieu.isDaTra()) {
            System.out.println("⚠️ Phiếu mượn này đã được hoàn tất trước đó!");
            return;
        }

        phieu.setNgayTraThucTe(ngayTraThucTe);
        phieu.setDaTra(true);
        
        // Trả sách: cộng kho 1
        phieu.getSach().tangSoLuongKho();
        phieu.getDocGia().giamSoSachDangMuon();

        double tienPhat = TienPhat.tinhTienPhat(phieu, ngayTraThucTe);
        System.out.println("✅ Nhận trả sách thành công cho phiếu " + maPhieu + "!");
        if (tienPhat > 0) {
            System.out.println("💰 Độc giả trả trễ hạn. Số tiền phạt phải đóng: " + tienPhat + " VND");
        }
    }

    // Yêu cầu nâng cao (Bài 3): Liệt kê tất cả phiếu mượn đang quá hạn
    public void lietKePhieuQuaHan(LocalDate ngayHienTai) {
        List<PhieuMuon> quaHan = thuVien.getDanhSachPhieuMuon().stream()
                .filter(p -> !p.isDaTra() && p.getNgayHenTra().isBefore(ngayHienTai))
                .collect(Collectors.toList());

        System.out.println("\n--- DANH SÁCH PHIẾU MƯỢN QUÁ HẠN (Tính đến " + ngayHienTai + ") ---");
        if (quaHan.isEmpty()) {
            System.out.println("Không có phiếu mượn nào quá hạn.");
        } else {
            for (PhieuMuon p : quaHan) {
                System.out.println("Phiếu: " + p.getMaPhieu() + 
                                   " | Độc giả: " + p.getDocGia().getHoTen() + 
                                   " | Sách: " + p.getSach().getTenSach() + 
                                   " | Hạn trả: " + p.getNgayHenTra());
            }
        }
    }

    // Getters and Setters...
    public String getMaThuThu() { return maThuThu; }
    public void setMaThuThu(String maThuThu) { this.maThuThu = maThuThu; }
    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }
    public ThuVien getThuVien() { return thuVien; }
    public void setThuVien(ThuVien thuVien) { this.thuVien = thuVien; }
}
