/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Vector;

/**
 *
 * @author Tien Tran
 */
public class TinNhanDAO {

    Connection conn;
    PreparedStatement pre;

    public Vector getAllMessenge() {
        Vector kq = new Vector();
        return kq;
    }
}
