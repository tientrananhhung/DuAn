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
public class PhieuNhapCT {
    private String maPN;
    private String maHH;
    private int soLuong;
    private int donGia;
    private int tongGia;
    public PhieuNhapCT() {
    }

    public PhieuNhapCT(String maPN, String maHH, int soLuong, int donGia, int tongGia) {
        this.maPN = maPN;
        this.maHH = maHH;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.tongGia = tongGia;
    }

    public String getMaPN() {
        return maPN;
    }

    public void setMaPN(String maPN) {
        this.maPN = maPN;
    }

    public String getMaHH() {
        return maHH;
    }

    public void setMaHH(String maHH) {
        this.maHH = maHH;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getTongGia() {
        return tongGia;
    }

    public void setTongGia(int tongGia) {
        this.tongGia = tongGia;
    }
    
}
