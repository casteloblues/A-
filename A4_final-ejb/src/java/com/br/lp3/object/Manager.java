/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.object;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author 31240550
 */
@Stateless
public class Manager implements ManagerLocal {

    private static final String urlbase = "http://pedrocacique.com/lp3/getAllPets/";
    
    public List<Dog> teste() {
        List<Dog> lista = new ArrayList<>();
        
        URL url;
        
        try {
            url = new URL(urlbase);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            conn.disconnect();
            lista = JSONParser.parse(sb.toString());
        } catch (MalformedURLException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
     public static String MD5(String md5) {
        try {
             java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
             byte[] array = md.digest(md5.getBytes());
             StringBuffer sb = new StringBuffer();
             for (int i = 0; i < array.length; ++i) {
               sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
             return sb.toString();
         } catch (java.security.NoSuchAlgorithmException e) {
         }
         return null;
    }
}
