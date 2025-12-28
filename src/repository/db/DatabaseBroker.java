/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db;
import domain.KategorijaOsobe;
import domain.OpstiDomenskiObjekat;
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
    
    public boolean kreiraj(OpstiDomenskiObjekat odo){
        try{
            String query = "INSERT INTO "+odo.nazivTabele()+" "+odo.koloneZaInsert()+" VALUES ("+odo.vrednostiZaInsert()+")";
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(query);
            return true;
        }
        catch(SQLException ex){
            System.out.println("Doslo je do greske. "+ex.getMessage());
        }
        return false;
    }
    
    public List<Osoba> returnPersons(){
        
        try{
            String query = "SELECT * FROM osoba";
        
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            List<Osoba> osobe = new ArrayList<>();
            while(rs.next()){
                KategorijaOsobe kategorija = new KategorijaOsobe();
                kategorija.setId(rs.getLong("idKategorijaOsobe"));
                Osoba osoba = new Osoba(rs.getLong("idOsoba"), rs.getString("ime"), rs.getString("prezime"), rs.getString("email"), rs.getString("brojTelefona"), kategorija);
                osobe.add(osoba);
            }
            
            return osobe;
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
    
    public boolean postojiBrojIliEmail(String brojTelefona, String email) {
        String query = "SELECT 1 FROM osoba WHERE brojTelefona = ? OR email = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(query);
        
            ps.setString(1, brojTelefona);
            ps.setString(2, email);
            
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            System.out.println("Doslo je do greske: " + ex.getMessage());
        }

        return false;
    }
    
    public void insertPerson(Osoba osoba) {
        String query = "INSERT INTO osoba(ime, prezime, email, brojTelefona, idKategorijaOsobe) VALUES (?,?,?,?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, osoba.getIme());
            ps.setString(2, osoba.getPrezime());
            ps.setString(3, osoba.getEmail());
            ps.setString(4, osoba.getBrojTelefona());
            ps.setLong(5, osoba.getKategorija().getId());

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Osoba je uspešno dodata u bazu!");
            }

        } catch (SQLException ex) {
            System.out.println("Doslo je do greske pri unosu: " + ex.getMessage());
        }
    }
    
    public List<Osoba> findPersons(Osoba osoba){
        String query = "SELECT o.ime,o.prezime,o.email,o.brojTelefona,ko.tipOsobe "
                + " FROM osoba o JOIN kategorijaosobe ko ON o.idKategorijeOsobe=ko.idKategorijeOsobe"
                + " WHERE o.ime LIKE ? AND o.idKategorijaOsobe=?";
        try{
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "%" + osoba.getIme() + "%");
            ps.setLong(2, osoba.getKategorija().getId());

            ResultSet rs = ps.executeQuery();
            List<Osoba> osobe = new ArrayList<>();

            while (rs.next()) {
                Osoba o = new Osoba();
                o.setIme(rs.getString("ime"));
                o.setPrezime(rs.getString("prezime"));
                o.setEmail(rs.getString("email"));
                o.setBrojTelefona(rs.getString("brojTelefona"));

                KategorijaOsobe ko = new KategorijaOsobe();
                ko.setTipOsobe(rs.getString("tipOsobe"));
                ko.setId(rs.getLong("idKategorijaOsobe"));
                o.setKategorija(ko);

                osobe.add(o);
            }
            
            return osobe;
            
        }
        catch(SQLException ex){
            System.out.println("Doslo je do greske. "+ex.getMessage());
        }
        return null;
    }
}
