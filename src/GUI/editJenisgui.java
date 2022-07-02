package GUI;

import Entity.JenisEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class editJenisgui extends component{
    int id_jenis,id_kategori;
    String namajenis;
    public editJenisgui(int id){
        initComponent(id);
    }
    void initComponent(final int id){
        for(JenisEntity jenis : allobjectcontroller.jenis.getById(id)){
            this.id_jenis = jenis.getId_jenis();
            this.namajenis = jenis.getNamajenis();
            this.id_kategori = jenis.getId_kategori();
        }

        setTitle("EDIT JENIS");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

        labelnamajenis.setBounds(25, 50, 150, 25);
        add(labelnamajenis);
        fieldnama.setBounds(160, 50, 130, 25);
        fieldnama.setText(namajenis);
        fieldnama.setEditable(false);
        add(fieldnama);

        labelidkategori.setBounds(25, 90, 150, 25);
        add(labelidkategori);
        fieldid_kategori.setBounds(160, 90, 130, 25);
        fieldid_kategori.setValue(id_kategori);
        fieldid_kategori.setEditable(false);
        add(fieldid_kategori);

        btneditnama.setBounds(320, 50, 130, 25);
        btneditidkategori.setBounds(320, 90, 130, 25);
        btnkategori.setBounds(320,130,130,25);

        add(btneditnama);
        add(btneditidkategori);
        add(btnkategori);

        btneditnama.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    String inputnama = JOptionPane.showInputDialog("Masukan NAMA JENIS Baru");
                    if(inputnama.length() > 0){
                        allobjectcontroller.jenis.updateDataStr(1,inputnama,id);
                        fieldnama.setText(inputnama);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });

        btneditidkategori.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    int id_kategori = Integer.parseInt(JOptionPane.showInputDialog("Masukan ID KATEGORI Baru"));
                    String cek = Integer.toString(id_kategori);
                    if(cek.length() > 0){
                        allobjectcontroller.jenis.updateDataint(2,id_kategori,id);
                        fieldharga.setValue(id_kategori);
                        System.out.println(id);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        btnkategori.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kategorigui kategori = new kategorigui();
            }
        });
    }

}
