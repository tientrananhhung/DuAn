/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tgdd
 */
public class TinNhan {

    ConnectDB DBCon;
    PreparedStatement pre1, pre2;

    public Vector getAllTNNV() {
        Vector kq = new Vector();
        DBCon = new ConnectDB();
        try {
            pre1 = DBCon.getConnect().prepareStatement("SELECT * FROM `emailnhanvien`");
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

    public Vector getAllTNAD() {
        Vector kq = new Vector();
        DBCon = new ConnectDB();
        try {
            pre1 = DBCon.getConnect().prepareStatement("SELECT * FROM `emailadmin`");
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

}