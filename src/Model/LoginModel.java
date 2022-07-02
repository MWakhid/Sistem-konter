package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel extends ModelAbstract{
    private String sql;
    public LoginModel(){};
    public int cekLogin(String username, String password){
        int cek = 0;
        try{
            sql = "SELECT * FROM login where username = ? and password = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, username);
            stat.setString(2, password);
            ResultSet rs = stat.executeQuery();
            if(rs.next()){
                cek = rs.getInt("id_login");
                username = rs.getString("username");
                System.out.println("Selamat Datang " + username);
            } else {
                cek = 0;
            }
        } catch (SQLException e){
            e.printStackTrace();
        } return cek;
    }
}
