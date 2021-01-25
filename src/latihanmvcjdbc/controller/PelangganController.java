/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanmvcjdbc.controller;

import javax.swing.JOptionPane;
import latihanmvcjdbc.entity.Pelanggan;
import latihanmvcjdbc.model.PelangganModel;
import latihanmvcjdbc.view.PelangganView;

/**
 *
 * @author 
 *  Nama    : Reihan Wiyanda
 *  Kelas   : IF-1  
 *  Nim     : 10119011
 */
public class PelangganController {
    
    private PelangganModel model;

    public void setModel(PelangganModel model) {
        this.model = model;
    }
    
    public void resetPelanggan (PelangganView view) {
        model.resetPelanggan();
    }
    
    public void insertPelanggan (PelangganView view) {
        String nama = view.getTxtNama().getText();
        String alamat = view.getTxtAlamat().getText();
        String telepon = view.getTxtTelepon().getText();
        String email = view.getTxtEmail().getText();
        
        if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh kosong");
        }else if (nama.length()>255) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh lebih dari 255 karakter");
        }else if (telepon.length()>13) {
            JOptionPane.showMessageDialog(view, "Telepon tidak boleh lebih dari 13 digit");
        }else if (!email.contains("@")|| !email.contains(".")) {
            JOptionPane.showMessageDialog(view, "Email tidak valid");
        }else 
            model.getNama();
            model.getAlamat();
            model.getTelepon();
            model.getEmail();
            
            try {
                model.insertPelanggan();
                JOptionPane.showMessageDialog(view, "Pelanggan Berhasil Ditambahkan");
                model.resetPelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[] {"Terjadi error di database dengan pesan", throwable.getMessage()});
            }
        }
    public void updatePelanggan (PelangganView view) {
        
        if (view.getTablePelanggan().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan Seleksi baris data yang akan diubah");
            return;
        }
        
        Integer id = Integer.parseInt(view.getTxtId().getText());
        
        String nama = view.getTxtNama().getText();
        String alamat = view.getTxtAlamat().getText();
        String telepon = view.getTxtTelepon().getText();
        String email = view.getTxtEmail().getText();
        
        if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh kosong");
        }else if (nama.length()>255) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh lebih dari 255 karakter");
        }else if (telepon.length()>13) {
            JOptionPane.showMessageDialog(view, "Telepon tidak boleh lebih dari 13 digit");
        }else if (!email.contains("@")|| !email.contains(".")) {
            JOptionPane.showMessageDialog(view, "Email tidak valid");
        }else
            model.getId();
            model.getNama();
            model.getAlamat();
            model.getTelepon();
            model.getEmail();
            
            try {
                model.updatePelanggan();
                JOptionPane.showMessageDialog(view, "Pelanggan Berhasil Di ubah");
                model.resetPelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[] {"Terjadi error di database dengan pesan", throwable.getMessage()});
            }
        }
    
    public void deletePelanggan (PelangganView view) {
        if (view.getTablePelanggan().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan Seleksi baris data yang akan diubah");
            return;
        }
        
        if (JOptionPane.showConfirmDialog(view, "Apa anda yakin akan menghapus?")==JOptionPane.OK_OPTION) {
            Integer id = Integer.parseInt(view.getTxtId().getText());
            model.setId(id);
            
            try {
                model.deletePelanggan();
                JOptionPane.showMessageDialog(view, "Data Pelanggan Berhasil Di Hapus");
                model.resetPelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                    "Terjadi error di database dengan pesan ", throwable.getMessage()
                });
            }
        }
    
    }
}

     

