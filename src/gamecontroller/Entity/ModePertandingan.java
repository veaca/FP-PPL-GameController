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
public class ModePertandingan {
    private int idmode;
    private String namamode;

    
    public int getIdmode() {
        return idmode;
    }

    public void setIdmode(int idmode) {
        this.idmode = idmode;
    }

    public String getNamamode() {
        return namamode;
    }

    public void setNamamode(String namamode) {
        this.namamode = namamode;
    }
    
    public String[] listMode() {
        String[] namamode = null;
        namamode = new String[] {"Easy", "Medium", "Hard"};
        return namamode;
    }
    
    public String[] listKategori(){
        KategoriPertandingan kategoriPertandingan = new KategoriPertandingan(namamode);
        String[] kategori = kategoriPertandingan.listKategori();
        return kategori;
    }
    
}

