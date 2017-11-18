package Controller;

import Controller.ConnectDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tgdd
 */
public class QLDSHang {

    ConnectDB DBCon;
    PreparedStatement pre1, pre2, pre3, pre4, pre5, pre6;

    public QLDSHang() {
        try {
            DBCon = new ConnectDB();
            pre1 = DBCon.getConnect().prepareStatement("SELECT kho.MaHH,hanghoa.TenHH, hanghoa.GiaBan, `SoLuong` FROM `kho` INNER JOIN hanghoa ON hanghoa.MaHH=kho.MaHH");
            pre2 = DBCon.getConnect().prepareStatement("SELECT kho.MaHH,hanghoa.TenHH, hanghoa.GiaBan, `SoLuong` FROM `kho` INNER JOIN hanghoa ON hanghoa.MaHH=kho.MaHH WHERE kho.MaHH LIKE ?");
            pre3 = DBCon.getConnect().prepareStatement("UPDATE `kho` SET `SoLuong`=? WHERE `MaHH`=?");
        } catch (SQLException ex) {
            Logger.getLogger(QLDSHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Vector getAllList() {
        Vector kq = new Vector();
        try {
            ResultSet rs = pre1.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                Vector t = new Vector();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    t.add(rs.getString(i));
                }
                kq.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QLDSHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    public int themHD(String user, String sdt, String ngayXuat) {
        try {
            DBCon = new ConnectDB();
            pre4 = DBCon.getConnect().prepareStatement("INSERT INTO `hoadon`(`MaHD`, `Username`, `SDTKH`, `NgayXuat`) VALUES (null,?,?,?)");
            pre4.setString(1, user);
            pre4.setString(2, sdt);
            pre4.setString(3, ngayXuat);
            if (pre4.executeUpdate() != 0) {
                return 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QLDSHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public Vector getMaHD() {
        Vector kq = new Vector();
        try {
            DBCon = new ConnectDB();
            pre5 = DBCon.getConnect().prepareStatement("SELECT * FROM `hoadon` ORDER BY `MaHD` DESC");
            ResultSet rs = pre5.executeQuery();
            rs.next();
            kq.add(rs.getString(1));
        } catch (SQLException ex) {
            Logger.getLogger(QLDSHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    public int themHDCT(String maHD, String maHH, int sl, int tongGia) {
        try {
            DBCon = new ConnectDB();
            pre6 = DBCon.getConnect().prepareStatement("INSERT INTO `hoadonct`(`MaHD`, `MaHH`, `SoLuong`, `TongGia`) VALUES (?,?,?,?)");
            pre6.setString(1, maHD);
            pre6.setString(2, maHH);
            pre6.setInt(3, sl);
            pre6.setInt(4, tongGia);
            if (pre6.executeUpdate() != 0) {
                return 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QLDSHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public Vector findByID(String keyWord) {
        Vector kq = new Vector();
        try {
            pre2.setString(1, "%" + keyWord + "%");
            ResultSet rs = pre2.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                Vector t = new Vector();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    t.add(rs.getString(i));
                }
                kq.add(t);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(QLDSHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    public int update(String MaHH, int SoLuong) {
        int kq = 0;
        try {
            pre3.setInt(1, SoLuong);
            pre3.setString(2, MaHH);
            kq = pre3.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QLDSHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    public static void main(String[] args) {
        QLDSHang ql = new QLDSHang();
        System.out.println(ql.getMaHD());
    }

}
