/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiHopDong;

import QuanLiKhachHang.KhachHang;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Tuan Dat
 */
public class DanhSach_HopDongTraGop {

    private ArrayList<HopDongTraGop> dsHopDongTraGop;
    private HopDongTraGop hd2;
    private int count = 0;

    public ArrayList<HopDongTraGop> getDsHopDongTraGop() {
        return dsHopDongTraGop;
    }
    Connection con = null;
    Statement sttm = null;
    ResultSet rs = null;
    PreparedStatement prsttm = null;
    String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=quanli;user=sa;password=123";

    public DanhSach_HopDongTraGop() {
        dsHopDongTraGop = new ArrayList<>();
        hd2 = new HopDongTraGop();
    }

    public ArrayList<HopDongTraGop> docTuBang() throws ClassNotFoundException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            String sql = "select*from hopdongtragop order by TenKhachHang asc";
            sttm = con.createStatement();
            rs = sttm.executeQuery(sql);

            while (rs.next()) {

                int soHopDong = rs.getInt(1);
                String ngayLapHopDong = rs.getString(2);
                int thoiGianBaoHanh = rs.getInt(3);
                float tongtien = rs.getFloat(4);
                String lanThanhToan = rs.getString(5);
                float soTienThanhToan = rs.getFloat(6);
                float soTienCon = rs.getFloat(7);

                String nhanVienThanhToan = rs.getString(8);
                String loaiHopDong = rs.getString(9);
                int maKhachHang = rs.getInt(10);
                String hoKhachHang = rs.getString(11);
                String tenKhachHang = rs.getString(12);
                String diaChi = rs.getString(13);
                String soDienThoai = rs.getString(14);
                String soChungMinh = rs.getString(15);
                String khachHangThanhToanHo = rs.getString(16);
                String soChungMinh_ThanhToanHo = rs.getString(17);
                int maXe = rs.getInt(18);
                String hangXe = rs.getString(19);
                String dongXe = rs.getString(20);
                HopDongTraGop hd = new HopDongTraGop(soHopDong, ngayLapHopDong, thoiGianBaoHanh, tongtien, lanThanhToan, soTienThanhToan, soTienCon, nhanVienThanhToan, loaiHopDong, maKhachHang, hoKhachHang, tenKhachHang, diaChi, soDienThoai, soChungMinh, khachHangThanhToanHo, soChungMinh_ThanhToanHo, maXe, hangXe, dongXe);

                count++;

                dsHopDongTraGop.add(hd);
            }
            rs.close();
            sttm.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dsHopDongTraGop;

    }

    public boolean Them_HopDong_1Lan(HopDongTraGop hd) {
        dsHopDongTraGop.add(hd);
        return true;
    }

    public void ThemHopDong_SQL(int SoHopDong, String NgayLapHopDong, int ThoiGianBaoHanh, float TongTien, String LanThanhToan, float SoTienThanhToan, float SoTienCon, String NhanVienThanhToan, String LoaiHopDong, int MakhachHang, String HoKhachHang, String TenKhachHang, String DiaChi, String SoDienThoai, String SoChungMinh, String KhachHangThanhToanHo, String SoChungMinh_ThanhToanHo, int MaXe, String HangXe, String DongXe) throws ClassNotFoundException {
        String sql = "insert into hopdongtragop (sohopdong, ngaylaphopdong, thoigianbaohanh, tongtien, lanthanhtoan , sotienthanhtoan, sotiencon,nhanvienthanhtoan, loaihopdong, makhachhang, hokhachhang, tenkhachhang, diachi, sodienThoai, sochungminh,khachhangthanhtoanho,sochungminhthanhtoanho, maxe, hang, dongxe)"
                + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            sttm = con.createStatement();
            prsttm = con.prepareStatement(sql);

            prsttm.setInt(1, SoHopDong);
            prsttm.setString(2, NgayLapHopDong);
            prsttm.setInt(3, ThoiGianBaoHanh);
            prsttm.setFloat(4, TongTien);
            prsttm.setString(5, LanThanhToan);
            prsttm.setFloat(6, SoTienThanhToan);
            prsttm.setFloat(7, SoTienCon);
            prsttm.setString(8, NhanVienThanhToan);
            prsttm.setString(9, LoaiHopDong);

            prsttm.setInt(10, MakhachHang);
            prsttm.setString(11, HoKhachHang);
            prsttm.setString(12, TenKhachHang);
            prsttm.setString(13, DiaChi);
            prsttm.setString(14, SoDienThoai);
            prsttm.setString(15, SoChungMinh);
            prsttm.setString(16, KhachHangThanhToanHo);
            prsttm.setString(17, SoChungMinh_ThanhToanHo);

            prsttm.setInt(18, MaXe);
            prsttm.setString(19, HangXe);
            prsttm.setString(20, DongXe);

            prsttm.executeUpdate();
            prsttm.close();
            sttm.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

}
