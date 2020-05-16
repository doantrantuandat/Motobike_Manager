/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_QuanLi;

import GUI_Hopdongs.GUI_HopDong1Lan;
import GUI_Hopdongs.GUI_HopDongTraGop;
import QuanLiKhachHang.DanhSachKhachHang;
import QuanLiKhachHang.KhachHang;
import QuanLiXeMay.DanhSachXeMay;
import QuanLiXeMay.XeMay;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tuan Dat
 */
public class GUI_QuanLi_XeMay_KhachHang extends javax.swing.JFrame {

    private DanhSachXeMay ds_XeMay;
    private DanhSachKhachHang ds_KhachHang;
    private DanhSachKhachHang ds_KhachHang_TimKiem_TenKhachHang;
    private DanhSachXeMay ds_XeMay_TimKiem;

    /**
     * Creates new form GUI_QuanLi
     */
    public GUI_QuanLi_XeMay_KhachHang() throws ClassNotFoundException {
        super("...:::Nhân viên bán hàng:::...");
        initComponents();
        setResizable(true);

        ds_XeMay = new DanhSachXeMay();
        ds_XeMay.docTuBang();
        ds_KhachHang = new DanhSachKhachHang();
        ds_KhachHang.docTuBang();
        ds_KhachHang_TimKiem_TenKhachHang = new DanhSachKhachHang();

        LoadData_XeMay();
        LoadData_KhachHang();

        ds_XeMay_TimKiem = new DanhSachXeMay();

        PhatSinhMa();

    }

    @SuppressWarnings("empty-statement")
    private void LoadData_XeMay() throws ClassNotFoundException {

        ArrayList<XeMay> list = ds_XeMay.getDsXeMay();

        for (int i = 0; i < list.size(); i++) {
            int MaXe = list.get(i).getMaXeMay();
            String maXe = Integer.toString(MaXe);
            String HangXe = list.get(i).getHangXe();
            String XuatXu = list.get(i).getXuatXu();
            String MauXe = list.get(i).getMauXe();
            String DongXe = list.get(i).getDongXe();
            double GiaXe = list.get(i).getGiaXe();
            String giaXe = Double.toString(GiaXe);
            double DungTich = list.get(i).getDungTich();
            String dungTich = Double.toString(DungTich);
            int soLuong = list.get(i).getSoLuong();
            String soLuong_ChuyenDoi = Integer.toString(soLuong);

            String rowData[] = {maXe, HangXe, XuatXu, MauXe, DongXe, giaXe, dungTich, soLuong_ChuyenDoi};
            DefaultTableModel TableModel = (DefaultTableModel) myTable_XeMay.getModel();
            TableModel.addRow(rowData);

        }
        combo_HangXe.setSelectedIndex(0);
        txt_MaXe.setEnabled(false);
        int row = myTable_XeMay.getRowCount();
        lbl_SoLuong.setText(Integer.toString(row));
        btn_HuyTim.setEnabled(false);
        btn_CapNhat_XeMay.setEnabled(false);

    }

    @SuppressWarnings("empty-statement")
    private void LoadData_KhachHang() throws ClassNotFoundException {

        ArrayList<KhachHang> list = ds_KhachHang.getDsKhachHang();

        for (int i = 0; i < list.size(); i++) {

            int MaKhachHang = list.get(i).getMaKhachHang();
            String maKhachHang = Integer.toString(MaKhachHang);
            String hoKhachHang = list.get(i).getHoKhachHang();
            String tenKhachHang = list.get(i).getTenKhachHang();
            String diaChi = list.get(i).getDiaChiKhachHang();
            String soDienThoai = list.get(i).getSoDienThoaiKhachHang();
            String soChungMinh = list.get(i).getSoChungMinhKhachHang();

            String rowData[] = {maKhachHang, hoKhachHang, tenKhachHang, diaChi, soDienThoai, soChungMinh};
            DefaultTableModel TableModel = (DefaultTableModel) myTable_KhachHang.getModel();
            TableModel.addRow(rowData);

        }
        btn_CapNhat_KhachHang.setEnabled(false);
        txt_MaKhachHang.setEnabled(false);
        txt_MaKhachHang.setEditable(false);
        int row = myTable_KhachHang.getRowCount();
        lbl_SoLuong_KhachHang_TrongDB.setText(Integer.toString(row));
        btn_HuyTim_KhachHang.setEnabled(false);

    }

    public void XoaTrang_XeMay() {
        txt_MaXe.setText("");
        txt_XuatXu.setText("");
        txt_MauXe.setText("");
        txt_GiaXe.setText("");
        txt_DungTichXe.setText("");
        txt_Tim_XeMay.setText("");
        txt_SoLuong_XeMay.setText("");
        btn_CapNhat_XeMay.setEnabled(false);
        btn_Them_XeMay.setEnabled(true);
    }

    public int KiemTraInput_XeMay() {

        if (!Pattern.matches("[0-9]+", txt_MaXe.getText())) {
            return 1;
        }
        if (!Pattern.matches("^[a-zA-Z\\sÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]{1,100}", txt_XuatXu.getText())) {
            return 2;
        }
        if (!Pattern.matches("^[a-zA-Z\\sÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]{1,20}", txt_MauXe.getText())) {
            return 3;
        }
        if (!Pattern.matches("[0-9]+(.)[0-9]+", txt_GiaXe.getText()) && !Pattern.matches("[0-9]+", txt_GiaXe.getText())) {
            return 4;
        }
        if (!Pattern.matches("[0-9]+(.)[0-9]+", txt_DungTichXe.getText()) && !Pattern.matches("[0-9]+", txt_DungTichXe.getText())) {
            return 5;
        }
        if (!Pattern.matches("[0-9]+", txt_SoLuong_XeMay.getText())) {
            return 6;
        }
        return 0;
    }

    public int KiemTraInput_KhachHang() {

        if (!Pattern.matches("[0-9]+", txt_MaKhachHang.getText())) {
            return 1;
        }
        if (!Pattern.matches("^[a-zA-Z\\sÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪƯễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹư]{1,100}", txt_HoKhachHang.getText())) {
            return 2;
        }
        if (!Pattern.matches("^[a-zA-Z\\sÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừưỬỮỰỲỴÝỶỸửữựỳỵỷỹ]{1,20}", txt_TenKhachHang.getText())) {
            return 3;
        }
        if (!Pattern.matches("[a-zA-Z0-9\\sÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ/.,_-]{1,100}", txt_DiaChi.getText())) {
            return 4;
        }
        if (!Pattern.matches("[0-9]{10,11}", txt_SoDienThoai.getText())) {
            return 5;
        }
        if (!Pattern.matches("[0-9]+", txt_SoChungMinh.getText())) {
            return 6;
        }
        return 0;
    }

