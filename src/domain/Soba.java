/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nikola
 */
public class Soba implements OpstiDomenskiObjekat{
    private Long id;
    private String tipSobe;
    private Double cena;
    private int kolicina;

    public Soba() {
    }

    public Soba(Long id, String tipSobe, Double cena, int kolicina) {
        this.id = id;
        this.tipSobe = tipSobe;
        this.cena = cena;
        this.kolicina = kolicina;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipSobe() {
        return tipSobe;
    }

    public void setTipSobe(String tipSobe) {
        this.tipSobe = tipSobe;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    @Override
    public String toString() {
        return ""+this.tipSobe;
    }

    @Override
    public String nazivTabele() {
        return " soba";
    }

    @Override
    public String select() {
        return " tipSobe, cena, brojSoba";
    }

    @Override
    public String alijas() {
        return " s";
    }

    @Override
    public String koloneZaInsert() {
        return " (tipSobe, cena, brojSoba)";
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + tipSobe + "', " + cena + ", " + kolicina + "";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public String uslov() {
        return "";
    }

    @Override
    public String deleteUslov() {
        return "";
    }

    @Override
    public String updateVrednosti() {
        return "";
    }

    @Override
    public String updateUslov() {
        return "";
    }

    @Override
    public void popuniPreparedStatement(PreparedStatement ps) throws SQLException {
        
    }

    @Override
    public OpstiDomenskiObjekat napuni(ResultSet rs) throws SQLException {
        Soba s = new Soba();

        s.setId(rs.getLong("idSoba"));
        s.setTipSobe(rs.getString("tipSobe"));
        s.setCena(rs.getDouble("cena"));
        s.setKolicina(rs.getInt("brojSoba"));

        return s;
    }
    
    
}
