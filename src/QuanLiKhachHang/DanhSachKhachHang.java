/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiKhachHang;

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
public class DanhSachKhachHang {

    private ArrayList<KhachHang> dsKhachHang;

    private KhachHang kh;
    private int count = 0;

    public ArrayList<KhachHang> getDsKhachHang() {
        return dsKhachHang;
    }

    Connection con = null;
    Statement sttm = null;
    ResultSet rs = null;
    PreparedStatement prsttm = null;
    String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=quanli;user=sa;password=123";

    public DanhSachKhachHang() {
        dsKhachHang = new ArrayList<>();
        kh = new KhachHang();
    }

    public ArrayList<KhachHang> docTuBang() throws ClassNotFoundException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            String sql = "select*from KhachHang order by TenKhachHang asc";
            sttm = con.createStatement();
            rs = sttm.executeQuery(sql);

            while (rs.next()) {
                int MaKhachHang = rs.getInt(1);
                String HoKhachHang = rs.getString(2);
                String TenKhachHang = rs.getString(3);
                String DiaChi = rs.getString(4);
                String SoDienThoai = rs.getString(5);
                String SoChungMinh = rs.getString(6);

                KhachHang kh = new KhachHang(MaKhachHang, HoKhachHang, TenKhachHang, DiaChi, SoDienThoai, SoChungMinh);

                count++;
                dsKhachHang.add(kh);
            }
            rs.close();
            sttm.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dsKhachHang;

    }

    public boolean ThemKhachHang_DanhSachKhachHang(KhachHang kh) {
        for (int i = 0; i < dsKhachHang.size(); i++) {

            if (kh.getMaKhachHang() == dsKhachHang.get(i).getMaKhachHang()) {
                return false;
            }

        }
        dsKhachHang.add(kh);
        return true;

    }

    public void ThemKhachHang_SQL(int maKhachHang, String hoKhachHang, String tenKhachHang, String diaChi, String soDienThoai, String soChungMinh) throws ClassNotFoundException {
        String sql = "insert into khachhang(makhachhang, hokhachhang, tenkhachhang,diachi, sodienthoai, sochungminh) values(?,?,?,?,?,?)";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            sttm = con.createStatement();
            prsttm = con.prepareStatement(sql);

            prsttm.setInt(1, maKhachHang);
            prsttm.setString(2, hoKhachHang);
            prsttm.setString(3, tenKhachHang);
            prsttm.setString(4, diaChi);
            prsttm.setString(5, soDienThoai);
            prsttm.setString(6, soChungMinh);

            prsttm.executeUpdate();
            prsttm.close();
            sttm.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

//    public boolean XoaKhachHang_DanhSachKhachHang(int maKhachHang) {
//        KhachHang kh = new KhachHang(maKhachHang);
//        for (int i = 0; i < dsKhachHang.size(); i++) {
//
//            if (kh.getMaKhachHang() == dsKhachHang.get(i).getMaKhachHang()) {
//                dsKhachHang.remove(kh);
//                return true;
//            }
//        }
//        dsKhachHang.add(kh);
//        return false;
//    }
//    public boolean XoaKhachHang_SQL(int maKhachHang) throws ClassNotFoundException, SQLException {
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        con = DriverManager.getConnection(connectionUrl);
//
//        int n = 0;
//        try {
//            prsttm = con.prepareStatement("delete from khachhang where makhachhang =?");
//            prsttm.setInt(1, maKhachHang);
//            n = prsttm.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return n > 0;
//    }
    public boolean CapNhat_KhachHang_DanhSachKhachHang(int maKhachHang, KhachHang khachHangMoi) {

        KhachHang KhachHangCu = new KhachHang(maKhachHang);
        if (dsKhachHang.contains(KhachHangCu)) {
            KhachHangCu = dsKhachHang.get(dsKhachHang.indexOf(KhachHangCu));
            KhachHangCu.setHoKhachHang(khachHangMoi.getHoKhachHang());
            KhachHangCu.setTenKhachHang(khachHangMoi.getTenKhachHang());
            KhachHangCu.setDiaChiKhachHang(khachHangMoi.getDiaChiKhachHang());
            KhachHangCu.setSoDienThoaiKhachHang(khachHangMoi.getSoDienThoaiKhachHang());
            KhachHangCu.setSoChungMinhKhachHang(khachHangMoi.getSoChungMinhKhachHang());

            return true;
        }
        return false;
    }

    public boolean CapNhat_KhachHang_SQL(int maKhachHang, String hoKhachHang, String tenKhachHang, String diaChi, String soDienThoai, String soChungMinh) throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection(connectionUrl);

        int n = 0;
        String sql = "UPDATE khachhang SET hokhachhang = ? , "
                + "tenkhachhang = ? ,"
                + "diachi = ? ,"
                + "sodienthoai = ? ,"
                + "sochungminh = ? "
                + "WHERE makhachhang = ?";

        try {
            con = DriverManager.getConnection(connectionUrl);
            prsttm = con.prepareStatement(sql);

            prsttm.setString(1, hoKhachHang);
            prsttm.setString(2, tenKhachHang);
            prsttm.setString(3, diaChi);
            prsttm.setString(4, soDienThoai);
            prsttm.setString(5, soChungMinh);

            prsttm.setInt(6, maKhachHang);

            n = prsttm.executeUpdate();

            prsttm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n > 0;
    }

    public int TimKiem_KhachHang_MaKhachHang_DanhSachKhachHang(int maKhachHang) {

        KhachHang kh = new KhachHang(maKhachHang);
        for (int i = 0; i < dsKhachHang.size(); i++) {
            if (kh.getMaKhachHang() == dsKhachHang.get(i).getMaKhachHang()) {
                return dsKhachHang.indexOf(kh);
            }
        }
        return -1;
    }

    public ArrayList<KhachHang> docTimKiem_TenKhachHang_SQL(String tenKhachHang) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            con = DriverManager.getConnection(connectionUrl);

            String sql = "select*from khachhang where tenkhachhang like ?";

            prsttm = con.prepareStatement(sql);
            prsttm.setString(1, tenKhachHang);
            rs = prsttm.executeQuery();

            while (rs.next()) {
                int MaKhachHang = rs.getInt(1);
                String HoKhachHang = rs.getString(2);
                String TenKhachHang = rs.getString(3);
                String DiaChi = rs.getString(4);
                String SoDienThoai = rs.getString(5);
                String SoChungMinh = rs.getString(6);

                KhachHang kh = new KhachHang(MaKhachHang, HoKhachHang, TenKhachHang, DiaChi, SoDienThoai, SoChungMinh);

                count++;

                dsKhachHang.add(kh);
            }
            rs.close();
            prsttm.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dsKhachHang;

    }

    public ArrayList<KhachHang> docTimKiem_MaKhachHang_SQL(int maKhachHang) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            con = DriverManager.getConnection(connectionUrl);

            String sql = "select*from khachhang where makhachhang= ?";

            prsttm = con.prepareStatement(sql);
            prsttm.setInt(1, maKhachHang);
            rs = prsttm.executeQuery();

            while (rs.next()) {
                int MaKhachHang = rs.getInt(1);
                String HoKhachHang = rs.getString(2);
                String TenKhachHang = rs.getString(3);
                String DiaChi = rs.getString(4);
                String SoDienThoai = rs.getString(5);
                String SoChungMinh = rs.getString(6);

                KhachHang kh = new KhachHang(MaKhachHang, HoKhachHang, TenKhachHang, DiaChi, SoDienThoai, SoChungMinh);

                count++;

                dsKhachHang.add(kh);
            }
            rs.close();
            prsttm.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dsKhachHang;

    }

    public boolean XoaDuLieu_BangJframe() {
        for (int i = 1; i < dsKhachHang.size(); i++) {
            dsKhachHang.removeAll(dsKhachHang);
            return true;
        }
        return false;
    }

}
