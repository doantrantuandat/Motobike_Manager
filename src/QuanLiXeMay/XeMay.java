/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiXeMay;

import java.util.Vector;

/**
 *
 * @author Tuan Dat
 */
public class XeMay {

    private int MaXeMay;
    private String HangXe;
    private String XuatXu;
    private String MauXe;
    private String DongXe;
    private float GiaXe;
    private float DungTich;
    private int SoLuong;

    public XeMay(int MaXeMay, String HangXe, String XuatXu, String MauXe, String DongXe, float GiaXe, float DungTich, int SoLuong) {
        this.MaXeMay = MaXeMay;
        this.HangXe = HangXe;
        this.XuatXu = XuatXu;
        this.MauXe = MauXe;
        this.DongXe = DongXe;
        this.GiaXe = GiaXe;
        this.DungTich = DungTich;
        this.SoLuong = SoLuong;
    }

    public XeMay(int MaXeMay) {
        this(MaXeMay, "", "", "", "", 0, 0,0);
    }

    public XeMay() {

    }

    public XeMay(String hangXe) {
        this(0, hangXe, "", "", "", 0, 0,0);
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getMaXeMay() {
        return MaXeMay;
    }

    public String getHangXe() {
        return HangXe;
    }

    public String getXuatXu() {
        return XuatXu;
    }

    public String getMauXe() {
        return MauXe;
    }

    public String getDongXe() {
        return DongXe;
    }

    public float getGiaXe() {
        return GiaXe;
    }

    public float getDungTich() {
        return DungTich;
    }

    public void setMaXeMay(int MaXeMay) {
        this.MaXeMay = MaXeMay;
    }

    public void setHangXe(String HangXe) {
        this.HangXe = HangXe;
    }

    public void setXuatXu(String XuatXu) {
        this.XuatXu = XuatXu;
    }

    public void setMauXe(String MauXe) {
        this.MauXe = MauXe;
    }

    public void setDongXe(String DongXe) {
        this.DongXe = DongXe;
    }

    public void setGiaXe(float GiaXe) {
        this.GiaXe = GiaXe;
    }

    public void setDungTich(float DungTich) {
        this.DungTich = DungTich;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.MaXeMay;
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
        final XeMay other = (XeMay) obj;
        if (this.MaXeMay != other.MaXeMay) {
            return false;
        }
        return true;
    }

    public Vector toObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
