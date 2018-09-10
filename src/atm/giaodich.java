/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class giaodich {
    private int magd, matk;
    private String ngaygio, tacvu, mota;
    private double sotiensaugd, sotiengd;

    public giaodich() {
    }

    public giaodich(int matk,int magd, String ngaygio, String tacvu, String mota, double sotiensaugd, double sotiengd) {
        this.matk = matk;
        this.magd = magd;
        this.ngaygio = ngaygio;
        this.tacvu = tacvu;
        this.mota = mota;
        this.sotiensaugd = sotiensaugd;
        this.sotiengd = sotiengd;
    }

    public void naptien(int matk, String tacvu, String mota, double sotiengd){
        
    }
    
    public int getMatk() {
        return matk;
    }
    
    public int getMagd() {
        return magd;
    }

    public String getNgaygio() {
        return ngaygio;
    }

    public String getTacvu() {
        return tacvu;
    }

    public String getMota() {
        return mota;
    }

    public double getSotiensaugd() {
        return sotiensaugd;
    }

    public double getSotiengd() {
        return sotiengd;
    }
    
    public void setMatk(int matk) {
        this.matk = matk;
    }

    public void setMagd(int magd) {
        this.magd = magd;
    }

    public void setNgaygio(String ngaygio) {
        this.ngaygio = ngaygio;
    }

    public void setTacvu(String tacvu) {
        this.tacvu = tacvu;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public void setSotiensaugd(double sotiensaugd) {
        this.sotiensaugd = sotiensaugd;
    }

    public void setSotiengd(double sotiengd) {
        this.sotiengd = sotiengd;
    }

    @Override
    public String toString() {
        return "giaodich :" + "matk=" + matk + ", magd=" + magd + ", ngaygio=" + ngaygio + ", tacvu=" + tacvu + ", mota=" + mota + ", sotiensaugd=" + sotiensaugd + ", sotiengd=" + sotiengd ;
    }
    
    
    Scanner sc = new Scanner(System.in);\
    public void rutTien(){
        Connection con = null;
        try {
            
           System.out.println("Nhập tài khoản muốn giao dịch");
            setMatk(sc.nextInt());
            
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1433/ATM;instance=SQLEXPRESS","sa","060170");
            
            PreparedStatement stmt = con.prepareStatement("select sodu from Taikhoan where matk = '"+getMatk()+"'");
            ResultSet rs = stmt.executeQuery();
            
            rs.next();
            int soDu = rs.getInt("sodu");
            
            System.out.println(""+soDu);
           System.out.println("Nhập số tiền muốn rút");
            setSotiengd(sc.nextDouble());
            
            
            double tiensaugd = soDu - getSotiengd();
            
            System.out.println("sau giao dich = "+tiensaugd);
            
            PreparedStatement sql = con.prepareStatement(
                "INSERT giaodich (matk,sotiensaugd,sotiengd,ngaygio,tacvu) VALUES "
                + " ('"+getMatk()+"','"+tiensaugd+"' ,'"+getSotiengd()+"','day','chuyentien' )");
            sql.executeUpdate();
            
            PreparedStatement sql1 = con.prepareStatement(
                    "update taikhoan set sodu = '"+tiensaugd+"' where matk ='"+getMatk()+"' ");
            sql1.executeUpdate();
            
            System.out.println("Số dư tài khoản = " + tiensaugd);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(con != null)
                    con.close();
            } catch (SQLException ex) {
                Logger.getLogger(khachhang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void napTien(){
        Connection con = null;
        try {
            
           System.out.println("Nhập tài khoản muốn giao dịch");
            setMatk(sc.nextInt());
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1433/ATM;instance=SQLEXPRESS","sa","060170");
            PreparedStatement stmt = con.prepareStatement("select sodu from Taikhoan where matk = '"+getMatk()+"'");
            ResultSet rs = stmt.executeQuery();
            rs.next();
            int soDu = rs.getInt("sodu");                    
            System.out.println(""+soDu);
           System.out.println("Nhập số tiền muốn giao dịch");
            setSotiengd(sc.nextDouble());
            double tiensaugd = soDu + getSotiengd();
            System.out.println("sau giao dich = "+tiensaugd);
            PreparedStatement sql = con.prepareStatement("INSERT giaodich (matk,sotiensaugd,sotiengd,ngaygio,tacvu) VALUES  ('"+getMatk()+"','"+tiensaugd+"' ,'"+getSotiengd()+"','day','chuyentien' )");
            sql.executeUpdate();
            PreparedStatement sql1 = con.prepareStatement("update taikhoan set sodu = '"+tiensaugd+"' where matk ='"+getMatk()+"' ");
            sql1.executeUpdate();
            System.out.println("Số dư tài khoản = " + tiensaugd);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(con != null)
                    con.close();
            } catch (SQLException ex) {
                Logger.getLogger(khachhang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
}
