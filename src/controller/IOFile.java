/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;

/**
 *
 * @author Administrator
 */
public class IOFile {

    public ArrayList<NhanVien> docFileNV;

    ////////// doc file mat hang
    public ArrayList docFileMH(String s) {
        ArrayList<MatHang> mhs = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(s));
            while (scanner.hasNext()) {
                String s1 = scanner.nextLine();
                String s2 = scanner.nextLine();
                String s3 = scanner.nextLine();
                String s4 = scanner.nextLine();
                String s5 = scanner.nextLine();
                if (!(s1.equals("") || s2.equals("") || s3.equals("") || s4.equals("") || s5.equals(""))) {// kiem tra khoang trang
                    if (checkMaMH(s1) && checkNH(s3) && checkGia(s4, s5)) {//kiem tra dung dieu kien 
                        MatHang mh = new MatHang();
                        mh.setMaH(Integer.parseInt(s1));
                        mh.setTenH(s2);
                        mh.setNhomH(s3);
                        mh.setGiaM(Float.parseFloat(s4));
                        mh.setGiaB(Float.parseFloat(s5));
                        mh.setLoiNhuan(-Float.parseFloat(s4) + Float.parseFloat(s5));
                        mhs.add(mh);
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IOFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mhs;
    }

    private boolean checkMaMH(String s) {
        boolean flag = true;
        try {
            int a = Integer.parseInt(s);
            if (a < 1000 || a > 9999) {
                flag = false;
            }
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    private boolean checkNH(String s) {
        if (s.equals("hang thoi trang") || s.equals("hang tieu dung") || s.equals("hang dien may") || s.equals("hang gia dung")) {
            return true;
        }
        return false;
    }

    private boolean checkGia(String s1, String s2) {
        float f1 = Float.parseFloat(s1);
        float f2 = Float.parseFloat(s2);
        if (f1 - f2 > 0 || f1 - f2 == 0) {
            return false;
        }
        return true;
    }

    /////////// doc file nhan vien
    public ArrayList<NhanVien> docFileNV(String s) {
        ArrayList<NhanVien> nvs = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(s));
            while (scanner.hasNext()) {
                String s1 = scanner.nextLine();
                String s2 = scanner.nextLine();
                String s3 = scanner.nextLine();
                String s4 = scanner.nextLine();
                if (!(s1.equals("") || s2.equals("") || s3.equals("") || s4.equals(""))) {
                    if (checkMaNV(s1)) {
                        NhanVien nv = new NhanVien();
                        nv.setMaNV(Integer.parseInt(s1));
                        nv.setHoT(s2);
                        nv.setDiaC(s3);
                        nv.setsDT(s4);
                        nvs.add(nv);
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IOFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nvs;
    }

    private boolean checkMaNV(String s) {
        boolean flag = true;
        try {
            int a = Integer.parseInt(s);
            if (a < 1000 || a > 9999) {
                flag = false;
            }
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /////////////// luu file danh sach ban hang
    public void ghiFileDSBH(ArrayList<DanhSachBanHang> dsbhs) {
        try (PrintWriter pw = new PrintWriter(new File("SX.OUT"))) {
            for (DanhSachBanHang dsbh : dsbhs) {
                pw.println(dsbh.getNv().getMaNV());
                pw.println(dsbh.getNv().getHoT());
                pw.println(dsbh.getMh().getTenH());
                pw.println(dsbh.getMh().getNhomH());
                pw.println(dsbh.getsL());
            }

        } catch (Exception e) {
        } finally {

        }
    }

    public ArrayList<DanhSachBanHang> docFileDSBH(String s) {
        ArrayList<DanhSachBanHang> dsbhs = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(s));
            while (scanner.hasNext()) {
                String s1 = scanner.nextLine();
                String s2 = scanner.nextLine();
                String s3 = scanner.nextLine();
                String s4 = scanner.nextLine();
                String s5 = scanner.nextLine();
                NhanVien nv = new NhanVien(Integer.parseInt(s1), s2);
                MatHang mh = new MatHang(s3, s4);
                DanhSachBanHang dsbh = new DanhSachBanHang(nv, mh, Integer.parseInt(s5));
                dsbhs.add(dsbh);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IOFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsbhs;

    }
}
