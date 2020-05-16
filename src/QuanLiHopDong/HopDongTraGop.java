/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiHopDong;

/**
 *
 * @author Tuan Dat
 */
public class HopDongTraGop {

    private int SoHopDong;
    private String NgayLapHopDong;
    private int ThoiGianBaoHanh;
    private float TongTien;
    private String LanThanhToan;
    private float SoTienThanhToan;
    private float SoTienCon;
    private String NhanVienThanhToan;
    private String LoaiHopDong;

    private int MaKhachHang;
    private String HoKhachHang;
    private String TenKhachHang;
    private String DiaChi;
    private String SoDienThoai;
    private String SoChungMinh;
    private String KhachHangThanhToanHo;
    private String SoChungMinh_KhachHangThanhToanHo;

    private int MaXe;
    private String HangXe;
    private String DongXe;

    public HopDongTraGop(int SoHopDong, String NgayLapHopDong, int ThoiGianBaoHanh, float TongTien, String LanThanhToan, float SoTienThanhToan, float SoTienCon, String NhanVienThanhToan, String LoaiHopDong, int MaKhachHang, String HoKhachHang, String TenKhachHang, String DiaChi, String SoDienThoai, String SoChungMinh, String KhachHangThanhToanHo, String SoChungMinh_KhachHangThanhToanHo, int MaXe, String HangXe, String DongXe) {
        this.SoHopDong = SoHopDong;
        this.NgayLapHopDong = NgayLapHopDong;
        this.ThoiGianBaoHanh = ThoiGianBaoHanh;
        this.TongTien = TongTien;
        this.LanThanhToan = LanThanhToan;
        this.SoTienThanhToan = SoTienThanhToan;
        this.SoTienCon = SoTienCon;
        this.NhanVienThanhToan = NhanVienThanhToan;
        this.LoaiHopDong = LoaiHopDong;
        this.MaKhachHang = MaKhachHang;
        this.HoKhachHang = HoKhachHang;
        this.TenKhachHang = TenKhachHang;
        this.DiaChi = DiaChi;
        this.SoDienThoai = SoDienThoai;
        this.SoChungMinh = SoChungMinh;
        this.KhachHangThanhToanHo = KhachHangThanhToanHo;
        this.SoChungMinh_KhachHangThanhToanHo = SoChungMinh_KhachHangThanhToanHo;
        this.MaXe = MaXe;
        this.HangXe = HangXe;
        this.DongXe = DongXe;
    }

    public HopDongTraGop() {

    }

    public HopDongTraGop(int SoHopDong) {
        this(SoHopDong, "", 0, 0, "", 0, 0, "", "", 0, "", "", "", "", "", "", "", 0, "", "");
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

    public String getLanThanhToan() {
        return LanThanhToan;
    }

    public void setLanThanhToan(String LanThanhToan) {
        this.LanThanhToan = LanThanhToan;
    }

    public float getSoTienThanhToan() {
        return SoTienThanhToan;
    }

    public void setSoTienThanhToan(float SoTienThanhToan) {
        this.SoTienThanhToan = SoTienThanhToan;
    }

    public float getSoTienCon() {
        return SoTienCon;
    }

    public void setSoTienCon(float SoTienCon) {
        this.SoTienCon = SoTienCon;
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

    public void setSoChungMinh(String SoChungMinh) {
        this.SoChungMinh = SoChungMinh;
    }

    public String getKhachHangThanhToanHo() {
        return KhachHangThanhToanHo;
    }

    public void setKhachHangThanhToanHo(String KhachHangThanhToanHo) {
        this.KhachHangThanhToanHo = KhachHangThanhToanHo;
    }

    public String getSoChungMinh_KhachHangThanhToanHo() {
        return SoChungMinh_KhachHangThanhToanHo;
    }

    public void setSoChungMinh_KhachHangThanhToanHo(String SoChungMinh_KhachHangThanhToanHo) {
        this.SoChungMinh_KhachHangThanhToanHo = SoChungMinh_KhachHangThanhToanHo;
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
    
}
