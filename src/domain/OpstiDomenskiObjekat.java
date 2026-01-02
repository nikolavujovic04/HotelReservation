/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.*;

/**
 *
 * @author Nikola
 */
public interface OpstiDomenskiObjekat {
    String nazivTabele();
    String select();
    String alijas();
    String koloneZaInsert();
    String vrednostiZaInsert();
    String join();
    String uslov();
    String deleteUslov();
    String updateVrednosti();
    String updateUslov();
    void popuniPreparedStatement(PreparedStatement ps) throws SQLException;
    OpstiDomenskiObjekat napuni(ResultSet rs) throws SQLException;
}
