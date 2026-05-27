package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

public class ThuVien {
    private List<Sach> danhSachSach;
    private List<DocGia> danhSachDocGia;
    private List<PhieuMuon> danhSachPhieuMuon;

    public ThuVien() {
        danhSachSach = new ArrayList<>();
        danhSachDocGia = new ArrayList<>();
        danhSachPhieuMuon = new ArrayList<>();
    }

    public void themSach(Sach sach) { danhSachSach.add(sach); }
    public void themDocGia(DocGia docGia) { danhSachDocGia.add(docGia); }
    public void themPhieuMuon(PhieuMuon phieu) { danhSachPhieuMuon.add(phieu); }

    public Sach timSachTheoMa(String maSach) {
        return danhSachSach.stream().filter(s -> s.getMaSach().equals(maSach)).findFirst().orElse(null);
    }
    
    public List<Sach> timKiemSach(String tuKhoa) {
        String keyword = tuKhoa.toLowerCase();
        return danhSachSach.stream()
                .filter(s -> s.getTenSach().toLowerCase().contains(keyword) || 
                             s.getTacGia().toLowerCase().contains(keyword))
                .collect(Collectors.toList());
    }

    public DocGia timDocGiaTheoMa(String maDocGia) {
        return danhSachDocGia.stream().filter(d -> d.getMaDocGia().equals(maDocGia)).findFirst().orElse(null);
    }

    public PhieuMuon timPhieuTheoMa(String maPhieu) {
        return danhSachPhieuMuon.stream().filter(p -> p.getMaPhieu().equals(maPhieu)).findFirst().orElse(null);
    }

    public List<Sach> getDanhSachSach() { return danhSachSach; }
    public List<DocGia> getDanhSachDocGia() { return danhSachDocGia; }
    public List<PhieuMuon> getDanhSachPhieuMuon() { return danhSachPhieuMuon; }

    // Yêu cầu nâng cao (Bài 3): Thống kê cuốn sách được mượn nhiều nhất
    public Sach thongKeSachMuonNhieuNhat() {
        if (danhSachPhieuMuon.isEmpty()) return null;
        Map<Sach, Integer> demSach = new HashMap<>();
        for (PhieuMuon p : danhSachPhieuMuon) {
            demSach.put(p.getSach(), demSach.getOrDefault(p.getSach(), 0) + 1);
        }
        return demSach.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    // Yêu cầu nâng cao (Bài 3): Thống kê độc giả mượn nhiều sách nhất
    public DocGia thongKeDocGiaMuonNhieuNhat() {
        if (danhSachPhieuMuon.isEmpty()) return null;
        Map<DocGia, Integer> demDocGia = new HashMap<>();
        for (PhieuMuon p : danhSachPhieuMuon) {
            demDocGia.put(p.getDocGia(), demDocGia.getOrDefault(p.getDocGia(), 0) + 1);
        }
        return demDocGia.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}
