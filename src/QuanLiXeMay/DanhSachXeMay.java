/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiXeMay;

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
public class DanhSachXeMay {

    private ArrayList<XeMay> dsXeMay;
    private XeMay xm;
    private int count = 0;

    public ArrayList<XeMay> getDsXeMay() {
        return dsXeMay;
    }

    public void setDsXeMay(ArrayList<XeMay> dsXeMay) {
        this.dsXeMay = dsXeMay;
    }
    

    Connection con = null;
    Statement sttm = null;
    ResultSet rs = null;
    PreparedStatement prsttm = null;

    String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=quanli;user=sa;password=123";

    public DanhSachXeMay() {
        dsXeMay = new ArrayList<>();
        xm = new XeMay();
    }

    public ArrayList<XeMay> docTuBang() throws ClassNotFoundException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            String sql = "select*from XeMay order by hang asc";
            sttm = con.createStatement();
            rs = sttm.executeQuery(sql);

            while (rs.next()) {
                int MaXe = rs.getInt(1);
                String HangXe = rs.getString(2);
                String XuatXu = rs.getString(3);
                String MauXe = rs.getString(4);
                String DongXe = rs.getString(5);
                float GiaXe = rs.getFloat(6);
                float DungTich = rs.getFloat(7);
                int Soluong = rs.getInt(8);
                XeMay xm = new XeMay(MaXe, HangXe, XuatXu, MauXe, DongXe, GiaXe, DungTich, Soluong);

                count++;
                dsXeMay.add(xm);
            }
            rs.close();
            sttm.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dsXeMay;

    }

    public boolean ThemXe_DanhSachXeMay(XeMay xm) {
        for (int i = 0; i < dsXeMay.size(); i++) {

            if (xm.getMaXeMay() == dsXeMay.get(i).getMaXeMay()) {
                return false;
            }

        }
        dsXeMay.add(xm);
        return true;
    }

    public void ThemXe_SQL(int maXe, String hangXe, String xuatXu, String mauXe, String dongXe, double giaXe, double dungTich, int soLuong) throws ClassNotFoundException {
        String sql = "insert into xemay(maxe, hang, xuatxu, mau, dongxe, gia, dungtich, soluong) values(?,?,?,?,?,?,?,?)";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            sttm = con.createStatement();
            prsttm = con.prepareStatement(sql);

            prsttm.setInt(1, maXe);
            prsttm.setString(2, hangXe);
            prsttm.setString(3, xuatXu);
            prsttm.setString(4, mauXe);
            prsttm.setString(5, dongXe);
            prsttm.setDouble(6, giaXe);
            prsttm.setDouble(7, dungTich);
            prsttm.setInt(8, soLuong);
            prsttm.executeUpdate();
            prsttm.close();
            sttm.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean XoaXe_DanhSachXeMay(int maXe) {
        XeMay xm = new XeMay(maXe);
        for (int i = 0; i < dsXeMay.size(); i++) {

            if (xm.getMaXeMay() == dsXeMay.get(i).getMaXeMay()) {
                dsXeMay.remove(xm);
                return true;
            }

        }

        return false;

    }

    public boolean XoaXe_SQL(int maXe) throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection(connectionUrl);

        int n = 0;
        try {
            prsttm = con.prepareStatement("delete from xemay where maxe =?");
            prsttm.setInt(1, maXe);
            n = prsttm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n > 0;
    }

    public boolean CapNhat_XeMay_DanhSachXeMay(int maXeCu, XeMay XeMayMoi) {
        XeMay XeMayCu = new XeMay(maXeCu);

        if (dsXeMay.contains(XeMayCu)) {

            XeMayCu = dsXeMay.get(dsXeMay.indexOf(XeMayCu));

            XeMayCu.setHangXe(XeMayCu.getHangXe());
            XeMayCu.setXuatXu(XeMayMoi.getXuatXu());
            XeMayCu.setMauXe(XeMayMoi.getMauXe());
            XeMayCu.setDongXe(XeMayMoi.getDongXe());
            XeMayCu.setGiaXe(XeMayMoi.getGiaXe());
            XeMayCu.setDungTich(XeMayMoi.getDungTich());
            XeMayCu.setSoLuong(XeMayMoi.getSoLuong());

            return true;
        }
        return false;
    }

    public boolean CapNhat_XeMay_SQL(int maXe, String hangXe, String xuatXu, String mauXe, String dongXe, double giaXe, double dungTich, int soLuong) throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection(connectionUrl);

        int n = 0;
        String sql = "UPDATE xemay SET hang = ? , "
                + "xuatxu = ? ,"
                + "mau = ? ,"
                + "dongxe = ? ,"
                + "gia = ? ,"
                + "dungtich = ? ,"
                + "soluong = ? "
                + "WHERE maxe = ?";

        try {
            con = DriverManager.getConnection(connectionUrl);
            prsttm = con.prepareStatement(sql);

            prsttm.setString(1, hangXe);
            prsttm.setString(2, xuatXu);
            prsttm.setString(3, mauXe);
            prsttm.setString(4, dongXe);
            prsttm.setDouble(5, giaXe);
            prsttm.setDouble(6, dungTich);
            prsttm.setInt(7, soLuong);
            prsttm.setInt(8, maXe);

            n = prsttm.executeUpdate();

            prsttm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n > 0;
    }

    public int TimKiem_XeMay_MaXe(int maXe) {
        XeMay xm = new XeMay(maXe);

        for (int i = 0; i < dsXeMay.size(); i++) {
            if (xm.getMaXeMay() == dsXeMay.get(i).getMaXeMay()) {
                return dsXeMay.indexOf(xm);
            }
        }
        return -1;
    }

    public int TimKiem_XeMay_HangXe(String hangXe) {
        XeMay xm = new XeMay(hangXe);
        for (int i = 0; i < dsXeMay.size(); i++) {
            if (xm.getHangXe().equalsIgnoreCase(dsXeMay.get(i).getHangXe())) {
                return dsXeMay.indexOf(xm);
            }
        }
        return -1;
    }

    public ArrayList<XeMay> docTimKiem_HangXeMay_TuBang_SQL(String hangXe) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            String sql = "select*from XeMay where hang like ?";

            prsttm = con.prepareStatement(sql);
            prsttm.setString(1, hangXe);
            rs = prsttm.executeQuery();

            while (rs.next()) {
                int MaXe = rs.getInt(1);
                String HangXe = rs.getString(2);
                String XuatXu = rs.getString(3);
                String MauXe = rs.getString(4);
                String DongXe = rs.getString(5);
                float GiaXe = rs.getFloat(6);
                float DungTich = rs.getFloat(7);
                int SoLuong = rs.getInt(8);
                XeMay xm = new XeMay(MaXe, HangXe, XuatXu, MauXe, DongXe, GiaXe, DungTich, SoLuong);

                count++;

                dsXeMay.add(xm);
            }
            rs.close();
            prsttm.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dsXeMay;

    }
    
    public ArrayList<XeMay> docTimKiem_MaXeMay_TuBang_SQL(int maXe) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            String sql = "select*from XeMay where maxe = ?";

            prsttm = con.prepareStatement(sql);
            prsttm.setInt(1, maXe);
            rs = prsttm.executeQuery();

            while (rs.next()) {
                int MaXe = rs.getInt(1);
                String HangXe = rs.getString(2);
                String XuatXu = rs.getString(3);
                String MauXe = rs.getString(4);
                String DongXe = rs.getString(5);
                float GiaXe = rs.getFloat(6);
                float DungTich = rs.getFloat(7);
                int SoLuong = rs.getInt(8);
                XeMay xm = new XeMay(MaXe, HangXe, XuatXu, MauXe, DongXe, GiaXe, DungTich, SoLuong);

                count++;

                dsXeMay.add(xm);
            }
            rs.close();
            prsttm.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dsXeMay;

    }

    public boolean XoaDuLieu_BangJframe() {
        for (int i = 1; i < dsXeMay.size(); i++) {
            dsXeMay.removeAll(dsXeMay);
            return true;
        }
        return false;
    }

}
