package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class jenisgui extends component{
    JTable tabeljenis = new JTable();
    JScrollPane spjenis = new JScrollPane(tabeljenis);


    public jenisgui(){
        initComponent();
    }

    void initComponent() {
        setTitle("Jenis");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);

        setLayout(null);
        setVisible(true);

        spjenis.setBounds(20, 50, 500, 350);
        tabeljenis.setModel(allobjectcontroller.jenis.daftarjenis());
        add(spjenis);

        btntambah.setBounds(550,50,120,25);
        btneditjenis.setBounds(550,90,120,25);
        btnbarang.setBounds(550,130,120,25);
        btnkategori.setBounds(550,170,120,25);
        btnrefresh.setBounds(550,350, 120, 25);
        btnrefresh.setBorder(null);
        btnrefresh.setBackground(Color.white);
        btnback.setBounds(20,15,120,25);
        btnback.setBackground(Color.red);

        add(btntambah);
        add(btneditjenis);
        add(btnbarang);
        add(btnkategori);
        add(btnrefresh);
        add(btnback);

        btntambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String namajenis = JOptionPane.showInputDialog("Nama : ");
                    int id_kategori = Integer.parseInt(JOptionPane.showInputDialog("id kategori : "));
                    if (namajenis.length() != 0) {
                        allobjectcontroller.jenis.insert(namajenis,id_kategori);
                        JOptionPane.showMessageDialog(null, "Data ditambahkan");
                        dispose();
                        initComponent();
                    } else {
                        JOptionPane.showMessageDialog(null, "Nama Tidak Boleh Kosong");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Dibatalkan");
                }
            }
        });
        btneditjenis.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id_jenis = Integer.parseInt(JOptionPane.showInputDialog("ID JENIS:"));
                    String cek = Integer.toString(id_jenis);
                    if (cek.length()>0) {
                        editJenisgui editjenis = new editJenisgui(id_jenis);
                        editjenis.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "ID TIDAK BOLEH KOSONG");

                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Dibatalkan");
                }
            }
        });
        btnbarang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baranggui barang = new baranggui();
                dispose();
            }
        });

        btnkategori.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kategorigui kategori = new kategorigui();
                dispose();
            }
        });

        btnrefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jenisgui gui = new jenisgui();
                dispose();
            }
        });

        btnback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logingui gui = new logingui();
                dispose();
            }
        });
    }
}
