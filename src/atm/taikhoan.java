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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class taikhoan {
    private int matk, makh;
    private double sodu;
    private String matkhau;
    private String lastaccess, trangthai;


//------------------------------------------------------------------------------    

    public taikhoan() {
    }

    

//------------------------------------------------------------------------------
    
    public taikhoan(int matk, int makh, double sodu, String matkhau, String lastaccess, String trangthai) {
        this.matk = matk;
        this.makh = makh;
        this.sodu = sodu;
        this.matkhau = matkhau;
        this.lastaccess = lastaccess;
        this.trangthai = trangthai;
    }



//------------------------------------------------------------------------------

    public int getMatk() {
        return matk;
    }

    public int getMakh() {
        return makh;
    }

    public double getSodu() {
        return sodu;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public String getLastaccess() {
        return lastaccess;
    }

    public String getTrangthai() {
        return trangthai;
    }
    

//------------------------------------------------------------------------------

    public void setMatk(int matk) {
        this.matk = matk;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }

    public void setSodu(double sodu) {
        this.sodu = sodu;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public void setLastaccess(String lastaccess) {
        this.lastaccess = lastaccess;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
    
//------------------------------------------------------------------------------
    
    @Override
    public String toString() {
        return "taikhoan :" + "matk=" + matk + ", makh=" + makh + ", sodu=" + sodu + ", matkhau=" + matkhau + ", lastaccess=" + lastaccess + ", trangthai=" + trangthai ;
    }
    
    //------------------------------------------------------------------------------

    public static ResultSet dangnhap(int matk, String matkhau){
        Connection con = null;
        ResultSet rs = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1433/ATM;instance=SQLEXPRESS","sa","060170");
            PreparedStatement stmt = con.prepareStatement(
                    "SELECT matk, matkhau  FROM dbo.Taikhoan WHERE matk = ? AND matkhau = ?");
            stmt.setInt(1, matk);
            stmt.setString(2,matkhau);
            rs = stmt.executeQuery();
    
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
        return rs;
    }

//------------------------------------------------------------------------------

public void selectTaikhoan(int code){
        Connection con = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1433/ATM;instance=SQLEXPRESS","sa","060170");
            PreparedStatement stmt = con.prepareStatement(
                    "SELECT matk ,makh ,sodu ,matkhau ,lastaccess ,trangthai FROM dbo.Taikhoan WHERE matk = ?");
            stmt.setInt(1, code);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                matk = rs.getInt("matk");
                makh = rs.getInt("makh");
                sodu = rs.getDouble("sodu");
                matkhau = rs.getString("matkhau");
                lastaccess = rs.getString("lastaccess");
                trangthai = rs.getString("trangthai");                
            }
        } catch (Exception e) {
        }finally{
            try {
                if(con != null)
                    con.close();
            } catch (SQLException ex) {
                Logger.getLogger(khachhang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
//------------------------------------------------------------------------------

public int CreateTaikhoan(int makh ,double sodu ,String matkhau ,String lastaccess ,String trangthai)
    {
        int rs = 0;
        Connection con = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1433/ATM;instance=SQLEXPRESS","sa","060170");
            PreparedStatement stmt = con.prepareStatement(
            "Insert into dbo.Taikhoan(makh ,sodu ,matkhau ,lastaccess ,trangthai) values(?,?,?,?,?)");
            stmt.setInt(1, makh);
            stmt.setDouble(2, sodu);
            stmt.setString(3, matkhau);
            stmt.setString(4, lastaccess);
            stmt.setString(5, trangthai);
            rs = stmt.executeUpdate();
            
        } catch (Exception e) {
        }finally{
            try {
                if(con != null)
                    con.close();
            } catch (SQLException ex) {
                Logger.getLogger(khachhang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rs;
    }

//------------------------------------------------------------------------------

public int updateTaikhoan(double sodu ,String matkhau, String trangthai, int matk)
    {
        int rs = 0;
        Connection con = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1433/ATM;instance=SQLEXPRESS","sa","060170");
            PreparedStatement stmt = con.prepareStatement(
            "update dbo.Taikhoan set sodu = ? ,matkhau = ? ,trangthai =?  where matk = ?");
            stmt.setDouble(1, sodu);
            stmt.setString(2, matkhau);
            stmt.setString(3,trangthai);
            stmt.setInt(4, matk);
            rs = stmt.executeUpdate();
            
        } catch (Exception e) {
        }finally{
            try {
                if(con != null)
                    con.close();
            } catch (SQLException ex) {
                Logger.getLogger(khachhang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rs;
    }

    
}
