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

public class khachhang {
    private int makh, cmnd;
    private String ho;
    private String ten, trangthai;
    private String ngaysinh;

    public khachhang() {
        
    }

    public khachhang(int makh, int cmnd, String ho, String ten, String trangthai, String ngaysinh) {
        this.makh = makh;
        this.cmnd = cmnd;
        this.ho = ho;
        this.ten = ten;
        this.trangthai = trangthai;
        this.ngaysinh = ngaysinh;
    }
//------------------------------------------------------------------------------
    
    
    
    public int getMakh() {
        return makh;
    }

    public int getCmnd() {
        return cmnd;
    }

    public String getHo() {
        return ho;
    }

    public String getTen() {
        return ten;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }
    
//------------------------------------------------------------------------------
    
    public void setMakh(int makh) {
        this.makh = makh;
    }

    public void setCmnd(int cmnd) {
        this.cmnd = cmnd;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    @Override
    public String toString() {
        return  "makh=" + makh + ", cmnd=" + cmnd + ", ho=" + ho + ", ten=" + ten + ", trangthai=" + trangthai + ", ngaysinh=" + ngaysinh ;
    }
    
        public void selectKhachhang(int code){
        Connection con = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1433/ATM;instance=SQLEXPRESS","sa","060170");
            PreparedStatement stmt = con.prepareStatement("SELECT makh ,ho ,ten ,cmnd ,ngaysinh ,trangthai FROM dbo.khachhang WHERE makh = ?");
            stmt.setInt(1, code);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                makh = rs.getInt("makh");
                ho = rs.getString("ho");
                ten = rs.getString("ten");
                cmnd = rs.getInt("cmnd");
                ngaysinh = rs.getString("ngaysinh");
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
    
    public int CreateKhachhang( String ho, String ten, int cmnd, String ngaysinh, String trangthai)
    {
        int rs = 0;
        Connection con = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1433/ATM;instance=SQLEXPRESS","sa","060170");
            PreparedStatement stmt = con.prepareStatement(
            "Insert into dbo.khachhang(ho ,ten ,cmnd ,ngaysinh ,trangthai) values(?,?,?,?,?)");
            stmt.setString(1, ho);
            stmt.setString(2, ten);
            stmt.setInt(3, cmnd);
            stmt.setString(4, ngaysinh);
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
    
    public int updateKhachhang(String ho, String ten, int cmnd, String ngaysinh, String trangthai, int makh)
    {
        int rs = 0;
        Connection con = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1433/ATM;instance=SQLEXPRESS","sa","060170");
            PreparedStatement stmt = con.prepareStatement(
            "update dbo.khachhang set ho = ? ,ten = ? ,cmnd =? ,ngaysinh = ? ,trangthai= ? where makh = ?");
            stmt.setString(1, ho);
            stmt.setString(2, ten);
            stmt.setInt(3, cmnd);
            stmt.setString(4, ngaysinh);
            stmt.setString(5, trangthai);
            stmt.setInt(6,makh);
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
}
