package Model;

import Entity.BarangEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BarangModel extends ModelAbstract{
    private String sql;
    public ArrayList<BarangEntity> getBarang(){
        ArrayList<BarangEntity> arraylistBarang = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT barang.id_barang, barang.namabarang, barang.harga, jenis.namajenis from barang left join jenis on barang.jenis_id=jenis.id_jenis";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()) {
                BarangEntity barangobj = new BarangEntity();
                barangobj.setId_barang(rs.getInt("id_barang"));
                barangobj.setNamabarang(rs.getString("namabarang"));
                barangobj.setHarga(rs.getInt("harga"));
                barangobj.setNamajenis(rs.getString("namajenis"));
                arraylistBarang.add(barangobj);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arraylistBarang;
    }
    public ArrayList<BarangEntity> getBarangsatuan(int id){
        ArrayList<BarangEntity> arrBarang = new ArrayList<>();
        try {
            sql = "SELECT * FROM barang where id_barang =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                BarangEntity barang = new BarangEntity();

                barang.setId_barang(rs.getInt("id_barang"));
                barang.setNamabarang(rs.getString("namabarang"));
                barang.setHarga(rs.getInt("harga"));
                barang.setId_jenis(rs.getInt("jenis_id"));
                arrBarang.add(barang);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }return arrBarang;
    }
    public ArrayList<BarangEntity> getinsert(String namabarang, int harga, int jenis_id) {
        ArrayList<BarangEntity> arraylistBarang = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            // query simpan
            String sql = "INSERT INTO barang (namabarang,harga,jenis_id) VALUE('%s','%d','%d')";
            sql = String.format(sql, namabarang, harga, jenis_id);
            stat.execute(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return arraylistBarang;
    }
    public void updateNamabarang(String namabarang, int id){
        try{
            sql = "update barang SET namabarang =? WHERE id_barang =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, namabarang);
            stat.setInt(2, id);
            stat.executeUpdate();
        } catch (SQLException e){
            System.out.println("GAGAL RUBAH NAMA!");
            e.printStackTrace();
        }
    }

    public void updateHarga(int harga, int id){
        try{
            sql = "update barang SET harga =? WHERE id_barang =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, harga);
            stat.setInt(2, id);
            stat.executeUpdate();
        } catch (SQLException e){
            System.out.println("GAGAL RUBAH HARGA!");
            e.printStackTrace();
        }
    }

    public void updateId_jenis(int id_jenis, int id){
        try{
            sql = "update barang SET jenis_id =? WHERE id_barang =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id_jenis);
            stat.setInt(2, id);
            stat.executeUpdate();
        } catch (SQLException e){
            System.out.println("GAGAL RUBAH ID JENIS!");
            e.printStackTrace();
        }
    }
    public void deleteData(int id){
        try {
            sql = "DELETE FROM barang where id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            stat.executeUpdate();
        } catch (SQLException e) {
            System.out.println("GAGAL Hapus DATA!!!");
        }
    }

}
