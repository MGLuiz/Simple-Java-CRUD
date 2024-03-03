/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functions;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author luizm
 */
public class HashFactory {
    public String getSHA256Hash(String text){
        return Hashing.sha256().hashString(text, StandardCharsets.UTF_8).toString();
    }
}
