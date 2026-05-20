package model;

public enum LoaiThe {
    SINH_VIEN(3),
    GIANG_VIEN(5);

    private final int soSachToiDa;

    LoaiThe(int soSachToiDa) {
        this.soSachToiDa = soSachToiDa;
    }

    public int getSoSachToiDa() {
        return soSachToiDa;
    }
}
