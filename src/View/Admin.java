/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
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
    Vector head, data, head1, data1, head2, data2;
    DefaultTableModel modelTable, modelTable1, modelTable2;
    String tenND;

    public Admin() {
        initComponents();
        currenColor = 1;
        changeTable();
    }

    public Admin(String tenND) {
        initComponents();
        currenColor = 1;
        changeTable();
        this.tenND = tenND;
        jLabel_TenNguoiDung.setText(tenND);
    }

    public void changeTable() {
        head = new Vector();
        data = new Vector();
        head1 = new Vector();
        data1 = new Vector();
        head2 = new Vector();
        data2 = new Vector();
        head.add("Mã hóa đơn");
        head.add("Ngày nhập");
        head.add("Nhà cung cấp");
        head.add("Số lượng");
        head.add("Tổng tiền");
        head.add("Nợ");
        head.add("");
        head1.add("Mã sản phẩm");
        head1.add("Tên sản phẩm");
        head1.add("Số lượng");
        head1.add("Giá nhập");
        head1.add("Giá xuất");
        head1.add("Loại sản phẩm");
        head2.add("Tên khách hàng");
        head2.add("Số điện thoại");
        head2.add("Địa chỉ");
        head2.add("Email");
        head2.add("Loại khách hàng");
        modelTable = new DefaultTableModel(data, head);
        modelTable1 = new DefaultTableModel(data1, head1);
        modelTable2 = new DefaultTableModel(data2, head2);
        jTable_PhieuNhapKho.setModel(modelTable);
        jTable_PhieuNhapKho.setDefaultEditor(Object.class, null);
        jTable_SanPham.setModel(modelTable1);
        jTable_SanPham.setDefaultEditor(Object.class, null);
        jTable_QLKH.setModel(modelTable2);
        jTable_QLKH.setDefaultEditor(Object.class, null);
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        jScrollPane4.getViewport().setBackground(Color.WHITE);
        jScrollPane6.getViewport().setBackground(Color.WHITE);
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(65, 127, 194));
        headerRenderer.setBorder(new LineBorder(Color.black, 1));
        headerRenderer.setForeground(Color.WHITE);
        for (int i = 0; i < jTable_PhieuNhapKho.getModel().getColumnCount(); i++) {
            jTable_PhieuNhapKho.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        for (int i = 0; i < jTable_SanPham.getModel().getColumnCount(); i++) {
            jTable_SanPham.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        for (int i = 0; i < jTable_QLKH.getModel().getColumnCount(); i++) {
            jTable_QLKH.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
//        Color color = UIManager.getColor("Table.gridColor");
//        MatteBorder border = new MatteBorder(5, 5, 0, 0, Color.blue);
//        jTable_PhieuNhapKho.setBorder(border);
    }

    public void disCard() {
        CardTongQuan.hide();
        CardNhapKho.hide();
        CardTaoPhieuNhap.hide();
        CardSanPham.hide();
        CardTaoSanPham.hide();
        CardKhachHang.hide();
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
        iconSuKien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Event_32px_1.png")));
        iconSuKien.setForeground(Color.BLACK);
        SuKien.setBackground(new Color(244, 244, 244));
        iconSuKien.setFont(new java.awt.Font("Tahoma", 0, 18));
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
        SuKien = new javax.swing.JPanel();
        iconSuKien = new javax.swing.JLabel();
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
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_HangHoa = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
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
        jLabel32 = new javax.swing.JLabel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jLabel33 = new javax.swing.JLabel();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
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
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable_QLKH = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
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
        Menu.setLayout(new java.awt.GridLayout(7, 0));

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
        iconTinNhan.setText("Tin nhắn chờ");

        javax.swing.GroupLayout MailLayout = new javax.swing.GroupLayout(Mail);
        Mail.setLayout(MailLayout);
        MailLayout.setHorizontalGroup(
            MailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 178, Short.MAX_VALUE)
            .addGroup(MailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MailLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(iconTinNhan)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        MailLayout.setVerticalGroup(
            MailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 104, Short.MAX_VALUE)
            .addGroup(MailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MailLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(iconTinNhan)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        Menu.add(Mail);

        SuKien.setBackground(new java.awt.Color(244, 244, 244));
        SuKien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SuKienMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SuKienMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SuKienMousePressed(evt);
            }
        });

        iconSuKien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        iconSuKien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Event_32px_1.png"))); // NOI18N
        iconSuKien.setText("Sự kiện");

        javax.swing.GroupLayout SuKienLayout = new javax.swing.GroupLayout(SuKien);
        SuKien.setLayout(SuKienLayout);
        SuKienLayout.setHorizontalGroup(
            SuKienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 178, Short.MAX_VALUE)
            .addGroup(SuKienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(SuKienLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(iconSuKien)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        SuKienLayout.setVerticalGroup(
            SuKienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 104, Short.MAX_VALUE)
            .addGroup(SuKienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(SuKienLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(iconSuKien)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        Menu.add(SuKien);

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
            .addGap(0, 1399, Short.MAX_VALUE)
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
        jLabel16.setText("Tạo phiếu nhập");
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
        jButton_NhapHang_huy.setText("Huỷ");
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
        jPanel1.setLayout(new java.awt.GridLayout(2, 1));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 905, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 326, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new java.awt.GridLayout(1, 0));

        jTable_HangHoa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
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
        jPanel6Layout.columnWidths = new int[] {0, 5, 0, 5, 0};
        jPanel6Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0};
        jPanel6.setLayout(jPanel6Layout);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Mã hoá đơn");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel6.add(jLabel17, gridBagConstraints);

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
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

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 190;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel6.add(jTextField3, gridBagConstraints);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("Ngày nhập");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel6.add(jLabel19, gridBagConstraints);

        jDateChooser3.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooser3.setDateFormatString("dd-MM-yyyy");
        jDateChooser3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 140;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel6.add(jDateChooser3, gridBagConstraints);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("Ghi Chú");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel6.add(jLabel20, gridBagConstraints);

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Plus_2_Math_18px.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        jPanel6.add(jLabel21, gridBagConstraints);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel6.add(jScrollPane3, gridBagConstraints);

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
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 140;
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

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel32.setText("Từ ngày: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(30, 50, 0, 0);
        jPanel4.add(jLabel32, gridBagConstraints);

        jDateChooser4.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooser4.setDateFormatString("dd-MM-yyyy");
        jDateChooser4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 0, 0);
        jPanel4.add(jDateChooser4, gridBagConstraints);

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel33.setText("đến ngày");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 0, 0);
        jPanel4.add(jLabel33, gridBagConstraints);

        jDateChooser5.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooser5.setDateFormatString("dd-MM-yyyy");
        jDateChooser5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 0, 10);
        jPanel4.add(jDateChooser5, gridBagConstraints);

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
        jTable_SanPham.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTable_SanPham);

        jPanel_Info_SanPham.add(jScrollPane4);

        jPanel_Show_Info1.add(jPanel_Info_SanPham, java.awt.BorderLayout.CENTER);

        jPanel_Show_NhapKho1.add(jPanel_Show_Info1, java.awt.BorderLayout.CENTER);

        CardSanPham.add(jPanel_Show_NhapKho1, java.awt.BorderLayout.CENTER);

        HienThi.add(CardSanPham, "card5");

        javax.swing.GroupLayout CardTaoSanPhamLayout = new javax.swing.GroupLayout(CardTaoSanPham);
        CardTaoSanPham.setLayout(CardTaoSanPhamLayout);
        CardTaoSanPhamLayout.setHorizontalGroup(
            CardTaoSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1399, Short.MAX_VALUE)
        );
        CardTaoSanPhamLayout.setVerticalGroup(
            CardTaoSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 733, Short.MAX_VALUE)
        );

        HienThi.add(CardTaoSanPham, "card6");

        CardKhachHang.setBackground(new java.awt.Color(255, 255, 255));
        CardKhachHang.setLayout(new java.awt.BorderLayout(0, 20));

        JPanel_Title_TaoNhapKho1.setBackground(new java.awt.Color(255, 255, 255));
        JPanel_Title_TaoNhapKho1.setLayout(new java.awt.GridBagLayout());

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(0, 102, 255));
        jLabel79.setText("Quản lý khách hàng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        JPanel_Title_TaoNhapKho1.add(jLabel79, gridBagConstraints);

        jButton_NhapHang_huy1.setBackground(new java.awt.Color(172, 172, 172));
        jButton_NhapHang_huy1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_NhapHang_huy1.setForeground(new java.awt.Color(255, 255, 255));
        jButton_NhapHang_huy1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Back_18px.png"))); // NOI18N
        jButton_NhapHang_huy1.setText("Quay lại");
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

        jButton_NhapHang_LamMoi1.setBackground(new java.awt.Color(71, 184, 107));
        jButton_NhapHang_LamMoi1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_NhapHang_LamMoi1.setForeground(new java.awt.Color(255, 255, 255));
        jButton_NhapHang_LamMoi1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Refresh_18px.png"))); // NOI18N
        jButton_NhapHang_LamMoi1.setText("Làm Mới");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 10;
        JPanel_Title_TaoNhapKho1.add(jButton_NhapHang_LamMoi1, gridBagConstraints);

        CardKhachHang.add(JPanel_Title_TaoNhapKho1, java.awt.BorderLayout.PAGE_START);

        jPanel_ShowKH.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_ShowKH.setLayout(new java.awt.BorderLayout());

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setLayout(new javax.swing.BoxLayout(jPanel27, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel29.setLayout(new java.awt.GridBagLayout());

        jButton3.setText("Sửa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 20, 50);
        jPanel29.add(jButton3, gridBagConstraints);

        jButton4.setText("Xóa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(20, 50, 20, 0);
        jPanel29.add(jButton4, gridBagConstraints);

        jPanel27.add(jPanel29);

        jPanel30.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Tổng khách hàng:");
        jPanel30.add(jLabel1, new java.awt.GridBagConstraints());

        jLabel_slKH.setText("0");
        jLabel_slKH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel30.add(jLabel_slKH, new java.awt.GridBagConstraints());

        jLabel3.setText("-");
        jPanel30.add(jLabel3, new java.awt.GridBagConstraints());

        jLabel80.setText("jLabel1");
        jPanel30.add(jLabel80, new java.awt.GridBagConstraints());

        jLabel81.setText("jLabel1");
        jPanel30.add(jLabel81, new java.awt.GridBagConstraints());

        jLabel82.setText("jLabel1");
        jPanel30.add(jLabel82, new java.awt.GridBagConstraints());

        jPanel27.add(jPanel30);

        jPanel_ShowKH.add(jPanel27, java.awt.BorderLayout.PAGE_END);

        jPanel28.setLayout(new javax.swing.BoxLayout(jPanel28, javax.swing.BoxLayout.LINE_AXIS));

        jTable_QLKH.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jScrollPane6.setViewportView(jTable_QLKH);

        jPanel28.add(jScrollPane6);

        jPanel_ShowKH.add(jPanel28, java.awt.BorderLayout.CENTER);

        CardKhachHang.add(jPanel_ShowKH, java.awt.BorderLayout.CENTER);

        HienThi.add(CardKhachHang, "card7");

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
        // TODO add your handling code here:
        currenColor = 2;
        disCard();
        CardTaoPhieuNhap.show();
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

    private void SuKienMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SuKienMouseEntered
        // TODO add your handling code here:
        iconSuKien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Event_32px.png")));
        SuKien.setBackground(Color.WHITE);
        iconSuKien.setForeground(new Color(100, 149, 237));
        iconSuKien.setFont(new java.awt.Font("Tahoma", 1, 18));
    }//GEN-LAST:event_SuKienMouseEntered

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

    private void SuKienMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SuKienMouseExited
        // TODO add your handling code here:
        if (currenColor != 6) {
            iconSuKien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Event_32px_1.png")));
            iconSuKien.setForeground(Color.BLACK);
            SuKien.setBackground(new Color(244, 244, 244));
            iconSuKien.setFont(new java.awt.Font("Tahoma", 0, 18));
        }
    }//GEN-LAST:event_SuKienMouseExited

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
        CardKhachHang.show();
        disSubMenu();
        iconTinNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Mail_32px_3.png")));
        Mail.setBackground(Color.WHITE);
        iconTinNhan.setForeground(new Color(100, 149, 237));
        iconTinNhan.setFont(new java.awt.Font("Tahoma", 1, 18));
    }//GEN-LAST:event_MailMousePressed

    private void SuKienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SuKienMousePressed
        // TODO add your handling code here:
        currenColor = 6;
        disCard();
        CardSanPham.show();
        disSubMenu();
        iconSuKien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Event_32px.png")));
        SuKien.setBackground(Color.WHITE);
        iconSuKien.setForeground(new Color(100, 149, 237));
        iconSuKien.setFont(new java.awt.Font("Tahoma", 1, 18));
    }//GEN-LAST:event_SuKienMousePressed

    private void jButton_NhapHang_huy1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_NhapHang_huy1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_NhapHang_huy1ActionPerformed

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
    private javax.swing.JPanel CardKhachHang;
    private javax.swing.JPanel CardNhapKho;
    private javax.swing.JPanel CardSanPham;
    private javax.swing.JPanel CardTaoPhieuNhap;
    private javax.swing.JPanel CardTaoSanPham;
    private javax.swing.JPanel CardTongQuan;
    private javax.swing.JPanel DangXuat;
    private javax.swing.JPanel Function;
    private javax.swing.JPanel HangHoa;
    private javax.swing.JPanel HienThi;
    private javax.swing.JPanel JPanel_Title_NhapKho;
    private javax.swing.JPanel JPanel_Title_TaoNhapKho;
    private javax.swing.JPanel JPanel_Title_TaoNhapKho1;
    private javax.swing.JPanel KhachHang;
    private javax.swing.JPanel Mail;
    private javax.swing.JPanel Menu;
    private javax.swing.JLabel Minimize;
    private javax.swing.JPanel NhapKho;
    private javax.swing.JPanel SuKien;
    private javax.swing.JPanel TongQuan;
    private javax.swing.JLabel X;
    private javax.swing.JLabel iconDangXuat;
    private javax.swing.JLabel iconKhachHang;
    private javax.swing.JLabel iconNhapKho;
    private javax.swing.JLabel iconSanPham;
    private javax.swing.JLabel iconSuKien;
    private javax.swing.JLabel iconTinNhan;
    private javax.swing.JLabel iconTongQuan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton_NhapHang_LamMoi;
    private javax.swing.JButton jButton_NhapHang_LamMoi1;
    private javax.swing.JButton jButton_NhapHang_XacNhan;
    private javax.swing.JButton jButton_NhapHang_huy;
    private javax.swing.JButton jButton_NhapHang_huy1;
    private javax.swing.JButton jButton_TaoPhieuNhap;
    private javax.swing.JButton jButton_ThemSP;
    private javax.swing.JButton jButton_XuatExcel;
    private javax.swing.JButton jButton_XuatExcelSP;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private com.toedter.calendar.JDateChooser jDateChooser5;
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
    private javax.swing.JLabel jLabel33;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_Filter_Space;
    private javax.swing.JLabel jLabel_Filter_Space1;
    private javax.swing.JLabel jLabel_TenNguoiDung;
    private javax.swing.JLabel jLabel_TitleNhapKho;
    private javax.swing.JLabel jLabel_Title_DSSP;
    private javax.swing.JLabel jLabel_slKH;
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
    private javax.swing.JPanel jPanel4;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable_HangHoa;
    private javax.swing.JTable jTable_PhieuNhapKho;
    private javax.swing.JTable jTable_QLKH;
    private javax.swing.JTable jTable_SanPham;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
