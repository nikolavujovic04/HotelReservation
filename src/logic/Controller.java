/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import domain.KategorijaOsobe;
import domain.OpstiDomenskiObjekat;
import domain.Osoba;
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
    
    public List<Osoba> getAllPersons(){
        
        try{
            dbbr.connect();           
        }
        catch(Exception ex){
            System.out.println("Doslo je do greske. "+ex.getMessage());
        }  
        try{
            List<Osoba> osobe = dbbr.returnPersons();
            return osobe;
        }
        catch(Exception ex){
            System.out.println("Doslo je do greske. "+ex.getMessage());
        }
        return null;
    }
    
    public boolean postojiTelEmail(String brojTelefona, String email){
        try{
            dbbr.connect();           
        }
        catch(Exception ex){
            System.out.println("Doslo je do greske. "+ex.getMessage());
        }  
        try{
            boolean postoji = dbbr.postojiBrojIliEmail(brojTelefona, email);
        }
        catch(Exception ex){
            System.out.println("Doslo je do greske. "+ex.getMessage());
        }
        return false;
    }
    
    public void fillPerson(Osoba osoba){
        try{
            dbbr.connect();           
        }
        catch(Exception ex){
            System.out.println("Doslo je do greske. "+ex.getMessage());
        }  
        try{
            dbbr.insertPerson(osoba);
        }
        catch(Exception ex){
            System.out.println("Doslo je do greske. "+ex.getMessage());
        }
    }
    
    public List<Osoba> pretraziOsoba(Osoba osoba){
        try{
            dbbr.connect();           
        }
        catch(Exception ex){
            System.out.println("Doslo je do greske. "+ex.getMessage());
        }  
        try{
            List<Osoba> osobe = dbbr.returnPersons();
            return osobe;
        }
        catch(Exception ex){
            System.out.println("Doslo je do greske. "+ex.getMessage());
        }
        return null;
    }
    
    public boolean kreiraj(OpstiDomenskiObjekat odo){
        try{
            dbbr.connect();           
        }
        catch(Exception ex){
            System.out.println("Doslo je do greske. "+ex.getMessage());
        }  
        try{
            boolean rezultat = dbbr.kreiraj(odo);
            return rezultat;
        }
        catch(Exception ex){
            System.out.println("Doslo je do greske. "+ex.getMessage());
        }
        return false;
    }
    
    public List<OpstiDomenskiObjekat> pretrazi(OpstiDomenskiObjekat odo){
        try{
            dbbr.connect();           
        }
        catch(Exception ex){
            System.out.println("Doslo je do greske. "+ex.getMessage());
        }  
        try{
            List<OpstiDomenskiObjekat> objekat = dbbr.pretrazi(odo);
            return objekat;
        }
        catch(Exception ex){
            System.out.println("Doslo je do greske. "+ex.getMessage());
        }
        return null;
    }
    
    public List<OpstiDomenskiObjekat> vrati(OpstiDomenskiObjekat odo){
        try{
            dbbr.connect();           
        }
        catch(Exception ex){
            System.out.println("Doslo je do greske. "+ex.getMessage());
        }  
        try{
            List<OpstiDomenskiObjekat> objekti = dbbr.vrati(odo);
            return objekti;
        }
        catch(Exception ex){
            System.out.println("Doslo je do greske. "+ex.getMessage());
        }
        return null;
    }
    
}
