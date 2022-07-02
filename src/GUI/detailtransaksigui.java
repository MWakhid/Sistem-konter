package GUI;

import javax.swing.*;
import java.awt.*;

public class detailtransaksigui extends component{
    JTable tabeltransaksi = new JTable();
    JScrollPane sptransaksi = new JScrollPane(tabeltransaksi);
    public detailtransaksigui(int id) {
        initComponent(id);
    }

    void initComponent(final int id) {
        setTitle("Detail Transaksi");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1200, 480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);

        setLayout(null);
        setVisible(true);

        sptransaksi.setBounds(20, 50, 1000, 350);
        tabeltransaksi.setModel(allobjectcontroller.transaksi.detailtransaksi(id));
        add(sptransaksi);


    }
}
