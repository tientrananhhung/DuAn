/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.HoaDon;
import Model.KhachHang;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author tgdd
 */
public class QLHoaDon {

    ConnectDB DBCon;
    PreparedStatement pre1, pre2;

    public QLHoaDon() {
        try {
            DBCon = new ConnectDB();
            pre1 = DBCon.getConnect().prepareStatement("INSERT INTO `hoadonct` (`MaHD`, `MaHH`, `SoLuong`, `ChietKhau`, `TongGia`) VALUES (?,?,?,?,?);");
        } catch (SQLException ex) {
            Logger.getLogger(QLDSHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public int insert(HoaDon hd) {
        int kq = 0;
        try {
            pre1.setInt(1, hd.getMaHD());
            pre1.setString(2, hd.getMaHH());
            pre1.setInt(3, hd.getSoluong());
            pre1.setInt(4, hd.getChietkhau());
            pre1.setInt(5, hd.getTonggia());
            kq = pre1.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi câu lệnh SQL");
        }
        return kq;
    }
}
