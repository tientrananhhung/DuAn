/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.QLHH;
import Controller.QLKhachHang;
import Controller.QuanLyNCC;
import Controller.TinNhan;
import Model.Account;
import Model.modelHangHoa;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tien Tran
 */
public class Admin extends javax.swing.JFrame {

    /**
     * Creates new form Admin
     */
    int currenColor;
    Vector head, data, head1, data1, head2, data2, head3, data3, head4, data4, head5, data5, head6, data6;
    DefaultTableModel modelTable, modelTable1, modelTable2, modelTable3, modelTable4, modelTable5, modelTable6;
    Account acc;
    QLKhachHang KH;
    QuanLyNCC qlNCC;
    TinNhan TN;
    QLHH hh;
    int tong1 = 0, tong2 = 0;
    String a1 = "", b1 = "";
    String a2 = "", b2 = "";
    String a3 = "", b3 = "";
    String a4 = "", b4 = "";
    String a5 = "", b5 = "";
    ThemNSX nsx;
    DecimalFormat formatter = new DecimalFormat("###,###,###");

    public Admin() {
        initComponents();
        currenColor = 1;
        changeTable();
        qlNCC = new QuanLyNCC();
        a();
    }

    public Admin(Account acc) {
        initComponents();
        currenColor = 1;
        changeTable();
        jLabel_TenNguoiDung.setText(acc.getTenNguoiDung());
        qlNCC = new QuanLyNCC();
        a();
    }

    public void a() {
        jLabel35.setText(jTable_SanPham.getRowCount() + "");
        for (int i = 0; i < jTable_SanPham.getRowCount(); i++) {
            tong1 += Integer.parseInt(jTable_SanPham.getValueAt(i, 2).toString());
            tong2 += Integer.parseInt(jTable_SanPham.getValueAt(i, 3).toString());
        }
        jLabel38.setText(tong1 + "");
        jLabel42.setText(tong2 + "");
        for (int i = 0; i < hh.getMaNH().size(); i++) {
            jComboBoxNhomHang.addItem((String) hh.getMaNH().get(i) + " (" + (String) hh.getTenNH().get(i) + ")");
        }
        for (int i = 0; i < hh.getMaNSX().size(); i++) {
            jComboBoxNhaSX.addItem((String) hh.getMaNSX().get(i) + " (" + (String) hh.getTenNSX().get(i) + ")");
        }
    }

