/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Utils;

import Flipmotor.Entities.Fav;
import Flipmotor.Entities.Registeredclient;
import Flipmotor.Entities.Vehicleadvert;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Flipmotor.model.FavJpaController;
import Flipmotor.model.VehicleadvertJpaController;

/**
 *
 * @author root
 */
public class Common {
    
    public static int generateUserID(String email){
        
        String input = email;
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
    
    public static int generateFavID(Vehicleadvert vehicle, Registeredclient client){
        
        String input = "" + vehicle.getCode() + "" + client.getClientID();
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
    
    public static List<Vehicleadvert> getMotorbikes(){
        
        List<Vehicleadvert> query;
        List<Vehicleadvert> motorbikes = new ArrayList<Vehicleadvert>();
        
        VehicleadvertJpaController vehicleJPA = new VehicleadvertJpaController();
        
        query = vehicleJPA.findVehicleadvertEntities();
        
        for(Vehicleadvert i : query){
            if(i.getVehicle().equalsIgnoreCase("motorbike")){
                motorbikes.add(i);
            }
        }
        
        return motorbikes;
    }
    
    
    public static List<Vehicleadvert> getCars(){
        
        List<Vehicleadvert> query;
        List<Vehicleadvert> cars = new ArrayList<Vehicleadvert>();
        
        VehicleadvertJpaController vehicleJPA = new VehicleadvertJpaController();
        
        query = vehicleJPA.findVehicleadvertEntities();
        
        for(Vehicleadvert i : query){
            if(i.getVehicle().equalsIgnoreCase("car")){
                cars.add(i);
            }
        }
        
        return cars;
    }
 
    
     public static List<Vehicleadvert> getAllAdverts(){                        
        
        VehicleadvertJpaController vehicleJPA = new VehicleadvertJpaController();
        
        List<Vehicleadvert> query = vehicleJPA.findVehicleadvertEntities();      
        
        return query;
    }
     
     
    public static List<Vehicleadvert> getAdvertsByClient(int clientID){                        
        
         VehicleadvertJpaController vehicleJPA = new VehicleadvertJpaController();
         List<Vehicleadvert> ads = vehicleJPA.findVehicleadvertEntities();
         List<Vehicleadvert> userads = new ArrayList<Vehicleadvert>();

         for(Vehicleadvert i : ads){
             if(i.getClientID().getClientID() == clientID){
                 userads.add(i);
             }
         }
            return userads;
    }
    
    public static List<Fav> getAFavouritesByClient(int clientID){                        
       
         FavJpaController favJPA = new FavJpaController();
         List<Fav> favourites = favJPA.findFavEntities();
         List<Fav> userfavs = new ArrayList<Fav>();

         for(Fav i : favourites){
             if(i.getClientID().getClientID() == clientID){
                 userfavs.add(i);
             }
         }
            return userfavs;
    }

     
}
