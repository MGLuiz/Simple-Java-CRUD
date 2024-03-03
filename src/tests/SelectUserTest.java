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
public class SelectUserTest {
    public static void main(String[] args) {
        User user = new UserFunctions().selectUserByEmail("lucas22@gmail.com");
        if (user == null) {
            System.out.println("Usuário não encontrado");
        }else{
            System.out.println(user.toString());
        }
    }
}
