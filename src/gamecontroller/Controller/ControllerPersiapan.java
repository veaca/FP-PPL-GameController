/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamecontroller.Controller;

import gamecontroller.Entity.KategoriPertandingan;
import gamecontroller.Entity.ModePertandingan;
import gamecontroller.Entity.Tim;
import gamecontroller.View.HalamanUtama;

/**
 *
 * @author EVAN
 */
public class ControllerPersiapan {

    public void lakukanPersiapan(){
        
    }
    
    public void PlayButtonClicked(String namamode,String namatim1,String namatim2,String namakategori){
        String namababak = "Babak 1";
        String namatahap = "Tahap Initial";
        HalamanUtama halamanUtama = new HalamanUtama(namamode, namatim1, namatim2, namakategori, namababak, namatahap, null, null, null, null, 0, 0);
        halamanUtama.setVisible(true);
    }
    
    public String[] getTim(){
        String[] tims;
        Tim tim = new Tim();
        tims = tim.listTim();
        return tims;
    }
    
    public String[] getMode() {
        ModePertandingan modePertandingan = new ModePertandingan();
        String[] listmode = modePertandingan.listMode();
        return listmode;
    }
    
    public String[] getKategori(String namamode){
        ModePertandingan modePertandingan = new ModePertandingan();
        modePertandingan.setNamamode(namamode);
        String[] kategori = modePertandingan.listKategori();
        return kategori;
    }
}
