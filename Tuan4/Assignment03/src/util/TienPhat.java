package util;

import model.PhieuMuon;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TienPhat {
    private static final double TIEN_PHAT_MOI_NGAY = 5000.0;

    public static double tinhTienPhat(PhieuMuon phieu, LocalDate ngayTra) {
        if (ngayTra != null && ngayTra.isAfter(phieu.getNgayHenTra())) {
            long soNgayTre = ChronoUnit.DAYS.between(phieu.getNgayHenTra(), ngayTra);
            return soNgayTre * TIEN_PHAT_MOI_NGAY;
        }
        return 0.0;
    }
}
