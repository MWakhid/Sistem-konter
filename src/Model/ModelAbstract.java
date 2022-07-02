package Model;

import Helper.koneksi;
import java.sql.Connection;

public abstract class ModelAbstract {
    Connection conn = koneksi.getconnection();
}