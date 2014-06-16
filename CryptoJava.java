package cryptojava;


import cryptojava.CryptoAlgorithm;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *
package cryptojava;

/**
 *
 * @author ghost
 */
public class CryptoJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CryptoAlgorithm crypto = new CryptoAlgorithm();        
         
        String originalString = "My name is Yeremy";
        String key = "yeremy";
        
        //Encryption
        String encryptedStr = crypto.encrypt(originalString, key);
        System.out.println(encryptedStr);
        
        
        //Decryption
        String decryptedStr = crypto.decrypt(encryptedStr, key);
        System.out.println(decryptedStr);
    }
}
