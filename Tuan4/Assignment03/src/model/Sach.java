package model;

public class Sach {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private int namXuatBan;
    private int soLuongTrongKho;

    public Sach(String maSach, String tenSach, String tacGia, int namXuatBan, int soLuongTrongKho) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.soLuongTrongKho = soLuongTrongKho;
    }

    public boolean kiemTraConHang() {
        return soLuongTrongKho > 0;
    }

    public void giamSoLuongKho() {
        if (soLuongTrongKho > 0) {
            soLuongTrongKho--;
        }
    }

    public void tangSoLuongKho() {
        soLuongTrongKho++;
    }


    public String getMaSach() { return maSach; }
    public void setMaSach(String maSach) { this.maSach = maSach; }
    public String getTenSach() { return tenSach; }
    public void setTenSach(String tenSach) { this.tenSach = tenSach; }
    public String getTacGia() { return tacGia; }
    public void setTacGia(String tacGia) { this.tacGia = tacGia; }
    public int getNamXuatBan() { return namXuatBan; }
    public void setNamXuatBan(int namXuatBan) { this.namXuatBan = namXuatBan; }
    public int getSoLuongTrongKho() { return soLuongTrongKho; }
    public void setSoLuongTrongKho(int soLuongTrongKho) { this.soLuongTrongKho = soLuongTrongKho; }
}
