/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiHopDong;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Tuan Dat
 */
public class HopDong1Lan {

    private int SoHopDong;
    private String NgayLapHopDong;
    private int ThoiGianBaoHanh;
    private float TongTien;
    private int SoLuongXeMua;
    private float GiamGia;
    private String NhanVienThanhToan;
    private String LoaiHopDong;
    private int MaKhachHang;
    private String HoKhachHang;
    private String TenKhachHang;
    private String DiaChi;
    private String SoDienThoai;
    private String SoChungMinh;
    private int MaXe;
    private String HangXe;
    private String DongXe;

    public HopDong1Lan() {

    }

    public HopDong1Lan(int SoHopDong, String NgayLapHopDong, int ThoiGianBaoHanh, float TongTien, int SoLuongXeMua, float GiamGia, String NhanVienThanhToan, String LoaiHopDong, int MakhachHang, String HoKhachHang, String TenKhachHang, String DiaChi, String SoDienThoai, String SoChungMinh, int MaXe, String HangXe, String DongXe) {
        this.SoHopDong = SoHopDong;
        this.NgayLapHopDong = NgayLapHopDong;
        this.ThoiGianBaoHanh = ThoiGianBaoHanh;
        this.TongTien = TongTien;
        this.SoLuongXeMua = SoLuongXeMua;
        this.GiamGia = GiamGia;
        this.NhanVienThanhToan = NhanVienThanhToan;
        this.LoaiHopDong = LoaiHopDong;
        this.MaKhachHang = MakhachHang;
        this.HoKhachHang = HoKhachHang;
        this.TenKhachHang = TenKhachHang;
        this.DiaChi = DiaChi;
        this.SoDienThoai = SoDienThoai;
        this.SoChungMinh = SoChungMinh;
        this.MaXe = MaXe;
        this.HangXe = HangXe;
        this.DongXe = DongXe;
    }

    public int getSoHopDong() {
        return SoHopDong;
    }

    public void setSoHopDong(int SoHopDong) {
        this.SoHopDong = SoHopDong;
    }

    public String getNgayLapHopDong() {
        return NgayLapHopDong;
    }

    public void setNgayLapHopDong(String NgayLapHopDong) {
        this.NgayLapHopDong = NgayLapHopDong;
    }

    public int getThoiGianBaoHanh() {
        return ThoiGianBaoHanh;
    }

    public void setThoiGianBaoHanh(int ThoiGianBaoHanh) {
        this.ThoiGianBaoHanh = ThoiGianBaoHanh;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float TongTien) {
        this.TongTien = TongTien;
    }

    public int getSoLuongXeMua() {
        return SoLuongXeMua;
    }

    public void setSoLuongXeMua(int SoLuongXeMua) {
        this.SoLuongXeMua = SoLuongXeMua;
    }

    public float getGiamGia() {
        return GiamGia;
    }

    public void setGiamGia(float GiamGia) {
        this.GiamGia = GiamGia;
    }

    public String getNhanVienThanhToan() {
        return NhanVienThanhToan;
    }

    public void setNhanVienThanhToan(String NhanVienThanhToan) {
        this.NhanVienThanhToan = NhanVienThanhToan;
    }

    public String getLoaiHopDong() {
        return LoaiHopDong;
    }

    public void setLoaiHopDong(String LoaiHopDong) {
        this.LoaiHopDong = LoaiHopDong;
    }

    public int getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(int MakhachHang) {
        this.MaKhachHang = MakhachHang;
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

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public String getSoChungMinh() {
        return SoChungMinh;
    }

    public void setSoChungMinh(String SoCungMinh) {
        this.SoChungMinh = SoCungMinh;
    }

    public int getMaXe() {
        return MaXe;
    }

    public void setMaXe(int MaXe) {
        this.MaXe = MaXe;
    }

    public String getHangXe() {
        return HangXe;
    }

    public void setHangXe(String HangXe) {
        this.HangXe = HangXe;
    }

    public String getDongXe() {
        return DongXe;
    }

    public void setDongXe(String DongXe) {
        this.DongXe = DongXe;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final HopDong1Lan other = (HopDong1Lan) obj;
        if (this.SoHopDong != other.SoHopDong) {
            return false;
        }
        return true;
    }

}
