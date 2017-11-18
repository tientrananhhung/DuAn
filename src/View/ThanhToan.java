/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.QLDSHang;
import Controller.TinNhanDAO;
import Model.Account;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Tien Tran
 */
public class ThanhToan extends javax.swing.JFrame {

    /**
     * Creates new form ThanhToan
     */
    Vector head, data, head1, data1, head2, data2;
    DefaultTableModel modelTable, modelTable1, modelTable2;
    QLDSHang DS;
    Account acc;
    JPopupMenu menu = new JPopupMenu();
    JTable jt;
    Vector a, n;
    TinNhanDAO tnDAO;
    int tong;

    public ThanhToan() {
        initComponents();
        popup();
        changeTable();
    }

    public ThanhToan(Account acc, Vector t) {
        initComponents();
        a = t;
        popup();
        changeTable();
        this.acc = acc;
        jButton_User.setText(acc.getTenNguoiDung());
        n = new Vector();
        tnDAO = new TinNhanDAO();
        jButton_Mail.setText("Thư đến " + tnDAO.demTNNV(acc.getTenTK()));
    }

    public void popup() {
        head2 = new Vector();
        data2 = new Vector();
        head2.add("Ngày gửi");
        head2.add("Nội dung");
        head2.add("Trạng thái");
        if (a.size() != 0) {
            for (int i = 0; i < a.size(); i++) {
                n = (Vector) a.get(i);
                System.out.println(n);
                Vector t = new Vector();
                t.add(n.get(2));
                t.add(n.get(1));
                t.add(n.get(3));
                data2.add(t);
            }
        } else {
        }
        jt = new JTable();
        jt.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(jt, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jt.setRowHeight(30);
        sp.setPreferredSize(new Dimension(800, 500));
        JScrollPane item1 = sp;
        JTableHeader header = jt.getTableHeader();
        header.setFont(new Font("Dialog", Font.BOLD, 24));
        jt.setFont(new Font("Serif", Font.PLAIN, 18));
        jt.getTableHeader().setReorderingAllowed(false);
        jt.getTableHeader().setResizingAllowed(false);
        sp.getViewport().setBackground(Color.WHITE);
        modelTable2 = new DefaultTableModel(data2, head2) {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        jt.setModel(modelTable2);
        menu.add(item1);
        jt.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    tong = 0;
                    tnDAO.seenNV(acc.getTenTK(), jt.getValueAt(jt.getSelectedRow(), 0).toString());
                    jt.setValueAt("Đã xem", jt.getSelectedRow(), 2);
                    ThuNhanVien tnv = new ThuNhanVien(null, true, 1, jt.getValueAt(jt.getSelectedRow(), 1).toString(), acc.getTenTK());
                    for (int i = 0; i < jt.getRowCount(); i++) {
                        if (jt.getValueAt(i, 2).equals("Chưa xem")) {
                            tong = tong + 1;
                        }
                    }
                    jButton_Mail.setText("Thư đến " + tong);
                    tnv.setVisible(true);
                }
            }
        });
    }

    public void changeTable() {
        DS = new QLDSHang();
        head = new Vector();
        data = new Vector();
        head1 = new Vector();
        data1 = new Vector();
        head.add("Mã hàng hoá");
        head.add("Tên mặt hàng");
        head.add("Giá bán");
        head.add("Số lượng");
        head1.add("Mã hàng hoá");
        head1.add("Tên mặt hàng");
        head1.add("Giá bán");
        head1.add("Số lượng");
        for (int i = 0; i < DS.getAllList().size(); i++) {
            data.add(DS.getAllList().get(i));
        }
        modelTable = new DefaultTableModel(data, head);
        modelTable1 = new DefaultTableModel(data1, head1);
        jTable_HangHoa.setModel(modelTable);
        jTable_ThanhToan.setModel(modelTable1);
        jTable_HangHoa.setRowHeight(30);
        jTable_ThanhToan.setRowHeight(30);
        jTable_HangHoa.setDefaultEditor(Object.class, null);
        jTable_ThanhToan.setDefaultEditor(Object.class, null);
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        jScrollPane2.getViewport().setBackground(Color.WHITE);
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(65, 127, 194));
        headerRenderer.setBorder(new LineBorder(Color.black, 1));
        headerRenderer.setForeground(Color.WHITE);
        for (int i = 0; i < jTable_HangHoa.getModel().getColumnCount(); i++) {
            jTable_HangHoa.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        for (int i = 0; i < jTable_ThanhToan.getModel().getColumnCount(); i++) {
            jTable_ThanhToan.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        for (int i = 0; i < jt.getModel().getColumnCount(); i++) {
            jt.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
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
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        Minimize1 = new javax.swing.JLabel();
        X1 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        ThanhToan = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton_User = new javax.swing.JButton();
        jButton_Mail = new javax.swing.JButton();
        jButton_Feedback = new javax.swing.JButton();
        jButton_Update = new javax.swing.JButton();
        jButton_Logout = new javax.swing.JButton();
        body = new javax.swing.JPanel();
        left = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_HangHoa = new javax.swing.JTable();
        right = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_ThanhToan = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);

        BG.setBackground(new java.awt.Color(255, 255, 255));

        jPanel18.setLayout(new javax.swing.BoxLayout(jPanel18, javax.swing.BoxLayout.LINE_AXIS));

        jPanel19.setBackground(new java.awt.Color(55, 126, 232));
        jPanel19.setForeground(new java.awt.Color(255, 255, 255));
        jPanel19.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 10));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Thanh Toán");
        jPanel19.add(jLabel12);

        jPanel18.add(jPanel19);

        jPanel20.setBackground(new java.awt.Color(55, 126, 232));
        jPanel20.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        Minimize1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Minus_32px_1.png"))); // NOI18N
        Minimize1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Minimize1MouseClicked(evt);
            }
        });
        jPanel20.add(Minimize1);

        X1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Delete_32px_1.png"))); // NOI18N
        X1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                X1MouseClicked(evt);
            }
        });
        jPanel20.add(X1);

        jPanel18.add(jPanel20);

        jPanel15.setLayout(new javax.swing.BoxLayout(jPanel15, javax.swing.BoxLayout.LINE_AXIS));
        jPanel15.add(jPanel16);
        jPanel15.add(jPanel17);

        ThanhToan.setBackground(new java.awt.Color(255, 255, 255));
        ThanhToan.setLayout(new java.awt.BorderLayout());

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.setLayout(new java.awt.GridLayout(1, 2));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Tìm kiếm");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        jPanel1.add(jLabel1, gridBagConstraints);

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 3.3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 30);
        jPanel1.add(jTextField1, gridBagConstraints);

        jButton1.setBackground(new java.awt.Color(65, 127, 194));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Search_32px.png"))); // NOI18N
        jButton1.setText("Tìm");
        jButton1.setToolTipText("Tìm kiếm theo mã hàng hoá");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 100);
        jPanel1.add(jButton1, gridBagConstraints);

        header.add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jButton_User.setBackground(new java.awt.Color(65, 127, 194));
        jButton_User.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_User.setForeground(new java.awt.Color(255, 255, 255));
        jButton_User.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_User_32px_1.png"))); // NOI18N
        jButton_User.setText("USER");
        jButton_User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UserActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 10;
        jPanel2.add(jButton_User, gridBagConstraints);

        jButton_Mail.setBackground(new java.awt.Color(65, 127, 194));
        jButton_Mail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_Mail.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Mail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Mail_32px.png"))); // NOI18N
        jButton_Mail.setText("Thư đến");
        jButton_Mail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_MailMouseClicked(evt);
            }
        });
        jButton_Mail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_MailActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 10;
        jPanel2.add(jButton_Mail, gridBagConstraints);

        jButton_Feedback.setBackground(new java.awt.Color(65, 127, 194));
        jButton_Feedback.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_Feedback.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Feedback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Feedback_32px.png"))); // NOI18N
        jButton_Feedback.setText("Phản hồi");
        jButton_Feedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_FeedbackActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 10;
        jPanel2.add(jButton_Feedback, gridBagConstraints);

        jButton_Update.setBackground(new java.awt.Color(65, 127, 194));
        jButton_Update.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_Update.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Update_32px.png"))); // NOI18N
        jButton_Update.setText("Cập nhật");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 10;
        jPanel2.add(jButton_Update, gridBagConstraints);

        jButton_Logout.setBackground(new java.awt.Color(242, 64, 64));
        jButton_Logout.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_Logout.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Logout_Rounded_Up_32px.png"))); // NOI18N
        jButton_Logout.setText("Đăng xuất");
        jButton_Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LogoutActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.1;
        jPanel2.add(jButton_Logout, gridBagConstraints);

        header.add(jPanel2);

        ThanhToan.add(header, java.awt.BorderLayout.PAGE_START);

        body.setLayout(new javax.swing.BoxLayout(body, javax.swing.BoxLayout.LINE_AXIS));

        left.setBackground(new java.awt.Color(255, 255, 255));
        left.setPreferredSize(new java.awt.Dimension(900, 692));
        left.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(55, 126, 232));
        jLabel2.setText("DANH SÁCH HÀNG HOÁ");
        jPanel3.add(jLabel2, new java.awt.GridBagConstraints());

        left.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(800, 659));
        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jTable_HangHoa.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTable_HangHoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable_HangHoa.getTableHeader().setResizingAllowed(false);
        jTable_HangHoa.getTableHeader().setReorderingAllowed(false);
        jTable_HangHoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_HangHoaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_HangHoa);

        jPanel4.add(jScrollPane2);

        left.add(jPanel4, java.awt.BorderLayout.CENTER);

        body.add(left);

        right.setBackground(new java.awt.Color(255, 0, 102));
        right.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel3.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(55, 126, 232));
        jLabel3.setText("THANH TOÁN");
        jPanel5.add(jLabel3, new java.awt.GridBagConstraints());

        right.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 3));
        jPanel7.add(jTextField2);

        jPanel6.add(jPanel7, java.awt.BorderLayout.PAGE_START);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new java.awt.GridLayout(1, 2));

        jButton6.setBackground(new java.awt.Color(65, 127, 194));
        jButton6.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Card_Payment_32px.png"))); // NOI18N
        jButton6.setText("Thanh Toán");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton6);

        jButton7.setBackground(new java.awt.Color(242, 64, 64));
        jButton7.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/icons8_Return_Purchase_32px.png"))); // NOI18N
        jButton7.setText("Xoá");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton7);

        jPanel6.add(jPanel8, java.awt.BorderLayout.PAGE_END);

        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new java.awt.GridBagLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Chiết khấu:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        jPanel10.add(jLabel4, gridBagConstraints);

        jFormattedTextField1.setText("0");
        jFormattedTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jFormattedTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField1ActionPerformed(evt);
            }
        });
        jFormattedTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextField1KeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.3;
        jPanel10.add(jFormattedTextField1, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("%");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.1;
        jPanel10.add(jLabel5, gridBagConstraints);

        jPanel9.add(jPanel10, java.awt.BorderLayout.PAGE_START);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new java.awt.GridLayout(3, 2, 0, 10));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Tổng giá:");
        jPanel11.add(jLabel6);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 0, 51));
        jLabel7.setText("0");
        jPanel11.add(jLabel7);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Số lượng:");
        jPanel11.add(jLabel8);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 51));
        jLabel9.setText("0");
        jPanel11.add(jLabel9);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Chiết khấu:");
        jPanel11.add(jLabel10);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 0, 51));
        jLabel11.setText("0");
        jPanel11.add(jLabel11);

        jPanel9.add(jPanel11, java.awt.BorderLayout.PAGE_END);

        jPanel12.setLayout(new java.awt.GridLayout(1, 0));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTable_ThanhToan.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTable_ThanhToan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable_ThanhToan.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable_ThanhToan);

        jPanel12.add(jScrollPane1);

        jPanel9.add(jPanel12, java.awt.BorderLayout.CENTER);

        jPanel6.add(jPanel9, java.awt.BorderLayout.CENTER);

        right.add(jPanel6, java.awt.BorderLayout.CENTER);

        body.add(right);

        ThanhToan.add(body, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout BGLayout = new javax.swing.GroupLayout(BG);
        BG.setLayout(BGLayout);
        BGLayout.setHorizontalGroup(
            BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BGLayout.createSequentialGroup()
                    .addGap(630, 630, 630)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(513, Short.MAX_VALUE)))
            .addGroup(BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE))
        );
        BGLayout.setVerticalGroup(
            BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BGLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(ThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE))
            .addGroup(BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BGLayout.createSequentialGroup()
                    .addGap(387, 387, 387)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(335, Short.MAX_VALUE)))
            .addGroup(BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BGLayout.createSequentialGroup()
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 747, Short.MAX_VALUE)))
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

    private void jButton_LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LogoutActionPerformed
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
    }//GEN-LAST:event_jButton_LogoutActionPerformed

    private void jButton_MailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_MailActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton_MailActionPerformed

    private void jFormattedTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField1KeyReleased
        // TODO add your handling code here:
        if (isNumeric(jFormattedTextField1.getText()) || jFormattedTextField1.getText().equals("")) {
            if (Integer.parseInt(jFormattedTextField1.getText()) > 100 || Integer.parseInt(jFormattedTextField1.getText()) < 0) {
                jFormattedTextField1.setText("0");
            } else {
                int a = Integer.parseInt(jTextField2.getText()) - (Integer.parseInt(jTextField2.getText()) * Integer.parseInt(jFormattedTextField1.getText())) / 100;
                jLabel11.setText(jFormattedTextField1.getText());
                jLabel7.setText(a + "");
            }
        } else {
            jFormattedTextField1.setText("0");
        }
    }//GEN-LAST:event_jFormattedTextField1KeyReleased

    private void jFormattedTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField1ActionPerformed

    private void jButton_UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UserActionPerformed
        // TODO add your handling code here:
        UserInfomation ui = new UserInfomation(this, true, acc);
        ui.setVisible(true);
    }//GEN-LAST:event_jButton_UserActionPerformed

    private void Minimize1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Minimize1MouseClicked
        // TODO add your handling code here:
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_Minimize1MouseClicked

    private void X1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_X1MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_X1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Tim kiem hang hoa
        if (jTextField1.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy hàng hóa");
        } else {
            modelTable.setRowCount(0);
            for (int i = 0; i < DS.findByID(jTextField1.getText()).size(); i++) {
                data.add(DS.findByID(jTextField1.getText()).get(i));
            }
            modelTable.fireTableDataChanged();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        modelTable.setRowCount(0);
        for (int i = 0; i < DS.findByID(jTextField1.getText()).size(); i++) {
            data.add(DS.findByID(jTextField1.getText()).get(i));
        }
        modelTable.fireTableDataChanged();
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTable_HangHoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_HangHoaMouseClicked
        // TODO add your handling code here:
        Vector vt = new Vector();
        boolean ck = true;
        if (jTable_ThanhToan.getRowCount() != 0) {
            if (Integer.parseInt(jTable_HangHoa.getValueAt(jTable_HangHoa.getSelectedRow(), 3).toString()) != 0) {
                for (int i = 0; i < jTable_ThanhToan.getRowCount(); i++) {
                    if (jTable_HangHoa.getValueAt(jTable_HangHoa.getSelectedRow(), 0).equals(jTable_ThanhToan.getValueAt(i, 0))) {
                        int so1 = Integer.parseInt(jTable_HangHoa.getValueAt(jTable_HangHoa.getSelectedRow(), 3).toString()) - 1;
                        int so2 = Integer.parseInt(jTable_ThanhToan.getValueAt(i, 3).toString()) + 1;
                        jTable_HangHoa.setValueAt(so1, jTable_HangHoa.getSelectedRow(), 3);
                        jTable_ThanhToan.setValueAt(so2, i, 3);
                        ck = false;
                        break;
                    }
                }
                if (ck == true) {
                    int so3 = Integer.parseInt(jTable_HangHoa.getValueAt(jTable_HangHoa.getSelectedRow(), 3).toString()) - 1;
                    for (int t = 0; t < 3; t++) {
                        vt.add(jTable_HangHoa.getValueAt(jTable_HangHoa.getSelectedRow(), t));
                    }
                    jTable_HangHoa.setValueAt(so3, jTable_HangHoa.getSelectedRow(), 3);
                    vt.add(1);
                    modelTable1.addRow(vt);
                }
            }
        }
        if (jTable_ThanhToan.getRowCount() == 0) {
            if (Integer.parseInt(jTable_HangHoa.getValueAt(jTable_HangHoa.getSelectedRow(), 3).toString()) != 0) {
                int so = Integer.parseInt(jTable_HangHoa.getValueAt(jTable_HangHoa.getSelectedRow(), 3).toString()) - 1;
                for (int t = 0; t < 3; t++) {
                    vt.add(jTable_HangHoa.getValueAt(jTable_HangHoa.getSelectedRow(), t));
                    jTable_HangHoa.setValueAt(so, jTable_HangHoa.getSelectedRow(), 3);
                }
                vt.add(1);
                modelTable1.addRow(vt);
            }
        }
        int tong = 0;
        int sl = 0;
        for (int k = 0; k < jTable_ThanhToan.getRowCount(); k++) {
            tong += (Integer.parseInt(jTable_ThanhToan.getValueAt(k, 2).toString()) * Integer.parseInt(jTable_ThanhToan.getValueAt(k, 3).toString()));
            sl += Integer.parseInt(jTable_ThanhToan.getValueAt(k, 3).toString());
        }
        jTextField2.setText(tong + "");
        jLabel7.setText(jTextField2.getText());
        jLabel9.setText(sl + "");
    }//GEN-LAST:event_jTable_HangHoaMouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        changeTable();
        jTextField2.setText("0");
        jFormattedTextField1.setText("0");
        jLabel7.setText("0");
        jLabel11.setText("0");
        jLabel9.setText("0");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        DS = new QLDSHang();

        String a = jLabel11.getText();
        String b = jLabel7.getText();
        HoaDon hd = new HoaDon(this, true, a, b, acc.getTenTK());
        hd.getjTable_HH().setModel(modelTable1);
        hd.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton_MailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_MailMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == 1) { // 1-left, 2-middle, 3-right button
            menu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jButton_MailMouseClicked

    private void jButton_FeedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_FeedbackActionPerformed
        // TODO add your handling code here:
        ThuNhanVien tnv = new ThuNhanVien(this, true, 2, "", acc.getTenTK());
        tnv.setVisible(true);
    }//GEN-LAST:event_jButton_FeedbackActionPerformed

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
            java.util.logging.Logger.getLogger(ThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThanhToan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BG;
    private javax.swing.JLabel Minimize1;
    private javax.swing.JPanel ThanhToan;
    private javax.swing.JLabel X1;
    private javax.swing.JPanel body;
    private javax.swing.JPanel header;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton_Feedback;
    private javax.swing.JButton jButton_Logout;
    private javax.swing.JButton jButton_Mail;
    private javax.swing.JButton jButton_Update;
    private javax.swing.JButton jButton_User;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_HangHoa;
    private javax.swing.JTable jTable_ThanhToan;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel left;
    private javax.swing.JPanel right;
    // End of variables declaration//GEN-END:variables
}
