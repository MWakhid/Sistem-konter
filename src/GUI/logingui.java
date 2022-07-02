package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class logingui extends component {

    public logingui(){
        initComponent();
    }

    void initComponent(){
        setTitle("Login");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,450);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

        labeljudul.setFont(new Font("Helvetica CY",Font.BOLD,20));
        labeljudul.setBounds(50, 30, 280, 50);
        add(labeljudul);
        labelusername.setBounds(30, 150, 140, 25);
        add(labelusername);
        fieldusername.setBounds(230, 150, 130, 25);
        add(fieldusername);

        labelpassword.setBounds(30, 190, 140, 25);
        add(labelpassword);
        fieldpassword.setBounds(230, 190, 130, 25);
        add(fieldpassword);

        btnlogin.setBounds(50, 250, 280, 50);
        btnlogin.setBackground(Color.black);
        btnlogin.setForeground(Color.white);
        btnlogin.setBorder(null);
        add(btnlogin);

        btnlogin.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                btnlogin.setForeground(Color.black);
                btnlogin.setBackground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnlogin.setForeground(Color.white);
                btnlogin.setBackground(Color.black);
            }
        });

        btnlogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String username = fieldusername.getText();
                String password = fieldpassword.getText();
                int cek = allobjectcontroller.login.login(username,password);
                if(cek > 0){
                    baranggui baranggui = new baranggui();
                    baranggui.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "AKUN TIDAK DITEMUKAN");
                    kosong();
                }
            }
        });
    }
}
