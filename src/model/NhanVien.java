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
public class NhanVien implements GiaoTiep{
  private int maNV;
    private String hoT,sDT,diaC;

    public NhanVien() {
    }

    public NhanVien(int maNV, String hoT, String sDT, String diaC) {
        this.maNV = maNV;
        this.hoT = hoT;
        this.sDT = sDT;
        this.diaC = diaC;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getHoT() {
        return hoT;
    }

    public void setHoT(String hoT) {
        this.hoT = hoT;
    }

    public String getsDT() {
        return sDT;
    }

    public void setsDT(String sDT) {
        this.sDT = sDT;
    }

    public String getDiaC() {
        return diaC;
    }

    public void setDiaC(String diaC) {
        this.diaC = diaC;
    }

    @Override
    public Object[] tobObjects() {
        return new Object[]{maNV,hoT,diaC,sDT};
    }
////////// cau 3 , 4
    public NhanVien(int maNV, String hoT) {
        this.maNV = maNV;
        this.hoT = hoT;
    }
    
}
