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
public class DanhSachBanHang implements GiaoTiep {

    private NhanVien nv;
    private MatHang mh;
    private int sL;

    public DanhSachBanHang() {
    }

    public DanhSachBanHang(NhanVien nv, MatHang mh, int sL) {
        this.nv = nv;
        this.mh = mh;
        this.sL = sL;
    }

    public NhanVien getNv() {
        return nv;
    }

    public void setNv(NhanVien nv) {
        this.nv = nv;
    }

    public MatHang getMh() {
        return mh;
    }

    public void setMh(MatHang mh) {
        this.mh = mh;
    }

    public int getsL() {
        return sL;
    }

    public void setsL(int sL) {
        this.sL = sL;
    }

    @Override
    public Object[] tobObjects() {
        return new Object[]{nv.getMaNV(), nv.getHoT(), mh.getTenH(),mh.getNhomH(),sL};
    }

}
