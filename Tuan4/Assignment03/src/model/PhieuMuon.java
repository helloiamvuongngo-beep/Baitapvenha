package model;

import java.time.LocalDate;

public class PhieuMuon {
    private String maPhieu;
    private DocGia docGia;
    private Sach sach;
    private LocalDate ngayMuon;
    private LocalDate ngayHenTra;
    private LocalDate ngayTraThucTe;
    private boolean daTra;

    public PhieuMuon(String maPhieu, DocGia docGia, Sach sach, LocalDate ngayMuon, int soNgayMuon) {
        this.maPhieu = maPhieu;
        this.docGia = docGia;
        this.sach = sach;
        this.ngayMuon = ngayMuon;
        this.ngayHenTra = ngayMuon.plusDays(soNgayMuon);
        this.daTra = false;
    }


    public String getMaPhieu() { return maPhieu; }
    public void setMaPhieu(String maPhieu) { this.maPhieu = maPhieu; }
    public DocGia getDocGia() { return docGia; }
    public void setDocGia(DocGia docGia) { this.docGia = docGia; }
    public Sach getSach() { return sach; }
    public void setSach(Sach sach) { this.sach = sach; }
    public LocalDate getNgayMuon() { return ngayMuon; }
    public void setNgayMuon(LocalDate ngayMuon) { this.ngayMuon = ngayMuon; }
    public LocalDate getNgayHenTra() { return ngayHenTra; }
    public void setNgayHenTra(LocalDate ngayHenTra) { this.ngayHenTra = ngayHenTra; }
    public LocalDate getNgayTraThucTe() { return ngayTraThucTe; }
    public void setNgayTraThucTe(LocalDate ngayTraThucTe) { this.ngayTraThucTe = ngayTraThucTe; }
    public boolean isDaTra() { return daTra; }
    public void setDaTra(boolean daTra) { this.daTra = daTra; }
}
