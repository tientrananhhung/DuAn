/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author tgdd
 */
public class KhachHang {
    private String SDT;
    private String tenKH;
    private String diaChi;
    private String Email;
    private String loaiKH;

    public KhachHang() {
    }

    public KhachHang(String tenKH, String diaChi, String SDT, String Email, String loaiKH) {
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.SDT = SDT;
        this.Email = Email;
        this.loaiKH = loaiKH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getLoaiKH() {
        return loaiKH;
    }

    public void setLoaiKH(String loaiKH) {
        this.loaiKH = loaiKH;
    }

}
