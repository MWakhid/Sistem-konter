package GUI;

import Entity.BarangEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class editBaranggui extends component{
    int id_barang, id_jenis,harga;
    String namabarang;
    public editBaranggui(int id){
        initComponent(id);
    }

    void initComponent(final int id){
        for(BarangEntity barang : allobjectcontroller.barang.getById(id)){
            this.id_barang = barang.getId_barang();
            this.id_jenis = barang.getId_jenis();
            this.namabarang = barang.getNamabarang();
            this.harga = barang.getHarga();
        }
        setTitle("EDIT BARANG");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

        labelnamabarang.setBounds(25, 50, 150, 25);
        add(labelnamabarang);
        fieldnama.setBounds(160, 50, 130, 25);
        fieldnama.setText(namabarang);
        fieldnama.setEditable(false);
        add(fieldnama);

        labelharga.setBounds(25, 90, 150, 25);
        add(labelharga);
        fieldharga.setBounds(160, 90, 130, 25);
        fieldharga.setValue(harga);
        fieldharga.setEditable(false);
        add(fieldharga);

        labelidjenis.setBounds(25, 130, 150, 25);
        add(labelidjenis);
        fieldid_jenis.setBounds(160, 130, 130, 25);
        fieldid_jenis.setValue(id_jenis);
        fieldid_jenis.setEditable(false);
        add(fieldid_jenis);

        btneditnama.setBounds(320, 50, 130, 25);
        btneditharga.setBounds(320, 90, 130, 25);
        btneditidjenis.setBounds(320, 130, 130, 25);
        btnjenis.setBounds(320,170,130,25);

        add(btneditnama);
        add(btneditharga);
        add(btneditidjenis);
        add(btnjenis);

        btneditnama.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    String inputnama = JOptionPane.showInputDialog("Masukan NAMA BARANG Baru");
                    if(inputnama.length() > 0){
                        allobjectcontroller.barang.updateDataStr(1,inputnama,id);
                        fieldnama.setText(inputnama);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        btneditharga.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    int harga = Integer.parseInt(JOptionPane.showInputDialog("Masukan HARGA BARANG Baru"));
                    String cek = Integer.toString(id_barang);
                    if(cek.length() > 0){
                        allobjectcontroller.barang.updateDataint(2,harga,id);
                        fieldharga.setValue(harga);
                        System.out.println(id);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });

        btneditidjenis.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    int id_jenis = Integer.parseInt(JOptionPane.showInputDialog("Masukan HARGA BARANG Baru"));
                    String cek = Integer.toString(id_jenis);
                    if(cek.length() > 0){
                        allobjectcontroller.barang.updateDataint(3,id_jenis,id);
                        fieldid_jenis.setValue(id_jenis);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        btnjenis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jenisgui jenis = new jenisgui();
            }
        });
    }

}
