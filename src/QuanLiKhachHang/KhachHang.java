/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiKhachHang;

/**
 *
 * @author Tuan Dat
 */
public class KhachHang {
    private int MaKhachHang;
    private String HoKhachHang;
    private String TenKhachHang;
    private String DiaChiKhachHang;
    private String SoDienThoaiKhachHang;
    private String SoChungMinhKhachHang;
    
    public KhachHang(){
        
    }
    public KhachHang(int maKhachHang){
        this(maKhachHang, "","","","","");
    }
    public KhachHang(String tenKhachHang){
        this(0,"",tenKhachHang, "","","");
    }

    public KhachHang(int MaKhachHang, String HoKhachHang, String TenKhachHang, String DiaChiKhachHang, String SoDienThoaiKhachHang, String SoChungMinhKhachHang) {
        this.MaKhachHang = MaKhachHang;
        this.HoKhachHang = HoKhachHang;
        this.TenKhachHang = TenKhachHang;
        this.DiaChiKhachHang = DiaChiKhachHang;
        this.SoDienThoaiKhachHang = SoDienThoaiKhachHang;
        this.SoChungMinhKhachHang = SoChungMinhKhachHang;
    }

    public int getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(int MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public String getHoKhachHang() {
        return HoKhachHang;
    }

    public void setHoKhachHang(String HoKhachHang) {
        this.HoKhachHang = HoKhachHang;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    public String getDiaChiKhachHang() {
        return DiaChiKhachHang;
    }

    public void setDiaChiKhachHang(String DiaChiKhachHang) {
        this.DiaChiKhachHang = DiaChiKhachHang;
    }

    public String getSoDienThoaiKhachHang() {
        return SoDienThoaiKhachHang;
    }

    public void setSoDienThoaiKhachHang(String SoDienThoaiKhachHang) {
        this.SoDienThoaiKhachHang = SoDienThoaiKhachHang;
    }

    public String getSoChungMinhKhachHang() {
        return SoChungMinhKhachHang;
    }

    public void setSoChungMinhKhachHang(String SoChungMinhKhachHang) {
        this.SoChungMinhKhachHang = SoChungMinhKhachHang;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.MaKhachHang;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KhachHang other = (KhachHang) obj;
        if (this.MaKhachHang != other.MaKhachHang) {
            return false;
        }
        return true;
    }
    
}