    public void changeTable() {
        KH = new QLKhachHang();
        TN = new TinNhan();
        hh = new QLHH();
        head = new Vector();
        data = new Vector();
        head1 = new Vector();
        data1 = new Vector();
        head2 = new Vector();
        data2 = new Vector();
        head3 = new Vector();
        data3 = new Vector();
        head4 = new Vector();
        data4 = new Vector();
        head5 = new Vector();
        data5 = new Vector();
        head6 = new Vector();
        data6 = new Vector();
        data1 = hh.getAllList();
        head.add("Mã hóa đơn");
        head.add("Ngày nhập");
        head.add("Nhà cung cấp");
        head.add("Số lượng");
        head.add("Tổng tiền");
        head.add("Nợ");
        head.add("");
        head1.add("Mã sản phẩm");
        head1.add("Tên sản phẩm");
        head1.add("Giá nhập");
        head1.add("Giá bán");
        head1.add("Thuế");
        head1.add("Mô tả");
        head1.add("Tên nhà sản xuất");
        head1.add("Tên nhóm hàng");
        head2.add("Tên khách hàng");
        head2.add("Số điện thoại");
        head2.add("Địa chỉ");
        head2.add("Email");
        head2.add("Loại khách hàng");
        head3.add("Mã sản phẩm");
        head3.add("Tên sản phẩm");
        head3.add("Số lượng");
        head3.add("Đơn giá");
        head3.add("Tổng giá");
        head4.add("Người nhận");
        head4.add("Nội dung");
        head4.add("Ngày gửi");
        head5.add("Người gửi");
        head5.add("Nội dung");
        head5.add("Ngày nhận");
        head5.add("Trạng thái");
        head6.add("Mã hàng hóa");
        head6.add("Tên hàng hóa");
        head6.add("Tên nhóm hàng");
        head6.add("Tên nhà sản xuất");
        head6.add("Giá nhập");
        for (int i = 0; i < KH.getAllList().size(); i++) {
            data2.add(KH.getAllList().get(i));
        }
        for (int i = 0; i < TN.getAllTNNV().size(); i++) {
            data4.add(TN.getAllTNNV().get(i));
        }
        for (int i = 0; i < TN.getAllTNAD().size(); i++) {
            data5.add(TN.getAllTNAD().get(i));
        }
        modelTable = new DefaultTableModel(data, head);
        modelTable1 = new DefaultTableModel(data1, head1);
        modelTable2 = new DefaultTableModel(data2, head2);
        modelTable3 = new DefaultTableModel(data3, head3);
        modelTable4 = new DefaultTableModel(data4, head4);
        modelTable5 = new DefaultTableModel(data5, head5);
        modelTable6 = new DefaultTableModel(data6, head6);
        jTable_PhieuNhapKho.setModel(modelTable);
        jTable_PhieuNhapKho.setDefaultEditor(Object.class, null);
        jTable_SanPham.setModel(modelTable1);
        jTable_SanPham.setDefaultEditor(Object.class, null);
        jTable_QLKH.setModel(modelTable2);
        jTable_QLKH.setDefaultEditor(Object.class, null);
        jTable_HangHoa.setModel(modelTable3);
        jTable_HangHoa.setDefaultEditor(Object.class, null);
        jTable_HopThuDen.setModel(modelTable5);
        jTable_HopThuDen.setDefaultEditor(Object.class, null);
        jTable_HopThuDi.setModel(modelTable4);
        jTable_HopThuDi.setDefaultEditor(Object.class, null);
        jTable_HH.setModel(modelTable6);
        jTable_HH.setDefaultEditor(Object.class, null);
        jLabel_slKH.setText(jTable_QLKH.getRowCount() + "");
        jLabel_vip.setText(KH.getAllKHVip().toString());
        jLabel_Standard.setText(KH.getAllKHStandard().toString());
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        jScrollPane4.getViewport().setBackground(Color.WHITE);
        jScrollPane6.getViewport().setBackground(Color.WHITE);
        jScrollPane2.getViewport().setBackground(Color.WHITE);
        jScrollPane7.getViewport().setBackground(Color.WHITE);
        jScrollPane8.getViewport().setBackground(Color.WHITE);
        jScrollPane9.getViewport().setBackground(Color.WHITE);
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(65, 127, 194));
        headerRenderer.setBorder(new LineBorder(Color.black, 1));
        headerRenderer.setForeground(Color.WHITE);
        jTable_PhieuNhapKho.setRowHeight(30);
        jTable_SanPham.setRowHeight(30);
        jTable_QLKH.setRowHeight(30);
        jTable_HangHoa.setRowHeight(30);
        jTable_HopThuDen.setRowHeight(30);
        jTable_HopThuDi.setRowHeight(30);
        jTable_HH.setRowHeight(30);
        for (int i = 0; i < jTable_PhieuNhapKho.getModel().getColumnCount(); i++) {
            jTable_PhieuNhapKho.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        for (int i = 0; i < jTable_SanPham.getModel().getColumnCount(); i++) {
            jTable_SanPham.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        for (int i = 0; i < jTable_QLKH.getModel().getColumnCount(); i++) {
            jTable_QLKH.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        for (int i = 0; i < jTable_HangHoa.getModel().getColumnCount(); i++) {
            jTable_HangHoa.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        for (int i = 0; i < jTable_HopThuDen.getModel().getColumnCount(); i++) {
            jTable_HopThuDen.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        for (int i = 0; i < jTable_HopThuDi.getModel().getColumnCount(); i++) {
            jTable_HopThuDi.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        for (int i = 0; i < jTable_HH.getModel().getColumnCount(); i++) {
            jTable_HH.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
//        Color color = UIManager.getColor("Table.gridColor");
//        MatteBorder border = new MatteBorder(5, 5, 0, 0, Color.blue);
//        jTable_PhieuNhapKho.setBorder(border);
    }

    public void setNhomHang(String item1, String item2) {
        String a = item1 + " (" + item2 + ")";
        System.out.println(a);
        jComboBoxNhomHang.addItem(a);
    }

    public void disCard() {
        CardTongQuan.hide();
        CardNhapKho.hide();
        CardTaoPhieuNhap.hide();
        CardSanPham.hide();
        CardTaoSanPham.hide();
        CardKhachHang.hide();
        CardTinNhan.hide();
        CardDSSP.hide();
    }

    public void disSubMenu() {
        iconTongQuan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Shop_32px.png")));
        iconTongQuan.setForeground(Color.BLACK);
        TongQuan.setBackground(new Color(244, 244, 244));
        iconTongQuan.setFont(new java.awt.Font("Tahoma", 0, 18));
        iconNhapKho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Truck_32px_1.png")));
        iconNhapKho.setForeground(Color.BLACK);
        NhapKho.setBackground(new Color(244, 244, 244));
        iconNhapKho.setFont(new java.awt.Font("Tahoma", 0, 18));
        iconSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Shopping_Cart_32px_1.png")));
        iconSanPham.setForeground(Color.BLACK);
        HangHoa.setBackground(new Color(244, 244, 244));
        iconSanPham.setFont(new java.awt.Font("Tahoma", 0, 18));
        iconDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Sign_Out_32px_1.png")));
        iconDangXuat.setForeground(Color.BLACK);
        DangXuat.setBackground(new Color(244, 244, 244));
        iconDangXuat.setFont(new java.awt.Font("Tahoma", 0, 18));
        iconKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_User_Groups_32px_1.png")));
        iconKhachHang.setForeground(Color.BLACK);
        KhachHang.setBackground(new Color(244, 244, 244));
        iconKhachHang.setFont(new java.awt.Font("Tahoma", 0, 18));
        iconTinNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Mail_32px_2.png")));
        iconTinNhan.setForeground(Color.BLACK);
        Mail.setBackground(new Color(244, 244, 244));
        iconTinNhan.setFont(new java.awt.Font("Tahoma", 0, 18));
    }

    public void reset() {
        jTextFieldMaHH.setText("");
        jTextFieldTenHH.setText("");
        jTextFieldGiaBan.setText("");
        jTextFieldGiaVon.setText("");
        jTextArea2.setText("");
        jFormattedThue.setText("");
        jLabelImage1.setIcon(null);
        jLabelImage2.setIcon(null);
        jLabelImage3.setIcon(null);
        jLabelImage4.setIcon(null);
        jLabelImage5.setIcon(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPopupMenu_SanPham = new javax.swing.JPopupMenu();
        jMenuItem_Sua = new javax.swing.JMenuItem();
        jMenuItem_Xoa = new javax.swing.JMenuItem();
        BG = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel_TenNguoiDung = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        Minimize = new javax.swing.JLabel();
        X = new javax.swing.JLabel();
        Function = new javax.swing.JPanel();
        Menu = new javax.swing.JPanel();
        TongQuan = new javax.swing.JPanel();
        iconTongQuan = new javax.swing.JLabel();
        NhapKho = new javax.swing.JPanel();
        iconNhapKho = new javax.swing.JLabel();
        HangHoa = new javax.swing.JPanel();
        iconSanPham = new javax.swing.JLabel();
        KhachHang = new javax.swing.JPanel();
        iconKhachHang = new javax.swing.JLabel();
        Mail = new javax.swing.JPanel();
        iconTinNhan = new javax.swing.JLabel();
        DangXuat = new javax.swing.JPanel();
        iconDangXuat = new javax.swing.JLabel();
        HienThi = new javax.swing.JPanel();
        CardTongQuan = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        CardNhapKho = new javax.swing.JPanel();
        JPanel_Title_NhapKho = new javax.swing.JPanel();
        jLabel_TitleNhapKho = new javax.swing.JLabel();
        jButton_TaoPhieuNhap = new javax.swing.JButton();
        jButton_XuatExcel = new javax.swing.JButton();
        jPanel_Show_NhapKho = new javax.swing.JPanel();
        jPanel_Filter = new javax.swing.JPanel();
        jPanel_Filter_Left = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel_Filter_Space = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jPanel_Show_Info = new javax.swing.JPanel();
        jPanel_Under_Info = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel_Info_NhapKho = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_PhieuNhapKho = new javax.swing.JTable();
        CardTaoPhieuNhap = new javax.swing.JPanel();
        JPanel_Title_TaoNhapKho = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jButton_NhapHang_XacNhan = new javax.swing.JButton();
        jButton_NhapHang_huy = new javax.swing.JButton();
        jButton_NhapHang_LamMoi = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel_TPN_DonGia = new javax.swing.JLabel();
        jLabel_TPN_TongGia = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_HangHoa = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel_TPN_ThemNCC = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField9 = new javax.swing.JTextField();
        jLabel_TPN_XoaNCC = new javax.swing.JLabel();
        jComboBox_NCC = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        CardSanPham = new javax.swing.JPanel();
        jPanel_Title_SanPham = new javax.swing.JPanel();
        jLabel_Title_DSSP = new javax.swing.JLabel();
        jButton_ThemSP = new javax.swing.JButton();
        jButton_XuatExcelSP = new javax.swing.JButton();
        jPanel_Show_NhapKho1 = new javax.swing.JPanel();
        jPanel_Filter1 = new javax.swing.JPanel();
        jPanel_Filter_Left1 = new javax.swing.JPanel();
        jTextField5 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel_Filter_Space1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel_Show_Info1 = new javax.swing.JPanel();
        jPanel_Under_Info1 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jPanel_Info_SanPham = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_SanPham = new javax.swing.JTable();
        CardTaoSanPham = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jLabel_Title_TSP = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel32 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jTextFieldMaHH = new javax.swing.JTextField();
        jTextFieldTenHH = new javax.swing.JTextField();
        jTextFieldGiaBan = new javax.swing.JFormattedTextField();
        jFormattedThue = new javax.swing.JFormattedTextField();
        jComboBoxNhomHang = new javax.swing.JComboBox<>();
        jComboBoxNhaSX = new javax.swing.JComboBox<>();
        jTextFieldGiaVon = new javax.swing.JFormattedTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel_ThemNSX = new javax.swing.JLabel();
        jLabel_XoaNSX = new javax.swing.JLabel();
        jLabel_ThemNH = new javax.swing.JLabel();
        jLabel_XoaNH = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jPanel43 = new javax.swing.JPanel();
        jPanel44 = new javax.swing.JPanel();
        jLabelImage1 = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        jLabelImage2 = new javax.swing.JLabel();
        jLabelImage3 = new javax.swing.JLabel();
        jLabelImage4 = new javax.swing.JLabel();
        jLabelImage5 = new javax.swing.JLabel();
        CardKhachHang = new javax.swing.JPanel();
        JPanel_Title_TaoNhapKho1 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        jButton_NhapHang_huy1 = new javax.swing.JButton();
        jButton_NhapHang_LamMoi1 = new javax.swing.JButton();
        jPanel_ShowKH = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel30 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel_slKH = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel_vip = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel_Standard = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable_QLKH = new javax.swing.JTable();
        CardTinNhan = new javax.swing.JPanel();
        JPanel_Title_NhapKho1 = new javax.swing.JPanel();
        jLabel_TitleTinNhan = new javax.swing.JLabel();
        jButton_SoanTinNhan = new javax.swing.JButton();
        jButton_CapNhat = new javax.swing.JButton();
        jPanel38 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable_HopThuDen = new javax.swing.JTable();
        jPanel39 = new javax.swing.JPanel();
        jLabel95 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable_HopThuDi = new javax.swing.JTable();
        CardDSSP = new javax.swing.JPanel();
        JPanel_Title_TaoNhapKho2 = new javax.swing.JPanel();
        jLabel94 = new javax.swing.JLabel();
        jButton_NhapHang_huy2 = new javax.swing.JButton();
        jButton_NhapHang_LamMoi2 = new javax.swing.JButton();
        jPanel40 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable_HH = new javax.swing.JTable();

        jMenuItem_Sua.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jMenuItem_Sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Edit_Property_18px.png"))); // NOI18N
        jMenuItem_Sua.setText("Sửa");
        jMenuItem_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_SuaActionPerformed(evt);
            }
        });
        jPopupMenu_SanPham.add(jMenuItem_Sua);

        jMenuItem_Xoa.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jMenuItem_Xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Delete_18px_1.png"))); // NOI18N
        jMenuItem_Xoa.setText("Xóa");
        jMenuItem_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_XoaActionPerformed(evt);
            }
        });
        jPopupMenu_SanPham.add(jMenuItem_Xoa);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);

        BG.setBackground(new java.awt.Color(255, 255, 255));

        jPanel24.setLayout(new javax.swing.BoxLayout(jPanel24, javax.swing.BoxLayout.LINE_AXIS));

        jPanel25.setBackground(new java.awt.Color(55, 126, 232));
        jPanel25.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 10));

        jLabel_TenNguoiDung.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_TenNguoiDung.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_TenNguoiDung.setText("User");
        jPanel25.add(jLabel_TenNguoiDung);

        jLabel78.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setText("-");
        jPanel25.add(jLabel78);

        jLabel77.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setText("Quản lý cửa hàng");
        jPanel25.add(jLabel77);

        jPanel24.add(jPanel25);

        jPanel26.setBackground(new java.awt.Color(55, 126, 232));
        jPanel26.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        Minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Minus_32px_1.png"))); // NOI18N
        Minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MinimizeMouseClicked(evt);
            }
        });
        jPanel26.add(Minimize);

        X.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Delete_32px_1.png"))); // NOI18N
        X.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                XMouseClicked(evt);
            }
        });
        jPanel26.add(X);

        jPanel24.add(jPanel26);

        Function.setLayout(new javax.swing.BoxLayout(Function, javax.swing.BoxLayout.LINE_AXIS));

        Menu.setBackground(new java.awt.Color(244, 244, 244));
        Menu.setPreferredSize(new java.awt.Dimension(200, 733));
        Menu.setLayout(new java.awt.GridLayout(6, 0));

        TongQuan.setBackground(new java.awt.Color(255, 255, 255));
        TongQuan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TongQuanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TongQuanMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TongQuanMousePressed(evt);
            }
        });
        TongQuan.setLayout(new java.awt.GridBagLayout());

        iconTongQuan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        iconTongQuan.setForeground(new java.awt.Color(100, 149, 237));
        iconTongQuan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Shop_32px_1.png"))); // NOI18N
        iconTongQuan.setText("Tổng quan");
        TongQuan.add(iconTongQuan, new java.awt.GridBagConstraints());

        Menu.add(TongQuan);

        NhapKho.setBackground(new java.awt.Color(244, 244, 244));
        NhapKho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NhapKhoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NhapKhoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                NhapKhoMousePressed(evt);
            }
        });
        NhapKho.setLayout(new java.awt.GridBagLayout());

        iconNhapKho.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        iconNhapKho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Truck_32px_1.png"))); // NOI18N
        iconNhapKho.setText("Nhập Kho");
        NhapKho.add(iconNhapKho, new java.awt.GridBagConstraints());

        Menu.add(NhapKho);

        HangHoa.setBackground(new java.awt.Color(244, 244, 244));
        HangHoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HangHoaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HangHoaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                HangHoaMousePressed(evt);
            }
        });
        HangHoa.setLayout(new java.awt.GridBagLayout());

        iconSanPham.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        iconSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Shopping_Cart_32px_1.png"))); // NOI18N
        iconSanPham.setText("Sản phẩm");
        HangHoa.add(iconSanPham, new java.awt.GridBagConstraints());

        Menu.add(HangHoa);

        KhachHang.setBackground(new java.awt.Color(244, 244, 244));
        KhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                KhachHangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                KhachHangMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                KhachHangMousePressed(evt);
            }
        });
        KhachHang.setLayout(new java.awt.GridBagLayout());

        iconKhachHang.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        iconKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_User_Groups_32px_1.png"))); // NOI18N
        iconKhachHang.setText("Khách hàng");
        KhachHang.add(iconKhachHang, new java.awt.GridBagConstraints());

        Menu.add(KhachHang);

        Mail.setBackground(new java.awt.Color(244, 244, 244));
        Mail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MailMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MailMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MailMousePressed(evt);
            }
        });

        iconTinNhan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        iconTinNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Mail_32px_2.png"))); // NOI18N
        iconTinNhan.setText("Tin nhắn");

        javax.swing.GroupLayout MailLayout = new javax.swing.GroupLayout(Mail);
        Mail.setLayout(MailLayout);
        MailLayout.setHorizontalGroup(
            MailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 152, Short.MAX_VALUE)
            .addGroup(MailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MailLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(iconTinNhan)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        MailLayout.setVerticalGroup(
            MailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 122, Short.MAX_VALUE)
            .addGroup(MailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MailLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(iconTinNhan)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        Menu.add(Mail);

        DangXuat.setBackground(new java.awt.Color(244, 244, 244));
        DangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DangXuatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DangXuatMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DangXuatMousePressed(evt);
            }
        });
        DangXuat.setLayout(new java.awt.GridBagLayout());

        iconDangXuat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        iconDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Sign_Out_32px_1.png"))); // NOI18N
        iconDangXuat.setText("Đăng xuất");
        DangXuat.add(iconDangXuat, new java.awt.GridBagConstraints());

        Menu.add(DangXuat);

        Function.add(Menu);

        HienThi.setLayout(new java.awt.CardLayout());

        CardTongQuan.setBackground(new java.awt.Color(255, 255, 255));
        CardTongQuan.setLayout(new java.awt.BorderLayout());

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new java.awt.GridBagLayout());

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 102, 255));
        jLabel44.setText("Thống Kê Cửa Hàng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 10, 0);
        jPanel10.add(jLabel44, gridBagConstraints);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new java.awt.GridBagLayout());

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel45.setText("Hiện có:");
        jPanel12.add(jLabel45, new java.awt.GridBagConstraints());

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(204, 0, 51));
        jLabel46.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel12.add(jLabel46, gridBagConstraints);

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel47.setText("tin nhắn đang chờ");
        jPanel12.add(jLabel47, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 5.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        jPanel10.add(jPanel12, gridBagConstraints);

        CardTongQuan.add(jPanel10, java.awt.BorderLayout.PAGE_START);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new java.awt.BorderLayout());

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1425, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel11.add(jPanel15, java.awt.BorderLayout.PAGE_END);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setLayout(new java.awt.GridLayout(1, 3));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 159, 234)));
        jPanel13.setLayout(new java.awt.BorderLayout());

        jPanel18.setBackground(new java.awt.Color(58, 159, 234));
        jPanel18.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel18.setLayout(new java.awt.GridLayout(1, 0));

        jLabel48.setBackground(new java.awt.Color(58, 159, 234));
        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Combo_Chart_50px.png"))); // NOI18N
        jLabel48.setText("Hoạt động");
        jPanel18.add(jLabel48);

        jPanel13.add(jPanel18, java.awt.BorderLayout.PAGE_START);

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setLayout(new java.awt.GridBagLayout());

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel62.setText("Doanh thu");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel23.add(jLabel62, gridBagConstraints);

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel63.setText("Lợi nhuận");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel23.add(jLabel63, gridBagConstraints);

        jLabel64.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel64.setText("Số đơn hàng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel23.add(jLabel64, gridBagConstraints);

        jLabel65.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel65.setText("Doanh thu/Đơn hàng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel23.add(jLabel65, gridBagConstraints);

        jLabel66.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel66.setText("Khách hàng trả lại");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel23.add(jLabel66, gridBagConstraints);

        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel67.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        jPanel23.add(jLabel67, gridBagConstraints);

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel68.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        jPanel23.add(jLabel68, gridBagConstraints);

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel69.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        jPanel23.add(jLabel69, gridBagConstraints);

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel70.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        jPanel23.add(jLabel70, gridBagConstraints);

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel71.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        jPanel23.add(jLabel71, gridBagConstraints);

        jPanel13.add(jPanel23, java.awt.BorderLayout.CENTER);

        jPanel16.add(jPanel13);

        jPanel14.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(230, 194, 85)));
        jPanel14.setLayout(new java.awt.BorderLayout());

        jPanel19.setBackground(new java.awt.Color(230, 194, 85));
        jPanel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel19.setLayout(new java.awt.GridLayout(1, 0));

        jLabel49.setBackground(new java.awt.Color(255, 188, 73));
        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Price_Tag_52px.png"))); // NOI18N
        jLabel49.setText("Thông tin kho");
        jPanel19.add(jLabel49);

        jPanel14.add(jPanel19, java.awt.BorderLayout.PAGE_START);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setLayout(new java.awt.GridBagLayout());

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel51.setText("Tồn kho lâu");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel20.add(jLabel51, gridBagConstraints);

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel52.setText("Hết hàng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel20.add(jLabel52, gridBagConstraints);

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel53.setText("Sắp hết hàng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel20.add(jLabel53, gridBagConstraints);

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel54.setText("Vượt định mức");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel20.add(jLabel54, gridBagConstraints);

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel55.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        jPanel20.add(jLabel55, gridBagConstraints);

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel56.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        jPanel20.add(jLabel56, gridBagConstraints);

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel57.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        jPanel20.add(jLabel57, gridBagConstraints);

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel58.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        jPanel20.add(jLabel58, gridBagConstraints);

        jPanel14.add(jPanel20, java.awt.BorderLayout.CENTER);

        jPanel16.add(jPanel14);

        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(143, 203, 41)));
        jPanel17.setLayout(new java.awt.BorderLayout());

        jPanel21.setBackground(new java.awt.Color(143, 203, 41));
        jPanel21.setLayout(new java.awt.GridLayout(1, 0));

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_More_Details_50px.png"))); // NOI18N
        jLabel50.setText("Thông tin hàng hoá");
        jPanel21.add(jLabel50);

        jPanel17.add(jPanel21, java.awt.BorderLayout.PAGE_START);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setLayout(new java.awt.GridBagLayout());

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel59.setText("Hàng hoá/Chủng loại");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel22.add(jLabel59, gridBagConstraints);

        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel60.setText("Chưa làm giá bán");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel22.add(jLabel60, gridBagConstraints);

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel61.setText("Chưa nhập giá mua");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel22.add(jLabel61, gridBagConstraints);

        jLabel72.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel72.setText("Hàng chưa phân loại");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel22.add(jLabel72, gridBagConstraints);

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel73.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        jPanel22.add(jLabel73, gridBagConstraints);

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel74.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        jPanel22.add(jLabel74, gridBagConstraints);

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel75.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        jPanel22.add(jLabel75, gridBagConstraints);

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel76.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        jPanel22.add(jLabel76, gridBagConstraints);

        jPanel17.add(jPanel22, java.awt.BorderLayout.CENTER);

        jPanel16.add(jPanel17);

        jPanel11.add(jPanel16, java.awt.BorderLayout.CENTER);

        CardTongQuan.add(jPanel11, java.awt.BorderLayout.CENTER);

        HienThi.add(CardTongQuan, "card2");

        CardNhapKho.setBackground(new java.awt.Color(255, 255, 255));
        CardNhapKho.setLayout(new java.awt.BorderLayout());

        JPanel_Title_NhapKho.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.GridBagLayout JPanel_Title_NhapKhoLayout = new java.awt.GridBagLayout();
        JPanel_Title_NhapKhoLayout.columnWidths = new int[] {0, 5, 0, 5, 0};
        JPanel_Title_NhapKhoLayout.rowHeights = new int[] {0};
        JPanel_Title_NhapKho.setLayout(JPanel_Title_NhapKhoLayout);

        jLabel_TitleNhapKho.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel_TitleNhapKho.setForeground(new java.awt.Color(0, 102, 255));
        jLabel_TitleNhapKho.setText("Danh Sách Phiếu Nhập");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        JPanel_Title_NhapKho.add(jLabel_TitleNhapKho, gridBagConstraints);

        jButton_TaoPhieuNhap.setBackground(new java.awt.Color(65, 127, 194));
        jButton_TaoPhieuNhap.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_TaoPhieuNhap.setForeground(new java.awt.Color(255, 255, 255));
        jButton_TaoPhieuNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Plus_Math_18px.png"))); // NOI18N
        jButton_TaoPhieuNhap.setText("Tạo phiếu nhập");
        jButton_TaoPhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TaoPhieuNhapActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 10;
        JPanel_Title_NhapKho.add(jButton_TaoPhieuNhap, gridBagConstraints);

        jButton_XuatExcel.setBackground(new java.awt.Color(71, 184, 107));
        jButton_XuatExcel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_XuatExcel.setForeground(new java.awt.Color(255, 255, 255));
        jButton_XuatExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Microsoft_Excel_18px.png"))); // NOI18N
        jButton_XuatExcel.setText("Xuất Excel");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.ipady = 10;
        JPanel_Title_NhapKho.add(jButton_XuatExcel, gridBagConstraints);

        CardNhapKho.add(JPanel_Title_NhapKho, java.awt.BorderLayout.PAGE_START);

        jPanel_Show_NhapKho.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_Show_NhapKho.setLayout(new java.awt.BorderLayout());

        jPanel_Filter.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_Filter.setLayout(new java.awt.GridLayout(1, 0));

        jPanel_Filter_Left.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_Filter_Left.setLayout(new java.awt.GridBagLayout());

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 300;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 0, 0);
        jPanel_Filter_Left.add(jTextField1, gridBagConstraints);

        jButton1.setBackground(new java.awt.Color(65, 127, 194));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Search_18px_1.png"))); // NOI18N
        jButton1.setText("Tìm kiếm");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 0, 0);
        jPanel_Filter_Left.add(jButton1, gridBagConstraints);

        jLabel_Filter_Space.setText("                               ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 0, 0);
        jPanel_Filter_Left.add(jLabel_Filter_Space, gridBagConstraints);

        jPanel_Filter.add(jPanel_Filter_Left);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Từ ngày: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(30, 50, 0, 0);
        jPanel3.add(jLabel4, gridBagConstraints);

        jDateChooser1.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooser1.setDateFormatString("dd-MM-yyyy");
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 0, 0);
        jPanel3.add(jDateChooser1, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("đến ngày");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 0, 0);
        jPanel3.add(jLabel5, gridBagConstraints);

        jDateChooser2.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooser2.setDateFormatString("dd-MM-yyyy");
        jDateChooser2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 0, 10);
        jPanel3.add(jDateChooser2, gridBagConstraints);

        jPanel_Filter.add(jPanel3);

        jPanel_Show_NhapKho.add(jPanel_Filter, java.awt.BorderLayout.PAGE_START);

        jPanel_Show_Info.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_Show_Info.setLayout(new java.awt.BorderLayout());

        jPanel_Under_Info.setBackground(new java.awt.Color(204, 204, 255));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Tổng hóa đơn:");
        jPanel_Under_Info.add(jLabel6);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 0, 51));
        jLabel7.setText("0");
        jPanel_Under_Info.add(jLabel7);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setText("-");
        jPanel_Under_Info.add(jLabel8);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setText("Tổng tiền:");
        jPanel_Under_Info.add(jLabel9);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 0, 51));
        jLabel10.setText("0");
        jPanel_Under_Info.add(jLabel10);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 0, 51));
        jLabel11.setText("VNĐ");
        jPanel_Under_Info.add(jLabel11);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setText("-");
        jPanel_Under_Info.add(jLabel12);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel13.setText("Tổng nợ:");
        jPanel_Under_Info.add(jLabel13);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 0, 51));
        jLabel14.setText("0");
        jPanel_Under_Info.add(jLabel14);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 0, 51));
        jLabel15.setText("VNĐ");
        jPanel_Under_Info.add(jLabel15);

        jPanel_Show_Info.add(jPanel_Under_Info, java.awt.BorderLayout.PAGE_END);

        jPanel_Info_NhapKho.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_Info_NhapKho.setLayout(new java.awt.GridLayout(1, 0));

        jTable_PhieuNhapKho.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable_PhieuNhapKho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable_PhieuNhapKho.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable_PhieuNhapKho);

        jPanel_Info_NhapKho.add(jScrollPane1);

        jPanel_Show_Info.add(jPanel_Info_NhapKho, java.awt.BorderLayout.CENTER);

        jPanel_Show_NhapKho.add(jPanel_Show_Info, java.awt.BorderLayout.CENTER);

        CardNhapKho.add(jPanel_Show_NhapKho, java.awt.BorderLayout.CENTER);

        HienThi.add(CardNhapKho, "card3");

        CardTaoPhieuNhap.setBackground(new java.awt.Color(255, 255, 255));
        CardTaoPhieuNhap.setLayout(new java.awt.BorderLayout());

        JPanel_Title_TaoNhapKho.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.GridBagLayout JPanel_Title_TaoNhapKhoLayout = new java.awt.GridBagLayout();
        JPanel_Title_TaoNhapKhoLayout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0};
        JPanel_Title_TaoNhapKhoLayout.rowHeights = new int[] {0};
        JPanel_Title_TaoNhapKho.setLayout(JPanel_Title_TaoNhapKhoLayout);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 255));
        jLabel16.setText("Tạo Phiếu Nhập");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        JPanel_Title_TaoNhapKho.add(jLabel16, gridBagConstraints);

        jButton_NhapHang_XacNhan.setBackground(new java.awt.Color(65, 127, 194));
        jButton_NhapHang_XacNhan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_NhapHang_XacNhan.setForeground(new java.awt.Color(255, 255, 255));
        jButton_NhapHang_XacNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Plus_Math_18px.png"))); // NOI18N
        jButton_NhapHang_XacNhan.setText("Nhập hàng");
        jButton_NhapHang_XacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_NhapHang_XacNhanActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        JPanel_Title_TaoNhapKho.add(jButton_NhapHang_XacNhan, gridBagConstraints);

        jButton_NhapHang_huy.setBackground(new java.awt.Color(172, 172, 172));
        jButton_NhapHang_huy.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_NhapHang_huy.setForeground(new java.awt.Color(255, 255, 255));
        jButton_NhapHang_huy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Back_18px.png"))); // NOI18N
        jButton_NhapHang_huy.setText("Trở lại");
        jButton_NhapHang_huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_NhapHang_huyActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.ipady = 10;
        JPanel_Title_TaoNhapKho.add(jButton_NhapHang_huy, gridBagConstraints);

        jButton_NhapHang_LamMoi.setBackground(new java.awt.Color(71, 184, 107));
        jButton_NhapHang_LamMoi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_NhapHang_LamMoi.setForeground(new java.awt.Color(255, 255, 255));
        jButton_NhapHang_LamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Refresh_18px.png"))); // NOI18N
        jButton_NhapHang_LamMoi.setText("Làm Mới");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 10;
        JPanel_Title_TaoNhapKho.add(jButton_NhapHang_LamMoi, gridBagConstraints);

        CardTaoPhieuNhap.add(JPanel_Title_TaoNhapKho, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thông tin hàng hoá", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 24))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1052, 689));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.LINE_AXIS));

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.GridBagLayout jPanel35Layout = new java.awt.GridBagLayout();
        jPanel35Layout.columnWidths = new int[] {0, 5, 0};
        jPanel35Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0};
        jPanel35.setLayout(jPanel35Layout);

        jLabel81.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel81.setText("Sản phẩm");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        jPanel35.add(jLabel81, gridBagConstraints);

        jLabel84.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel84.setText("Số lượng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        jPanel35.add(jLabel84, gridBagConstraints);

        jLabel92.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel92.setText("Đơn giá");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        jPanel35.add(jLabel92, gridBagConstraints);

        jLabel93.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel93.setText("Tổng giá");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        jPanel35.add(jLabel93, gridBagConstraints);

        jTextField8.setEditable(false);
        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextField8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField8MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 600;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        jPanel35.add(jTextField8, gridBagConstraints);

        jSpinner1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 567;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel35.add(jSpinner1, gridBagConstraints);

        jLabel_TPN_DonGia.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel_TPN_DonGia.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel35.add(jLabel_TPN_DonGia, gridBagConstraints);

        jLabel_TPN_TongGia.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel_TPN_TongGia.setText("0");
        jLabel_TPN_TongGia.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel35.add(jLabel_TPN_TongGia, gridBagConstraints);

        jPanel8.add(jPanel35);

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));
        jPanel36.setLayout(new java.awt.GridBagLayout());

        jButton8.setBackground(new java.awt.Color(65, 127, 194));
        jButton8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Input_18px.png"))); // NOI18N
        jButton8.setText("Thêm/Sửa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel36.add(jButton8, gridBagConstraints);

        jPanel8.add(jPanel36);

        jPanel1.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(452, 602));
        jPanel9.setLayout(new java.awt.GridLayout(1, 0));

        jTable_HangHoa.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTable_HangHoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable_HangHoa.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable_HangHoa);

        jPanel9.add(jScrollPane2);

        jPanel1.add(jPanel9);

        jPanel2.add(jPanel1);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(500, 689));
        jPanel5.setLayout(new java.awt.GridLayout(2, 1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thông tin hoá đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 24))); // NOI18N
        java.awt.GridBagLayout jPanel6Layout = new java.awt.GridBagLayout();
        jPanel6Layout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0};
        jPanel6Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0};
        jPanel6.setLayout(jPanel6Layout);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Mã hoá đơn");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel6.add(jLabel17, gridBagConstraints);

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel6.add(jTextField2, gridBagConstraints);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Nhà cung cấp");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel6.add(jLabel18, gridBagConstraints);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("Ngày nhập");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel6.add(jLabel19, gridBagConstraints);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("Ghi Chú");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel6.add(jLabel20, gridBagConstraints);

        jLabel_TPN_ThemNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Plus_30px_1.png"))); // NOI18N
        jLabel_TPN_ThemNCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_TPN_ThemNCCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_TPN_ThemNCCMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel_TPN_ThemNCCMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        jPanel6.add(jLabel_TPN_ThemNCC, gridBagConstraints);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel6.add(jScrollPane3, gridBagConstraints);

        jTextField9.setEditable(false);
        jTextField9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel6.add(jTextField9, gridBagConstraints);

        jLabel_TPN_XoaNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Minus_30px.png"))); // NOI18N
        jLabel_TPN_XoaNCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_TPN_XoaNCCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_TPN_XoaNCCMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel_TPN_XoaNCCMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        jPanel6.add(jLabel_TPN_XoaNCC, gridBagConstraints);

        jComboBox_NCC.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox_NCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_NCCActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 190;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel6.add(jComboBox_NCC, gridBagConstraints);

        jPanel5.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thông tin thanh toán", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 24))); // NOI18N
        java.awt.GridBagLayout jPanel7Layout = new java.awt.GridBagLayout();
        jPanel7Layout.columnWidths = new int[] {0, 5, 0};
        jPanel7Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        jPanel7.setLayout(jPanel7Layout);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setText("Hình thức");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel7.add(jLabel22, gridBagConstraints);

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel7.add(jComboBox1, gridBagConstraints);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setText("Tiền hàng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel7.add(jLabel23, gridBagConstraints);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setText("0 VNĐ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel7.add(jLabel24, gridBagConstraints);

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setText("Tiền thuế");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel7.add(jLabel25, gridBagConstraints);

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setText("0 VNĐ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel7.add(jLabel26, gridBagConstraints);

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setText("Tổng cộng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel7.add(jLabel27, gridBagConstraints);

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel28.setText("0 VNĐ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel7.add(jLabel28, gridBagConstraints);

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel29.setText("Thanh toán");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel7.add(jLabel29, gridBagConstraints);

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel7.add(jTextField4, gridBagConstraints);

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel30.setText("Còn nợ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel7.add(jLabel30, gridBagConstraints);

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel31.setText("0 VNĐ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel7.add(jLabel31, gridBagConstraints);

        jPanel5.add(jPanel7);

        jPanel2.add(jPanel5);

        CardTaoPhieuNhap.add(jPanel2, java.awt.BorderLayout.CENTER);

        HienThi.add(CardTaoPhieuNhap, "card4");

        CardSanPham.setBackground(new java.awt.Color(255, 255, 255));
        CardSanPham.setLayout(new java.awt.BorderLayout());

        jPanel_Title_SanPham.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.GridBagLayout jPanel_Title_SanPhamLayout = new java.awt.GridBagLayout();
        jPanel_Title_SanPhamLayout.columnWidths = new int[] {0, 5, 0, 5, 0};
        jPanel_Title_SanPhamLayout.rowHeights = new int[] {0};
        jPanel_Title_SanPham.setLayout(jPanel_Title_SanPhamLayout);

        jLabel_Title_DSSP.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel_Title_DSSP.setForeground(new java.awt.Color(0, 102, 255));
        jLabel_Title_DSSP.setText("Danh Sách Sản Phẩm");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel_Title_SanPham.add(jLabel_Title_DSSP, gridBagConstraints);

        jButton_ThemSP.setBackground(new java.awt.Color(65, 127, 194));
        jButton_ThemSP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_ThemSP.setForeground(new java.awt.Color(255, 255, 255));
        jButton_ThemSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Plus_Math_18px.png"))); // NOI18N
        jButton_ThemSP.setText("Thêm sản phẩm");
        jButton_ThemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ThemSPActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 10;
        jPanel_Title_SanPham.add(jButton_ThemSP, gridBagConstraints);

        jButton_XuatExcelSP.setBackground(new java.awt.Color(71, 184, 107));
        jButton_XuatExcelSP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_XuatExcelSP.setForeground(new java.awt.Color(255, 255, 255));
        jButton_XuatExcelSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Microsoft_Excel_18px.png"))); // NOI18N
        jButton_XuatExcelSP.setText("Xuất Excel");
        jButton_XuatExcelSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XuatExcelSPActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        jPanel_Title_SanPham.add(jButton_XuatExcelSP, gridBagConstraints);

        CardSanPham.add(jPanel_Title_SanPham, java.awt.BorderLayout.PAGE_START);

        jPanel_Show_NhapKho1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_Show_NhapKho1.setLayout(new java.awt.BorderLayout());

        jPanel_Filter1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_Filter1.setLayout(new java.awt.GridLayout(1, 0));

        jPanel_Filter_Left1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_Filter_Left1.setLayout(new java.awt.GridBagLayout());

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 300;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 0, 0);
        jPanel_Filter_Left1.add(jTextField5, gridBagConstraints);

        jButton2.setBackground(new java.awt.Color(65, 127, 194));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Search_18px_1.png"))); // NOI18N
        jButton2.setText("Tìm kiếm");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 0, 0);
        jPanel_Filter_Left1.add(jButton2, gridBagConstraints);

        jLabel_Filter_Space1.setText("                               ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 0, 0);
        jPanel_Filter_Left1.add(jLabel_Filter_Space1, gridBagConstraints);

        jPanel_Filter1.add(jPanel_Filter_Left1);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.GridBagLayout());
        jPanel_Filter1.add(jPanel4);

        jPanel_Show_NhapKho1.add(jPanel_Filter1, java.awt.BorderLayout.PAGE_START);

        jPanel_Show_Info1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_Show_Info1.setLayout(new java.awt.BorderLayout());

        jPanel_Under_Info1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel34.setText("Tổng sản phẩm:");
        jPanel_Under_Info1.add(jLabel34);

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(204, 0, 51));
        jLabel35.setText("0");
        jPanel_Under_Info1.add(jLabel35);

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel36.setText("-");
        jPanel_Under_Info1.add(jLabel36);

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel37.setText("Tổng tiền mua:");
        jPanel_Under_Info1.add(jLabel37);

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(204, 0, 51));
        jLabel38.setText("0");
        jPanel_Under_Info1.add(jLabel38);

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(204, 0, 51));
        jLabel39.setText("VNĐ");
        jPanel_Under_Info1.add(jLabel39);

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel40.setText("-");
        jPanel_Under_Info1.add(jLabel40);

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel41.setText("Tổng tiền bán:");
        jPanel_Under_Info1.add(jLabel41);

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(204, 0, 51));
        jLabel42.setText("0");
        jPanel_Under_Info1.add(jLabel42);

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(204, 0, 51));
        jLabel43.setText("VNĐ");
        jPanel_Under_Info1.add(jLabel43);

        jPanel_Show_Info1.add(jPanel_Under_Info1, java.awt.BorderLayout.PAGE_END);

        jPanel_Info_SanPham.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_Info_SanPham.setLayout(new java.awt.GridLayout(1, 0));

        jTable_SanPham.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable_SanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable_SanPham.setComponentPopupMenu(jPopupMenu_SanPham);
        jTable_SanPham.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTable_SanPham);

        jPanel_Info_SanPham.add(jScrollPane4);

        jPanel_Show_Info1.add(jPanel_Info_SanPham, java.awt.BorderLayout.CENTER);

        jPanel_Show_NhapKho1.add(jPanel_Show_Info1, java.awt.BorderLayout.CENTER);

        CardSanPham.add(jPanel_Show_NhapKho1, java.awt.BorderLayout.CENTER);

        HienThi.add(CardSanPham, "card5");

        CardTaoSanPham.setBackground(new java.awt.Color(255, 255, 255));
        CardTaoSanPham.setLayout(new java.awt.BorderLayout());

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));
        jPanel31.setLayout(new java.awt.GridBagLayout());

        jLabel_Title_TSP.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel_Title_TSP.setForeground(new java.awt.Color(0, 102, 255));
        jLabel_Title_TSP.setText("Tạo Sản Phẩm");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 0);
        jPanel31.add(jLabel_Title_TSP, gridBagConstraints);

        jButton9.setBackground(new java.awt.Color(71, 184, 107));
        jButton9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Edit_18px.png"))); // NOI18N
        jButton9.setText("Sửa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        jPanel31.add(jButton9, gridBagConstraints);

        jButton5.setBackground(new java.awt.Color(65, 127, 194));
        jButton5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Plus_Math_18px.png"))); // NOI18N
        jButton5.setText("Thêm");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        jPanel31.add(jButton5, gridBagConstraints);

        jButton6.setBackground(new java.awt.Color(172, 172, 172));
        jButton6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Back_18px.png"))); // NOI18N
        jButton6.setText("Trở lại");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        jPanel31.add(jButton6, gridBagConstraints);

        CardTaoSanPham.add(jPanel31, java.awt.BorderLayout.PAGE_START);

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));
        jPanel32.setLayout(new javax.swing.BoxLayout(jPanel32, javax.swing.BoxLayout.LINE_AXIS));

        jPanel33.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.GridBagLayout jPanel33Layout = new java.awt.GridBagLayout();
        jPanel33Layout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0};
        jPanel33Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        jPanel33.setLayout(jPanel33Layout);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("Mã hàng hóa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        jPanel33.add(jLabel2, gridBagConstraints);

        jLabel85.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel85.setText("Tên hàng hóa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        jPanel33.add(jLabel85, gridBagConstraints);

        jLabel86.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel86.setText("Giá bán");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        jPanel33.add(jLabel86, gridBagConstraints);

        jLabel87.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel87.setText("Giá vốn");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        jPanel33.add(jLabel87, gridBagConstraints);

        jLabel88.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel88.setText("Nhóm hàng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        jPanel33.add(jLabel88, gridBagConstraints);

        jLabel89.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel89.setText("Nhà sản xuất");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        jPanel33.add(jLabel89, gridBagConstraints);

        jLabel90.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel90.setText("Thuế VAT (%)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        jPanel33.add(jLabel90, gridBagConstraints);

        jLabel91.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel91.setText("Mô tả sản phẩm");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        jPanel33.add(jLabel91, gridBagConstraints);

        jTextFieldMaHH.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        jPanel33.add(jTextFieldMaHH, gridBagConstraints);

        jTextFieldTenHH.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        jPanel33.add(jTextFieldTenHH, gridBagConstraints);

        jTextFieldGiaBan.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextFieldGiaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldGiaBanActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        jPanel33.add(jTextFieldGiaBan, gridBagConstraints);

        jFormattedThue.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedThue.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jFormattedThue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedThueActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        jPanel33.add(jFormattedThue, gridBagConstraints);

        jComboBoxNhomHang.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 600;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 0.1;
        jPanel33.add(jComboBoxNhomHang, gridBagConstraints);

        jComboBoxNhaSX.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 380;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 0.1;
        jPanel33.add(jComboBoxNhaSX, gridBagConstraints);

        jTextFieldGiaVon.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextFieldGiaVon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldGiaVonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        jPanel33.add(jTextFieldGiaVon, gridBagConstraints);

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Monospaced", 0, 20)); // NOI18N
        jTextArea2.setRows(5);
        jScrollPane5.setViewportView(jTextArea2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 300;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        jPanel33.add(jScrollPane5, gridBagConstraints);

        jLabel_ThemNSX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Plus_30px_1.png"))); // NOI18N
        jLabel_ThemNSX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_ThemNSXMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_ThemNSXMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_ThemNSXMouseExited(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel33.add(jLabel_ThemNSX, gridBagConstraints);

        jLabel_XoaNSX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Minus_30px.png"))); // NOI18N
        jLabel_XoaNSX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_XoaNSXMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_XoaNSXMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel_XoaNSXMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 30);
        jPanel33.add(jLabel_XoaNSX, gridBagConstraints);

        jLabel_ThemNH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Plus_30px_1.png"))); // NOI18N
        jLabel_ThemNH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_ThemNHMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_ThemNHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_ThemNHMouseExited(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel33.add(jLabel_ThemNH, gridBagConstraints);

        jLabel_XoaNH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Minus_30px.png"))); // NOI18N
        jLabel_XoaNH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_XoaNHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_XoaNHMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel_XoaNHMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 30);
        jPanel33.add(jLabel_XoaNH, gridBagConstraints);

        jPanel32.add(jPanel33);

        jPanel34.setBackground(new java.awt.Color(255, 255, 255));
        jPanel34.setPreferredSize(new java.awt.Dimension(700, 669));
        jPanel34.setLayout(new java.awt.BorderLayout());

        jPanel42.setBackground(new java.awt.Color(255, 255, 255));

        jButton7.setBackground(new java.awt.Color(71, 184, 107));
        jButton7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Add_Image_18px.png"))); // NOI18N
        jButton7.setText("Thêm ảnh");
        jButton7.setMargin(new java.awt.Insets(5, 15, 5, 15));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
            .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel42Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jButton7)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel42Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jButton7)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel34.add(jPanel42, java.awt.BorderLayout.PAGE_END);

        jPanel43.setLayout(new javax.swing.BoxLayout(jPanel43, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel44.setBackground(new java.awt.Color(255, 255, 255));

        jLabelImage1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
            .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel44Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 483, Short.MAX_VALUE)
            .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel44Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel43.add(jPanel44);

        jPanel45.setBackground(new java.awt.Color(255, 255, 255));
        jPanel45.setLayout(new java.awt.GridLayout(1, 4, 2, 0));

        jLabelImage2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImage2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelImage2.setPreferredSize(new java.awt.Dimension(2, 100));
        jPanel45.add(jLabelImage2);

        jLabelImage3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImage3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel45.add(jLabelImage3);

        jLabelImage4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImage4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel45.add(jLabelImage4);

        jLabelImage5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImage5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel45.add(jLabelImage5);

        jPanel43.add(jPanel45);

        jPanel34.add(jPanel43, java.awt.BorderLayout.CENTER);

        jPanel32.add(jPanel34);

        CardTaoSanPham.add(jPanel32, java.awt.BorderLayout.CENTER);

        HienThi.add(CardTaoSanPham, "card6");

        CardKhachHang.setBackground(new java.awt.Color(255, 255, 255));
        CardKhachHang.setLayout(new java.awt.BorderLayout(0, 20));

        JPanel_Title_TaoNhapKho1.setBackground(new java.awt.Color(255, 255, 255));
        JPanel_Title_TaoNhapKho1.setLayout(new java.awt.GridBagLayout());

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(0, 102, 255));
        jLabel79.setText("Quản Lý Khách Hàng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        JPanel_Title_TaoNhapKho1.add(jLabel79, gridBagConstraints);

        jButton_NhapHang_huy1.setBackground(new java.awt.Color(71, 184, 107));
        jButton_NhapHang_huy1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_NhapHang_huy1.setForeground(new java.awt.Color(255, 255, 255));
        jButton_NhapHang_huy1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Microsoft_Excel_18px.png"))); // NOI18N
        jButton_NhapHang_huy1.setText("Xuất Excel");
        jButton_NhapHang_huy1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_NhapHang_huy1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.ipady = 10;
        JPanel_Title_TaoNhapKho1.add(jButton_NhapHang_huy1, gridBagConstraints);

        jButton_NhapHang_LamMoi1.setBackground(new java.awt.Color(65, 127, 194));
        jButton_NhapHang_LamMoi1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_NhapHang_LamMoi1.setForeground(new java.awt.Color(255, 255, 255));
        jButton_NhapHang_LamMoi1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Refresh_18px.png"))); // NOI18N
        jButton_NhapHang_LamMoi1.setText("Làm Mới");
        jButton_NhapHang_LamMoi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_NhapHang_LamMoi1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.ipady = 10;
        JPanel_Title_TaoNhapKho1.add(jButton_NhapHang_LamMoi1, gridBagConstraints);

        CardKhachHang.add(JPanel_Title_TaoNhapKho1, java.awt.BorderLayout.PAGE_START);

        jPanel_ShowKH.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_ShowKH.setLayout(new java.awt.BorderLayout());

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setLayout(new javax.swing.BoxLayout(jPanel27, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setLayout(new java.awt.GridBagLayout());

        jButton3.setBackground(new java.awt.Color(65, 127, 194));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Sửa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 20, 50);
        jPanel29.add(jButton3, gridBagConstraints);

        jButton4.setBackground(new java.awt.Color(242, 64, 64));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Xóa");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(20, 50, 20, 0);
        jPanel29.add(jButton4, gridBagConstraints);

        jPanel27.add(jPanel29);

        jPanel30.setBackground(new java.awt.Color(204, 204, 255));
        jPanel30.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Tổng khách hàng: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel30.add(jLabel1, gridBagConstraints);

        jLabel_slKH.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_slKH.setForeground(new java.awt.Color(204, 0, 51));
        jLabel_slKH.setText("0");
        jPanel30.add(jLabel_slKH, new java.awt.GridBagConstraints());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText(" - ");
        jPanel30.add(jLabel3, new java.awt.GridBagConstraints());

        jLabel80.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel80.setText("Khách V.I.P: ");
        jPanel30.add(jLabel80, new java.awt.GridBagConstraints());

        jLabel_vip.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_vip.setForeground(new java.awt.Color(204, 0, 51));
        jLabel_vip.setText("0");
        jPanel30.add(jLabel_vip, new java.awt.GridBagConstraints());

        jLabel82.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel82.setText(" - ");
        jPanel30.add(jLabel82, new java.awt.GridBagConstraints());

        jLabel83.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel83.setText("Khách thường: ");
        jPanel30.add(jLabel83, new java.awt.GridBagConstraints());

        jLabel_Standard.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_Standard.setForeground(new java.awt.Color(204, 0, 51));
        jLabel_Standard.setText("0");
        jPanel30.add(jLabel_Standard, new java.awt.GridBagConstraints());

        jPanel27.add(jPanel30);

        jPanel_ShowKH.add(jPanel27, java.awt.BorderLayout.PAGE_END);

        jPanel28.setLayout(new javax.swing.BoxLayout(jPanel28, javax.swing.BoxLayout.LINE_AXIS));

        jTable_QLKH.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jScrollPane6.setViewportView(jTable_QLKH);

        jPanel28.add(jScrollPane6);

        jPanel_ShowKH.add(jPanel28, java.awt.BorderLayout.CENTER);

        CardKhachHang.add(jPanel_ShowKH, java.awt.BorderLayout.CENTER);

        HienThi.add(CardKhachHang, "card7");

        CardTinNhan.setBackground(new java.awt.Color(255, 255, 255));
        CardTinNhan.setLayout(new java.awt.BorderLayout());

        JPanel_Title_NhapKho1.setBackground(new java.awt.Color(255, 255, 255));
        JPanel_Title_NhapKho1.setLayout(new java.awt.GridBagLayout());

        jLabel_TitleTinNhan.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel_TitleTinNhan.setForeground(new java.awt.Color(0, 102, 255));
        jLabel_TitleTinNhan.setText("Danh Sách Tin Nhắn");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        JPanel_Title_NhapKho1.add(jLabel_TitleTinNhan, gridBagConstraints);

        jButton_SoanTinNhan.setBackground(new java.awt.Color(65, 127, 194));
        jButton_SoanTinNhan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_SoanTinNhan.setForeground(new java.awt.Color(255, 255, 255));
        jButton_SoanTinNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Plus_Math_18px.png"))); // NOI18N
        jButton_SoanTinNhan.setText("Soạn");
        jButton_SoanTinNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SoanTinNhanActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 80;
        gridBagConstraints.ipady = 10;
        JPanel_Title_NhapKho1.add(jButton_SoanTinNhan, gridBagConstraints);

        jButton_CapNhat.setBackground(new java.awt.Color(71, 184, 107));
        jButton_CapNhat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_CapNhat.setForeground(new java.awt.Color(255, 255, 255));
        jButton_CapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Refresh_18px.png"))); // NOI18N
        jButton_CapNhat.setText("Cập nhật");
        jButton_CapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CapNhatActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.ipady = 10;
        JPanel_Title_NhapKho1.add(jButton_CapNhat, gridBagConstraints);

        CardTinNhan.add(JPanel_Title_NhapKho1, java.awt.BorderLayout.PAGE_START);

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));
        jPanel38.setLayout(new java.awt.GridLayout(2, 1, 0, 10));

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));
        jPanel37.setLayout(new java.awt.BorderLayout(0, 10));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(150, 40, 27));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("HỘP THƯ ĐẾN");
        jPanel37.add(jLabel21, java.awt.BorderLayout.PAGE_START);

        jTable_HopThuDen.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTable_HopThuDen.getTableHeader().setResizingAllowed(false);
        jTable_HopThuDen.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(jTable_HopThuDen);

        jPanel37.add(jScrollPane7, java.awt.BorderLayout.CENTER);

        jPanel38.add(jPanel37);

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));
        jPanel39.setLayout(new java.awt.BorderLayout(0, 10));

        jLabel95.setBackground(new java.awt.Color(255, 255, 255));
        jLabel95.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(150, 40, 27));
        jLabel95.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel95.setText("HỘP THƯ ĐI");
        jPanel39.add(jLabel95, java.awt.BorderLayout.PAGE_START);

        jTable_HopThuDi.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTable_HopThuDi.getTableHeader().setResizingAllowed(false);
        jTable_HopThuDi.getTableHeader().setReorderingAllowed(false);
        jScrollPane8.setViewportView(jTable_HopThuDi);

        jPanel39.add(jScrollPane8, java.awt.BorderLayout.CENTER);

        jPanel38.add(jPanel39);

        CardTinNhan.add(jPanel38, java.awt.BorderLayout.CENTER);

        HienThi.add(CardTinNhan, "card8");

        CardDSSP.setBackground(new java.awt.Color(255, 255, 255));
        CardDSSP.setLayout(new java.awt.BorderLayout());

        JPanel_Title_TaoNhapKho2.setBackground(new java.awt.Color(255, 255, 255));
        JPanel_Title_TaoNhapKho2.setLayout(new java.awt.GridBagLayout());

        jLabel94.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(0, 102, 255));
        jLabel94.setText("Danh Sách Sản Phẩm");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        JPanel_Title_TaoNhapKho2.add(jLabel94, gridBagConstraints);

        jButton_NhapHang_huy2.setBackground(new java.awt.Color(172, 172, 172));
        jButton_NhapHang_huy2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_NhapHang_huy2.setForeground(new java.awt.Color(255, 255, 255));
        jButton_NhapHang_huy2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Back_18px.png"))); // NOI18N
        jButton_NhapHang_huy2.setText("Trở lại");
        jButton_NhapHang_huy2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_NhapHang_huy2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.ipady = 10;
        JPanel_Title_TaoNhapKho2.add(jButton_NhapHang_huy2, gridBagConstraints);

        jButton_NhapHang_LamMoi2.setBackground(new java.awt.Color(65, 127, 194));
        jButton_NhapHang_LamMoi2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_NhapHang_LamMoi2.setForeground(new java.awt.Color(255, 255, 255));
        jButton_NhapHang_LamMoi2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Refresh_18px.png"))); // NOI18N
        jButton_NhapHang_LamMoi2.setText("Làm Mới");
        jButton_NhapHang_LamMoi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_NhapHang_LamMoi2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.ipady = 10;
        JPanel_Title_TaoNhapKho2.add(jButton_NhapHang_LamMoi2, gridBagConstraints);

        CardDSSP.add(JPanel_Title_TaoNhapKho2, java.awt.BorderLayout.PAGE_START);

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));
        jPanel40.setLayout(new java.awt.BorderLayout());

        jPanel41.setBackground(new java.awt.Color(255, 255, 255));
        jPanel41.setLayout(new java.awt.GridBagLayout());

        jLabel32.setBackground(new java.awt.Color(255, 255, 255));
        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel32.setText("Tìm kiếm:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        jPanel41.add(jLabel32, gridBagConstraints);

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 3.3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 50);
        jPanel41.add(jTextField3, gridBagConstraints);

        jButton10.setBackground(new java.awt.Color(65, 127, 194));
        jButton10.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Tìm");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 10;
        jPanel41.add(jButton10, gridBagConstraints);

        jPanel40.add(jPanel41, java.awt.BorderLayout.PAGE_START);

        jTable_HH.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTable_HH.getTableHeader().setResizingAllowed(false);
        jTable_HH.getTableHeader().setReorderingAllowed(false);
        jScrollPane9.setViewportView(jTable_HH);

        jPanel40.add(jScrollPane9, java.awt.BorderLayout.CENTER);

        CardDSSP.add(jPanel40, java.awt.BorderLayout.CENTER);

        HienThi.add(CardDSSP, "card9");

        Function.add(HienThi);

        javax.swing.GroupLayout BGLayout = new javax.swing.GroupLayout(BG);
        BG.setLayout(BGLayout);
        BGLayout.setHorizontalGroup(
            BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Function, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1578, Short.MAX_VALUE)
            .addGroup(BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, 1578, Short.MAX_VALUE))
        );
        BGLayout.setVerticalGroup(
            BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BGLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(Function, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BGLayout.createSequentialGroup()
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 743, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TongQuanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TongQuanMouseEntered
        // TODO add your handling code here:
        iconTongQuan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Shop_32px_1.png")));
        TongQuan.setBackground(Color.WHITE);
        iconTongQuan.setForeground(new Color(100, 149, 237));
        iconTongQuan.setFont(new java.awt.Font("Tahoma", 1, 18));
    }//GEN-LAST:event_TongQuanMouseEntered

    private void TongQuanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TongQuanMouseExited
        // TODO add your handling code here:
        if (currenColor != 1) {
            iconTongQuan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Shop_32px.png")));
            iconTongQuan.setForeground(Color.BLACK);
            TongQuan.setBackground(new Color(244, 244, 244));
            iconTongQuan.setFont(new java.awt.Font("Tahoma", 0, 18));
        }
    }//GEN-LAST:event_TongQuanMouseExited

    private void TongQuanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TongQuanMousePressed
        // TODO add your handling code here:
        currenColor = 1;
        disCard();
        CardTongQuan.show();
        disSubMenu();
        iconTongQuan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Shop_32px_1.png")));
        TongQuan.setBackground(Color.WHITE);
        iconTongQuan.setForeground(new Color(100, 149, 237));
        iconTongQuan.setFont(new java.awt.Font("Tahoma", 1, 18));
    }//GEN-LAST:event_TongQuanMousePressed

    private void NhapKhoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NhapKhoMouseEntered
        // TODO add your handling code here:
        iconNhapKho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Truck_32px_2.png")));
        NhapKho.setBackground(Color.WHITE);
        iconNhapKho.setForeground(new Color(100, 149, 237));
        iconNhapKho.setFont(new java.awt.Font("Tahoma", 1, 18));
    }//GEN-LAST:event_NhapKhoMouseEntered

    private void NhapKhoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NhapKhoMouseExited
        // TODO add your handling code here:
        if (currenColor != 2) {
            iconNhapKho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Truck_32px_1.png")));
            iconNhapKho.setForeground(Color.BLACK);
            NhapKho.setBackground(new Color(244, 244, 244));
            iconNhapKho.setFont(new java.awt.Font("Tahoma", 0, 18));
        }
    }//GEN-LAST:event_NhapKhoMouseExited

    private void NhapKhoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NhapKhoMousePressed
        // TODO add your handling code here:
        currenColor = 2;
        disCard();
        CardNhapKho.show();
        disSubMenu();
        iconNhapKho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Truck_32px_2.png")));
        NhapKho.setBackground(Color.WHITE);
        iconNhapKho.setForeground(new Color(100, 149, 237));
        iconNhapKho.setFont(new java.awt.Font("Tahoma", 1, 18));
    }//GEN-LAST:event_NhapKhoMousePressed

    private void jButton_NhapHang_huyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_NhapHang_huyActionPerformed
        // TODO add your handling code here:
        currenColor = 2;
        disCard();
        CardNhapKho.show();
    }//GEN-LAST:event_jButton_NhapHang_huyActionPerformed

    private void jButton_NhapHang_XacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_NhapHang_XacNhanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_NhapHang_XacNhanActionPerformed

    private void jButton_TaoPhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TaoPhieuNhapActionPerformed
        try {
            // TODO add your handling code here:
            currenColor = 2;
            disCard();
            CardTaoPhieuNhap.show();
            for (int i = 0; i < jComboBox_NCC.getItemCount(); i++) {
                jComboBox_NCC.removeItemAt(i);
            }
            for (int i = 0; i < qlNCC.getAllNCC().size(); i++) {
                jComboBox_NCC.addItem(qlNCC.getAllNCC().get(i).getTenNCC());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_TaoPhieuNhapActionPerformed

    private void HangHoaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HangHoaMouseEntered
        // TODO add your handling code here:
        iconSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Shopping_Cart_32px.png")));
        HangHoa.setBackground(Color.WHITE);
        iconSanPham.setForeground(new Color(100, 149, 237));
        iconSanPham.setFont(new java.awt.Font("Tahoma", 1, 18));
    }//GEN-LAST:event_HangHoaMouseEntered

    private void HangHoaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HangHoaMouseExited
        // TODO add your handling code here:
        if (currenColor != 3) {
            iconSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Shopping_Cart_32px_1.png")));
            iconSanPham.setForeground(Color.BLACK);
            HangHoa.setBackground(new Color(244, 244, 244));
            iconSanPham.setFont(new java.awt.Font("Tahoma", 0, 18));
        }
    }//GEN-LAST:event_HangHoaMouseExited

    private void HangHoaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HangHoaMousePressed
        // TODO add your handling code here:
        currenColor = 3;
        disCard();
        CardSanPham.show();
        disSubMenu();
        iconSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Shopping_Cart_32px.png")));
        HangHoa.setBackground(Color.WHITE);
        iconSanPham.setForeground(new Color(100, 149, 237));
        iconSanPham.setFont(new java.awt.Font("Tahoma", 1, 18));

        modelTable1.fireTableDataChanged();
    }//GEN-LAST:event_HangHoaMousePressed

    private void jButton_XuatExcelSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XuatExcelSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_XuatExcelSPActionPerformed

    private void DangXuatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DangXuatMouseEntered
        // TODO add your handling code here:
        iconDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Sign_Out_32px_2.png")));
        DangXuat.setBackground(Color.WHITE);
        iconDangXuat.setForeground(new Color(100, 149, 237));
        iconDangXuat.setFont(new java.awt.Font("Tahoma", 1, 18));
    }//GEN-LAST:event_DangXuatMouseEntered

    private void DangXuatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DangXuatMousePressed
        // TODO add your handling code here:
        int choose = JOptionPane.showConfirmDialog(this, "Bạn có thật sự muốn thoát khỏi hệ thống?");
        switch (choose) {
            case 0:
                Login login = new Login();
                login.setVisible(true);
                this.dispose();
            case 1:

            case 2:
        }

    }//GEN-LAST:event_DangXuatMousePressed

    private void DangXuatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DangXuatMouseExited
        // TODO add your handling code here:
        if (currenColor != 4) {
            iconDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Sign_Out_32px_1.png")));
            iconDangXuat.setForeground(Color.BLACK);
            DangXuat.setBackground(new Color(244, 244, 244));
            iconDangXuat.setFont(new java.awt.Font("Tahoma", 0, 18));
        }
    }//GEN-LAST:event_DangXuatMouseExited

    private void MinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizeMouseClicked
        // TODO add your handling code here:
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_MinimizeMouseClicked

    private void XMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_XMouseClicked

    private void KhachHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KhachHangMouseEntered
        // TODO add your handling code here:
        iconKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_User_Groups_32px.png")));
        KhachHang.setBackground(Color.WHITE);
        iconKhachHang.setForeground(new Color(100, 149, 237));
        iconKhachHang.setFont(new java.awt.Font("Tahoma", 1, 18));
    }//GEN-LAST:event_KhachHangMouseEntered

    private void MailMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MailMouseEntered
        // TODO add your handling code here:
        iconTinNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Mail_32px_3.png")));
        Mail.setBackground(Color.WHITE);
        iconTinNhan.setForeground(new Color(100, 149, 237));
        iconTinNhan.setFont(new java.awt.Font("Tahoma", 1, 18));
    }//GEN-LAST:event_MailMouseEntered

    private void KhachHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KhachHangMouseExited
        // TODO add your handling code here:
        if (currenColor != 4) {
            iconKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_User_Groups_32px_1.png")));
            iconKhachHang.setForeground(Color.BLACK);
            KhachHang.setBackground(new Color(244, 244, 244));
            iconKhachHang.setFont(new java.awt.Font("Tahoma", 0, 18));
        }
    }//GEN-LAST:event_KhachHangMouseExited

    private void MailMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MailMouseExited
        // TODO add your handling code here:
        if (currenColor != 5) {
            iconTinNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Mail_32px_2.png")));
            iconTinNhan.setForeground(Color.BLACK);
            Mail.setBackground(new Color(244, 244, 244));
            iconTinNhan.setFont(new java.awt.Font("Tahoma", 0, 18));
        }
    }//GEN-LAST:event_MailMouseExited

    private void KhachHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KhachHangMousePressed
        // TODO add your handling code here:

        currenColor = 4;
        disCard();
        CardKhachHang.show();
        disSubMenu();
        iconKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_User_Groups_32px.png")));
        KhachHang.setBackground(Color.WHITE);
        iconKhachHang.setForeground(new Color(100, 149, 237));
        iconKhachHang.setFont(new java.awt.Font("Tahoma", 1, 18));
    }//GEN-LAST:event_KhachHangMousePressed

    private void MailMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MailMousePressed
        // TODO add your handling code here:
        currenColor = 5;
        disCard();
        CardTinNhan.show();
        disSubMenu();
        iconTinNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Mail_32px_3.png")));
        Mail.setBackground(Color.WHITE);
        iconTinNhan.setForeground(new Color(100, 149, 237));
        iconTinNhan.setFont(new java.awt.Font("Tahoma", 1, 18));
    }//GEN-LAST:event_MailMousePressed

    private void jButton_NhapHang_huy1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_NhapHang_huy1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_NhapHang_huy1ActionPerformed

    private void jButton_ThemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ThemSPActionPerformed
        // TODO add your handling code here:
        currenColor = 3;
        disCard();
        CardTaoSanPham.show();
        jButton5.setVisible(true);
        jButton9.hide();
        jTextFieldMaHH.setEnabled(true);
        reset();
    }//GEN-LAST:event_jButton_ThemSPActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        currenColor = 3;
        disCard();
        CardSanPham.show();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            String a = (String) jTable_QLKH.getValueAt(jTable_QLKH.getSelectedRow(), 0);
            String a1 = (String) jTable_QLKH.getValueAt(jTable_QLKH.getSelectedRow(), 1);
            String a2 = (String) jTable_QLKH.getValueAt(jTable_QLKH.getSelectedRow(), 2);
            String a3 = (String) jTable_QLKH.getValueAt(jTable_QLKH.getSelectedRow(), 3);
            String a4 = (String) jTable_QLKH.getValueAt(jTable_QLKH.getSelectedRow(), 4);
            SuaKhachHang sKH = new SuaKhachHang(this, true, a, a1, a2, a3, a4);
            sKH.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Phải chọn khách hàng cần sửa");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jFormattedThueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedThueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedThueActionPerformed

    private void jTextFieldGiaBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldGiaBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGiaBanActionPerformed

    private void jTextFieldGiaVonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldGiaVonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGiaVonActionPerformed

    private void jLabel_ThemNHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_ThemNHMouseEntered
        // TODO add your handling code here:
        jLabel_ThemNH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Plus_30px_2.png")));
    }//GEN-LAST:event_jLabel_ThemNHMouseEntered

    private void jLabel_ThemNSXMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_ThemNSXMouseEntered
        // TODO add your handling code here:
        jLabel_ThemNSX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Plus_30px_2.png")));
    }//GEN-LAST:event_jLabel_ThemNSXMouseEntered

    private void jLabel_XoaNHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_XoaNHMouseEntered
        // TODO add your handling code here:
        jLabel_XoaNH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Minus_30px_1.png")));
    }//GEN-LAST:event_jLabel_XoaNHMouseEntered

    private void jLabel_XoaNSXMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_XoaNSXMouseEntered
        // TODO add your handling code here:
        jLabel_XoaNSX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Minus_30px_1.png")));
    }//GEN-LAST:event_jLabel_XoaNSXMouseEntered

    private void jLabel_ThemNHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_ThemNHMouseExited
        // TODO add your handling code here:
        jLabel_ThemNH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Plus_30px_1.png")));
    }//GEN-LAST:event_jLabel_ThemNHMouseExited

    private void jLabel_ThemNSXMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_ThemNSXMouseExited
        // TODO add your handling code here:
        jLabel_ThemNSX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Plus_30px_1.png")));
    }//GEN-LAST:event_jLabel_ThemNSXMouseExited

    private void jLabel_XoaNHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_XoaNHMouseExited
        // TODO add your handling code here:
        jLabel_XoaNH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Minus_30px.png")));
    }//GEN-LAST:event_jLabel_XoaNHMouseExited

    private void jLabel_XoaNSXMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_XoaNSXMouseExited
        // TODO add your handling code here:
        jLabel_XoaNSX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Minus_30px.png")));
    }//GEN-LAST:event_jLabel_XoaNSXMouseExited

    private void jButton_NhapHang_LamMoi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_NhapHang_LamMoi1ActionPerformed
        // TODO add your handling code here:
        changeTable();
        KH = new QLKhachHang();
        jLabel_slKH.setText(jTable_QLKH.getRowCount() + "");
        jLabel_vip.setText(KH.getAllKHVip().toString());
        jLabel_Standard.setText(KH.getAllKHStandard().toString());
    }//GEN-LAST:event_jButton_NhapHang_LamMoi1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //delete KH
        try {
            KH.delete(jTable_QLKH.getValueAt(jTable_QLKH.getSelectedRow(), 0).toString());
            modelTable2 = (DefaultTableModel) jTable_QLKH.getModel();
            modelTable2.removeRow(jTable_QLKH.getSelectedRow());
            JOptionPane.showMessageDialog(this, "Xóa khách hàng thành công");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Phải chọn khach hàng cần xóa");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jLabel_TPN_ThemNCCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_TPN_ThemNCCMouseEntered
        // TODO add your handling code here:
        jLabel_TPN_ThemNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Plus_30px_2.png")));
    }//GEN-LAST:event_jLabel_TPN_ThemNCCMouseEntered

    private void jLabel_TPN_ThemNCCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_TPN_ThemNCCMouseExited
        // TODO add your handling code here:
        jLabel_TPN_ThemNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Plus_30px_1.png")));
    }//GEN-LAST:event_jLabel_TPN_ThemNCCMouseExited

    private void jLabel_TPN_ThemNCCMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_TPN_ThemNCCMousePressed
        // TODO add your handling code here:
        ThemNCC ncc = new ThemNCC(this, true);
        ncc.setVisible(true);
    }//GEN-LAST:event_jLabel_TPN_ThemNCCMousePressed

    private void jLabel_TPN_XoaNCCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_TPN_XoaNCCMouseEntered
        // TODO add your handling code here:
        jLabel_TPN_XoaNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Minus_30px_1.png")));
    }//GEN-LAST:event_jLabel_TPN_XoaNCCMouseEntered

    private void jLabel_TPN_XoaNCCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_TPN_XoaNCCMouseExited
        // TODO add your handling code here:
        jLabel_TPN_XoaNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Minus_30px.png")));
    }//GEN-LAST:event_jLabel_TPN_XoaNCCMouseExited

    private void jLabel_TPN_XoaNCCMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_TPN_XoaNCCMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_TPN_XoaNCCMousePressed

    private void jButton_SoanTinNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SoanTinNhanActionPerformed
        // TODO add your handling code here:
        ThuAdmin tAdmin = new ThuAdmin(this, true);
        tAdmin.setVisible(true);
    }//GEN-LAST:event_jButton_SoanTinNhanActionPerformed

    private void jButton_CapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CapNhatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_CapNhatActionPerformed

    private void jTextField8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField8MouseClicked
        // TODO add your handling code here:
        disCard();
        CardDSSP.show();
    }//GEN-LAST:event_jTextField8MouseClicked

    private void jComboBox_NCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_NCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_NCCActionPerformed

    private void jLabel_ThemNHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_ThemNHMouseClicked
        // TODO add your handling code here:
        ThemNhomHang tnh = new ThemNhomHang(this, true);
        tnh.setVisible(true);
    }//GEN-LAST:event_jLabel_ThemNHMouseClicked

    private void jLabel_ThemNSXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_ThemNSXMouseClicked
        // TODO add your handling code here:
        ThemNSX nsx = new ThemNSX(this, true);
        nsx.setVisible(true);
    }//GEN-LAST:event_jLabel_ThemNSXMouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        try {
            if (jLabelImage1.getIcon() == null) {
                String a = hh.copyFile().getPath();
                b1 = a.substring(a.lastIndexOf("\\") + 1, a.length());
                String b = System.getProperty("user.dir") + "\\src\\img\\" + jTextFieldMaHH.getText() + "1" + a.substring(a.lastIndexOf("."), a.length());
                a1 = b;
                FileInputStream fis = new FileInputStream(a);
                FileOutputStream fos = new FileOutputStream(b);
                int i;
                while ((i = fis.read()) != -1) {
                    fos.write(i);
                }
                BufferedImage image = ImageIO.read(new File(b));
                ImageIcon icon = new ImageIcon(image.getScaledInstance(jLabelImage1.getSize().width, jLabelImage1.getSize().height, image.SCALE_SMOOTH));
                jLabelImage1.setIcon(icon);
            } else if (jLabelImage1.getIcon() != null && jLabelImage2.getIcon() == null) {
                String a = hh.copyFile().getPath();
                b2 = a.substring(a.lastIndexOf("\\") + 1, a.length());
                String b = System.getProperty("user.dir") + "\\src\\img\\" + jTextFieldMaHH.getText() + "2" + a.substring(a.lastIndexOf("."), a.length());
                a2 = b;
                FileInputStream fis = new FileInputStream(a);
                FileOutputStream fos = new FileOutputStream(b);
                int i;
                while ((i = fis.read()) != -1) {
                    fos.write(i);
                }
                BufferedImage image = ImageIO.read(new File(b));
                ImageIcon icon = new ImageIcon(image.getScaledInstance(jLabelImage2.getSize().width, jLabelImage2.getSize().height, image.SCALE_SMOOTH));
                jLabelImage2.setIcon(icon);
            } else if (jLabelImage2.getIcon() != null && jLabelImage3.getIcon() == null) {
                String a = hh.copyFile().getPath();
                b3 = a.substring(a.lastIndexOf("\\") + 1, a.length());
                String b = System.getProperty("user.dir") + "\\src\\img\\" + jTextFieldMaHH.getText() + "3" + a.substring(a.lastIndexOf("."), a.length());
                a3 = b;
                FileInputStream fis = new FileInputStream(a);
                FileOutputStream fos = new FileOutputStream(b);
                int i;
                while ((i = fis.read()) != -1) {
                    fos.write(i);
                }
                BufferedImage image = ImageIO.read(new File(b));
                ImageIcon icon = new ImageIcon(image.getScaledInstance(jLabelImage3.getSize().width, jLabelImage3.getSize().height, image.SCALE_SMOOTH));
                jLabelImage3.setIcon(icon);
            } else if (jLabelImage3.getIcon() != null && jLabelImage4.getIcon() == null) {
                String a = hh.copyFile().getPath();
                b4 = a.substring(a.lastIndexOf("\\") + 1, a.length());
                String b = System.getProperty("user.dir") + "\\src\\img\\" + jTextFieldMaHH.getText() + "4" + a.substring(a.lastIndexOf("."), a.length());
                a4 = b;
                FileInputStream fis = new FileInputStream(a);
                FileOutputStream fos = new FileOutputStream(b);
                int i;
                while ((i = fis.read()) != -1) {
                    fos.write(i);
                }
                BufferedImage image = ImageIO.read(new File(b));
                ImageIcon icon = new ImageIcon(image.getScaledInstance(jLabelImage4.getSize().width, jLabelImage4.getSize().height, image.SCALE_SMOOTH));
                jLabelImage4.setIcon(icon);
            } else if (jLabelImage4.getIcon() != null && jLabelImage5.getIcon() == null) {
                String a = hh.copyFile().getPath();
                b5 = a.substring(a.lastIndexOf("\\") + 1, a.length());
                String b = System.getProperty("user.dir") + "\\src\\img\\" + jTextFieldMaHH.getText() + "5" + a.substring(a.lastIndexOf("."), a.length());
                a5 = b;
                FileInputStream fis = new FileInputStream(a);
                FileOutputStream fos = new FileOutputStream(b);
                int i;
                while ((i = fis.read()) != -1) {
                    fos.write(i);
                }
                BufferedImage image = ImageIO.read(new File(b));
                ImageIcon icon = new ImageIcon(image.getScaledInstance(jLabelImage5.getSize().width, jLabelImage5.getSize().height, image.SCALE_SMOOTH));
                jLabelImage5.setIcon(icon);
            }
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jMenuItem_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_SuaActionPerformed
        // TODO add your handling code here:
        disCard();
        reset();
        CardTaoSanPham.show();
        jTextFieldMaHH.setEnabled(false);
        jButton9.setVisible(true);
        jButton5.hide();
        jTextFieldMaHH.setText((String) jTable_SanPham.getValueAt(jTable_SanPham.getSelectedRow(), 0));
        jTextFieldTenHH.setText((String) jTable_SanPham.getValueAt(jTable_SanPham.getSelectedRow(), 1));
        jTextFieldGiaVon.setText((String) jTable_SanPham.getValueAt(jTable_SanPham.getSelectedRow(), 2));
        jTextFieldGiaBan.setText((String) jTable_SanPham.getValueAt(jTable_SanPham.getSelectedRow(), 3));
        jFormattedThue.setText((String) jTable_SanPham.getValueAt(jTable_SanPham.getSelectedRow(), 4));
        jTextArea2.setText((String) jTable_SanPham.getValueAt(jTable_SanPham.getSelectedRow(), 5));
        jComboBoxNhaSX.setSelectedItem((String) jTable_SanPham.getValueAt(jTable_SanPham.getSelectedRow(), 6));
        jComboBoxNhomHang.setSelectedItem((String) jTable_SanPham.getValueAt(jTable_SanPham.getSelectedRow(), 7));
        a1 = System.getProperty("user.dir") + "\\src\\img\\" + hh.getImg(jTextFieldMaHH.getText()).get(0);
        a2 = System.getProperty("user.dir") + "\\src\\img\\" + hh.getImg(jTextFieldMaHH.getText()).get(1);
        a3 = System.getProperty("user.dir") + "\\src\\img\\" + hh.getImg(jTextFieldMaHH.getText()).get(2);
        a4 = System.getProperty("user.dir") + "\\src\\img\\" + hh.getImg(jTextFieldMaHH.getText()).get(3);
        a5 = System.getProperty("user.dir") + "\\src\\img\\" + hh.getImg(jTextFieldMaHH.getText()).get(4);
        try {
            BufferedImage image, image2, image3, image4, image5;
            ImageIcon icon, icon2, icon3, icon4, icon5;
            image = ImageIO.read(new File(a1));
            icon = new ImageIcon(image.getScaledInstance(jLabelImage1.getSize().width, jLabelImage1.getSize().height, image.SCALE_SMOOTH));
            jLabelImage1.setIcon(icon);
            image2 = ImageIO.read(new File(a2));
            icon2 = new ImageIcon(image2.getScaledInstance(jLabelImage2.getSize().width, jLabelImage2.getSize().height, image2.SCALE_SMOOTH));
            jLabelImage2.setIcon(icon2);
            image3 = ImageIO.read(new File(a3));
            icon3 = new ImageIcon(image3.getScaledInstance(jLabelImage3.getSize().width, jLabelImage3.getSize().height, image3.SCALE_SMOOTH));
            jLabelImage3.setIcon(icon3);
            image4 = ImageIO.read(new File(a4));
            icon4 = new ImageIcon(image4.getScaledInstance(jLabelImage4.getSize().width, jLabelImage4.getSize().height, image4.SCALE_SMOOTH));
            jLabelImage4.setIcon(icon4);
            image5 = ImageIO.read(new File(a5));
            icon5 = new ImageIcon(image5.getScaledInstance(jLabelImage5.getSize().width, jLabelImage5.getSize().height, image5.SCALE_SMOOTH));
            jLabelImage5.setIcon(icon5);
            jTextFieldMaHH.setEnabled(false);
        } catch (IOException ex) {
        }
    }//GEN-LAST:event_jMenuItem_SuaActionPerformed

    private void jMenuItem_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_XoaActionPerformed
        // TODO add your handling code here:
        hh.deleteHH(jTable_SanPham.getValueAt(jTable_SanPham.getSelectedRow(), 0).toString());
        modelTable1.removeRow(jTable_SanPham.getSelectedRow());
    }//GEN-LAST:event_jMenuItem_XoaActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        String a = jFormattedThue.getText().replace(",", ".");
        try {
            if (jTextFieldMaHH.getText().equals("") || jTextFieldTenHH.getText().equals("") || jTextFieldGiaVon.getText().equals("") || jTextFieldGiaBan.getText().equals("")
                    || jFormattedThue.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
            } else {
                jButton9.hide();
                jButton5.show();
                modelHangHoa mhh = new modelHangHoa();
                mhh.setMaHH(jTextFieldMaHH.getText());
                mhh.setTenHH(jTextFieldTenHH.getText());
                mhh.setGiaVon(Integer.parseInt(jTextFieldGiaVon.getText()));
                mhh.setGiaBan(Integer.parseInt(jTextFieldGiaBan.getText()));
                mhh.setNhomHang(jComboBoxNhomHang.getSelectedItem().toString().substring(0, jComboBoxNhomHang.getSelectedItem().toString().indexOf("(")).trim());
                mhh.setNhaSX(jComboBoxNhaSX.getSelectedItem().toString().substring(0, jComboBoxNhaSX.getSelectedItem().toString().indexOf("(")).trim());
                mhh.setThueVAT(Double.parseDouble(a));
                mhh.setMoTa(jTextArea2.getText());
                if (jLabelImage5.getIcon() != null) {
                    mhh.setImg1(jTextFieldMaHH.getText() + "1" + a1.substring(a1.lastIndexOf(".")));
                    mhh.setImg2(jTextFieldMaHH.getText() + "2" + a1.substring(a1.lastIndexOf(".")));
                    mhh.setImg3(jTextFieldMaHH.getText() + "3" + a1.substring(a1.lastIndexOf(".")));
                    mhh.setImg4(jTextFieldMaHH.getText() + "4" + a1.substring(a1.lastIndexOf(".")));
                    mhh.setImg5(jTextFieldMaHH.getText() + "5" + a1.substring(a1.lastIndexOf(".")));
                } else if (jLabelImage4.getIcon() != null) {
                    mhh.setImg1(jTextFieldMaHH.getText() + "1" + a1.substring(a1.lastIndexOf(".")));
                    mhh.setImg2(jTextFieldMaHH.getText() + "2" + a1.substring(a1.lastIndexOf(".")));
                    mhh.setImg3(jTextFieldMaHH.getText() + "3" + a1.substring(a1.lastIndexOf(".")));
                    mhh.setImg4(jTextFieldMaHH.getText() + "4" + a1.substring(a1.lastIndexOf(".")));
                } else if (jLabelImage3.getIcon() != null) {
                    mhh.setImg1(jTextFieldMaHH.getText() + "1" + a1.substring(a1.lastIndexOf(".")));
                    mhh.setImg2(jTextFieldMaHH.getText() + "2" + a1.substring(a1.lastIndexOf(".")));
                    mhh.setImg3(jTextFieldMaHH.getText() + "3" + a1.substring(a1.lastIndexOf(".")));
                } else if (jLabelImage2.getIcon() != null) {
                    mhh.setImg1(jTextFieldMaHH.getText() + "1" + a1.substring(a1.lastIndexOf(".")));
                    mhh.setImg2(jTextFieldMaHH.getText() + "2" + a1.substring(a1.lastIndexOf(".")));
                } else if (jLabelImage1.getIcon() != null) {
                    mhh.setImg1(jTextFieldMaHH.getText() + "1" + a1.substring(a1.lastIndexOf(".")));
                } else {
                }
                if (hh.insertHangHoa(mhh) != 0) {
                    String Nrow[] = new String[13];
                    Nrow[0] = mhh.getMaHH();
                    Nrow[1] = mhh.getTenHH();
                    Nrow[2] = mhh.getGiaVon() + "";
                    Nrow[3] = mhh.getGiaBan() + "";
                    Nrow[4] = mhh.getThueVAT() + "";
                    Nrow[5] = mhh.getMoTa();
                    Nrow[6] = mhh.getNhaSX();
                    Nrow[7] = mhh.getNhomHang();
                    modelTable1.addRow(Nrow);
                    String tam = jTextFieldMaHH.getText().trim();
                    reset();
                    for (int i = 1; i <= 5; i++) {
                        File file = new File(a1.substring(0, a1.lastIndexOf(".") - 1) + i + a1.substring(a1.lastIndexOf(".")));
                        File newFile = new File(a1.substring(0, a1.lastIndexOf(".") - 1) + tam + i + a1.substring(a1.lastIndexOf(".")));
                        System.out.println(a1.substring(0, a1.lastIndexOf(".") - 1) + i + a1.substring(a1.lastIndexOf(".")));
                        System.out.println(a1.substring(0, a1.lastIndexOf(".") - 1) + tam + i + a1.substring(a1.lastIndexOf(".")));
                        if (file.renameTo(newFile)) {
                            System.out.println("1");
                        } else {
                            System.out.println("2");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
        // TODO add your handling code here:
        modelTable1.setRowCount(0);
        for (int i = 0; i < hh.findByID(jTextField5.getText()).size(); i++) {
            data1.add(hh.findByID(jTextField5.getText()).get(i));
        }
        modelTable1.fireTableDataChanged();
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jLabel_XoaNHMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_XoaNHMousePressed
        // TODO add your handling code here:
        String a;
        int vt;
        vt = jComboBoxNhomHang.getSelectedItem().toString().indexOf("(") - 1;
        a = jComboBoxNhomHang.getSelectedItem().toString().substring(0, vt);
        if (hh.deleteNH(a) != 0) {
            jComboBoxNhomHang.removeItem(jComboBoxNhomHang.getSelectedItem().toString());
        }
    }//GEN-LAST:event_jLabel_XoaNHMousePressed

    private void jLabel_XoaNSXMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_XoaNSXMousePressed
        // TODO add your handling code here:
        String a;
        int vt;
        vt = jComboBoxNhaSX.getSelectedItem().toString().indexOf("(") - 1;
        a = jComboBoxNhaSX.getSelectedItem().toString().substring(0, vt);
        if (hh.deleteNSX(a) != 0) {
            jComboBoxNhaSX.removeItem(jComboBoxNhaSX.getSelectedItem().toString());
        }
    }//GEN-LAST:event_jLabel_XoaNSXMousePressed

    private void jButton_NhapHang_huy2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_NhapHang_huy2ActionPerformed
        // TODO add your handling code here:
        disCard();
        CardTaoPhieuNhap.show();
    }//GEN-LAST:event_jButton_NhapHang_huy2ActionPerformed

    private void jButton_NhapHang_LamMoi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_NhapHang_LamMoi2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_NhapHang_LamMoi2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BG;
    private javax.swing.JPanel CardDSSP;
    private javax.swing.JPanel CardKhachHang;
    private javax.swing.JPanel CardNhapKho;
    private javax.swing.JPanel CardSanPham;
    private javax.swing.JPanel CardTaoPhieuNhap;
    private javax.swing.JPanel CardTaoSanPham;
    private javax.swing.JPanel CardTinNhan;
    private javax.swing.JPanel CardTongQuan;
    private javax.swing.JPanel DangXuat;
    private javax.swing.JPanel Function;
    private javax.swing.JPanel HangHoa;
    private javax.swing.JPanel HienThi;
    private javax.swing.JPanel JPanel_Title_NhapKho;
    private javax.swing.JPanel JPanel_Title_NhapKho1;
    private javax.swing.JPanel JPanel_Title_TaoNhapKho;
    private javax.swing.JPanel JPanel_Title_TaoNhapKho1;
    private javax.swing.JPanel JPanel_Title_TaoNhapKho2;
    private javax.swing.JPanel KhachHang;
    private javax.swing.JPanel Mail;
    private javax.swing.JPanel Menu;
    private javax.swing.JLabel Minimize;
    private javax.swing.JPanel NhapKho;
    private javax.swing.JPanel TongQuan;
    private javax.swing.JLabel X;
    private javax.swing.JLabel iconDangXuat;
    private javax.swing.JLabel iconKhachHang;
    private javax.swing.JLabel iconNhapKho;
    private javax.swing.JLabel iconSanPham;
    private javax.swing.JLabel iconTinNhan;
    private javax.swing.JLabel iconTongQuan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButton_CapNhat;
    private javax.swing.JButton jButton_NhapHang_LamMoi;
    private javax.swing.JButton jButton_NhapHang_LamMoi1;
    private javax.swing.JButton jButton_NhapHang_LamMoi2;
    private javax.swing.JButton jButton_NhapHang_XacNhan;
    private javax.swing.JButton jButton_NhapHang_huy;
    private javax.swing.JButton jButton_NhapHang_huy1;
    private javax.swing.JButton jButton_NhapHang_huy2;
    private javax.swing.JButton jButton_SoanTinNhan;
    private javax.swing.JButton jButton_TaoPhieuNhap;
    private javax.swing.JButton jButton_ThemSP;
    private javax.swing.JButton jButton_XuatExcel;
    private javax.swing.JButton jButton_XuatExcelSP;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBoxNhaSX;
    private javax.swing.JComboBox<String> jComboBoxNhomHang;
    private javax.swing.JComboBox<String> jComboBox_NCC;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JFormattedTextField jFormattedThue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabelImage1;
    private javax.swing.JLabel jLabelImage2;
    private javax.swing.JLabel jLabelImage3;
    private javax.swing.JLabel jLabelImage4;
    private javax.swing.JLabel jLabelImage5;
    private javax.swing.JLabel jLabel_Filter_Space;
    private javax.swing.JLabel jLabel_Filter_Space1;
    private javax.swing.JLabel jLabel_Standard;
    private javax.swing.JLabel jLabel_TPN_DonGia;
    private javax.swing.JLabel jLabel_TPN_ThemNCC;
    private javax.swing.JLabel jLabel_TPN_TongGia;
    private javax.swing.JLabel jLabel_TPN_XoaNCC;
    private javax.swing.JLabel jLabel_TenNguoiDung;
    private javax.swing.JLabel jLabel_ThemNH;
    private javax.swing.JLabel jLabel_ThemNSX;
    private javax.swing.JLabel jLabel_TitleNhapKho;
    private javax.swing.JLabel jLabel_TitleTinNhan;
    private javax.swing.JLabel jLabel_Title_DSSP;
    private javax.swing.JLabel jLabel_Title_TSP;
    private javax.swing.JLabel jLabel_XoaNH;
    private javax.swing.JLabel jLabel_XoaNSX;
    private javax.swing.JLabel jLabel_slKH;
    private javax.swing.JLabel jLabel_vip;
    private javax.swing.JMenuItem jMenuItem_Sua;
    private javax.swing.JMenuItem jMenuItem_Xoa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel_Filter;
    private javax.swing.JPanel jPanel_Filter1;
    private javax.swing.JPanel jPanel_Filter_Left;
    private javax.swing.JPanel jPanel_Filter_Left1;
    private javax.swing.JPanel jPanel_Info_NhapKho;
    private javax.swing.JPanel jPanel_Info_SanPham;
    private javax.swing.JPanel jPanel_ShowKH;
    private javax.swing.JPanel jPanel_Show_Info;
    private javax.swing.JPanel jPanel_Show_Info1;
    private javax.swing.JPanel jPanel_Show_NhapKho;
    private javax.swing.JPanel jPanel_Show_NhapKho1;
    private javax.swing.JPanel jPanel_Title_SanPham;
    private javax.swing.JPanel jPanel_Under_Info;
    private javax.swing.JPanel jPanel_Under_Info1;
    private javax.swing.JPopupMenu jPopupMenu_SanPham;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable_HH;
    private javax.swing.JTable jTable_HangHoa;
    private javax.swing.JTable jTable_HopThuDen;
    private javax.swing.JTable jTable_HopThuDi;
    private javax.swing.JTable jTable_PhieuNhapKho;
    private javax.swing.JTable jTable_QLKH;
    private javax.swing.JTable jTable_SanPham;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JFormattedTextField jTextFieldGiaBan;
    private javax.swing.JFormattedTextField jTextFieldGiaVon;
    private javax.swing.JTextField jTextFieldMaHH;
    private javax.swing.JTextField jTextFieldTenHH;
    // End of variables declaration//GEN-END:variables
}
