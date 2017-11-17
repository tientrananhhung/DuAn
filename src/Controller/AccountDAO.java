/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.ConnectDB;
import Model.Account;
import Model.NhaCungCap;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Tien Tran
 */
public class AccountDAO {

    Connection conn;
    PreparedStatement pre, pre1;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public Account checkLogin(String user, String pass) {
        Account kq = null;
        conn = new ConnectDB().getConnect();
        try {
            pre = conn.prepareStatement("SELECT * FROM `taikhoan` WHERE `Username` = ? AND `Password` = ?");
            pre.setString(1, user);
            pre.setString(2, pass);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                kq = new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
            } else {
                kq = null;
            }
        } catch (Exception e) {

        }
        return kq;
    }

    public List<Account> getAllAccount() {
        List<Account> listAcc = new ArrayList<>();
        try {
            conn = new ConnectDB().getConnect();
            pre1 = conn.prepareStatement("SELECT * FROM `taikhoan` WHERE `ChucVu` = 'Nhân viên'");
            ResultSet rs = pre1.executeQuery();
            while (rs.next()) {
                Account acc = new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), sdf.parse(rs.getString(5)), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                listAcc.add(acc);
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
        }
        return listAcc;
    }

    public static void main(String[] args) {
        AccountDAO aDAO = new AccountDAO();
        System.out.println(aDAO.getAllAccount().size());
    }
}
