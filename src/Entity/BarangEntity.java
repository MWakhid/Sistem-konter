package Entity;

public class BarangEntity {
        private String namabarang,namajenis;
        private int harga;
        private int id_barang,id_jenis;

        public BarangEntity(){};

        public int getId_barang() {
                return id_barang;
        }

        public void setId_barang(int id_barang) {
                this.id_barang = id_barang;
        }

        public String getNamabarang() {
                return namabarang;
        }

        public void setNamabarang(String namabarang) {
                this.namabarang = namabarang;
        }

        public int getHarga() {
                return harga;
        }

        public void setHarga(int harga) {
                this.harga = harga;
        }

        public int getId_jenis() {
                return id_jenis;
        }

        public void setId_jenis(int id_jenis) {
                this.id_jenis = id_jenis;
        }

        public String getNamajenis() {
                return namajenis;
        }

        public void setNamajenis(String namajenis) {
                this.namajenis = namajenis;
        }
}
