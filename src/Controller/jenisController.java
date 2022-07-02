package Controller;

import Entity.BarangEntity;
import Entity.JenisEntity;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class jenisController {
    public ArrayList<JenisEntity> getDatajenis(){
        return allobjectcontroller.jenis.getJenis();
    }
    public DefaultTableModel daftarjenis(){
        DefaultTableModel datajenis = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        Object[] kolom = {"ID", "JENIS","KATEGORI"};
        datajenis.setColumnIdentifiers(kolom);
        int size = getDatajenis().size();
        for(int i = 0; i < size; i++ ){
            Object[] data = new Object[5];
            data[0] = allobjectcontroller.jenis.getJenis().get(i).getId_jenis();
            data[1] = allobjectcontroller.jenis.getJenis().get(i).getNamajenis();
            data[2] = allobjectcontroller.jenis.getJenis().get(i).getNamakategori();
            datajenis.addRow(data);
        }
        return datajenis;
    }
    public ArrayList<JenisEntity> getById(int id){
        return allobjectcontroller.jenis.getJenissatuan(id);
    }

    public ArrayList<JenisEntity> insert(String namajenis,int id_kategori){
        return allobjectcontroller.jenis.getinsert(namajenis,id_kategori);
    }
    public void updateDataStr(int pilih, String datastr, int id){
        switch(pilih){
            case 1:
                allobjectcontroller.jenis.updateNamajenis(datastr,id);
                break;
        }
    }
    public void updateDataint(int pilih1, int dataint, int id) {
        switch (pilih1) {
            case 2:
                allobjectcontroller.jenis.updateId_kategori(dataint,id);
                break;
        }
    }
}