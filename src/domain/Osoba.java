/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import logic.Controller;

/**
 *
 * @author Nikola
 */
public class Osoba implements OpstiDomenskiObjekat{
    
    private long id;
    private String imePrezime;
    private String email;
    private String brojTelefona;
    private KategorijaOsobe kategorija;

    public Osoba() {
    }

    public Osoba(long id, String imePrezime, String email, String brojTelefona, KategorijaOsobe kategorija) {
        this.id = id;
        this.imePrezime = imePrezime;
        this.email = email;
        this.brojTelefona = brojTelefona;
        this.kategorija = kategorija;
    }

    public Osoba(String imePrezime, String email, String brojTelefona, KategorijaOsobe kategorija) {
        this.imePrezime = imePrezime;
        this.email = email;
        this.brojTelefona = brojTelefona;
        this.kategorija = kategorija;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public KategorijaOsobe getKategorija() {
        return kategorija;
    }

    public void setKategorija(KategorijaOsobe kategorija) {
        this.kategorija = kategorija;
    }

    @Override
    public String toString() {
        return this.imePrezime;
    }

    @Override
    public String nazivTabele() {
        return "osoba";
    }

    @Override
    public String select() {
        return "o.idOsoba, o.imePrezime, o.email, o.brojTelefona, o.idKategorijaOsobe, ko.TipOsobe";
    }

    @Override
    public String join() {
        return " JOIN kategorijaosobe ko ON o.idKategorijaOsobe=ko.idKategorijaOsobe";
    }

    @Override
    public String koloneZaInsert() {
        return "(imePrezime,email,brojTelefona,idKategorijaOsobe)";
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + imePrezime + "', '" + email + "', '" +
               brojTelefona + "', " + kategorija.getId();
    }

    @Override
    public String alijas() {
        return " o";
    }

    @Override
    public OpstiDomenskiObjekat napuni(ResultSet rs) throws SQLException {
        Osoba osoba = new Osoba();
        osoba.setId(rs.getLong("idOsoba"));
        osoba.setImePrezime(rs.getString("imePrezime"));
        osoba.setEmail(rs.getString("email"));
        osoba.setBrojTelefona(rs.getString("brojTelefona"));

        KategorijaOsobe k = new KategorijaOsobe();
        k.setId(rs.getInt("idKategorijaOsobe"));
        k.setTipOsobe(rs.getString("TipOsobe"));
        osoba.setKategorija(k);

        return osoba;
    }

    @Override
    public String uslov() {
        String uslov = "";

        boolean imaImePrezime = imePrezime != null && !imePrezime.isEmpty();
        boolean imaKategoriju = kategorija != null && kategorija.getId() > -1;

        if (imaImePrezime) {
            uslov += " o.imePrezime LIKE '%" + imePrezime + "%'";
        }

        if (imaKategoriju) {
            if (!uslov.isEmpty()) {
                uslov += " AND ";
            }
            uslov += " o.idKategorijaOsobe = " + kategorija.getId();
        }

        return uslov;
    }
    
    public List<Osoba> konvertovanje(List<OpstiDomenskiObjekat> osobe){
        List<Osoba> listaOsoba = new ArrayList<>();
        for (OpstiDomenskiObjekat odo : osobe) {
            listaOsoba.add((Osoba) odo);
        }
        
        return listaOsoba;
    }

    @Override
    public String deleteUslov() {
        return " WHERE idOsoba = "+id;
    }
    
    
}
