/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author luizm
 */
public class DBConnection {
    private static Connection conn = null;
    private static final String url = "jdbc:mysql://db4free.net/ativi2faprotidb";
    private static final String user = "client4ativi2faj";
    private static final String pass = "11352773";
    // host: db4free.net e port: 3306
    
    public Connection getConn() throws SQLException, ClassNotFoundException{
        if (conn == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            return conn;
        }else{
            return conn;
        }
    }
}
