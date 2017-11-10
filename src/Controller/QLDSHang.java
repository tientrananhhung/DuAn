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
    PreparedStatement pre1, pre2;

    public QLDSHang() {
        try {
            DBCon = new ConnectDB();
            pre1 = DBCon.getConnect().prepareStatement("SELECT kho.MaHH,hanghoa.TenHH, hanghoa.GiaBan, `SoLuong` FROM `kho` INNER JOIN hanghoa ON hanghoa.MaHH=kho.MaHH");
            pre2 = DBCon.getConnect().prepareStatement("SELECT kho.MaHH,hanghoa.TenHH, hanghoa.GiaBan, `SoLuong` FROM `kho` INNER JOIN hanghoa ON hanghoa.MaHH=kho.MaHH WHERE kho.MaHH LIKE ?");
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

}
