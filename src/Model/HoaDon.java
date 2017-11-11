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
public class HoaDon {
    private int maHD;
    private String maHH;
    private int soluong;
    private int chietkhau;
    private int tonggia;

    public HoaDon() {
    }

    public HoaDon(int maHD, String maHH, int soluong, int chietkhau, int tonggia) {
        this.maHD = maHD;
        this.maHH = maHH;
        this.soluong = soluong;
        this.chietkhau = chietkhau;
        this.tonggia = tonggia;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public String getMaHH() {
        return maHH;
    }

    public void setMaHH(String maHH) {
        this.maHH = maHH;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getChietkhau() {
        return chietkhau;
    }

    public void setChietkhau(int chietkhau) {
        this.chietkhau = chietkhau;
    }

    public int getTonggia() {
        return tonggia;
    }

    public void setTonggia(int tonggia) {
        this.tonggia = tonggia;
    }
    
}
