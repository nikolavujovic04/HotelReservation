/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Nikola
 */
public class Osoba implements OpstiDomenskiObjekat{
    private long id;
    private String ime;
    private String prezime;
    private String email;
    private String brojTelefona;
    private KategorijaOsobe kategorija;

    public Osoba() {
    }

    public Osoba(long id, String ime, String prezime, String email, String brojTelefona, KategorijaOsobe kategorija) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.brojTelefona = brojTelefona;
        this.kategorija = kategorija;
    }

    public Osoba(String ime, String prezime, String email, String brojTelefona, KategorijaOsobe kategorija) {
        this.ime = ime;
        this.prezime = prezime;
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

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
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
        return this.ime+" "+this.prezime;
    }

    @Override
    public String nazivTabele() {
        return "osoba";
    }

    @Override
    public String select() {
        return "o.ime, o.prezime, o.email, o.brojTelefona, o.idKategorijaOsobe";
    }

    @Override
    public String join() {
        return " JOIN kategorijaosobe ko ON o.idKategorijaOsobe=ko.idKategorijaOsobe";
    }

    @Override
    public String uslov() {
        String uslov="";
        if (ime != null && !ime.isEmpty()) {
            uslov += " AND o.ime LIKE '%" + ime + "%'";
        }       

        if (kategorija != null) {
            uslov += " AND o.idKategorijaOsobe = " + kategorija.getId();
        }

        return uslov;
    }

    @Override
    public String koloneZaInsert() {
        return "(ime,prezime,email,brojTelefona,idKategorijaOsobe)";
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + ime + "', '" + prezime + "', '" + email + "', '" +
           brojTelefona + "', " + kategorija.getId();
    }

    @Override
    public String alijas() {
        return " o";
    }
    
    
}
