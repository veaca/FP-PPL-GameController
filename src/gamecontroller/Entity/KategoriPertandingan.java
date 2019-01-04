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
public class KategoriPertandingan {
    private int idkategori;
    private String namakategori;
    private String namamode;

    public KategoriPertandingan(String namamode) {
        this.namamode = namamode;
    }
    
    public int getIdkategori() {
        return idkategori;
    }

    public void setIdkategori(int idkategori) {
        this.idkategori = idkategori;
    }

    public String getNamakategori() {
        return namakategori;
    }

    public void setNamakategori(String namakategori) {
        this.namakategori = namakategori;
    }
    
    public String[] listKategori(){
        String[] namakategori = null;
        if (namamode == "Easy"){
            namakategori = new String[] {"Easy A","Easy B","Easy C"};
        }
        if (namamode == "Medium"){
            namakategori = new String[] {"Medium A","Medium B","Medium C"};
        }
        if (namamode == "Hard"){
            namakategori = new String[] {"Hard A","Hard B","Hard C"};
        }
        return namakategori;
    }
    
}
