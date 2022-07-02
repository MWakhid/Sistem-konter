package Model;

import Entity.TransaksiEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TransaksiModel extends ModelAbstract {
    private String sql;
    public ArrayList<TransaksiEntity> getTransaksi(){
        ArrayList<TransaksiEntity> arraylistTransaksi = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM transaksi";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()) {
                TransaksiEntity transaksiobj = new TransaksiEntity();
                transaksiobj.setId_transaksi(rs.getInt("id_transaksi"));
                transaksiobj.setBayar(rs.getInt("bayar"));
                transaksiobj.setTotal(rs.getInt("total"));
                transaksiobj.setWaktu(rs.getTimestamp("waktu"));
                arraylistTransaksi.add(transaksiobj);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arraylistTransaksi;
    }

    public ArrayList<TransaksiEntity> getTransaksisatuan(int id){
        ArrayList<TransaksiEntity> arraylistTransaksisatuan = new ArrayList<>();
        try {
            sql = "SELECT transaksi.id_transaksi, barang.namabarang, barang.harga FROM transaksi INNER JOIN akhir ON transaksi.id_transaksi = akhir.transaksi_id INNER JOIN barang ON akhir.barang_id = barang.id_barang where akhir.transaksi_id = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,id);
            ResultSet rs = stat.executeQuery();
            while(rs.next()) {
                TransaksiEntity transaksiobj = new TransaksiEntity();
                transaksiobj.setId_transaksi(rs.getInt("id_transaksi"));
                transaksiobj.setBarang(rs.getString("namabarang"));
                transaksiobj.setHarga(rs.getInt("harga"));
                arraylistTransaksisatuan.add(transaksiobj);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arraylistTransaksisatuan;
    }
}
