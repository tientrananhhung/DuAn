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
public class HoaDon {
    private String maHoaDon;
    private String nhaCungCap;
    private String ngayNhap;
    private String ghiChu;
    private String hinhThuc;
    private int tienHang;
    private int tienThue;
    private int tongCong;
    private int thanhToan;
    private int conNo;

    public HoaDon(String maHoaDon, String nhaCungCap, String ngayNhap, String ghiChu, String hinhThuc, int tienHang, int tienThue, int tongCong, int thanhToan, int conNo) {
        this.maHoaDon = maHoaDon;
        this.nhaCungCap = nhaCungCap;
        this.ngayNhap = ngayNhap;
        this.ghiChu = ghiChu;
        this.hinhThuc = hinhThuc;
        this.tienHang = tienHang;
        this.tienThue = tienThue;
        this.tongCong = tongCong;
        this.thanhToan = thanhToan;
        this.conNo = conNo;
    }

    public HoaDon() {
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
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

    public int getTienHang() {
        return tienHang;
    }

    public void setTienHang(int tienHang) {
        this.tienHang = tienHang;
    }

    public int getTienThue() {
        return tienThue;
    }

    public void setTienThue(int tienThue) {
        this.tienThue = tienThue;
    }

    public int getTongCong() {
        return tongCong;
    }

    public void setTongCong(int tongCong) {
        this.tongCong = tongCong;
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
