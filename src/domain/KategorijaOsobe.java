/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Nikola
 */
public class KategorijaOsobe {
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

    public void setId(int id) {
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
    
    
}
