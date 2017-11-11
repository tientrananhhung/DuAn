/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.ConnectDB;
import Model.NhaSanXuat;
import Model.NhomHang;
import Model.modelHangHoa;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Admin
 */
public class QLHH {

    ConnectDB dbcn;

    public QLHH() {
        dbcn = new ConnectDB();
    }

    public int insertHangHoa(modelHangHoa obj) {
        int kq = 0;
        try {
            PreparedStatement ps;
            ps = dbcn.getConnect().prepareStatement("INSERT INTO `hanghoa` VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, obj.getMaHH());
            ps.setString(2, obj.getTenHH());
            ps.setString(3, obj.getGiaVon() + "");
            ps.setString(4, obj.getGiaBan() + "");
            ps.setString(5, obj.getNhomHang());
            ps.setString(6, obj.getNhaSX());
            ps.setString(7, obj.getThueVAT() + "");
            ps.setString(8, obj.getMoTa());
            ps.setString(9, obj.getImg1());
            ps.setString(10, obj.getImg2());
            ps.setString(11, obj.getImg3());
            ps.setString(12, obj.getImg4());
            ps.setString(13, obj.getImg5());
            kq = ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sai câu lệnh database");
        }
        return kq;
    }

    public int updateHangHoa(modelHangHoa obj) {
        int kq = 0;
        try {
            PreparedStatement ps;
            ps = dbcn.getConnect().prepareStatement("Update hanghoa set `TenHH`=?,`GiaVon`=?,`GiaBan`=?,`MaNH`=?,`MaNSX`=?,`Thue`=?,`MoTa`=?,`Img1`=?,`Img2`=?,`Img3`=?,`Img4`=?,`Img5`=? WHERE `MaHH`= ?");
            ps.setString(1, obj.getTenHH());
            ps.setString(2, obj.getGiaVon() + "");
            ps.setString(3, obj.getGiaBan() + "");
            ps.setString(4, obj.getNhomHang());
            ps.setString(5, obj.getNhaSX());
            ps.setString(6, obj.getThueVAT() + "");
            ps.setString(7, obj.getMoTa());
            ps.setString(8, obj.getImg1());
            ps.setString(9, obj.getImg2());
            ps.setString(10, obj.getImg3());
            ps.setString(11, obj.getImg4());
            ps.setString(12, obj.getImg5());
            ps.setString(13, obj.getMaHH());
            kq = ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sai câu lệnh database");
        }
        return kq;
    }

    public int insertNhomHang(NhomHang obj) {
        int kq = 0;
        try {
            PreparedStatement ps;
            ps = dbcn.getConnect().prepareStatement("insert into nhomhang values (?,?)");
            ps.setString(1, obj.getMaNH());
            ps.setString(2, obj.getTenNH());
            kq = ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sai câu lệnh database");
        }
        return kq;
    }

    public int insertNSX(NhaSanXuat obj) {
        int kq = 0;
        try {
            PreparedStatement ps;
            ps = dbcn.getConnect().prepareStatement("insert into nsx values (?,?)");
            ps.setString(1, obj.getMaNSX());
            ps.setString(2, obj.getTenNSX());
            kq = ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sai câu lệnh database");
        }
        return kq;
    }

    public Vector findByID(String keyWord) {
        // Tìm kiếm theo username
        Vector kq = new Vector();
        try {
            PreparedStatement ps5;
            ps5 = dbcn.getConnect().prepareStatement("SELECT * FROM hanghoa WHERE MaHH LIKE ? OR MaNH LIKE ? OR MaSX LIKE ? OR TenHH LIKE ?");
            ps5.setString(1, "%" + keyWord + "%");
            ps5.setString(2, "%" + keyWord + "%");
            ps5.setString(3, "%" + keyWord + "%");
            ps5.setString(4, "%" + keyWord + "%");
            ResultSet rs = ps5.executeQuery();
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

        }
        return kq;
    }

    public int deleteNSX(String a) {
        int kq = 0;
        try {
            PreparedStatement ps;
            ps = dbcn.getConnect().prepareStatement("delete from nsx where MaNSX = ?");
            ps.setString(1, a);
            kq = ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sai câu lệnh database");
        }
        return kq;
    }

    public int deleteHH(String a) {
        int kq = 0;
        try {
            PreparedStatement ps;
            ps = dbcn.getConnect().prepareStatement("delete from hanghoa where MaHH = ?");
            ps.setString(1, a);
            kq = ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sai câu lệnh database");
        }
        return kq;
    }

    public int deleteNH(String a) {
        int kq = 0;
        try {
            PreparedStatement ps;
            ps = dbcn.getConnect().prepareStatement("delete from nhomhang where MaNH = ?");
            ps.setString(1, a);
            kq = ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sai câu lệnh database");
        }
        return kq;
    }

    public File copyFile() {
        JFileChooser openImg = new JFileChooser();
        openImg.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
        openImg.setAcceptAllFileFilterUsed(false);
        int a = openImg.showOpenDialog(null);
        java.io.File file = openImg.getSelectedFile();
        return file;
    }

    public Vector getColumnName() {
        Vector kq = new Vector();
        try {
            PreparedStatement ps;
            ps = dbcn.getConnect().prepareStatement("Select * from hanghoa");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                kq.add(rsmd.getColumnName(i));
            }
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sai câu lệnh database");
        }
        return kq;
    }

    public Vector getAllList() {
        Vector kq = new Vector();
        try {
            PreparedStatement ps;
            ps = dbcn.getConnect().prepareStatement("Select * from hanghoa");
            ResultSet rs = ps.executeQuery();
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
            JOptionPane.showMessageDialog(null, "Sai câu lệnh database");
        }

        return kq;
    }

    public Vector getMaNH() {
        Vector kq = new Vector();
        try {
            PreparedStatement ps;
            ps = dbcn.getConnect().prepareStatement("Select * from nhomhang");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                kq.add(rs.getString(1));
            }
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sai câu lệnh database");
        }
        return kq;
    }
    public Vector getNCC() {
        Vector kq = new Vector();
        try {
            PreparedStatement ps;
            ps = dbcn.getConnect().prepareStatement("Select * from nhacungcap");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                kq.add(rs.getString(1));
            }
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sai câu lệnh database");
        }
        return kq;
    }
    public Vector getTenNH() {
        Vector kq = new Vector();
        try {
            PreparedStatement ps;
            ps = dbcn.getConnect().prepareStatement("Select * from nhomhang");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                kq.add(rs.getString(2));
            }
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sai câu lệnh database");
        }
        return kq;
    }

    public Vector getMaNSX() {
        Vector kq = new Vector();
        try {
            PreparedStatement ps;
            ps = dbcn.getConnect().prepareStatement("Select * from nsx");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                kq.add(rs.getString(1));
            }
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sai câu lệnh database");
        }
        return kq;
    }

    public Vector getTenNSX() {
        Vector kq = new Vector();
        try {
            PreparedStatement ps;
            ps = dbcn.getConnect().prepareStatement("Select * from nsx");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                kq.add(rs.getString(2));
            }
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sai câu lệnh database");
        }
        return kq;
    }

    public static void main(String[] args) {
        QLHH ql = new QLHH();
        modelHangHoa hh = new modelHangHoa("a1", "a", 1, 2, "A001", "TQ", 2, "s", "a", "a", "a", "a", "a");
        System.out.println(ql.updateHangHoa(hh));
    }
}
