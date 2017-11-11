/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.NhaCungCap;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tien Tran
 */
public class QuanLyNCC {

    ConnectDB conn;
    PreparedStatement pre1, pre2;

    public QuanLyNCC() {
        try {
            conn = new ConnectDB();
            pre1 = conn.getConnect().prepareStatement("INSERT INTO `nhacungcap`(`MaNCC`, `TenNCC`, `DiaChi`, `Email`, `SDT`) VALUES (?,?,?,?,?)");
            pre2 = conn.getConnect().prepareStatement("SELECT * FROM `nhacungcap`");
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyNCC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<NhaCungCap> getAllNCC() throws SQLException {
        List<NhaCungCap> listNCC = new ArrayList<>();
        ConnectDB cn = new ConnectDB();
        ResultSet rs = pre2.executeQuery();
        try {
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                listNCC.add(ncc);
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
        }
        return listNCC;
    }

    public int addNCC(NhaCungCap ncc) {
        try {
            pre1.setString(1, ncc.getMaNCC());
            pre1.setString(2, ncc.getTenNCC());
            pre1.setString(3, ncc.getDiaChi());
            pre1.setString(4, ncc.getEmail());
            pre1.setString(5, ncc.getSdt());
            if (pre1.executeUpdate() != 0) {
                return 1;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

}
