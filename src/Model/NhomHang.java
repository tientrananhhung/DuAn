/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Admin
 */
public class NhomHang {
    private String MaNH;
    private String TenNH;

    public NhomHang(String MaNH, String TenNH) {
        this.MaNH = MaNH;
        this.TenNH = TenNH;
    }

    public NhomHang() {
    }

    public String getMaNH() {
        return MaNH;
    }

    public void setMaNH(String MaNH) {
        this.MaNH = MaNH;
    }

    public String getTenNH() {
        return TenNH;
    }

    public void setTenNH(String TenNH) {
        this.TenNH = TenNH;
    }
    
}
