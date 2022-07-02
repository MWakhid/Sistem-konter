package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class transaksigui extends component {
    JTable tabeltransaksi = new JTable();
    JScrollPane sptransaksi = new JScrollPane(tabeltransaksi);

    public transaksigui() {
        initComponent();
    }

    void initComponent() {
        setTitle("Transaksi");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1200, 480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);

        setLayout(null);
        setVisible(true);

        sptransaksi.setBounds(20, 50, 1000, 350);
        tabeltransaksi.setModel(allobjectcontroller.transaksi.daftartransaksi());
        add(sptransaksi);

        detailtx.setBounds(1050,50,120,25);
        add(detailtx);

        detailtx.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id_transaksi = Integer.parseInt(JOptionPane.showInputDialog("ID TRANSAKSI:"));
                    String cek = Integer.toString(id_transaksi);

                        detailtransaksigui gui = new detailtransaksigui(id_transaksi);
                        gui.setVisible(true);

                } catch (Exception ex) {
                }
            }
        });
    }
}
