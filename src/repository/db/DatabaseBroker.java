/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db;
import domain.KategorijaOsobe;
import domain.Osoba;
import domain.Recepcionar;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nikola
 */
public class DatabaseBroker {
    Connection connection;
    
    public void connect(){
        try{
            String url = "jdbc:mysql://localhost:3306/hotel";
            String root="root";
            String pass="";
            
            connection = DriverManager.getConnection(url, root, pass);
        }
        catch(SQLException ex){
            System.out.println("Doslo je do greske. "+ex.getMessage());
        }
    }
    
    public Recepcionar login(Recepcionar recepcionar,int idSmene){
        String query =
        "SELECT r.*, td.opis " +
        "FROM recepcionar r " +
        "JOIN recepcionartermindezurstva rtd ON r.idRecepcionar = rtd.idRecepcionar " +
        "JOIN termindezurstva td ON td.idTerminDezurstva = rtd.idTerminDezurstva " +
        "WHERE r.korisnickoIme = ? " +
        "AND r.sifra = ? " +
        "AND rtd.datumDezurstva = ? " +
        "AND td.idTerminDezurstva = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, recepcionar.getKorisnickoIme());
            ps.setString(2, recepcionar.getSifra());
            ps.setDate(3, Date.valueOf(LocalDate.now()));
            ps.setInt(4, idSmene);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                Recepcionar loged = new Recepcionar();
                loged.setIdRecepcionar(rs.getLong("idRecepcionar"));
                loged.setIme(rs.getString("ime"));
                loged.setPrezime(rs.getString("prezime"));
                loged.setKorisnickoIme(rs.getString("korisnickoIme"));
                loged.setSifra(rs.getString("sifra"));
                loged.setJmbg(rs.getString("jmbg"));
                loged.setBrojTelefona(rs.getString("brojTelefona"));
                
                rs.close();
                ps.close();
                return loged;
            }
        }
        catch(SQLException ex){
            System.out.println("Doslo je do greske. "+ex.getMessage());
        }
        return null;
    }
    
    public List<KategorijaOsobe> returnCategories(){
        try{
            String query = "SELECT * FROM kategorijaosobe";
            Statement statement = connection.createStatement();
            
            ResultSet rs = statement.executeQuery(query);
            List<KategorijaOsobe> kategorije = new ArrayList<>();
            while(rs.next()){
                KategorijaOsobe kategorija = new KategorijaOsobe( rs.getLong("idKategorijaOsobe"), rs.getString("tipOsobe"), rs.getDouble("popust"));
                kategorije.add(kategorija);
            }
            return kategorije;
        }
        catch(SQLException ex){
            System.out.println("Doslo je do greske. "+ex.getMessage());
        }
        
        return null;
    }
    
}
