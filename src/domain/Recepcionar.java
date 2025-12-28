/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Nikola
 */
public class Recepcionar implements OpstiDomenskiObjekat{
    private long idRecepcionar;
    private String ime;
    private String prezime;
    private String jmbg;
    private String korisnickoIme;
    private String sifra;
    private String brojTelefona;

    public Recepcionar() {
    }

    public Recepcionar(long idRecepcionar, String ime, String prezime, String jmbg, String korisnickoIme, String sifra, String brojTelefona) {
        this.idRecepcionar = idRecepcionar;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
        this.brojTelefona = brojTelefona;
    }

    public long getIdRecepcionar() {
        return idRecepcionar;
    }

    public void setIdRecepcionar(long idRecepcionar) {
        this.idRecepcionar = idRecepcionar;
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

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    @Override
    public String toString() {
        return this.ime+" "+this.prezime;
    }

    @Override
    public String nazivTabele() {
        return "recepcionar"
    }

    @Override
    public String select() {
        return " rc.ime,rc.prezime,rc.jmbg,rc.korisnickoIme,rc.sifra,rc.brojTelefona";
    }

    @Override
    public String alijas() {
        return "rc";
    }

    @Override
    public String koloneZaInsert() {
        return " (ime,prezime,jmbg,korisnickoIme,sifra,brojTelefona)";
    }

    @Override
    public String vrednostiZaInsert() {
        
    }

    @Override
    public String join() {
        return " JOIN rezervacija r ON rc.idRecepcionar=r.idRecepcionar JOIN recepcionartermindezurstva rtd ON rtd.idRecepcionar=rc.idRecepcionar";
    }

    @Override
    public String uslov() {
    }
    
    
}
