/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class PhieuNhap {
    private String maPN;
    private String maNCC;
    private String ngayNhap;
    private String ghiChu;
    private String hinhThuc;
    private int tongTien;
    private int thanhToan;
    private int conNo;

    public PhieuNhap() {
    }

    public PhieuNhap(String maPN, String maNCC, String ngayNhap, String ghiChu, String hinhThuc, int tongTien, int thanhToan, int conNo) {
        this.maPN = maPN;
        this.maNCC = maNCC;
        this.ngayNhap = ngayNhap;
        this.ghiChu = ghiChu;
        this.hinhThuc = hinhThuc;
        this.tongTien = tongTien;
        this.thanhToan = thanhToan;
        this.conNo = conNo;
    }

    public String getMaPN() {
        return maPN;
    }

    public void setMaPN(String maPN) {
        this.maPN = maPN;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getHinhThuc() {
        return hinhThuc;
    }

    public void setHinhThuc(String hinhThuc) {
        this.hinhThuc = hinhThuc;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public int getThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(int thanhToan) {
        this.thanhToan = thanhToan;
    }

    public int getConNo() {
        return conNo;
    }

    public void setConNo(int conNo) {
        this.conNo = conNo;
    }
   
}
