/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikumdb;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author eldi
 */
public class Koneksi {

    private static Connection connection = null;
    /**
     * Sesuaikan port dengan port dari server Postgre kalian (Default 5432)
     *
     */
    private final String url = "jdbc:postgresql://localhost:5432/praktikum";
    private final String user = "postgres";
    private final String password = "AleqInsan23$";

    public Connection connect() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("koneksi berhasil");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }

}