    private int PhatSinhMa() {
        //To change body of generated methods, choose Tools | Templates.
        Random rd = new Random();
        int Ma = rd.nextInt(1000000);
//         System.out.println(MaXe);
        return Ma;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_XeMay_KhachHang = new javax.swing.JTabbedPane();
        pn_ChiTietXeMay = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lbl_TieuDe_XeMay = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        myTable_XeMay = new javax.swing.JTable();
        btn_Them_XeMay = new javax.swing.JButton();
        btn_Xoa_XeMay = new javax.swing.JButton();
        btn_CapNhat_XeMay = new javax.swing.JButton();
        btn_ThanhToan_1Lan_XeMay = new javax.swing.JButton();
        txt_Tim_XeMay = new javax.swing.JTextField();
        btn_Tim_XeMay = new javax.swing.JButton();
        btn_PhatSinhMaXe = new javax.swing.JButton();
        lbl_SoLuongXeMay = new javax.swing.JLabel();
        lbl_SoLuong = new javax.swing.JLabel();
        btn_XoaTrang_XeMay = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn_HuyTim = new javax.swing.JButton();
        btn_ThanhToan_TraGop_XeMay = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        lbl_SoLuong_XeMay = new javax.swing.JLabel();
        txt_SoLuong_XeMay = new javax.swing.JTextField();
        lbl_DungTich = new javax.swing.JLabel();
        txt_DungTichXe = new javax.swing.JTextField();
        lbl_GiaXe = new javax.swing.JLabel();
        txt_GiaXe = new javax.swing.JTextField();
        lbl_DongXe = new javax.swing.JLabel();
        combo_DongXe = new javax.swing.JComboBox<>();
        lbl_Mau = new javax.swing.JLabel();
        txt_MauXe = new javax.swing.JTextField();
        lbl_XuatXu = new javax.swing.JLabel();
        txt_XuatXu = new javax.swing.JTextField();
        lbl_HangXe = new javax.swing.JLabel();
        combo_HangXe = new javax.swing.JComboBox<>();
        lbl_MaXe = new javax.swing.JLabel();
        txt_MaXe = new javax.swing.JTextField();
        pn_ChiTietKhachHang = new javax.swing.JPanel();
        btn_Them_KhachHang = new javax.swing.JButton();
        btn_CapNhat_KhachHang = new javax.swing.JButton();
        btn_PhatSinh_MaKhachHang = new javax.swing.JButton();
        btn_XoaTrang_KhachHang = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lbl_SoLuong_KhachHang_TrongDB = new javax.swing.JLabel();
        btn_LichSuGiaoDich = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_SoChungMinh = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_SoDienThoai = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_DiaChi = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_TenKhachHang = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_MaKhachHang = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_HoKhachHang = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txt_Tim_KhachHang = new javax.swing.JTextField();
        btn_Tim_KhachHang = new javax.swing.JButton();
        btn_HuyTim_KhachHang = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        myTable_KhachHang = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_TieuDe_XeMay.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lbl_TieuDe_XeMay.setForeground(new java.awt.Color(255, 51, 51));
        lbl_TieuDe_XeMay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_TieuDe_XeMay.setText("Danh sách các loại xe");

        myTable_XeMay.setBackground(new java.awt.Color(204, 204, 204));
        myTable_XeMay.setForeground(new java.awt.Color(0, 0, 0));
        myTable_XeMay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã xe", "Hãng", "Xuất xứ", "Màu", "Dòng xe", "Giá (triệu)", "Dung tích (cm3)", "Số lượng còn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        myTable_XeMay.setToolTipText("");
        myTable_XeMay.setDoubleBuffered(true);
        myTable_XeMay.setGridColor(new java.awt.Color(51, 51, 51));
        myTable_XeMay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myTable_XeMayMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(myTable_XeMay);

        btn_Them_XeMay.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("file:add.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        btn_Them_XeMay.setText("Thêm");
        btn_Them_XeMay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Them_XeMayActionPerformed(evt);
            }
        });

        btn_Xoa_XeMay.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("file:remove.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        btn_Xoa_XeMay.setText("Xóa");
        btn_Xoa_XeMay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Xoa_XeMayActionPerformed(evt);
            }
        });

        btn_CapNhat_XeMay.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("file:update.PNG")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        btn_CapNhat_XeMay.setText("Cập nhật");
        btn_CapNhat_XeMay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CapNhat_XeMayActionPerformed(evt);
            }
        });

        btn_ThanhToan_1Lan_XeMay.setText("Thanh toán - 1 lần");
        btn_ThanhToan_1Lan_XeMay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThanhToan_1Lan_XeMayActionPerformed(evt);
            }
        });

        txt_Tim_XeMay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Tim_XeMayActionPerformed(evt);
            }
        });
        txt_Tim_XeMay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_Tim_XeMayKeyPressed(evt);
            }
        });

        btn_Tim_XeMay.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("file:search.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        btn_Tim_XeMay.setText("Tìm");
        btn_Tim_XeMay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Tim_XeMayActionPerformed(evt);
            }
        });

        btn_PhatSinhMaXe.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("file:create.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        btn_PhatSinhMaXe.setText("Phát sinh mã xe");
        btn_PhatSinhMaXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PhatSinhMaXeActionPerformed(evt);
            }
        });

        lbl_SoLuongXeMay.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_SoLuongXeMay.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_SoLuongXeMay.setText("Số loại xe máy hiện tại trong danh sách:");

        lbl_SoLuong.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_SoLuong.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_SoLuong.setText("0");

        btn_XoaTrang_XeMay.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("file:arrow_refresh.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        btn_XoaTrang_XeMay.setText("Làm mới");
        btn_XoaTrang_XeMay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaTrang_XeMayActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("...:: Nhập Mã xe hoặc Hãng Xe để tìm ::...");

        btn_HuyTim.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("file:huy.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        btn_HuyTim.setText("Hủy");
        btn_HuyTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HuyTimActionPerformed(evt);
            }
        });

        btn_ThanhToan_TraGop_XeMay.setText("Thanh toán - Trả góp");
        btn_ThanhToan_TraGop_XeMay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThanhToan_TraGop_XeMayActionPerformed(evt);
            }
        });

        lbl_SoLuong_XeMay.setText("Số lượng");

        lbl_DungTich.setText("Dung tích");

        lbl_GiaXe.setText("Giá xe");

        lbl_DongXe.setText("Dòng xe");

        lbl_Mau.setText("Màu");

        lbl_XuatXu.setText("Xuất xứ");

        lbl_HangXe.setText("Hãng xe");

        combo_HangXe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yamaha", "Honda", "Kawasaki" }));
        combo_HangXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_HangXeActionPerformed(evt);
            }
        });

        lbl_MaXe.setText("Mã xe");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbl_HangXe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_XuatXu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_Mau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_DongXe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_GiaXe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_DungTich, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                    .addComponent(lbl_SoLuong_XeMay, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_MaXe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_SoLuong_XeMay)
                    .addComponent(txt_DungTichXe)
                    .addComponent(txt_GiaXe)
                    .addComponent(combo_DongXe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_MauXe)
                    .addComponent(txt_XuatXu)
                    .addComponent(combo_HangXe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_MaXe))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_MaXe)
                    .addComponent(txt_MaXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_HangXe)
                    .addComponent(combo_HangXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_XuatXu)
                    .addComponent(txt_XuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Mau)
                    .addComponent(txt_MauXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_DongXe)
                    .addComponent(combo_DongXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_GiaXe)
                    .addComponent(txt_GiaXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_DungTich)
                    .addComponent(txt_DungTichXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_SoLuong_XeMay)
                    .addComponent(txt_SoLuong_XeMay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_SoLuongXeMay, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_PhatSinhMaXe, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                            .addComponent(btn_XoaTrang_XeMay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_ThanhToan_1Lan_XeMay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_Them_XeMay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_Xoa_XeMay, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_ThanhToan_TraGop_XeMay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_TieuDe_XeMay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE))
                                .addGap(132, 132, 132))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_Tim_XeMay, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(btn_Tim_XeMay, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_HuyTim, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_CapNhat_XeMay, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                .addGap(129, 129, 129)))
                        .addGap(20, 20, 20))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbl_TieuDe_XeMay, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_HuyTim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_Tim_XeMay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_CapNhat_XeMay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_Tim_XeMay, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_PhatSinhMaXe, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_Xoa_XeMay, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Them_XeMay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_ThanhToan_1Lan_XeMay, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_ThanhToan_TraGop_XeMay, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_XoaTrang_XeMay, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_SoLuongXeMay, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pn_ChiTietXeMay.addTab("Chi tiết", jPanel1);

        pn_XeMay_KhachHang.addTab("Thông tin xe máy", pn_ChiTietXeMay);

        btn_Them_KhachHang.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("file:add.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        btn_Them_KhachHang.setText("Thêm");
        btn_Them_KhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Them_KhachHangActionPerformed(evt);
            }
        });

        btn_CapNhat_KhachHang.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\Documents\\NetBeansProjects\\BaiTapLon_QuanLiXeMay\\update.PNG")); // NOI18N
        btn_CapNhat_KhachHang.setText("Cập nhật");
        btn_CapNhat_KhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CapNhat_KhachHangActionPerformed(evt);
            }
        });

        btn_PhatSinh_MaKhachHang.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\Documents\\NetBeansProjects\\BaiTapLon_QuanLiXeMay\\create.png")); // NOI18N
        btn_PhatSinh_MaKhachHang.setText("Phát sinh mã khách hàng");
        btn_PhatSinh_MaKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PhatSinh_MaKhachHangActionPerformed(evt);
            }
        });

        btn_XoaTrang_KhachHang.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\Documents\\NetBeansProjects\\BaiTapLon_QuanLiXeMay\\arrow_refresh.png")); // NOI18N
        btn_XoaTrang_KhachHang.setText("Làm mới");
        btn_XoaTrang_KhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaTrang_KhachHangActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Số khách hàng hiện tại trong danh sách: ");

        lbl_SoLuong_KhachHang_TrongDB.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_SoLuong_KhachHang_TrongDB.setText("0");

        btn_LichSuGiaoDich.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\Documents\\NetBeansProjects\\BaiTapLon_QuanLiXeMay\\history.png")); // NOI18N
        btn_LichSuGiaoDich.setText("Lịch sử giao dịch");
        btn_LichSuGiaoDich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LichSuGiaoDichActionPerformed(evt);
            }
        });

        jLabel4.setText("Số chứng minh");

        jLabel5.setText("Số điện thoại");

        txt_DiaChi.setColumns(20);
        txt_DiaChi.setRows(5);
        jScrollPane3.setViewportView(txt_DiaChi);

        jLabel6.setText("Địa chỉ");

        jLabel7.setText("Tên khách hàng");

        jLabel8.setText("Mã khách hàng");

        jLabel9.setText("Họ khách hàng");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_SoChungMinh)
                    .addComponent(txt_SoDienThoai)
                    .addComponent(jScrollPane3)
                    .addComponent(txt_TenKhachHang)
                    .addComponent(txt_MaKhachHang)
                    .addComponent(txt_HoKhachHang)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txt_MaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_HoKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_TenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 25, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_SoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_SoChungMinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel3.setBackground(new java.awt.Color(222, 222, 222));

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Thông tin chi tiết khách hàng");

        btn_Tim_KhachHang.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\Documents\\NetBeansProjects\\BaiTapLon_QuanLiXeMay\\search.png")); // NOI18N
        btn_Tim_KhachHang.setText("Tìm");
        btn_Tim_KhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Tim_KhachHangActionPerformed(evt);
            }
        });

        btn_HuyTim_KhachHang.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\Documents\\NetBeansProjects\\BaiTapLon_QuanLiXeMay\\huy.png")); // NOI18N
        btn_HuyTim_KhachHang.setText("Hủy");
        btn_HuyTim_KhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HuyTim_KhachHangActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("...::: Nhập mã khách hàng hoặc tên khách hàng để tìm kiếm :::...");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(txt_Tim_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Tim_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_HuyTim_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(311, 311, 311)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_Tim_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Tim_KhachHang))
                    .addComponent(btn_HuyTim_KhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        myTable_KhachHang.setAutoCreateRowSorter(true);
        myTable_KhachHang.setBackground(new java.awt.Color(204, 204, 204));
        myTable_KhachHang.setForeground(new java.awt.Color(0, 0, 0));
        myTable_KhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khách hàng", "Họ khách hàng", "Tên khách hàng", "Địa chỉ", "Số điện thoại", "Số chứng minh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        myTable_KhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myTable_KhachHangMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(myTable_KhachHang);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
        );

        javax.swing.GroupLayout pn_ChiTietKhachHangLayout = new javax.swing.GroupLayout(pn_ChiTietKhachHang);
        pn_ChiTietKhachHang.setLayout(pn_ChiTietKhachHangLayout);
        pn_ChiTietKhachHangLayout.setHorizontalGroup(
            pn_ChiTietKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ChiTietKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_ChiTietKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_ChiTietKhachHangLayout.createSequentialGroup()
                        .addGroup(pn_ChiTietKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_PhatSinh_MaKhachHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_XoaTrang_KhachHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pn_ChiTietKhachHangLayout.createSequentialGroup()
                                .addComponent(btn_Them_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_CapNhat_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_LichSuGiaoDich, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_ChiTietKhachHangLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_SoLuong_KhachHang_TrongDB, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        pn_ChiTietKhachHangLayout.setVerticalGroup(
            pn_ChiTietKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ChiTietKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_ChiTietKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_ChiTietKhachHangLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_PhatSinh_MaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pn_ChiTietKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Them_KhachHang)
                            .addComponent(btn_CapNhat_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addComponent(btn_LichSuGiaoDich)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_XoaTrang_KhachHang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pn_ChiTietKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_SoLuong_KhachHang_TrongDB, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pn_ChiTietKhachHangLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pn_XeMay_KhachHang.addTab("Thông tin khách hàng", pn_ChiTietKhachHang);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_XeMay_KhachHang))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_XeMay_KhachHang))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_PhatSinhMaXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PhatSinhMaXeActionPerformed
        // TODO add your handling code here:
        int maXe = PhatSinhMa();
        txt_MaXe.setText(Integer.toString(maXe));

    }//GEN-LAST:event_btn_PhatSinhMaXeActionPerformed

    private void btn_Them_XeMayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Them_XeMayActionPerformed
        // TODO add your handling code here:
        ThemActions_XeMay();

    }//GEN-LAST:event_btn_Them_XeMayActionPerformed

    private void btn_Xoa_XeMayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Xoa_XeMayActionPerformed
        try {
            // TODO add your handling code here:
            XoaActions();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI_QuanLi_XeMay_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GUI_QuanLi_XeMay_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_Xoa_XeMayActionPerformed

    private void btn_ThanhToan_1Lan_XeMayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThanhToan_1Lan_XeMayActionPerformed
        try {
            // TODO add your handling code here:
            new GUI_HopDong1Lan().setVisible(true);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI_QuanLi_XeMay_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_ThanhToan_1Lan_XeMayActionPerformed

    private void btn_XoaTrang_XeMayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaTrang_XeMayActionPerformed
        // TODO add your handling code here:
        XoaTrang_XeMay();
    }//GEN-LAST:event_btn_XoaTrang_XeMayActionPerformed

    private void myTable_XeMayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myTable_XeMayMouseClicked
        // TODO add your handling code here:
        btn_ThanhToan_1Lan_XeMay.setEnabled(true);
        btn_ThanhToan_TraGop_XeMay.setEnabled(true);
        btn_Them_XeMay.setEnabled(false);
        btn_CapNhat_XeMay.setEnabled(true);
        int row = myTable_XeMay.getSelectedRow();

        txt_MaXe.setText(myTable_XeMay.getValueAt(row, 0).toString());
        String hangXe = myTable_XeMay.getValueAt(row, 1).toString();
        String dongXe = myTable_XeMay.getValueAt(row, 4).toString();
        if (hangXe.equalsIgnoreCase("Yamaha")) {
            combo_HangXe.setSelectedIndex(0);
            if (dongXe.equalsIgnoreCase("Sirius FI RC")) {
                combo_DongXe.setSelectedIndex(0);
            }
            if (dongXe.equalsIgnoreCase("Exciter 150")) {
                combo_DongXe.setSelectedIndex(1);
            }
            if (dongXe.equalsIgnoreCase("Exciter 150 gp")) {
                combo_DongXe.setSelectedIndex(2);
            }
        } else if (hangXe.equalsIgnoreCase("Honda")) {
            combo_HangXe.setSelectedIndex(1);
            if (dongXe.equalsIgnoreCase("winner 150cc")) {
                combo_DongXe.setSelectedIndex(0);
            }
            if (dongXe.equalsIgnoreCase("SH 300cc")) {
                combo_DongXe.setSelectedIndex(1);
            }
            if (dongXe.equalsIgnoreCase("Air Blade 125cc")) {
                combo_DongXe.setSelectedIndex(2);
            }
        } else {
            combo_HangXe.setSelectedIndex(2);
            if (dongXe.equalsIgnoreCase("z1000 2016")) {
                combo_DongXe.setSelectedIndex(0);
            }
            if (dongXe.equalsIgnoreCase("Z1000 2018")) {
                combo_DongXe.setSelectedIndex(1);
            }
            if (dongXe.equalsIgnoreCase("Ninja H2R")) {
                combo_DongXe.setSelectedIndex(2);
            }
        }

        txt_XuatXu.setText(myTable_XeMay.getValueAt(row, 2).toString());
        txt_MauXe.setText(myTable_XeMay.getValueAt(row, 3).toString());

        txt_GiaXe.setText(myTable_XeMay.getValueAt(row, 5).toString());
        txt_DungTichXe.setText(myTable_XeMay.getValueAt(row, 6).toString());
        txt_SoLuong_XeMay.setText(myTable_XeMay.getValueAt(row, 7).toString());

    }//GEN-LAST:event_myTable_XeMayMouseClicked

    private void btn_CapNhat_XeMayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CapNhat_XeMayActionPerformed
        // TODO add your handling code here:
        if (KiemTraInput_XeMay() == 0) {
            SuaActions();
        } else {
            switch (KiemTraInput_XeMay()) {
                case 1: {
                    JOptionPane.showMessageDialog(this, "Hãy phát sinh mã xe!");
                    break;
                }
                case 2: {
                    JOptionPane.showMessageDialog(this, "Nhập xuất xứ là chuỗi kí tự. \n Ví dụ: Nhật Bản");
                    break;
                }
                case 3: {
                    JOptionPane.showMessageDialog(this, "Nhập màu là chuỗi kí tự. \n Ví dụ: Đỏ đen");
                    break;
                }
                case 4: {
                    JOptionPane.showMessageDialog(this, "Nhập giá là số thực. \n Ví dụ: 19 hoặc 19.5");
                    break;
                }
                case 5: {
                    JOptionPane.showMessageDialog(this, "Nhập dung tích là số thực. \n Ví dụ: 125 hoặc 123.4");
                    break;
                }
                case 6: {
                    JOptionPane.showMessageDialog(this, "Nhập số lượng là số nguyên dương. \n Ví dụ: 23 ");
                }
            }
        }

    }//GEN-LAST:event_btn_CapNhat_XeMayActionPerformed

    private void btn_Tim_XeMayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Tim_XeMayActionPerformed

        try {

            String KhoaTimKiem = txt_Tim_XeMay.getText();

            if (KhoaTimKiem.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "Nhập thông tin để tìm kiếm");
                btn_HuyTim.setEnabled(true);
            }
            if (Pattern.matches("[0-9]+", KhoaTimKiem)) {
                btn_HuyTim.setEnabled(false);
                int maXe = Integer.parseInt(KhoaTimKiem);
                int ViTriTim_MaXe = ds_XeMay.TimKiem_XeMay_MaXe(maXe);
                if (ViTriTim_MaXe != -1) {
                    myTable_XeMay.setRowSelectionInterval(ViTriTim_MaXe, ViTriTim_MaXe);
                    int row = myTable_XeMay.getSelectedRow() + 1;
                    String row_ChuyenDoi = Integer.toString(row);
                    JOptionPane.showMessageDialog(this, "Đã tìm thấy ở hàng thứ   " + row_ChuyenDoi);
                } else {
                    JOptionPane.showMessageDialog(this, "Không tìm thấy!");
                }

            }
            if (Pattern.matches("[a-zA-Z\\s]+", KhoaTimKiem)) {

                ds_XeMay_TimKiem.XoaDuLieu_BangJframe();
                DefaultTableModel table_Model = (DefaultTableModel) myTable_XeMay.getModel();

                table_Model.setRowCount(0);

                LoadData_TimKiem_HangXe(KhoaTimKiem);

                btn_HuyTim.setEnabled(true);
                XoaTrang_XeMay();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btn_Tim_XeMayActionPerformed

    private void btn_HuyTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HuyTimActionPerformed
        try {

            DefaultTableModel table_Model = (DefaultTableModel) myTable_XeMay.getModel();
            table_Model.setRowCount(0);
            LoadData_XeMay();
            XoaTrang_XeMay();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI_QuanLi_XeMay_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_HuyTimActionPerformed

    private void txt_Tim_XeMayKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Tim_XeMayKeyPressed

    }//GEN-LAST:event_txt_Tim_XeMayKeyPressed

    private void txt_Tim_XeMayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Tim_XeMayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Tim_XeMayActionPerformed

    private void btn_XoaTrang_KhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaTrang_KhachHangActionPerformed
        // TODO add your handling code here:
        XoaTrang_KhachHang();
    }//GEN-LAST:event_btn_XoaTrang_KhachHangActionPerformed

    private void btn_PhatSinh_MaKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PhatSinh_MaKhachHangActionPerformed
        // TODO add your handling code here:
        int maKhachHang = PhatSinhMa();
        String maKhachHang_ChuyenDoi = Integer.toString(maKhachHang);
        txt_MaKhachHang.setText(maKhachHang_ChuyenDoi);
    }//GEN-LAST:event_btn_PhatSinh_MaKhachHangActionPerformed

    private void btn_CapNhat_KhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CapNhat_KhachHangActionPerformed
        // TODO add your handling code here:
        if (KiemTraInput_KhachHang() == 0) {
            int row = myTable_KhachHang.getSelectedRow();
            try {
                String maKhachHangCu = (String) myTable_KhachHang.getValueAt(row, 0);
                int maKhachHangCu_ChuyenDoi = Integer.parseInt(maKhachHangCu);

                String hoKhachHang = txt_HoKhachHang.getText();
                String tenKhachHang = txt_TenKhachHang.getText();
                String diaChi = txt_DiaChi.getText();
                String soDienThoai = txt_SoDienThoai.getText();
                String soChungMinh = txt_SoChungMinh.getText();
                KhachHang khachHangMoi = new KhachHang(maKhachHangCu_ChuyenDoi, hoKhachHang, tenKhachHang, diaChi, soDienThoai, soChungMinh);

                if (ds_KhachHang.CapNhat_KhachHang_DanhSachKhachHang(maKhachHangCu_ChuyenDoi, khachHangMoi)) {

                    DefaultTableModel table_Model = (DefaultTableModel) myTable_KhachHang.getModel();

                    table_Model.setValueAt(khachHangMoi.getHoKhachHang(), row, 1);
                    table_Model.setValueAt(khachHangMoi.getTenKhachHang(), row, 2);
                    table_Model.setValueAt(khachHangMoi.getDiaChiKhachHang(), row, 3);
                    table_Model.setValueAt(khachHangMoi.getSoDienThoaiKhachHang(), row, 4);
                    table_Model.setValueAt(khachHangMoi.getSoChungMinhKhachHang(), row, 5);
                    CapNhat_KhachHang_SQL();

                }
                btn_CapNhat_KhachHang.setEnabled(false);
                JOptionPane.showMessageDialog(this, "Cập nhật thành công!");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Không cập nhật được");
                e.printStackTrace();
                // TODO: handle exception
            }
        } else {
            switch (KiemTraInput_KhachHang()) {
                case 1: {
                    JOptionPane.showMessageDialog(this, "Hãy phát sinh mã khách hàng!");
                    break;
                }
                case 2: {
                    JOptionPane.showMessageDialog(this, "Nhập họ khách hàng là chuỗi kí tự\n Ví dụ: Nguyễn Văn ");
                    break;
                }
                case 3: {
                    JOptionPane.showMessageDialog(this, "Nhập tên khách hàng là chuỗi kí tự. \n Ví dụ: Đạt");
                    break;
                }
                case 4: {
                    JOptionPane.showMessageDialog(this, "Nhập Địa chỉ là chuỗi kí tự. \n Ví dụ: 497/24/9N Phan Văn Trị, phường 5, Gò Vấp");
                    break;
                }
                case 5: {
                    JOptionPane.showMessageDialog(this, "Nhập Số điện thoại gồm 10 hoặc 11 chữ số. \n Ví dụ: 01634054618");
                    break;
                }
                case 6: {
                    JOptionPane.showMessageDialog(this, "Nhập số chứng minh là một dãy số. \n Ví dụ: 23 ");
                }
            }
        }
    }//GEN-LAST:event_btn_CapNhat_KhachHangActionPerformed

    private void btn_Them_KhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Them_KhachHangActionPerformed
        // TODO add your handling code here:
        if (KiemTraInput_KhachHang() == 0) {
            try {
                String maKhachHang = txt_MaKhachHang.getText();
                int maKhachHang_ChuyenDoi = Integer.parseInt(maKhachHang);

                String hoKhachHang = txt_HoKhachHang.getText();
                String tenKhachHang = txt_TenKhachHang.getText();

                String diaChi = txt_DiaChi.getText();
                String soDienThoai = txt_SoDienThoai.getText();
                String soChungMinh = txt_SoChungMinh.getText();

                KhachHang kh = new KhachHang(maKhachHang_ChuyenDoi, hoKhachHang, tenKhachHang, diaChi, soDienThoai, soChungMinh);

                if (ds_KhachHang.ThemKhachHang_DanhSachKhachHang(kh)) {
                    String rowData[] = {maKhachHang, hoKhachHang, tenKhachHang, diaChi, soDienThoai, soChungMinh};

                    DefaultTableModel table_Model = (DefaultTableModel) myTable_KhachHang.getModel();
                    table_Model.addRow(rowData);
                    ds_KhachHang.ThemKhachHang_SQL(maKhachHang_ChuyenDoi, hoKhachHang, tenKhachHang, diaChi, soDienThoai, soChungMinh);

                    JOptionPane.showMessageDialog(this, "Thêm thành công!");

                    int row = myTable_KhachHang.getRowCount();
                    lbl_SoLuong_KhachHang_TrongDB.setText(Integer.toString(row));

                    XoaTrang_KhachHang();
                } else {
                    JOptionPane.showMessageDialog(this, "Trùng mã");
                }
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
                System.out.println("Thêm không thành công");
            }
        } else {
            switch (KiemTraInput_KhachHang()) {
                case 1: {
                    JOptionPane.showMessageDialog(this, "Hãy phát sinh mã khách hàng!");
                    break;
                }
                case 2: {
                    JOptionPane.showMessageDialog(this, "Nhập họ khách hàng là chuỗi kí tự.\n Ví dụ: Nguyễn Văn ");
                    break;
                }
                case 3: {
                    JOptionPane.showMessageDialog(this, "Nhập tên khách hàng là chuỗi kí tự. \n Ví dụ: Đạt");
                    break;
                }
                case 4: {
                    JOptionPane.showMessageDialog(this, "Nhập Địa chỉ là chuỗi kí tự. \n Ví dụ: 497/24/9N Phan Văn Trị, phường 5, Gò Vấp");
                    break;
                }
                case 5: {
                    JOptionPane.showMessageDialog(this, "Nhập Số điện thoại gồm 10 hoặc 11 chữ số. \n Ví dụ: 01634054618");
                    break;
                }
                case 6: {
                    JOptionPane.showMessageDialog(this, "Nhập số chứng minh là một dãy số. \n Ví dụ: 23 ");
                }
            }
        }
    }//GEN-LAST:event_btn_Them_KhachHangActionPerformed

    private void btn_Tim_KhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Tim_KhachHangActionPerformed
        // TODO add your handling code here:
        btn_HuyTim_KhachHang.setEnabled(true);

        try {
            //
            String KhoaTimKiem = txt_Tim_KhachHang.getText();

            if (KhoaTimKiem.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "Nhập thông tin để tìm kiếm");

            }
            if (Pattern.matches("[0-9]+", KhoaTimKiem)) {
                //                btn_HuyTim.setEnabled(false);
                int maKhachHang = Integer.parseInt(KhoaTimKiem);
                int ViTriTim_MaKhachHang = ds_KhachHang.TimKiem_KhachHang_MaKhachHang_DanhSachKhachHang(maKhachHang);
                if (ViTriTim_MaKhachHang != -1) {
                    myTable_KhachHang.setRowSelectionInterval(ViTriTim_MaKhachHang, ViTriTim_MaKhachHang);
                    int row = myTable_KhachHang.getSelectedRow() + 1;
                    String row_ChuyenDoi = Integer.toString(row);
                    JOptionPane.showMessageDialog(this, "Đã tìm thấy ở hàng thứ   " + row_ChuyenDoi);
                } else {
                    JOptionPane.showMessageDialog(this, "Không tìm thấy!");
                }

            }
            if (Pattern.matches("^[a-zA-Z\\sÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]{1,20}", KhoaTimKiem)) {
                DefaultTableModel table_Model = (DefaultTableModel) myTable_KhachHang.getModel();
                table_Model.setRowCount(0);
                ds_KhachHang_TimKiem_TenKhachHang.XoaDuLieu_BangJframe();

                table_Model.setRowCount(0);

                ds_KhachHang_TimKiem_TenKhachHang.docTimKiem_TenKhachHang_SQL(KhoaTimKiem);
                ArrayList<KhachHang> list = ds_KhachHang_TimKiem_TenKhachHang.getDsKhachHang();

                for (int i = 0; i < list.size(); i++) {
                    int MaKhachHang = list.get(i).getMaKhachHang();
                    String maKhachHang = Integer.toString(MaKhachHang);
                    String HoKhachHang = list.get(i).getHoKhachHang();
                    String TenKhachHang = list.get(i).getTenKhachHang();
                    String DiaChi = list.get(i).getDiaChiKhachHang();
                    String SoDienThoai = list.get(i).getSoDienThoaiKhachHang();
                    String SoChungMinh = list.get(i).getSoChungMinhKhachHang();

                    String rowData[] = {maKhachHang, HoKhachHang, TenKhachHang, DiaChi, SoDienThoai, SoChungMinh};

                    table_Model.addRow(rowData);
                }
                int row = myTable_KhachHang.getRowCount();
                lbl_SoLuong_KhachHang_TrongDB.setText(Integer.toString(row));
                btn_HuyTim_KhachHang.setEnabled(true);
                XoaTrang_KhachHang();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btn_Tim_KhachHangActionPerformed

    private void btn_HuyTim_KhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HuyTim_KhachHangActionPerformed
        // TODO add your handling code here:
        DefaultTableModel table_Model = (DefaultTableModel) myTable_KhachHang.getModel();
        table_Model.setRowCount(0);
        try {
            LoadData_KhachHang();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI_QuanLi_XeMay_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        XoaTrang_KhachHang();
    }//GEN-LAST:event_btn_HuyTim_KhachHangActionPerformed

    private void myTable_KhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myTable_KhachHangMouseClicked
        // TODO add your handling code here:
        btn_CapNhat_KhachHang.setEnabled(true);
        btn_Them_KhachHang.setEnabled(false);

        int row = myTable_KhachHang.getSelectedRow();

        txt_MaKhachHang.setText(myTable_KhachHang.getValueAt(row, 0).toString());
        txt_HoKhachHang.setText(myTable_KhachHang.getValueAt(row, 1).toString());
        txt_TenKhachHang.setText(myTable_KhachHang.getValueAt(row, 2).toString());
        txt_DiaChi.setText(myTable_KhachHang.getValueAt(row, 3).toString());
        txt_SoDienThoai.setText(myTable_KhachHang.getValueAt(row, 4).toString());
        txt_SoChungMinh.setText(myTable_KhachHang.getValueAt(row, 5).toString());
    }//GEN-LAST:event_myTable_KhachHangMouseClicked

    private void combo_HangXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_HangXeActionPerformed
        // TODO add your handling code here:
        int selected = combo_HangXe.getSelectedIndex();
        if (selected == 0) {
            combo_DongXe.removeAllItems();
            combo_DongXe.addItem("Sirius FI RC");
            combo_DongXe.addItem("Exciter 150");
            combo_DongXe.addItem("Exciter 150 GP");
        }
        if (selected == 1) {
            combo_DongXe.removeAllItems();
            combo_DongXe.addItem("WINNER 150cc");
            combo_DongXe.addItem("SH 300cc");
            combo_DongXe.addItem("Air Blade 125cc");
        }
        if (selected == 2) {
            combo_DongXe.removeAllItems();
            combo_DongXe.addItem("Z1000 2016");
            combo_DongXe.addItem("Z1000 2018");
            combo_DongXe.addItem("NINJA H2R");
        }
    }//GEN-LAST:event_combo_HangXeActionPerformed

    private void btn_LichSuGiaoDichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LichSuGiaoDichActionPerformed
        // TODO add your handling code here:
        new GUI_LichSuKhachHang().setVisible(true);
    }//GEN-LAST:event_btn_LichSuGiaoDichActionPerformed

    private void btn_ThanhToan_TraGop_XeMayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThanhToan_TraGop_XeMayActionPerformed
        try {
            // TODO add your handling code here:
            new GUI_HopDongTraGop().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI_QuanLi_XeMay_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_ThanhToan_TraGop_XeMayActionPerformed
    private void ThemActions_XeMay() {
        //To change body of generated methods, choose Tools | Templates.
        if (KiemTraInput_XeMay() == 0) {
            try {
                String maXe = txt_MaXe.getText();
                int maXe_ChuyenDoi = Integer.parseInt(maXe);
                int chon_HangXe = combo_HangXe.getSelectedIndex();
                String hangXe = combo_HangXe.getItemAt(chon_HangXe);

                String xuatXu = txt_XuatXu.getText();

                String mauXe = txt_MauXe.getText();

                int chon_DongXe = combo_DongXe.getSelectedIndex();
                String dongXe = combo_DongXe.getItemAt(chon_DongXe);

                String giaXe = txt_GiaXe.getText();
                Float giaXe_ChuyenDoi = Float.parseFloat(giaXe);

                String dungTich = txt_DungTichXe.getText();
                Float dungTich_ChuyenDoi = Float.parseFloat(dungTich);

                String soluong = txt_SoLuong_XeMay.getText();
                int soLuong_ChuyenDoi = Integer.parseInt(soluong);

                XeMay xm = new XeMay(maXe_ChuyenDoi, hangXe, xuatXu, mauXe, dongXe, giaXe_ChuyenDoi, dungTich_ChuyenDoi, soLuong_ChuyenDoi);

                if (ds_XeMay.ThemXe_DanhSachXeMay(xm)) {
                    String rowData[] = {maXe, hangXe, xuatXu, mauXe, dongXe, giaXe, dungTich, soluong};

                    DefaultTableModel table_Model = (DefaultTableModel) myTable_XeMay.getModel();
                    table_Model.addRow(rowData);

                    ds_XeMay.ThemXe_SQL(maXe_ChuyenDoi, hangXe, xuatXu, mauXe, dongXe, giaXe_ChuyenDoi, dungTich_ChuyenDoi, soLuong_ChuyenDoi);

                    JOptionPane.showMessageDialog(this, "Thêm thành công!");

                    int row = myTable_XeMay.getRowCount();
                    lbl_SoLuong.setText(Integer.toString(row));

                    XoaTrang_XeMay();
                } else {
                    JOptionPane.showMessageDialog(this, "Trùng mã");
                }
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
                System.out.println("Thêm không thành công");
            }
        } else {
            switch (KiemTraInput_XeMay()) {
                case 1: {
                    JOptionPane.showMessageDialog(this, "Hãy phát sinh mã xe!");
                    break;
                }
                case 2: {
                    JOptionPane.showMessageDialog(this, "Nhập xuất xứ là chuỗi kí tự. \n Ví dụ: Nhật Bản");
                    break;
                }
                case 3: {
                    JOptionPane.showMessageDialog(this, "Nhập màu là chuỗi kí tự. \n Ví dụ: Đỏ đen");
                    break;
                }
                case 4: {
                    JOptionPane.showMessageDialog(this, "Nhập giá là số thực. \n Ví dụ: 19 hoặc 19.5");
                    break;
                }
                case 5: {
                    JOptionPane.showMessageDialog(this, "Nhập dung tích là số thực. \n Ví dụ: 125 hoặc 123.4");
                    break;
                }
                case 6: {
                    JOptionPane.showMessageDialog(this, "Nhập số lượng là số nguyên dương. \n Ví dụ: 23 ");
                }
            }
        }

    }

    private void XoaActions() throws ClassNotFoundException, SQLException {
        int row = myTable_XeMay.getSelectedRow();
        if (row >= 0) {
            String maXe = myTable_XeMay.getValueAt(row, 0).toString();
            int maXe_ChuyenDoi = Integer.parseInt(maXe);

            int HoiNhac = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa không?", "Chú ý!!!", JOptionPane.YES_NO_OPTION);
            if (HoiNhac == JOptionPane.YES_OPTION) {
                if (ds_XeMay.XoaXe_DanhSachXeMay(maXe_ChuyenDoi)) {
                    DefaultTableModel table_Model = (DefaultTableModel) myTable_XeMay.getModel();
                    table_Model.removeRow(row);
                    ds_XeMay.XoaXe_SQL(maXe_ChuyenDoi);
                    int lbl_row = myTable_XeMay.getRowCount();
                    lbl_SoLuong.setText(Integer.toString(lbl_row));
                    JOptionPane.showMessageDialog(this, "Xoá thành công!");
                    XoaTrang_XeMay();
                }
            }

        }
    }

    public void SuaActions() {
        int row = myTable_XeMay.getSelectedRow();
        try {
            String maXeCu = (String) myTable_XeMay.getValueAt(row, 0);
            int maXeCu_ChuyenDoi = Integer.parseInt(maXeCu);

            int Vitri_HangXe = combo_HangXe.getSelectedIndex();
            String hangXe = combo_HangXe.getItemAt(Vitri_HangXe);
            String xuatXu = txt_XuatXu.getText();
            String mauXe = txt_MauXe.getText();
            int Vitri_DongXe = combo_DongXe.getSelectedIndex();
            String dongXe = combo_DongXe.getItemAt(Vitri_DongXe);
            String giaXe = txt_GiaXe.getText();
            float giaXe_ChuyenDoi = Float.parseFloat(giaXe);
            String dungTich = txt_DungTichXe.getText();
            float dungTich_ChuyenDoi = Float.parseFloat(dungTich);

            String soLuong = txt_SoLuong_XeMay.getText();
            int soLuong_ChuyenDoi = Integer.parseInt(soLuong);

            XeMay XeMayMoi = new XeMay(maXeCu_ChuyenDoi, hangXe, xuatXu, mauXe, dongXe, giaXe_ChuyenDoi, dungTich_ChuyenDoi, soLuong_ChuyenDoi);

            if (ds_XeMay.CapNhat_XeMay_DanhSachXeMay(maXeCu_ChuyenDoi, XeMayMoi)) {

                DefaultTableModel table_Model = (DefaultTableModel) myTable_XeMay.getModel();
                table_Model.setValueAt(XeMayMoi.getHangXe(), row, 1);
                table_Model.setValueAt(XeMayMoi.getXuatXu(), row, 2);
                table_Model.setValueAt(XeMayMoi.getMauXe(), row, 3);
                table_Model.setValueAt(XeMayMoi.getDongXe(), row, 4);
                table_Model.setValueAt(XeMayMoi.getGiaXe(), row, 5);
                table_Model.setValueAt(XeMayMoi.getDungTich(), row, 6);
                table_Model.setValueAt(XeMayMoi.getSoLuong(), row, 7);
                CapNhat_XeMay_SQL();
            }
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Không cập nhật được");
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    public void CapNhat_XeMay_SQL() throws ClassNotFoundException, SQLException {
        ArrayList<XeMay> list = ds_XeMay.getDsXeMay();
        try {
            for (int i = 0; i < list.size(); i++) {
                int maXe = list.get(i).getMaXeMay();
                String hangXe = list.get(i).getHangXe();
                String xuatXu = list.get(i).getXuatXu();
                String mauXe = list.get(i).getMauXe();
                String dongXe = list.get(i).getDongXe();
                float giaXe = list.get(i).getGiaXe();
                float dungTich = list.get(i).getDungTich();
                int soLuong = list.get(i).getSoLuong();

                ds_XeMay.CapNhat_XeMay_SQL(maXe, hangXe, xuatXu, mauXe, dongXe, giaXe, dungTich, soLuong);

            }
            System.out.println("Câp nhật ở SQL Server thành công!");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(GUI_QuanLi_XeMay_KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GUI_QuanLi_XeMay_KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GUI_QuanLi_XeMay_KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GUI_QuanLi_XeMay_KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new GUI_QuanLi_XeMay_KhachHang().setVisible(false);
//                } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(GUI_QuanLi_XeMay_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_CapNhat_KhachHang;
    private javax.swing.JButton btn_CapNhat_XeMay;
    private javax.swing.JButton btn_HuyTim;
    private javax.swing.JButton btn_HuyTim_KhachHang;
    private javax.swing.JButton btn_LichSuGiaoDich;
    private javax.swing.JButton btn_PhatSinhMaXe;
    private javax.swing.JButton btn_PhatSinh_MaKhachHang;
    private javax.swing.JButton btn_ThanhToan_1Lan_XeMay;
    private javax.swing.JButton btn_ThanhToan_TraGop_XeMay;
    private javax.swing.JButton btn_Them_KhachHang;
    private javax.swing.JButton btn_Them_XeMay;
    private javax.swing.JButton btn_Tim_KhachHang;
    private javax.swing.JButton btn_Tim_XeMay;
    private javax.swing.JButton btn_XoaTrang_KhachHang;
    private javax.swing.JButton btn_XoaTrang_XeMay;
    private javax.swing.JButton btn_Xoa_XeMay;
    private javax.swing.JComboBox<String> combo_DongXe;
    private javax.swing.JComboBox<String> combo_HangXe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbl_DongXe;
    private javax.swing.JLabel lbl_DungTich;
    private javax.swing.JLabel lbl_GiaXe;
    private javax.swing.JLabel lbl_HangXe;
    private javax.swing.JLabel lbl_MaXe;
    private javax.swing.JLabel lbl_Mau;
    private javax.swing.JLabel lbl_SoLuong;
    private javax.swing.JLabel lbl_SoLuongXeMay;
    private javax.swing.JLabel lbl_SoLuong_KhachHang_TrongDB;
    private javax.swing.JLabel lbl_SoLuong_XeMay;
    private javax.swing.JLabel lbl_TieuDe_XeMay;
    private javax.swing.JLabel lbl_XuatXu;
    private javax.swing.JTable myTable_KhachHang;
    private javax.swing.JTable myTable_XeMay;
    private javax.swing.JPanel pn_ChiTietKhachHang;
    private javax.swing.JTabbedPane pn_ChiTietXeMay;
    private javax.swing.JTabbedPane pn_XeMay_KhachHang;
    private javax.swing.JTextArea txt_DiaChi;
    private javax.swing.JTextField txt_DungTichXe;
    private javax.swing.JTextField txt_GiaXe;
    private javax.swing.JTextField txt_HoKhachHang;
    private javax.swing.JTextField txt_MaKhachHang;
    private javax.swing.JTextField txt_MaXe;
    private javax.swing.JTextField txt_MauXe;
    private javax.swing.JTextField txt_SoChungMinh;
    private javax.swing.JTextField txt_SoDienThoai;
    private javax.swing.JTextField txt_SoLuong_XeMay;
    private javax.swing.JTextField txt_TenKhachHang;
    private javax.swing.JTextField txt_Tim_KhachHang;
    private javax.swing.JTextField txt_Tim_XeMay;
    private javax.swing.JTextField txt_XuatXu;
    // End of variables declaration//GEN-END:variables

    private void LoadData_TimKiem_HangXe(String hangXe) throws ClassNotFoundException, SQLException {

        ds_XeMay_TimKiem.docTimKiem_HangXeMay_TuBang_SQL(hangXe);
        ArrayList<XeMay> list = ds_XeMay_TimKiem.getDsXeMay();

        for (int i = 0; i < list.size(); i++) {
            int MaXe = list.get(i).getMaXeMay();
            String maXe = Integer.toString(MaXe);
            String HangXe = list.get(i).getHangXe();
            String XuatXu = list.get(i).getXuatXu();
            String MauXe = list.get(i).getMauXe();
            String DongXe = list.get(i).getDongXe();
            float GiaXe = list.get(i).getGiaXe();
            String giaXe = Float.toString(GiaXe);
            float DungTich = list.get(i).getDungTich();
            String dungTich = Float.toString(DungTich);
            int soLuong = list.get(i).getSoLuong();
            String soLuong_ChuyenDoi = Integer.toString(soLuong);

            String rowData[] = {maXe, HangXe, XuatXu, MauXe, DongXe, giaXe, dungTich, soLuong_ChuyenDoi};
            DefaultTableModel TableModel = (DefaultTableModel) myTable_XeMay.getModel();
            TableModel.addRow(rowData);

        }
        combo_HangXe.setSelectedIndex(0);
        txt_MaXe.setEnabled(false);
        int row = myTable_XeMay.getRowCount();
        lbl_SoLuong.setText(Integer.toString(row));
        btn_HuyTim.setEnabled(false);

    }

    private void XoaTrang_KhachHang() {
        btn_Them_KhachHang.setEnabled(true);
        btn_CapNhat_KhachHang.setEnabled(false);
        btn_Them_KhachHang.setEnabled(true);
        txt_MaKhachHang.setText("");
        txt_HoKhachHang.setText("");
        txt_TenKhachHang.setText("");
        txt_DiaChi.setText("");
        txt_SoDienThoai.setText("");
        txt_SoChungMinh.setText("");
        txt_Tim_KhachHang.setText("");//To change body of generated methods, choose Tools | Templates.
    }

    private void CapNhat_KhachHang_SQL() {
        //To change body of generated methods, choose Tools | Templates.
        ArrayList<KhachHang> list = ds_KhachHang.getDsKhachHang();
        try {
            for (int i = 0; i < list.size(); i++) {
                int maKhachHang = list.get(i).getMaKhachHang();
                String hoKhachHang = list.get(i).getHoKhachHang();
                String tenKhachHang = list.get(i).getTenKhachHang();
                String diaChi = list.get(i).getDiaChiKhachHang();
                String soDienThoai = list.get(i).getSoDienThoaiKhachHang();
                String soChungMinh = list.get(i).getSoChungMinhKhachHang();

                ds_KhachHang.CapNhat_KhachHang_SQL(maKhachHang, hoKhachHang, tenKhachHang, diaChi, soDienThoai, soChungMinh);

            }
            System.out.println("Câp nhật khách hàng ở SQL Server thành công!");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}
