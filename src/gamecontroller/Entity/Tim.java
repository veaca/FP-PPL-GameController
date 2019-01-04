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
public class Tim {
    private int idtim;
    private String namatim;
    public String namarobot;

    public Tim() {
    }
    
    public Tim(String namatim) {
        this.namatim = namatim;
    }
    
    public String[] getRobot() {
        Robot robot = new Robot(namatim);
        String[] robots = robot.getNamaRobots();
        return robots;
    }
   
    public int getIdtim() {
        return idtim;
    }

    public void setIdtim(int idtim) {
        this.idtim = idtim;
    }

    public String getNamatim() {
        return namatim;
    }

    public void setNamatim(String namatim) {
        this.namatim = namatim;
    }
    
    public String[] listTim (){
        String[] namatim =  null;
        namatim = new String[] {"A", "B"};
        return namatim;
    }
}

