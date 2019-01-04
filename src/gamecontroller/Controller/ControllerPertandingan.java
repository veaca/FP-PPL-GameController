package gamecontroller.Controller;

import gamecontroller.Entity.Countdown;
import gamecontroller.Entity.Pelanggaran;
import gamecontroller.Entity.Robot;
import gamecontroller.Entity.Tim;
import gamecontroller.View.HalamanPersiapan;
import gamecontroller.View.HalamanUtama;

public class ControllerPertandingan {
    String namatim;
    String tim1robot1;
    String tim1robot2;
    String tim2robot1;
    String tim2robot2;
    int skortim1, skortim2;
    public ControllerPertandingan() {
    }
    
    public ControllerPertandingan(String namatim) {
        this.namatim = namatim;
    }

    public ControllerPertandingan(String namamode, String namatim1, String namatim2, String namakategori, String namababak, String namatahap,String namarobot1tim1,String namarobot2tim1,String namarobot1tim2,String namarobot2tim2, int skortim1, int skortim2) {
        this.tim1robot1 = namarobot1tim1;
        this.tim1robot2 = namarobot2tim1;
        this.tim2robot1 = namarobot1tim2;
        this.tim2robot2 = namarobot2tim2;
        this.skortim1 = skortim1;
        this.skortim2 = skortim2;
    }
    
    
    public void NextButtonClicked( String namamode, String namatim1, String namatim2, String namakategori, String namababak, String namatahap){
//        if (namababak == "Babak 2" && namatahap == "Tahap Play"){
//           HalamanPersiapan halamanPersiapan = new HalamanPersiapan();
//           halamanPersiapan.setVisible(true);
//       }
       
            HalamanUtama halamanUtama = new HalamanUtama(namamode, namatim1, namatim2, namakategori, namababak, namatahap, tim1robot1, tim1robot2, tim2robot1, tim2robot2, skortim1, skortim2);
            halamanUtama.setVisible(true);
       
    }
    
    public void NewPage(){
        HalamanPersiapan halamanPersiapan = new HalamanPersiapan();
        halamanPersiapan.setVisible(true);
    }
    
    public String[] PersiapanTimButtonClicked(String namatim){
        Tim tim = new Tim(namatim);
        String[] robots = tim.getRobot();
//        for (int i=0;i<robots.length; i++){
//            System.out.println(robots[i].toString());
//        }
        return robots;
    }
    
    public String[] getListPelanggaran() {
        Pelanggaran pelanggaran = new Pelanggaran();
        String[] listpelanggaran = pelanggaran.getPelanggaran();
        return listpelanggaran;
    }
   
    public void Timer() {
        Countdown countdown = new Countdown();
    }
}
