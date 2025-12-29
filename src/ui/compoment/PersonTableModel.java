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
    private String[] columns = {"Ime i prezime","Email","Broj telefona","Kategorija"};
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
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Osoba osoba = osobe.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return osoba.getImePrezime();
            case 1:
                return osoba.getEmail();
            case 2:
                return osoba.getBrojTelefona();
            case 3:
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
                osoba.setImePrezime(aValue.toString());
            case 1:
                osoba.setEmail(aValue.toString());
            case 2:
                osoba.setBrojTelefona(aValue.toString());
            case 3:
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
