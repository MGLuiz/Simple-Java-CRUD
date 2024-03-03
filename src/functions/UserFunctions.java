/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functions;

import java.sql.Connection;
import model.User;
import controller.DBConnection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author c29maq1
 */
public class UserFunctions {
    private String sql;
    
    public boolean insertUser(User user){
        sql = "INSERT INTO users(name, email, pass) VALUES (?, ?, ?)";
        
        try{
            Connection conn = new DBConnection().getConn();
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, user.getName());
            psmt.setString(2, user.getEmail());
            psmt.setString(3, user.getPass());
            
            psmt.execute();
            
            conn.close();
            psmt.close();
            
            return true;
        }catch(SQLException | ClassNotFoundException e){
            System.out.println(e);
            return false;
        }
    }
    
    public User selectUserByEmail(String email){
        sql = "SELECT * FROM `users` WHERE email = ?";
        User user;
        
        try{
            Connection conn = new DBConnection().getConn();
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, email);
            
            ResultSet rs = psmt.executeQuery();
            
            if (rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("pass"));
                conn.close();
                psmt.close();
                rs.close();
                return user;
            }else{
                return null;
            }
            
        }catch(SQLException | ClassNotFoundException e){
            System.out.println(e);
            return null;
        }
    }
    
    public boolean chkUser(String e, String p){
        String emailToValid = "luizmiguelxavierdebrito@faacgedu.org.br";
        String passToValid = "123188";
        
        return e.equals(emailToValid) && p.equals(passToValid);
    }
    
    public String getValidationKey(){
        int min = 100000;
        int max = 999999;
        
        return String.valueOf((int)(Math.random() * (max - min + 1) + min));
    }
}
