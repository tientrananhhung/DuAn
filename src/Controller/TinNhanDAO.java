/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.mysql.jdbc.ResultSetMetaData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tien Tran
 */
public class TinNhanDAO {

    Connection conn;
    PreparedStatement pre, pre1, pre2, pre3, pre4, pre5, pre6;
    TinNhanDAO tnDAO;

    public Vector getAllMessengeNV(String user) {
        Vector kq = new Vector();
        try {
            conn = new ConnectDB().getConnect();
            pre = conn.prepareStatement("SELECT * FROM `emailnhanvien` WHERE `Username` = ?");
            pre.setString(1, user);
            ResultSet rs = pre.executeQuery();
            ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
            while (rs.next()) {
                Vector t = new Vector();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    t.add(rs.getString(i));
                }
                kq.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TinNhanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    public Vector getAllMessengeAD() {
        Vector kq = new Vector();
        try {
            conn = new ConnectDB().getConnect();
            pre = conn.prepareStatement("SELECT * FROM `emailadmin`");
            ResultSet rs = pre.executeQuery();
            ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
            while (rs.next()) {
                Vector t = new Vector();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    t.add(rs.getString(i));
                }
                kq.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TinNhanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    public int demTNAD() {
        int tong = 0;
        tnDAO = new TinNhanDAO();
        for (int i = 0; i < tnDAO.getAllMessengeAD().size(); i++) {
            Vector t = (Vector) tnDAO.getAllMessengeAD().get(i);
            if (t.get(3).equals("Chưa xem")) {
                tong = tong + 1;
            }
        }
        return tong;
    }

    public int demTNNV(String user) {
        int tong = 0;
        tnDAO = new TinNhanDAO();
        for (int i = 0; i < tnDAO.getAllMessengeNV(user).size(); i++) {
            Vector t = (Vector) tnDAO.getAllMessengeNV(user).get(i);
            if (t.get(3).equals("Chưa xem")) {
                tong = tong + 1;
            }
        }
        return tong;
    }

    public int seenNV(String user, String ngayNhan) {
        try {
            conn = new ConnectDB().getConnect();
            pre1 = conn.prepareStatement("UPDATE `emailnhanvien` SET `TrangThai` = ? WHERE `Username` = ? AND `NgayGui` = ?");
            pre1.setString(1, "Đã xem");
            pre1.setString(2, user);
            pre1.setString(3, ngayNhan);
            if (pre1.executeUpdate() != 0) {
                return 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TinNhanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int seenAD(String user, String ngayNhan) {
        try {
            conn = new ConnectDB().getConnect();
            pre4 = conn.prepareStatement("UPDATE `emailadmin` SET `TrangThai`= 'Đã xem' WHERE `Username` = ? AND `NgayNhan` = ?");
            pre4.setString(1, user);
            pre4.setString(2, ngayNhan);
            if (pre4.executeUpdate() != 0) {
                return 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TinNhanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int sendMailNV(String user, String noiDung, String ngayGui) {
        try {
            conn = new ConnectDB().getConnect();
            pre2 = conn.prepareStatement("INSERT INTO `emailadmin`(`Username`, `NoiDung`, `NgayNhan`, `TrangThai`) VALUES (?,?,?,?)");
            pre2.setString(1, user);
            pre2.setString(2, noiDung);
            pre2.setString(3, ngayGui);
            pre2.setString(4, "Chưa xem");
            if (pre2.executeUpdate() != 0) {
                return 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TinNhanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int sendMailAD(String user, String noiDung, String ngayGui) {
        try {
            conn = new ConnectDB().getConnect();
            pre3 = conn.prepareStatement("INSERT INTO `emailnhanvien`(`Username`, `NoiDung`, `NgayGui`, `TrangThai`) VALUES (?,?,?,?)");
            pre3.setString(1, user);
            pre3.setString(2, noiDung);
            pre3.setString(3, ngayGui);
            pre3.setString(4, "Chưa xem");
            if (pre3.executeUpdate() != 0) {
                return 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TinNhanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int deleteMailAD(String user, String ngayNhan) {
        try {
            conn = new ConnectDB().getConnect();
            pre5 = conn.prepareStatement("DELETE FROM `emailadmin` WHERE `Username` = ? AND `NgayNhan` = ?");
            pre5.setString(1, user);
            pre5.setString(2, ngayNhan);
            if (pre5.executeUpdate() != 0) {
                return 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TinNhanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int deleteMailNV(String user, String ngayGui) {
        try {
            conn = new ConnectDB().getConnect();
            pre6 = conn.prepareStatement("DELETE FROM `emailnhanvien` WHERE `Username` = ? AND `NgayGui` = ?");
            pre6.setString(1, user);
            pre6.setString(2, ngayGui);
            if (pre6.executeUpdate() != 0) {
                return 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TinNhanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static void main(String[] args) {
        TinNhanDAO tnDAO = new TinNhanDAO();
        System.out.println(tnDAO.demTNNV("tien"));
    }
}
