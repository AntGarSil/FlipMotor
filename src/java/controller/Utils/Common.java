/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class Common {
    
    public static int generateUserID(String email, String password){
        
        String input = email.concat(password);
        int key = 0;
        try {
            byte[] idbytes = input.getBytes();            
            
            StringBuffer hashString = new StringBuffer();
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            
            //Hash id to obtain PK
            md.reset();
            md.update(idbytes);
            byte[] hash = md.digest();
            
            for(int i = 0; i < hash.length; i++){
                hashString.append(0xFF & hash[i]);
            }
            
            String stringres = hashString.toString().substring(0, 18);
            key = (int) Long.parseLong(stringres) % 2147483647;
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Common.class.getName()).log(Level.SEVERE, null, ex);
        }
        return key;
    }
}
