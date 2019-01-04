/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamecontroller.Entity;

import java.util.ArrayList;

/**
 *
 * @author EVAN
 */
public class Robot {
    private int idrobot;
    private String namarobot;
    private String namatim;
    
    public Robot(String namatim) {
        this.namatim = namatim;
    }

    public int getIdrobot() {
        return idrobot;
    }

    public void setIdrobot(int idrobot) {
        this.idrobot = idrobot;
    }

    public String getNamarobot() {
        
        return namarobot;
    }

    public void setNamarobot(String namarobot) {
        this.namarobot = namarobot;
    }
    
    public String[] getNamaRobots(){
        String[] namarobots = null;
        if (namatim == "A"){
            
            namarobots = new String[] {"RobotA1", "RobotA2"};
        }
        else if (namatim == "B"){
           
            namarobots = new String[] {"RobotB1", "RobotB2"};
        }
        return namarobots;
    }
    
}
