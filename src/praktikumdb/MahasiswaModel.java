/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikumdb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eldi
 */
public class MahasiswaModel {

    Koneksi koneksi = new Koneksi();

    public boolean insert(Mahasiswa m) {
        String query = "INSERT INTO mahasiswa VALUES (DEFAULT, ?, ?);";
        try {
            PreparedStatement statement = koneksi.connect().prepareStatement(query);
            //statement.setString(1, "default");
            statement.setString(1, m.getNim());
            statement.setString(2, m.getNama());

            int row = statement.executeUpdate();
            if (row > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<Mahasiswa> getData() {
        List<Mahasiswa> allMahasiswa = new ArrayList<>();
        String query = "select * from mahasiswa";
        try {
            PreparedStatement statement = koneksi.connect().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Mahasiswa m = new Mahasiswa(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3)
                );
                allMahasiswa.add(m);
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allMahasiswa;
    }

    public boolean updateData(Mahasiswa m) {
        String query = "UPDATE mahasiswa SET nim=?, nama=? WHERE id=?;";
        try {
            PreparedStatement statement = koneksi.connect().prepareStatement(query);
            //statement.setString(1, "default");
            statement.setString(1, m.getNim());
            statement.setString(2, m.getNama());
            statement.setString(3, m.getId());

            int row = statement.executeUpdate();
            if (row > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean deleteData(Mahasiswa m) {
        String query = "DELETE FROM mahasiswa WHERE id=?;";
        try {
            PreparedStatement statement = koneksi.connect().prepareStatement(query);
            //statement.setString(1, "default");
            statement.setInt(1, Integer.valueOf(m.getId()));

            statement.executeUpdate();
            return true;
//            if (row > 0) {
//                return true;
//            }
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
