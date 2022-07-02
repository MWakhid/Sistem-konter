package Controller;

import Entity.TransaksiEntity;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class transaksiController {
    public ArrayList<TransaksiEntity> getDataTransaksi(){
        return allobjectcontroller.transaksi.getTransaksi();
    }

    public DefaultTableModel daftartransaksi(){
        DefaultTableModel datatransaksi = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        Object[] kolom = {"ID", "WAKTU","TOTAL","BAYAR","KEMBALI"};
        datatransaksi.setColumnIdentifiers(kolom);
        int size = getDataTransaksi().size();
        for(int i = 0; i < size; i++ ){
            Object[] data = new Object[5];
            data[0] = allobjectcontroller.transaksi.getTransaksi().get(i).getId_transaksi();
            data[1] = allobjectcontroller.transaksi.getTransaksi().get(i).getWaktu();
            data[2] = allobjectcontroller.transaksi.getTransaksi().get(i).getTotal();
            data[3] = allobjectcontroller.transaksi.getTransaksi().get(i).getBayar();
            data[4] = allobjectcontroller.transaksi.getTransaksi().get(i).getKembali();
            datatransaksi.addRow(data);
        }
        return datatransaksi;
    }
    public ArrayList<TransaksiEntity> getById(int id){
        return allobjectcontroller.transaksi.getTransaksisatuan(id);
    }
    public DefaultTableModel detailtransaksi(int id){
        DefaultTableModel datatransaksi = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        Object[] kolom = {"ID TRANSAKSI", "NAMA BARANG","HARGA"};
        datatransaksi.setColumnIdentifiers(kolom);
        int size = getDataTransaksi().size();
        for(int i = 0; i < size; i++ ){
            Object[] data = new Object[3];
            data[0] = allobjectcontroller.transaksi.getTransaksisatuan(id).get(i).getId_transaksi();
            data[1] = allobjectcontroller.transaksi.getTransaksisatuan(id).get(i).getBarang();
            data[2] = allobjectcontroller.transaksi.getTransaksisatuan(id).get(i).getHarga();
            datatransaksi.addRow(data);
        }
        return datatransaksi;
    }
}
