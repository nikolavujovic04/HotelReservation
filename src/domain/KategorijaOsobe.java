/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nikola
 */
public class KategorijaOsobe implements OpstiDomenskiObjekat{
    private long id;
    private String tipOsobe;
    private double popust;

    public KategorijaOsobe() {
    }

    public KategorijaOsobe(long id, String tipOsobe, double popust) {
        this.id = id;
        this.tipOsobe = tipOsobe;
        this.popust = popust;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipOsobe() {
        return tipOsobe;
    }

    public void setTipOsobe(String tipOsobe) {
        this.tipOsobe = tipOsobe;
    }

    public double getPopust() {
        return popust;
    }

    public void setPopust(double popust) {
        this.popust = popust;
    }

    @Override
    public String toString() {
        return this.tipOsobe;
    }

    @Override
    public String nazivTabele() {
        return "kategorijaosobe";
    }

    @Override
    public String select() {
        return "ko.idKategorijaOsobe,ko.tipOsobe,ko.popust";
    }

    @Override
    public String alijas() {
        return "ko";
    }

    @Override
    public String koloneZaInsert() {
        return "(tipOsobe,popust)";
    }

    @Override
    public String vrednostiZaInsert() {
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public String uslov() {
    }

    @Override
    public OpstiDomenskiObjekat napuni(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
