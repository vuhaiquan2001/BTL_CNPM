package ThongKe;

import cnpm_btl.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author HaiQuan
 */
public class ConnectMySQL {
    Connection conn;
    //ket noi voi database
    public ConnectMySQL() throws ClassNotFoundException,SQLException{
            Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cnpm","root", "quancap2001");
   
    }
    // lấy thông tin từ mysql
    public ResultSet getdata(String hoadon) throws SQLException{
        ResultSet kq=null;
        Statement stmt = conn.createStatement();
        String sql ="SELECT * FROM "+hoadon+"";
        kq=stmt.executeQuery(sql);
        return kq;
    }
    //BẪY LỖI TRÙNG LẶP KHÓA CHÍNH
    public ResultSet getdata1(String madh) throws SQLException{
        ResultSet kq=null;
        Statement stmt = conn.createStatement();
        String sql ="SELECT MaHD FROM hoadon where MaHD = '"+madh+"' ";
        kq=stmt.executeQuery(sql);
        return kq;
    }
    //đóng kết nối
    public void close() throws SQLException{
        if(this.conn!=null)
            this.conn.close();
    }
}
