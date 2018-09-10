/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import static atm.taikhoan.dangnhap;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class ATM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
//        khachhang kh = new khachhang();
//        kh.selectKhachhang(101);

        // Tạo khách hàng
//        int rs = kh.CreateKhachhang("Dương Tấn","Vinh",5448658,"14/01/1998","active");
//        if (rs > 0) {
//            System.out.println("Tạo khách hàng thành công" + rs );
//        }else{
//            System.out.println("Tạo khách hàng không thành công");
//        }
        
//        int rs = kh.updateKhachhang("Hồ Văn","Nhân", 123456789,"10/2/2000","active",100);
//        if (rs > 0) {
//            System.out.println("Cập nhật khách hàng thành công"  + rs);
//        }else{
//            System.out.println("Cập nhật khong thành công");
//        }
//        
//        System.out.println(kh.toString());


        //taikhoan tk = new taikhoan();
        
      
//        tk.selectTaikhoan(103);
//        System.out.println(tk.toString());
//        
        /*ResultSet rs = dangnhap(103, "123456");
        if (rs.next()) {
            System.out.println("Đăng nhập thành công");
        }else{
            System.out.println("Đăng nhập thất bại");
        }*/
        
        // Tạo khách hàng
//        int rs = tk.CreateTaikhoan(101,20000,"123456","","active");
//        if (rs > 0) {
//            System.out.println("Tạo tài khoản thành công" + rs );
//        }else{
//            System.out.println("Tạo tài khoản không thành công");
//        }
        
//        int rs = tk.updateTaikhoan(5000,"456789","active",111);
//        if (rs > 0) {
//            System.out.println("Cập nhật tài khoản thành công"  + rs);
//        }else{
//            System.out.println("Cập nhật khong thành công");
//        }
//        
        //System.out.println(tk.toString());
        
        giaodich gd = new giaodich();
        gd.rutTien();
    }
    
}
