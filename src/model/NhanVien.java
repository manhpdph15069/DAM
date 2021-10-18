/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author phamd
 */
public class NhanVien {
    private String maNV,hoTen,matKhau,email;
    private boolean trangThai;

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public NhanVien(String maNV, String hoTen, String matKhau, String email, boolean trangThai) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.matKhau = matKhau;
        this.email = email;
        this.trangThai = trangThai;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    private boolean vaiTro=false;

    public NhanVien() {
    }

    public NhanVien(String maNV, String hoTen, String matKhau, String email) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.matKhau = matKhau;
        this.email = email;
    }



    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public boolean isVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(boolean vaiTro) {
        this.vaiTro = vaiTro;
    }

    
    
}
