/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanmvcjdbc.main;

import java.sql.SQLException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import latihanmvcjdbc.database.KingBarbershopDatabase;
import latihanmvcjdbc.entity.Pelanggan;
import latihanmvcjdbc.error.PelangganException;
import latihanmvcjdbc.service.PelangganDao;
import latihanmvcjdbc.view.MainViewPelanggan;

/**
 *
 * @author 
 * Nama     : Reihan Wiyanda
 * Kelas    : IF-1
 * Nim      : 10119011
 */
public class LatihanMVCJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, PelangganException {
        // TODO code application logic here
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MainViewPelanggan pelanggan = new MainViewPelanggan ();
                    pelanggan.loadDatabase();
                    pelanggan.setVisible(true);
                } catch (SQLException e) {
                } catch (PelangganException ex) {
                    Logger.getLogger(LatihanMVCJDBC.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }); 
    
    }
}
