package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class baranggui extends component{
    JTable tabelbarang = new JTable();
    JScrollPane spbarang = new JScrollPane(tabelbarang);


    public baranggui(){
        initComponent();
    }

    void initComponent() {
        setTitle("Barang");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);

        setLayout(null);
        setVisible(true);

        spbarang.setBounds(20, 50, 500, 350);
        tabelbarang.setModel(allobjectcontroller.barang.daftarbarang());
        add(spbarang);

        btntambah.setBounds(550,50,120,25);
        btneditbarang.setBounds(550,90,120,25);
        btnjenis.setBounds(550,130,120,25);
        btntransaksi.setBounds(550,170,120,25);
        btnrefresh.setBounds(550,350, 130, 25);
        btnrefresh.setBorder(null);
        btnrefresh.setBackground(Color.white);
        btnback.setBounds(20,15,120,25);
        btnback.setBackground(Color.red);

        add(btntambah);
        add(btneditbarang);
        add(btnjenis);
        add(btntransaksi);
        add(btnrefresh);
        add(btnback);

        btntambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String namabarang = JOptionPane.showInputDialog("Nama : ");
                    int harga = Integer.parseInt(JOptionPane.showInputDialog("Harga : "));
                    int id_jenis = Integer.parseInt(JOptionPane.showInputDialog("id jenis : "));
                    if (namabarang.length() != 0) {
                        allobjectcontroller.barang.insert(namabarang, harga, id_jenis);
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

        btneditbarang.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id_barang = Integer.parseInt(JOptionPane.showInputDialog("ID BARANG:"));
                    String cek = Integer.toString(id_barang);
                    if (cek.length()>0) {
                        editBaranggui editbarang = new editBaranggui(id_barang);
                        editbarang.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "ID TIDAK BOLEH KOSONG");

                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Dibatalkan");
                }
            }
        });

        btnjenis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jenisgui gui = new jenisgui();
                dispose();
            }
        });

        btntransaksi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transaksigui gui = new transaksigui();
            }
        });

        btnrefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                baranggui barang = new baranggui();
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
