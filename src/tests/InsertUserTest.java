package tests;


import functions.UserFunctions;
import model.User;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author luizm
 */
public class InsertUserTest {
    public static void main(String[] args) {
        User user = new User();
        user.setName("Lucas");
        user.setEmail("lucas@gmail.com");
        user.setPass("123188");
        
        new UserFunctions().insertUser(user);
    }
}
