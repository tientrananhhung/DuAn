/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.ConnectDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

/**
 *
 * @author Tien Tran
 */
public class AccountDAO {

    Connection conn;
    PreparedStatement pre;

    public Account checkLogin(String user, String pass) {
        Account kq = null;
        conn = new ConnectDB().getConnect();
        try {
            pre = conn.prepareStatement("SELECT * FROM `taikhoan` WHERE `TenTaiKhoan` = ? AND `MatKhau` = ?");
            pre.setString(1, user);
            pre.setString(2, pass);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                kq = new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
            } else {
                kq = null;
            }
        } catch (Exception e) {

        }
        return kq;
    }
}
