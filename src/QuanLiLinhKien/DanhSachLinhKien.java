/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiLinhKien;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author ThanhTam
 */
public class DanhSachLinhKien {

    private ArrayList<LinhKien> arr;
    private Connection conn = null;
    private PreparedStatement pst = null;
    private Statement st = null;
    private ResultSet rs = null;
    private int count;
    String connectionURL = "jdbc:sqlserver://localhost:1433;"+ 
            "databaseName=QuanLi;user=sa;password=123";

    public DanhSachLinhKien() {
        arr = new ArrayList<>();
        count =0;
    }

    public ArrayList<LinhKien> getArr() {
        return arr;
    }

    public void setArr(ArrayList<LinhKien> arr) {
        this.arr = arr;
    }
    public ArrayList<LinhKien> layDuLieu(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String tenLK;
            double giaTien;
            conn = DriverManager.getConnection(connectionURL);
            String sql = "Select *from LinhKien";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){
                tenLK = rs.getString(1);
                giaTien = rs.getDouble(2);
                LinhKien lk = new LinhKien(tenLK, giaTien);
                count++;
                arr.add(lk);
            }
            rs.close();
            pst.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }
    public boolean themLinhKien(LinhKien lk){
        for (int i=0; i<arr.size(); i++){
            if (arr.get(i).getTenLinhKien().equals(lk.getTenLinhKien()))
                
                return false;
        }
        arr.add(lk);
        return true;
    }
    public void themSQLLinhKien(String tenLK, double giaTien){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(connectionURL);
            String sql = "insert into LinhKien(linhkien, giatien) values (?,?)";
            Statement st = conn.createStatement();
            pst = conn.prepareStatement(sql);

            pst.setString(1, tenLK);
            pst.setDouble(2, giaTien);
            pst.executeUpdate();
            pst.close();
            st.close();
            conn.close();
            
        } catch (Exception e) {
        }
        
    }
    public boolean xoaLinhKien(LinhKien lk){
        if (arr.contains(lk)){
            arr.remove(lk);
            return true;
        }
        return false;
    }
    public void xoaSQLLinhKien(String linhKien){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn.prepareStatement(connectionURL);
            String sql = "delete from LinhKien where linhkien =?";
            st = conn.createStatement();
            pst= conn.prepareStatement(sql);
            pst.setString(1, linhKien);
            rs = pst.executeQuery();
            st.close();
            rs.close();
            pst.close();
            conn.close();
          
        } catch (Exception e) {
        }
    }
    public int timKiem(String tenLK){
        for (int i=0; i<arr.size(); i++){
            if (arr.get(i).getTenLinhKien().equalsIgnoreCase(tenLK))
                return i;
        }
        return -1;
    }
    public void timKiemSQLLK(String tenLK){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn.prepareStatement(connectionURL);
            String sql = "select *from LinhKien where linhkien =?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, tenLK);
            pst.executeQuery();
            pst.close();
            conn.close();
            
        } catch (Exception e) {
        }
    }
    public boolean capNhatLK(String tenLK, LinhKien lkMoi){
        LinhKien lkCu = new LinhKien(tenLK);
        for(int i=0; i<arr.size(); i++)
            
            if (lkCu.getTenLinhKien().equals(lkMoi.getTenLinhKien())){
                lkCu = arr.get(i);
                lkCu.setGiaTienLinhKien(lkMoi.getGiaTienLinhKien());
                return true;
            }
        
        return false;
        
    }
    public void capNhatSQLLK(String tenLK, double giaTien){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(connectionURL);
            String sql = "UPDATE LinhKien SET giatien =? where linhkien =?";
            pst = conn.prepareStatement(sql);
            pst.setDouble(1, giaTien);
            pst.setString(2, tenLK);
            pst.executeUpdate();
            pst.close();
            conn.close();
        } catch (Exception e) {
        }
    }
    
    
}
