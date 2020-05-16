/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiHopDong;

import java.sql.Connection;
import java.sql.Date;
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
public class DanhSach_HopDong1Lan {

    private ArrayList<HopDong1Lan> dsHopDong1Lan;

    private HopDong1Lan hd1;
    private int count = 0;

    public ArrayList<HopDong1Lan> getDsHopDong1Lan() {
        return dsHopDong1Lan;
    }

    Connection con = null;
    Statement sttm = null;
    ResultSet rs = null;
    PreparedStatement prsttm = null;
    String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=quanli;user=sa;password=123";

    public DanhSach_HopDong1Lan() {
        dsHopDong1Lan = new ArrayList<>();
        hd1 = new HopDong1Lan();
    }

    public ArrayList<HopDong1Lan> docTuBang() throws ClassNotFoundException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            String sql = "select*from hopdong1lan order by TenKhachHang asc";
            sttm = con.createStatement();
            rs = sttm.executeQuery(sql);

            while (rs.next()) {

                int soHopDong = rs.getInt(1);
                String ngayLapHopDong = rs.getString(2);
                int thoiGianBaoHanh = rs.getInt(3);
                Float tongtien = rs.getFloat(4);
                int soLuongXeMua = rs.getInt(5);
                float giamGia = rs.getFloat(6);
                String nhanVienThanhToan = rs.getString(7);
                String loaiHopDong = rs.getString(8);
                int maKhachHang = rs.getInt(9);
                String hoKhachHang = rs.getString(10);
                String tenKhachHang = rs.getString(11);
                String diaChi = rs.getString(12);
                String soDienThoai = rs.getString(13);
                String soChungMinh = rs.getString(14);
                int maXe = rs.getInt(15);
                String hangXe = rs.getString(16);
                String dongXe = rs.getString(17);

                HopDong1Lan hd = new HopDong1Lan(soHopDong, ngayLapHopDong, thoiGianBaoHanh, tongtien, soLuongXeMua, giamGia, nhanVienThanhToan, loaiHopDong, maKhachHang, hoKhachHang, tenKhachHang, diaChi, soDienThoai, soChungMinh, maXe, hangXe, dongXe);
                count++;
                dsHopDong1Lan.add(hd);
            }
            rs.close();
            sttm.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dsHopDong1Lan;

    }

    public boolean Them_HopDong_1Lan(HopDong1Lan hd) {
        for (int i = 0; i < dsHopDong1Lan.size(); i++) {

            if (hd.getSoHopDong() == dsHopDong1Lan.get(i).getSoHopDong()) {
                return false;
            }

        }
        dsHopDong1Lan.add(hd);
        return true;

    }

    public void ThemHopDong_SQL(int SoHopDong, String NgayLapHopDong, int ThoiGianBaoHanh, float TongTien, int SoLuongXeMua, float GiamGia, String NhanVienThanhToan, String LoaiHopDong, int MakhachHang, String HoKhachHang, String TenKhachHang, String DiaChi, String SoDienThoai, String SoChungMinh, int MaXe, String HangXe, String DongXe) throws ClassNotFoundException {
        String sql = "insert into hopdong1lan(sohopdong, ngaylaphopdong, thoigianbaohanh, tongtien, soluongxemua, giamgia, nhanvienthanhtoan, loaihopdong, makhachhang, hokhachhang, tenkhachhang, diachi, sodienThoai, sochungminh, maxe, hang, dongxe)"
                + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            sttm = con.createStatement();
            prsttm = con.prepareStatement(sql);

            prsttm.setInt(1, SoHopDong);
            prsttm.setString(2, NgayLapHopDong);
            prsttm.setInt(3, ThoiGianBaoHanh);
            prsttm.setFloat(4, TongTien);
            prsttm.setInt(5, SoLuongXeMua);
            prsttm.setFloat(6, GiamGia);
            prsttm.setString(7, NhanVienThanhToan);
            prsttm.setString(8, LoaiHopDong);

            prsttm.setInt(9, MakhachHang);
            prsttm.setString(10, HoKhachHang);
            prsttm.setString(11, TenKhachHang);
            prsttm.setString(12, DiaChi);
            prsttm.setString(13, SoDienThoai);
            prsttm.setString(14, SoChungMinh);

            prsttm.setInt(15, MaXe);
            prsttm.setString(16, HangXe);
            prsttm.setString(17, DongXe);

            prsttm.executeUpdate();
            prsttm.close();
            sttm.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
