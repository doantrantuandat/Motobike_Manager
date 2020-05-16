/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyBaoHanh;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author ThanhTam
 */
public class HeThongBaoHanh {
    private int maBaoHanh;
    private String tenKhachHang;
    private int maXe;
    private String lyDo;
    private String loiThuocVe;
    private String linhKien;
    private double giaTien;
    private String nhanVienBaoHanh;
    private String diaChi;
    
    
    
    
    public HeThongBaoHanh(int maBaoHanh, String tenKhachHang, int maXe, String lyDo, String loiThuocVe, String linhKien,
            double giaTien, String nhanVienBaoHanh, String diaChi) {
        this.maBaoHanh = maBaoHanh;
        this.tenKhachHang = tenKhachHang;
        this.maXe = maXe;
        this.lyDo = lyDo;
        this.loiThuocVe = loiThuocVe;
        this.linhKien = linhKien;
        this.giaTien = giaTien;
        this.nhanVienBaoHanh = nhanVienBaoHanh;
        this.diaChi = diaChi;
    }
    public HeThongBaoHanh(int maBaoHanh){
        this(maBaoHanh, "", 0, "", "", "", 0, "", "");
    }
    
    public HeThongBaoHanh(){
       
    }

    public int getMaBaoHanh() {
        return maBaoHanh;
    }

    public void setMaBaoHanh(int maBaoHanh) {
        this.maBaoHanh = maBaoHanh;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public int getMaXe() {
        return maXe;
    }

    public void setMaXe(int maXe) {
        this.maXe = maXe;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public String getLoiThuocVe() {
        return loiThuocVe;
    }

    public void setLoiThuocVe(String loiThuocVe) {
        this.loiThuocVe = loiThuocVe;
    }

    public String getLinhKien() {
        return linhKien;
    }

    public void setLinhKien(String linhKien) {
        this.linhKien = linhKien;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public String getNhanVienBaoHanh() {
        return nhanVienBaoHanh;
    }

    public void setNhanVienBaoHanh(String nhanVienBaoHanh) {
        this.nhanVienBaoHanh = nhanVienBaoHanh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.maBaoHanh;
        hash = 41 * hash + Objects.hashCode(this.tenKhachHang);
        hash = 41 * hash + this.maXe;
        hash = 41 * hash + Objects.hashCode(this.lyDo);
        hash = 41 * hash + Objects.hashCode(this.loiThuocVe);
        hash = 41 * hash + Objects.hashCode(this.linhKien);
        hash = (int) (41 * hash + this.giaTien);
        hash = 41 * hash + Objects.hashCode(this.nhanVienBaoHanh);
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
        final HeThongBaoHanh other = (HeThongBaoHanh) obj;
        if (this.maBaoHanh != other.maBaoHanh) {
            return false;
        }
        if (this.maXe != other.maXe) {
            return false;
        }
        if (this.giaTien != other.giaTien) {
            return false;
        }
        if (!Objects.equals(this.tenKhachHang, other.tenKhachHang)) {
            return false;
        }
        if (!Objects.equals(this.lyDo, other.lyDo)) {
            return false;
        }
        if (!Objects.equals(this.loiThuocVe, other.loiThuocVe)) {
            return false;
        }
        if (!Objects.equals(this.linhKien, other.linhKien)) {
            return false;
        }
        if (!Objects.equals(this.nhanVienBaoHanh, other.nhanVienBaoHanh)) {
            return false;
        }
        return true;
    }

    

    
}
