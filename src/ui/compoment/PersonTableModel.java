/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.compoment;

import domain.KategorijaOsobe;
import domain.Osoba;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nikola
 */
public class PersonTableModel extends AbstractTableModel{
    private final List<Osoba> osobe;
    private String[] columns = {"Ime","Prezime","Email","Broj telefona","Kategorija"};
    private Class[] classes = {String.class, String.class, String.class, String.class, KategorijaOsobe.class};
    
    public PersonTableModel(List<Osoba> osobe){
        this.osobe = osobe;
    }

    @Override
    public int getRowCount() {
        if(osobe == null){
            return 0;
        }
        return osobe.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Osoba osoba = osobe.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return osoba.getIme();
            case 2:
                return osoba.getPrezime();
            case 3:
                return osoba.getEmail();
            case 4:
                return osoba.getBrojTelefona();
            case 5:
                return osoba.getKategorija().toString();
            default:
                return "n/a";
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Osoba osoba = osobe.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                osoba.setIme(aValue.toString());
            case 1:
                osoba.setPrezime(aValue.toString());
            case 2:
                osoba.setEmail(aValue.toString());
            case 3:
                osoba.setBrojTelefona(aValue.toString());
            case 4:
                osoba.setKategorija((KategorijaOsobe) aValue);
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return classes[columnIndex];
    }

    public Osoba getTranslates(int rowIndex) {
        return osobe.get(rowIndex);
    }
}
