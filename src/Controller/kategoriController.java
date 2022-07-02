package Controller;

import Entity.KategoriEntity;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class kategoriController {
    public ArrayList<KategoriEntity> getDataKategori(){
        return allobjectcontroller.kategori.getKategori();
    }
    public DefaultTableModel daftarkategori(){
        DefaultTableModel datakategori = new DefaultTableModel(){
            @Override
        public boolean isCellEditable(int row, int column) {
            //all cells false
            return false;
            }
        };

        Object[] kolom = {"ID", "KATEGORI"};
        datakategori.setColumnIdentifiers(kolom);
        int size = getDataKategori().size();
        for(int i = 0; i < size; i++ ){
            Object[] data = new Object[5];
            data[0] = allobjectcontroller.kategori.getKategori().get(i).getId();
            data[1] = allobjectcontroller.kategori.getKategori().get(i).getNamakategori();
            datakategori.addRow(data);
        }
        return datakategori;
    }
}
