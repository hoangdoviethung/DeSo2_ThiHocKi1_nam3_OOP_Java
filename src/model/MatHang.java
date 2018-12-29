/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.GiaoTiep;

/**
 *
 * @author Administrator
 */
public class MatHang implements GiaoTiep{
    private int maH;
    private String tenH,nhomH;
    private float giaM,giaB;
    private float loiNhuan;

    public MatHang(int maH, String tenH, String nhomH, float giaM, float giaB, float loiNhuan) {
        this.maH = maH;
        this.tenH = tenH;
        this.nhomH = nhomH;
        this.giaM = giaM;
        this.giaB = giaB;
        this.loiNhuan = loiNhuan;
    }
    public MatHang() {
    }

    public int getMaH() {
        return maH;
    }

    public void setMaH(int maH) {
        this.maH = maH;
    }

    public String getTenH() {
        return tenH;
    }

    public void setTenH(String tenH) {
        this.tenH = tenH;
    }

    public String getNhomH() {
        return nhomH;
    }

    public void setNhomH(String nhomH) {
        this.nhomH = nhomH;
    }

    public float getGiaM() {
        return giaM;
    }

    public void setGiaM(float giaM) {
        this.giaM = giaM;
    }

    public float getGiaB() {
        return giaB;
    }

    public void setGiaB(float giaB) {
        this.giaB = giaB;
    }

    public float getLoiNhuan() {
        return giaB-giaM;
    }

    public void setLoiNhuan(float loiNhuan) {
        this.loiNhuan = loiNhuan;
    }

   
    
    @Override
    public Object[] tobObjects() {
        return new Object[]{maH,tenH,nhomH,giaM,giaB,loiNhuan};
    }
///// cau 3 ,4

    public MatHang(String tenH, String nhomH) {
        this.tenH = tenH;
        this.nhomH = nhomH;
    }
    
   
}
