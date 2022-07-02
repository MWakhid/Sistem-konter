package Model;

import Entity.KategoriEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class KategoriModel extends ModelAbstract{
    private String sql;
    public ArrayList<KategoriEntity> getKategori(){
        ArrayList<KategoriEntity> arraylistKategori = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM kategori";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()) {
                KategoriEntity kategoriobj = new KategoriEntity();
                kategoriobj.setId(rs.getInt("id_kategori"));
                kategoriobj.setNamakategori(rs.getString("namakategori"));
                arraylistKategori.add(kategoriobj);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arraylistKategori;
    }
    public void updateId_kategori(int id_kategori, int id){
        try{
            sql = "update jenis SET kategori_id =? WHERE id_jenis =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id_kategori);
            stat.setInt(2, id);
            stat.executeUpdate();
        } catch (SQLException e){
            System.out.println("GAGAL RUBAH ID kategori!");
            e.printStackTrace();
        }
    }
}
