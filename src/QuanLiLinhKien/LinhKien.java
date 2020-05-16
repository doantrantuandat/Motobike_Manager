/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiLinhKien;

import java.util.Objects;

/**
 *
 * @author ThanhTam
 */
public class LinhKien {
    private String tenLinhKien;
    private double giaTienLinhKien;

    public LinhKien(String tenLinhKien, double giaTienLinhKien) {
        this.tenLinhKien = tenLinhKien;
        this.giaTienLinhKien = giaTienLinhKien;
    }

    public LinhKien(String tenLinhKien) {
        this(tenLinhKien, 0);
    }

    public String getTenLinhKien() {
        return tenLinhKien;
    }

    public void setTenLinhKien(String tenLinhKien) {
        this.tenLinhKien = tenLinhKien;
    }

    public double getGiaTienLinhKien() {
        return giaTienLinhKien;
    }

    public void setGiaTienLinhKien(double giaTienLinhKien) {
        this.giaTienLinhKien = giaTienLinhKien;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.tenLinhKien);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.giaTienLinhKien) ^ (Double.doubleToLongBits(this.giaTienLinhKien) >>> 32));
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
        final LinhKien other = (LinhKien) obj;
        if (Double.doubleToLongBits(this.giaTienLinhKien) != Double.doubleToLongBits(other.giaTienLinhKien)) {
            return false;
        }
        if (!Objects.equals(this.tenLinhKien, other.tenLinhKien)) {
            return false;
        }
        return true;
    }
    
    
    
}
