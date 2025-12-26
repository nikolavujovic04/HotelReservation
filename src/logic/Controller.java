/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import domain.KategorijaOsobe;
import domain.Recepcionar;
import repository.db.DatabaseBroker;
import java.sql.*;
import java.util.List;

/**
 *
 * @author Nikola
 */
public class Controller {
    DatabaseBroker dbbr;

    public Controller() {
        dbbr = new DatabaseBroker();
    }
    
    public Recepcionar getLoged(Recepcionar recepcionar, int idSmene){
        try{
            dbbr.connect();
        }
        catch(Exception ex){
            System.out.println("Doslo je do greske. "+ex.getMessage());
        }
        
        try{
            Recepcionar loged = dbbr.login(recepcionar, idSmene);
            return loged;
        }
        catch(Exception ex){
            System.out.println("Doslo je do greske. "+ex.getMessage());
        }
        return null;
    }
    
    public List<KategorijaOsobe> getAllCategories(){
        try{
            dbbr.connect();           
        }
        catch(Exception ex){
            System.out.println("Doslo je do greske. "+ex.getMessage());
        }
        
        try{
            List<KategorijaOsobe> kategorije = dbbr.returnCategories();
            return kategorije;
        }
        catch(Exception ex){
            System.out.println("Doslo je do greske. "+ex.getMessage());
        }
        return null;
    }
    
}
