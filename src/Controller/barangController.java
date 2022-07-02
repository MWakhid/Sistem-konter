package Controller;

import Entity.BarangEntity;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class barangController {
    public ArrayList<BarangEntity> getDatabarang(){
        return allobjectcontroller.barang.getBarang();
    }
    public DefaultTableModel daftarbarang(){
        DefaultTableModel databarang = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        Object[] kolom = {"ID", "NAMA","HARGA","JENIS"};
        databarang.setColumnIdentifiers(kolom);
        int size = getDatabarang().size();
        for(int i = 0; i < size; i++ ){
            Object[] data = new Object[5];
            data[0] = allobjectcontroller.barang.getBarang().get(i).getId_barang();
            data[1] = allobjectcontroller.barang.getBarang().get(i).getNamabarang();
            data[2] = allobjectcontroller.barang.getBarang().get(i).getHarga();
            data[3] = allobjectcontroller.barang.getBarang().get(i).getNamajenis();
            databarang.addRow(data);
        }
        return databarang;
    }
    public ArrayList<BarangEntity> getById(int id){
        return allobjectcontroller.barang.getBarangsatuan(id);
    }

    public ArrayList<BarangEntity> insert(String namabarang, int harga, int jenis_id){
        return allobjectcontroller.barang.getinsert(namabarang,harga,jenis_id);
    }

    public void updateDataStr(int pilih, String datastr, int id){
        switch(pilih){
            case 1:
                allobjectcontroller.barang.updateNamabarang(datastr,id);
                break;
        }
    }
    public void updateDataint(int pilih1, int dataint, int id) {
        switch (pilih1) {
            case 2:
                allobjectcontroller.barang.updateHarga(dataint, id);
                break;
            case 3:
                allobjectcontroller.barang.updateId_jenis(dataint, id);
                break;
        }
    }
}