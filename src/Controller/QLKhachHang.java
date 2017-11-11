/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.KhachHang;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author tgdd
 */
public class QLKhachHang {

    ConnectDB DBCon;
    PreparedStatement pre1, pre2, pre3, pre4, pre5, pre6, pre7, pre8;

    public int insert(KhachHang KH) {
        int kq = 0;
        DBCon = new ConnectDB();
        try {
            pre1 = DBCon.getConnect().prepareStatement("INSERT INTO khachhang VALUES (?,?,?,?,?)");
            pre1.setString(1, KH.getSDT());
            pre1.setString(2, KH.getTenKH());
            pre1.setString(3, KH.getDiaChi());
            pre1.setString(4, KH.getEmail());
            pre1.setString(5, KH.getLoaiKH());
            kq = pre1.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi SQL");
        }
        return kq;
    }

    public int update(String SDTKH, String TenKH, String DiaChi, String Email, String LoaiKH) {
        int kq = 0;
        DBCon = new ConnectDB();
        try {
            pre2 = DBCon.getConnect().prepareStatement("UPDATE `khachhang` SET `TenKH` = ?, `DiaChi` = ?, `Email` = ?, `LoaiKH` = ? WHERE `khachhang`.`SDTKH` = ?;");
            pre2.setString(1, TenKH);
            pre2.setString(2, DiaChi);
            pre2.setString(3, Email);
            pre2.setString(4, LoaiKH);
            pre2.setString(5, SDTKH);
            kq = pre2.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QLKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    public int delete(String SDT) {
        DBCon = new ConnectDB();
        try {
            pre3 = DBCon.getConnect().prepareStatement("DELETE FROM khachhang WHERE SDTKH = ?");
            pre3.setString(1, SDT);
            if (pre3.executeUpdate() != 0) {
                return 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QLKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }

        return -1;
    }

    public Vector getAllList() {
        DBCon = new ConnectDB();
        Vector kq = new Vector();
        try {
            pre4 = DBCon.getConnect().prepareStatement("SELECT * FROM khachhang");
            ResultSet rs = pre4.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                Vector vt = new Vector();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    vt.add(rs.getString(i));
                }
                kq.add(vt);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(QLKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    public Vector findByID(String a) {
        DBCon = new ConnectDB();
        Vector kq = new Vector();
        try {
            pre5 = DBCon.getConnect().prepareStatement("SELECT * FROM khachhang WHERE SDTKH = ?");
            pre5.setString(1, a);
            ResultSet rs = pre5.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    kq.add(rs.getString(i));
                }
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(QLKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    public Vector getColumeName() {
        DBCon = new ConnectDB();
        Vector kq = new Vector();
        try {
            pre4 = DBCon.getConnect().prepareStatement("SELECT * FROM khachhang");
            ResultSet rs = pre4.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            Vector t = new Vector();
            for (int i = 1; i < rsmd.getColumnCount(); i++) {
                kq.add(rsmd.getColumnName(i));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(QLKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

//    public static void main(String[] args) {
//        QLKhachHang a = new QLKhachHang();
//        System.out.println(a.update("12", "a1", "a", "a", "a"));
//    }
    public Vector getAllKHVip() {
        DBCon = new ConnectDB();
        Vector kq = new Vector();
        try {
            pre6 = DBCon.getConnect().prepareStatement("SELECT COUNT(*) FROM khachhang WHERE `LoaiKH`='VIP';");
            ResultSet rs = pre6.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                Vector vt = new Vector();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    vt.add(rs.getString(i));
                }
                kq.add(vt);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(QLKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    public Vector getAllKHStandard() {
        DBCon = new ConnectDB();
        Vector kq = new Vector();
        try {
            pre7 = DBCon.getConnect().prepareStatement("SELECT COUNT(*) FROM khachhang WHERE `LoaiKH`='Standard';");
            ResultSet rs = pre7.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                Vector vt = new Vector();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    vt.add(rs.getString(i));
                }
                kq.add(vt);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(QLKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    public Vector getSDT() {
        DBCon = new ConnectDB();
        Vector kq = new Vector();
        try {
            pre8 = DBCon.getConnect().prepareStatement("SELECT `SDTKH` FROM khachhang");
            ResultSet rs = pre8.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                Vector vt = new Vector();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    vt.add(rs.getString(i));
                }
                kq.add(vt);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(QLKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
}
