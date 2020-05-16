/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyBaoHanh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ThanhTam
 */
public class DanhSachBaoHanh {

    private ArrayList<HeThongBaoHanh> arr;
    private HeThongBaoHanh hTBH;
    private int count = 0;

    public ArrayList<HeThongBaoHanh> getArr() {
        return arr;
    }

    public void setArr(ArrayList<HeThongBaoHanh> arr) {
        this.arr = arr;
    }

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Statement st = null;

    String connectionUrl = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=QuanLi;user=sa;password=123";

    public DanhSachBaoHanh() {
        arr = new ArrayList<HeThongBaoHanh>();
        hTBH = new HeThongBaoHanh();
    }

    public ArrayList<HeThongBaoHanh> layDuLieu() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(connectionUrl);
            String sql = "select *from HeThongBaoHanh ";
            pst = conn.prepareStatement(sql);
            //pst.executeQuery();
            rs = pst.executeQuery();
            while (rs.next()) {
                int maBaoHanh = rs.getInt(1);
                String tenKhachHang = rs.getString(2);
                int maXe = rs.getInt(3);
                String lyDo = rs.getString(4);
                String loi = rs.getString(5);
                String linhKien = rs.getString(6);
                double giaTien = rs.getDouble(7);
                String nhanVienBaoHanh = rs.getString(8);
                String diaChi = rs.getString(9);
                HeThongBaoHanh hTBH = new HeThongBaoHanh(maBaoHanh, tenKhachHang, maXe, lyDo, loi, linhKien,
                        giaTien, nhanVienBaoHanh, diaChi);
                count++;
                arr.add(hTBH);

            }
            rs.close();
            pst.close();
            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return arr;
    }

    public boolean themBaoHanh(HeThongBaoHanh hTBH) {
        for (int i = 0; i < arr.size(); i++) {
            if (hTBH.getMaBaoHanh() == arr.get(i).getMaBaoHanh()) {
                return false;
            }

        }
        arr.add(hTBH);
        return true;
    }

    public void themSQLBaoHanh(int maBaoHanh, String tenKhachHang, int maXe, String lyDo, String loi,
            String linhKien, double giaTien, String nhanVienBaoHanh, String diaChi) {
        String sql = "insert into HeThongBaoHanh(mabaohanh, tenkhachhang, maxe, lydo, loi, linhkien, giatien, nhanvienbaohanh, diachi) "
                + "values(?,?,?,?,?,?,?,?,?)";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(connectionUrl);
            st = conn.createStatement();
            pst = conn.prepareStatement(sql);

            pst.setInt(1, maBaoHanh);
            pst.setString(2, tenKhachHang);
            pst.setInt(3, maXe);
            pst.setString(4, lyDo);
            pst.setString(5, loi);
            pst.setString(6, linhKien);
            pst.setDouble(7, giaTien);
            pst.setString(8, nhanVienBaoHanh);
            pst.setString(9, diaChi);
            pst.executeUpdate();
            pst.close();
            st.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean doiChieuMaXe1Lan(int maXe) throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String s = Integer.toString(maXe);
        String sql = "select *from HopDong1Lan where maxe =? ";
        conn = DriverManager.getConnection(connectionUrl);
        pst = conn.prepareStatement(sql);
        pst.setString(1, s);
        rs = pst.executeQuery();
        if (!rs.next()) {
            //          JOptionPane.showMessageDialog(null, "Ma xe nay khong co trong hop dong!");
            return false;
        }
        rs.close();
        pst.close();
        conn.close();

        return true;

    }

    public boolean doiChieuMaXeTraGop(int maXe) throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String s = Integer.toString(maXe);
        String sql = "select *from HopDongTraGop where maxe =? ";
        conn = DriverManager.getConnection(connectionUrl);
        pst = conn.prepareStatement(sql);
        pst.setString(1, s);
        rs = pst.executeQuery();
        if (!rs.next()) {
            //          JOptionPane.showMessageDialog(null, "Ma xe nay khong co trong hop dong!");
            return false;
        }
        rs.close();
        pst.close();
        conn.close();

        return true;

    }

    public boolean xoaBaoHanh(HeThongBaoHanh hTBH) {
        if (arr.contains(hTBH)) {
            return false;
        }
        arr.remove(hTBH);

        return true;

    }

    public void xoaSQLBaoHanh(int maBH) throws ClassNotFoundException, SQLException {

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(connectionUrl);
        //String s = Integer.toString(maBH);
        String sql = "delete from HeThongBaoHanh where mabaohanh=?";
        st = conn.createStatement();
        pst = conn.prepareStatement(sql);
        pst.setInt(1, maBH);
        pst.executeUpdate();
        pst.close();
        st.close();
        conn.close();

    }

    public boolean capNhatBaoHanh(int maBH, HeThongBaoHanh bhMoi) {
        HeThongBaoHanh bhCu = new HeThongBaoHanh(maBH);
        for (int i = 0; i < arr.size(); i++) {
            if (bhCu.getMaBaoHanh() == arr.get(i).getMaBaoHanh()) {
                bhCu = arr.get(i);

                bhCu.setTenKhachHang(bhMoi.getTenKhachHang());
                bhCu.setLyDo(bhMoi.getLyDo());
                bhCu.setLoiThuocVe(bhMoi.getLoiThuocVe());
                bhCu.setLinhKien(bhMoi.getLinhKien());
                bhCu.setGiaTien(bhMoi.getGiaTien());
                bhCu.setNhanVienBaoHanh(bhMoi.getNhanVienBaoHanh());
                bhCu.setNhanVienBaoHanh(bhMoi.getDiaChi());

                return true;
            }
        }
        return false;

    }

    public void capNhatSQLBaoHanh(int maBH, String tenKH, int maXe, String lyDo, String loi,
            String linhKien, double giaTien, String nhanVienBH, String diaChi) throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(connectionUrl);

        String sql = "UPDATE HeThongBaoHanh SET tenkhachhang =? , "
                + "maxe =? ,"
                + "lydo =? ,"
                + "loi =? ,"
                + "linhkien =? ,"
                + "giatien =? ,"
                + "nhanvienbaohanh =? ,"
                + "diachi =? "
                + "WHERE mabaohanh =?";

        conn = DriverManager.getConnection(connectionUrl);
        pst = conn.prepareStatement(sql);

        pst.setInt(9, maBH);
        pst.setString(1, tenKH);
        pst.setInt(2, maXe);
        pst.setString(3, lyDo);
        pst.setString(4, loi);
        pst.setString(5, linhKien);
        pst.setDouble(6, giaTien);
        pst.setString(7, nhanVienBH);
        pst.setString(8, diaChi);

        pst.executeUpdate();

        pst.close();
        conn.close();
    }

    public int timKiemMaBH_BH(HeThongBaoHanh bh) {
        for (int i = 0; i < arr.size(); i++) {
            if (bh.getMaBaoHanh() == arr.get(i).getMaBaoHanh()) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<HeThongBaoHanh> timKiemSQLMaXeMay_BH(int maXe) throws ClassNotFoundException, SQLException {
        // JOptionPane.showMessageDialog(null , "a");
        System.out.println("a");
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(connectionUrl);

            String sql = "select*from HeThongBaoHanh where maxe=?";

            pst = conn.prepareStatement(sql);
            pst.setInt(1, maXe);
            rs = pst.executeQuery();

            while (rs.next()) {
                int maBaoHanh = rs.getInt(1);
                String tenKhachHang = rs.getString(2);
                int maX = rs.getInt(3);
                String lyDo = rs.getString(4);
                String loi = rs.getString(5);
                String linhKien = rs.getString(6);
                double giaTien = rs.getDouble(7);
                String nhanVienBH = rs.getString(8);
                String diaChi = rs.getString(9);
                HeThongBaoHanh bh = new HeThongBaoHanh(maBaoHanh, tenKhachHang, maX, lyDo, loi,
                        linhKien, giaTien, nhanVienBH, diaChi);

                count++;
                arr.add(bh);
            }
            rs.close();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return arr;

    }

    public boolean xoaJframeDuLieu() {
        for (int i = 0; i < arr.size(); i++) {

            arr.removeAll(arr);
            return true;
        }
        return false;
    }

}
