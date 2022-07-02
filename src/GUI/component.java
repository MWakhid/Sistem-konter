package GUI;

import javax.swing.*;

public class component extends JFrame {

    protected JButton btnlogin = new JButton("LOG IN");
    protected JButton btnback = new JButton("<< LOG OUT");
    protected JButton btntambah = new JButton("TAMBAH DATA");
    protected JButton btneditbarang = new JButton("EDIT BARANG");
    protected JButton btneditnama = new JButton("EDIT NAMA");
    protected JButton btneditharga = new JButton("EDIT HARGA");
    protected JButton btneditidjenis = new JButton("EDIT ID JENIS");
    protected JButton btneditjenis = new JButton("EDIT JENIS");
    protected JButton btneditidkategori = new JButton("EDIT KATEGORI");
    protected JButton btnrefresh = new JButton("REFRESH");
    protected JButton btnbarang = new JButton("BUKA BARANG");
    protected JButton btnjenis = new JButton("BUKA JENIS");
    protected JButton btnkategori = new JButton("BUKA KATEGORI");
    protected JButton btntransaksi = new JButton("BUKA TRANSAKSI");
    protected JButton detailtx = new JButton("DETAIL");

    protected JLabel labeljudul = new JLabel("LOGIN KONTER");
    protected JLabel labelusername = new JLabel("USERNAME");
    protected JLabel labelidjenis = new JLabel("ID JENIS");
    protected JLabel labelharga = new JLabel("HARGA");
    protected JLabel labelnamabarang = new JLabel("NAMA BARANG");
    protected JLabel labelpassword = new JLabel("PASSWORD");
    protected JLabel labelnamajenis = new JLabel("NAMA JENIS");
    protected JLabel labelidkategori = new JLabel("ID KATEGORI");

    protected JTextField fieldusername = new JTextField();
    protected JTextField fieldid= new JTextField();
    protected JTextField fieldnama = new JTextField();
    protected JFormattedTextField fieldharga = new JFormattedTextField();
    protected JFormattedTextField fieldid_jenis = new JFormattedTextField();
    protected JPasswordField fieldpassword = new JPasswordField();
    protected JFormattedTextField fieldid_kategori = new JFormattedTextField();

    void kosong(){
        fieldusername.setText(null);
        fieldpassword.setText(null);
    }
}