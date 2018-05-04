/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikumdb;

/**
 *
 * @author eldi
 */
public class PraktikumDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Koneksi koneksi = new Koneksi();
        koneksi.connect();
        
        FormInputMhs formInputMhs = new FormInputMhs();
        formInputMhs.setVisible(true);
    }
    
}
