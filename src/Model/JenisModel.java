package Model;

import Entity.BarangEntity;
import Entity.JenisEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JenisModel extends ModelAbstract{
    private String sql;
    public ArrayList<JenisEntity> getJenis(){
        ArrayList<JenisEntity> arraylistJenis = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT jenis.id_jenis, jenis.namajenis, kategori.namakategori from jenis join kategori on jenis.kategori_id = kategori.id_kategori";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()) {
                JenisEntity jenisobj = new JenisEntity();
                jenisobj.setId_jenis(rs.getInt("id_jenis"));
                jenisobj.setNamajenis(rs.getString("namajenis"));
                jenisobj.setNamakategori(rs.getString("namakategori"));
                arraylistJenis.add(jenisobj);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arraylistJenis;
    }

    public ArrayList<JenisEntity> getJenissatuan(int id){
        ArrayList<JenisEntity> arrJenis = new ArrayList<>();
        try {
            sql = "SELECT * FROM jenis where id_jenis =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                JenisEntity jenis = new JenisEntity();

                jenis.setId_jenis(rs.getInt("id_jenis"));
                jenis.setNamajenis(rs.getString("namajenis"));
                jenis.setId_kategori(rs.getInt("kategori_id"));
                arrJenis.add(jenis);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }return arrJenis;
    }

    public ArrayList<JenisEntity> getinsert(String namajenis, int kategori_id) {
        ArrayList<JenisEntity> arraylistJenis = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            // query simpan
            String sql = "INSERT INTO jenis (namajenis,kategori_id) VALUE('%s','%d')";
            sql = String.format(sql, namajenis,kategori_id);
            stat.execute(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return arraylistJenis;
    }

    public void updateNamajenis(String namajenis, int id){
        try{
            sql = "update jenis SET namajenis =? WHERE id_jenis =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, namajenis);
            stat.setInt(2, id);
            stat.executeUpdate();
        } catch (SQLException e){
            System.out.println("GAGAL RUBAH NAMA JENIS!!!");
            e.printStackTrace();
        }
    }
    public void updateId_kategori(int id_kategori, int id){
        try{
            sql = "update jenis SET kategori_id =? WHERE id_jenis =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id_kategori);
            stat.setInt(2, id);
            stat.executeUpdate();
        } catch (SQLException e){
            System.out.println("GAGAL RUBAH ID KATEGORI!");
            e.printStackTrace();
        }
    }

}
