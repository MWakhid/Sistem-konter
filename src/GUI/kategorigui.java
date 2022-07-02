package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class kategorigui extends component{
    JTable tabelkategori = new JTable();
    JScrollPane spkategori = new JScrollPane(tabelkategori);

    public kategorigui(){
        initComponent();
    }

    void initComponent() {
        setTitle("Kategori");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);

        setLayout(null);
        setVisible(true);

        spkategori.setBounds(20, 50, 500, 350);
        tabelkategori.setModel(allobjectcontroller.kategori.daftarkategori());
        add(spkategori);

        btnbarang.setBounds(550,50,120,25);
        btnjenis.setBounds(550,90,120,25);
        btnback.setBounds(20,15,120,25);
        btnback.setBackground(Color.red);

        add(btnbarang);
        add(btnjenis);
        add(btnback);

        btnbarang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baranggui barang = new baranggui();
                dispose();
            }
        });

        btnjenis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jenisgui jenis = new jenisgui();
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

