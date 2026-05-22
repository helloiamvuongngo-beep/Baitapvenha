package model;

public class DocGia {
    private String maDocGia;
    private String hoTen;
    private String email;
    private LoaiThe loaiThe;
    private int soSachDangMuon;

    public DocGia(String maDocGia, String hoTen, String email, LoaiThe loaiThe) {
        this.maDocGia = maDocGia;
        this.hoTen = hoTen;
        this.email = email;
        this.loaiThe = loaiThe;
        this.soSachDangMuon = 0;
    }

    public boolean coTheMuonThem() {
        return soSachDangMuon < loaiThe.getSoSachToiDa();
    }

    public void tangSoSachDangMuon() {
        soSachDangMuon++;
    }

    public void giamSoSachDangMuon() {
        if (soSachDangMuon > 0) {
            soSachDangMuon--;
        }
    }

    // Getters / Setters
    public String getMaDocGia() { return maDocGia; }
    public void setMaDocGia(String maDocGia) { this.maDocGia = maDocGia; }
    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public LoaiThe getLoaiThe() { return loaiThe; }
    public void setLoaiThe(LoaiThe loaiThe) { this.loaiThe = loaiThe; }
    public int getSoSachDangMuon() { return soSachDangMuon; }
}
