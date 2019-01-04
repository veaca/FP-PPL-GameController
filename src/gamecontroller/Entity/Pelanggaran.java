/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamecontroller.Entity;

/**
 *
 * @author EVAN
 */
public class Pelanggaran {
    String[] pelanggaran = new String[] {"Illegal Defense", "Illegal Attack", "Illegal Start"};
    public Pelanggaran() {
    }

    public String[] getPelanggaran() {
        return pelanggaran;
    }

    public void setPelanggaran(String[] pelanggaran) {
        this.pelanggaran = pelanggaran;
    }
    
}
