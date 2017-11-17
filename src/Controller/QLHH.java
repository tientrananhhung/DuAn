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
    PreparedStatement pre1;

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
            ps.setString(8, obj.getNhomHang());
            ps.setString(7, obj.getNhaSX());
            ps.setString(5, obj.getThueVAT() + "");
            ps.setString(6, obj.getMoTa());
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
            ps = dbcn.getConnect().prepareStatement("UPDATE `hanghoa` SET `TenHH`=?,`GiaNhap`=?,`GiaBan`=?,`MaNH`=?,`MaNSX`=?,`Thue`=?,`MoTa`=?,`Image1`=?,`Image2`=?,`Image3`=?,`Image4`=?,`Image5`=? WHERE `MaHH`= ?");
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
            ps5 = dbcn.getConnect().prepareStatement("SELECT * FROM hanghoa WHERE MaHH LIKE ? OR MaNH LIKE ? OR MaNSX LIKE ? OR TenHH LIKE ?");
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
            PreparedStatement ps,ps2,ps3,ps4;
            ps = dbcn.getConnect().prepareStatement("DELETE FROM phieunhapct where MaHH = ?");
            ps2 = dbcn.getConnect().prepareStatement("DELETE FROM hoadonct where MaHH = ?");
            ps3 = dbcn.getConnect().prepareStatement("DELETE FROM kho where MaHH = ?");
            ps4 = dbcn.getConnect().prepareStatement("DELETE FROM hanghoa where MaHH = ?");
            ps.setString(1, a);
            ps2.setString(1, a);
            ps3.setString(1, a);
            ps4.setString(1, a);
            ps.executeUpdate();
            ps2.executeUpdate();
            ps3.executeUpdate();
            kq = ps4.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QLHH.class.getName()).log(Level.SEVERE, null, ex);
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

    public Vector getImg(String a) {
        Vector vt = new Vector();
        try {
            PreparedStatement ps;
            ps = dbcn.getConnect().prepareStatement("SELECT `Image1`, `Image2`, `Image3`, `Image4`, `Image5` FROM `hanghoa` WHERE MaHH = ?");
            ps.setString(1, a);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                Vector t = new Vector();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    vt.add(rs.getString(i));
                }
            }
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sai link ảnh");
        }
        return vt;
    }

    public Vector getMaNH1() {
        Vector kq = new Vector();
        try {
            pre1 = dbcn.getConnect().prepareStatement("SELECT * FROM `nhomhang`");
            ResultSet rs = pre1.executeQuery();
            while (rs.next()) {
                Vector t = new Vector();
                t.add(rs.getString(1));
                t.add(rs.getString(2));
                kq.add(t);
            }
            rs.close();
            pre1.close();
        } catch (SQLException ex) {
            Logger.getLogger(QLHH.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    public static void main(String[] args) {
        QLHH qlhh = new QLHH();
        System.out.println(qlhh.deleteHH("sp2"));
        
    }
}
