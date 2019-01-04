/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamecontroller.View;

import gamecontroller.Controller.ControllerPertandingan;
import gamecontroller.Entity.ModePertandingan;
import java.awt.event.ActionEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EVAN
 */
public class HalamanUtama extends javax.swing.JFrame {

    /**
     * Creates new form HalamanUtama
     */
    
    String namamode, namatim1, namatim2, namakategori, namababak, namatahap, namarobot1tim1, namarobot2tim1, namarobot1tim2, namarobot2tim2;
    int skortim1, skortim2;
    int counterready = 30;
    int counterplay = 60;
    int waktupelanggaran = 15;
    int sem_waktutim1, sem_waktutim2;
    int counter;
    int waktu1 = 30, waktu2 = 30, waktu3 = 30, waktu4 = 30;
    int timeout=15;
    boolean isstopped = false;
    int stoppedtime = 10;
    int countbabak = 0;
    public HalamanUtama() {
        initComponents();
    }

    public HalamanUtama(String namamode, String namatim1, String namatim2, String namakategori, String namababak, String namatahap) {
        initComponents();
        this.namamode = namamode;
        this.namatim1 = namatim1;
        this.namatim2 = namatim2;
        this.namakategori = namakategori;
        this.namababak = namababak;
        this.namatahap = namatahap;
    }
    
    public HalamanUtama(String namamode, String namatim1, String namatim2, String namakategori, String namababak, String namatahap,String namarobot1tim1,String namarobot2tim1,String namarobot1tim2,String namarobot2tim2, int skortim1, int skortim2){
        initComponents();
        this.namamode =  namamode;
        this.namatim1 = namatim1;
        this.namatim2 = namatim2;
        this.namakategori = namakategori;
        this.namababak = namababak;
        this.namatahap = namatahap;
        this.skortim1 = skortim1;
        this.skortim2 = skortim2;
        this.namarobot1tim1 = namarobot1tim1;
        this.namarobot2tim1 = namarobot2tim1;
        this.namarobot1tim2 = namarobot1tim2;
        this.namarobot2tim2 = namarobot2tim2;
        labelnamamode.setText(namamode);
        labelnamakategori.setText(namakategori);
        labeltim1.setText(namatim1);
        labeltim2.setText(namatim2);
        Babak.setText(namababak);
        Tahap.setText(namatahap);
        labeltim1robot1.setText(namarobot1tim1);
        labeltim1robot2.setText(namarobot2tim1);
        labeltim2robot1.setText(namarobot1tim2);
        labeltim2robot2.setText(namarobot2tim2);
        labeltim1skor.setText(String.valueOf(skortim1));
        labeltim2skor.setText(String.valueOf(skortim2));
        
        ControllerPertandingan controllerPertandingan = new ControllerPertandingan();
        String[] pelanggaran = controllerPertandingan.getListPelanggaran();
        for (int i=0 ; i<pelanggaran.length ; i++){
            combo_pelanggaran1.addItem(pelanggaran[i]);
            combo_pelanggaran2.addItem(pelanggaran[i]);
        }
        
        if ("Tahap Initial".equals(namatahap)){
            ControllerPertandingan controllerpertandingan = new ControllerPertandingan(namatim1);
            String[] namarobots = controllerpertandingan.PersiapanTimButtonClicked(namatim1);
            String[] namarobots2 = controllerpertandingan.PersiapanTimButtonClicked(namatim2);
            for (int i=0;i<namarobots.length; i++){
                tim1_robot1.addItem(namarobots[i]);
                tim1_robot2.addItem(namarobots[i]);
            }
            for (int i=0;i<namarobots2.length; i++){
                tim2_robot1.addItem(namarobots2[i]);
                tim2_robot2.addItem(namarobots2[i]);
            }
        
            tim1_robot1.setVisible(true);
            tim1_robot2.setVisible(true);
            tim2_robot1.setVisible(true);
            tim2_robot2.setVisible(true);
            labeltim1robot1.setVisible(false);
            labeltim1robot2.setVisible(false);
            labeltim2robot1.setVisible(false);
            labeltim2robot1.setVisible(false);
            persiapantim1.setText("Persiapkan Robot");
            nextbutton.setText("Ready");
            this.namatahap = "Tahap Ready";
        }
        else if ("Tahap Ready".equals(namatahap)){
            persiapantim1.setText("Letakkan Robot");
            Timer timer = new Timer();
            
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                   label_matchtime.setText(Integer.toString(counterready));
                   counterready--;
                   if (counterready == -1){
                       timer.cancel();
                       ActionEvent evt = null;
                       nextbuttonActionPerformed(evt);
                       
                   }
                   
                }
            };
            timer.scheduleAtFixedRate(task, 1000, 1000);
            
            tim1_robot1.setVisible(false);
            tim1_robot2.setVisible(false);
            tim2_robot1.setVisible(false);
            tim2_robot2.setVisible(false);
            labeltim1robot1.setVisible(true);
            labeltim1robot2.setVisible(true);
            labeltim2robot1.setVisible(true);
            labeltim2robot1.setVisible(true);
            
            nextbutton.setText("Set");
            this.namatahap = "Tahap Set";
        }
        else if ("Tahap Set".equals(namatahap)){
            nextbutton.setText("Play");
            this.namatahap = "Tahap Play";
            persiapantim1.setVisible(false);
            tim1_robot1.setVisible(false);
            tim1_robot2.setVisible(false);
            tim2_robot1.setVisible(false);
            tim2_robot2.setVisible(false);
            labeltim1robot1.setVisible(true);
            labeltim1robot2.setVisible(true);
            labeltim2robot1.setVisible(true);
            labeltim2robot1.setVisible(true);
        }
        else if ("Tahap Play".equals(namatahap)){
            Timer timer = new Timer();
            
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                   label_matchtime.setText(Integer.toString(counterplay));
                   counterplay--;
                   if (counterplay == -1){
                       timer.cancel();
                   }
                   else if (isstopped){
                       timer.cancel();
                       
                   }
                }
            };
            timer.scheduleAtFixedRate(task, 1000, 1000);
            if (namababak == "Babak 2"){
                System.out.println(countbabak);
                countbabak = 1;
            }
            tim1_robot1.setVisible(false);
            tim1_robot2.setVisible(false);
            tim2_robot1.setVisible(false);
            tim2_robot2.setVisible(false);
            labeltim1robot1.setVisible(true);
            labeltim1robot2.setVisible(true);
            labeltim2robot1.setVisible(true);
            labeltim2robot1.setVisible(true);
            if ("Babak 1".equals(namababak)){
                this.namababak = "Babak 2";
                this.namatahap = "Tahap Initial";
            }
            persiapantim1.setVisible(false);
            nextbutton.setText("Finish");
        }
        else {
            this.namarobot1tim1 = namarobot1tim1;
            this.namarobot2tim1 = namarobot2tim1;
            this.namarobot1tim2 = namarobot1tim2;
            this.namarobot2tim2 = namarobot2tim2;
        }
    }
    ModePertandingan modePertandingan = new ModePertandingan();
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        labelnamamode = new javax.swing.JLabel();
        labelnamakategori = new javax.swing.JLabel();
        labeltim1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labeltim2 = new javax.swing.JLabel();
        Babak = new javax.swing.JLabel();
        Tahap = new javax.swing.JLabel();
        persiapantim1 = new javax.swing.JButton();
        nextbutton = new javax.swing.JButton();
        tim1_robot1 = new javax.swing.JComboBox<>();
        tim1_robot2 = new javax.swing.JComboBox<>();
        tim2_robot1 = new javax.swing.JComboBox<>();
        tim2_robot2 = new javax.swing.JComboBox<>();
        labeltim1robot1 = new javax.swing.JLabel();
        labeltim1robot2 = new javax.swing.JLabel();
        labeltim2robot1 = new javax.swing.JLabel();
        labeltim2robot2 = new javax.swing.JLabel();
        labeltim1skor = new javax.swing.JLabel();
        labeltim2skor = new javax.swing.JLabel();
        button_addscoretim1 = new javax.swing.JButton();
        button_addscoretim2 = new javax.swing.JButton();
        button_tim1timeout = new javax.swing.JButton();
        button_tim2timeout = new javax.swing.JButton();
        button_tim1robot1incapable = new javax.swing.JButton();
        button_tim1robot2incapable = new javax.swing.JButton();
        button_tim2robot1incapable = new javax.swing.JButton();
        button_tim2robot2incapable = new javax.swing.JButton();
        combo_pelanggaran1 = new javax.swing.JComboBox<>();
        button_pelanggaran1 = new javax.swing.JButton();
        combo_pelanggaran2 = new javax.swing.JComboBox<>();
        button_pelanggaran2 = new javax.swing.JButton();
        label_matchtime = new javax.swing.JLabel();
        label_tim1time = new javax.swing.JLabel();
        label_tim2time = new javax.swing.JLabel();
        time_pause = new javax.swing.JButton();
        time_continue = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        label_tim1robot1incapabletime = new javax.swing.JLabel();
        label_tim1robot2incapabletime = new javax.swing.JLabel();
        label_tim2robot1incapabletime = new javax.swing.JLabel();
        label_tim2robot2incapabletime = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        label_timeout = new javax.swing.JLabel();
        button_droppedball = new javax.swing.JButton();
        button_out = new javax.swing.JButton();
        a = new javax.swing.JLabel();
        label_stoppedtime = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelnamamode.setText("jLabel1");

        labelnamakategori.setText("jLabel2");

        labeltim1.setText("jLabel3");

        jLabel4.setText("vs");

        labeltim2.setText("jLabel5");

        Babak.setText("jLabel6");
        Babak.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                BabakAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        Tahap.setText("jLabel7");

        persiapantim1.setText("jButton1");
        persiapantim1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                persiapantim1ActionPerformed(evt);
            }
        });

        nextbutton.setText("jButton2");
        nextbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextbuttonActionPerformed(evt);
            }
        });

        tim1_robot1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tim1_robot1ActionPerformed(evt);
            }
        });

        tim1_robot2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tim1_robot2ActionPerformed(evt);
            }
        });

        tim2_robot1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tim2_robot1ActionPerformed(evt);
            }
        });

        tim2_robot2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tim2_robot2ActionPerformed(evt);
            }
        });

        labeltim1robot1.setText("jLabel6");

        labeltim1robot2.setText("jLabel7");

        labeltim2robot1.setText("jLabel8");

        labeltim2robot2.setText("jLabel9");

        labeltim1skor.setText("jLabel1");

        labeltim2skor.setText("jLabel2");

        button_addscoretim1.setText("Add Score");
        button_addscoretim1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_addscoretim1ActionPerformed(evt);
            }
        });

        button_addscoretim2.setText("Add Score");
        button_addscoretim2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_addscoretim2ActionPerformed(evt);
            }
        });

        button_tim1timeout.setText("Timeout");
        button_tim1timeout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_tim1timeoutActionPerformed(evt);
            }
        });

        button_tim2timeout.setText("Timeout");
        button_tim2timeout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_tim2timeoutActionPerformed(evt);
            }
        });

        button_tim1robot1incapable.setText("Incapable");
        button_tim1robot1incapable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_tim1robot1incapableActionPerformed(evt);
            }
        });

        button_tim1robot2incapable.setText("Incapable");
        button_tim1robot2incapable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_tim1robot2incapableActionPerformed(evt);
            }
        });

        button_tim2robot1incapable.setText("Incapable");
        button_tim2robot1incapable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_tim2robot1incapableActionPerformed(evt);
            }
        });

        button_tim2robot2incapable.setText("Incapable");
        button_tim2robot2incapable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_tim2robot2incapableActionPerformed(evt);
            }
        });

        combo_pelanggaran1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_pelanggaran1ActionPerformed(evt);
            }
        });

        button_pelanggaran1.setText("Pelanggaran");
        button_pelanggaran1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_pelanggaran1ActionPerformed(evt);
            }
        });

        button_pelanggaran2.setText("Pelanggaran");
        button_pelanggaran2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_pelanggaran2ActionPerformed(evt);
            }
        });

        label_matchtime.setText("0");

        label_tim1time.setText("0");

        label_tim2time.setText("0");

        time_pause.setText("Pause");
        time_pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                time_pauseActionPerformed(evt);
            }
        });

        time_continue.setText("Continue");
        time_continue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                time_continueActionPerformed(evt);
            }
        });

        jLabel1.setText("Time");

        jLabel2.setText("Waktu Pelanggaran ");

        jLabel3.setText("Waktu Pelanggaran");

        label_tim1robot1incapabletime.setText("0");

        label_tim1robot2incapabletime.setText("0");

        label_tim2robot1incapabletime.setText("0");

        label_tim2robot2incapabletime.setText("0");

        jLabel5.setText("Timeout");

        label_timeout.setText("0");

        button_droppedball.setText("Dropped Ball");
        button_droppedball.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_droppedballActionPerformed(evt);
            }
        });

        button_out.setText("Out");
        button_out.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_outActionPerformed(evt);
            }
        });

        a.setText("Waktu Berhenti");

        label_stoppedtime.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(labeltim1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labeltim1robot1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tim1_robot1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelnamamode)
                                        .addGap(18, 18, 18)
                                        .addComponent(labelnamakategori))
                                    .addComponent(persiapantim1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Babak)
                                        .addGap(18, 18, 18)
                                        .addComponent(Tahap))
                                    .addComponent(nextbutton)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labeltim1robot2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tim1_robot2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(button_addscoretim1)
                                    .addComponent(button_tim1robot1incapable)
                                    .addComponent(button_tim1robot2incapable)
                                    .addComponent(combo_pelanggaran1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addComponent(button_pelanggaran2))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(label_tim1robot2incapabletime)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(label_tim1robot1incapabletime)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(button_tim1timeout)))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labeltim1skor)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4)
                                        .addGap(38, 38, 38))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(246, 246, 246)
                                .addComponent(label_stoppedtime)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(time_pause)
                                        .addGap(18, 18, 18)
                                        .addComponent(time_continue)
                                        .addGap(18, 18, 18)
                                        .addComponent(button_droppedball))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(127, 127, 127)
                                        .addComponent(jLabel2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(209, 209, 209)
                                        .addComponent(label_tim1time)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_out)
                                .addGap(7, 7, 7)
                                .addComponent(label_timeout))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_matchtime, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(296, 296, 296)
                                .addComponent(a)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(button_pelanggaran1)
                                    .addGap(29, 29, 29)
                                    .addComponent(combo_pelanggaran2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(button_tim2timeout)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                            .addComponent(label_tim2robot1incapabletime))
                                        .addComponent(label_tim2robot2incapabletime, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(button_tim2robot2incapable)
                                        .addComponent(jLabel3)
                                        .addComponent(button_tim2robot1incapable))))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labeltim2robot2)
                                .addComponent(labeltim2robot1))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tim2_robot2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tim2_robot1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(25, 25, 25))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addComponent(labeltim2skor)
                            .addGap(18, 18, 18)
                            .addComponent(button_addscoretim2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labeltim2)
                            .addGap(19, 19, 19)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(label_tim2time)
                        .addGap(178, 178, 178))))
            .addGroup(layout.createSequentialGroup()
                .addGap(342, 342, 342)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelnamamode)
                    .addComponent(labelnamakategori))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Babak)
                    .addComponent(Tahap))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(persiapantim1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labeltim1)
                    .addComponent(labeltim2)
                    .addComponent(jLabel4)
                    .addComponent(labeltim1skor)
                    .addComponent(labeltim2skor)
                    .addComponent(button_addscoretim1)
                    .addComponent(button_addscoretim2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tim1_robot1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tim2_robot1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labeltim1robot1)
                    .addComponent(labeltim2robot1)
                    .addComponent(button_tim1timeout)
                    .addComponent(button_tim2timeout)
                    .addComponent(button_tim1robot1incapable)
                    .addComponent(button_tim2robot1incapable)
                    .addComponent(label_tim1robot1incapabletime)
                    .addComponent(label_tim2robot1incapabletime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tim1_robot2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tim2_robot2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labeltim1robot2)
                        .addComponent(labeltim2robot2)
                        .addComponent(button_tim1robot2incapable)
                        .addComponent(button_tim2robot2incapable)
                        .addComponent(label_tim2robot2incapabletime))
                    .addComponent(label_tim1robot2incapabletime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_pelanggaran1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_pelanggaran1)
                    .addComponent(combo_pelanggaran2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_pelanggaran2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(time_pause)
                    .addComponent(time_continue)
                    .addComponent(button_droppedball)
                    .addComponent(button_out))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(5, 5, 5)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_tim1time)
                    .addComponent(label_tim2time)
                    .addComponent(label_timeout))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_matchtime)
                    .addComponent(a))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextbutton)
                    .addComponent(label_stoppedtime))
                .addGap(33, 33, 33))
        );

        Babak.getAccessibleContext().setAccessibleName("Babak");
        Tahap.getAccessibleContext().setAccessibleName("Tahap");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void persiapantim1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_persiapantim1ActionPerformed
        
    }//GEN-LAST:event_persiapantim1ActionPerformed

    private void nextbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextbuttonActionPerformed
        if (namababak == "Babak 2" && countbabak == 1){
            ControllerPertandingan controllerPertandingan = new ControllerPertandingan(namamode, namatim1, namatim2, namakategori, namababak, namatahap, namarobot1tim1, namarobot2tim1, namarobot1tim2, namarobot2tim2, skortim1, skortim2);
           
           jDialog1.setTitle("Game Finished");
           jDialog1.setVisible(true);
            controllerPertandingan.NewPage();
       }
        else {
            ControllerPertandingan controllerPertandingan = new ControllerPertandingan(namamode, namatim1, namatim2, namakategori, namababak, namatahap, namarobot1tim1, namarobot2tim1, namarobot1tim2, namarobot2tim2, skortim1, skortim2);
            controllerPertandingan.NextButtonClicked(namamode, namatim1, namatim2, namakategori, namababak, namatahap);
       }
        
       this.setVisible(false);
    }//GEN-LAST:event_nextbuttonActionPerformed

    private void BabakAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_BabakAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_BabakAncestorAdded

    private void tim1_robot1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tim1_robot1ActionPerformed
        System.out.println(tim1_robot1.getSelectedItem().toString());
        this.namarobot1tim1 = tim1_robot1.getSelectedItem().toString();
    }//GEN-LAST:event_tim1_robot1ActionPerformed

    private void tim1_robot2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tim1_robot2ActionPerformed
        System.out.println(tim1_robot2.getSelectedItem().toString());
        this.namarobot2tim1 = tim1_robot2.getSelectedItem().toString();
    }//GEN-LAST:event_tim1_robot2ActionPerformed

    private void tim2_robot1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tim2_robot1ActionPerformed
        System.out.println(tim2_robot1.getSelectedItem().toString());
        this.namarobot1tim2 = tim2_robot1.getSelectedItem().toString();
    }//GEN-LAST:event_tim2_robot1ActionPerformed

    private void tim2_robot2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tim2_robot2ActionPerformed
        System.out.println(tim2_robot2.getSelectedItem().toString());
        this.namarobot2tim2 = tim2_robot2.getSelectedItem().toString();
    }//GEN-LAST:event_tim2_robot2ActionPerformed

    private void button_addscoretim1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_addscoretim1ActionPerformed
        skortim1++;
        labeltim1skor.setText(String.valueOf(skortim1));
    }//GEN-LAST:event_button_addscoretim1ActionPerformed

    private void button_addscoretim2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_addscoretim2ActionPerformed
        skortim2++;
        labeltim2skor.setText(String.valueOf(skortim2));
    }//GEN-LAST:event_button_addscoretim2ActionPerformed

    private void button_tim1robot1incapableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_tim1robot1incapableActionPerformed
        labeltim1robot1.setVisible(true);
        tim1_robot1.setVisible(true);
        Timer timer = new Timer();
            
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                   label_tim1robot1incapabletime.setText(Integer.toString(waktu1));
                   waktu1--;
                   if (waktu1 == -1){
                       timer.cancel();
                       waktu1 = 30;
                   }
                }
            };
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }//GEN-LAST:event_button_tim1robot1incapableActionPerformed

    private void button_tim1robot2incapableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_tim1robot2incapableActionPerformed
        labeltim1robot2.setVisible(true);
        tim1_robot2.setVisible(true);
        Timer timer = new Timer();
            
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                   label_tim1robot2incapabletime.setText(Integer.toString(waktu2));
                   waktu2--;
                   if (waktu2 == -1){
                       timer.cancel();
                       waktu2= 30;
                   }
                }
            };
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }//GEN-LAST:event_button_tim1robot2incapableActionPerformed

    private void button_tim2robot1incapableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_tim2robot1incapableActionPerformed
        labeltim2robot1.setVisible(false);
        tim2_robot1.setVisible(true);
        Timer timer = new Timer();
            
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                   label_tim2robot1incapabletime.setText(Integer.toString(waktu3));
                   waktu3--;
                   if (waktu3 == -1){
                       timer.cancel();
                       waktu3= 30;
                   }
                }
            };
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }//GEN-LAST:event_button_tim2robot1incapableActionPerformed

    private void button_tim2robot2incapableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_tim2robot2incapableActionPerformed
        labeltim2robot2.setVisible(false);
        tim2_robot2.setVisible(true);
        Timer timer = new Timer();
            
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                   label_tim2robot2incapabletime.setText(Integer.toString(waktu4));
                   waktu4--;
                   if (waktu4 == -1){
                       timer.cancel();
                       waktu4 = 30;
                   }
                }
            };
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }//GEN-LAST:event_button_tim2robot2incapableActionPerformed

    private void combo_pelanggaran1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_pelanggaran1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_pelanggaran1ActionPerformed

    private void time_pauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_time_pauseActionPerformed
        isstopped = true;
    }//GEN-LAST:event_time_pauseActionPerformed

    private void time_continueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_time_continueActionPerformed
        
        isstopped = false;
        if (namatahap == "Tahap Play"){
            System.out.println(counterready);
            counter = counterready;
        }
        else if (namatahap == "Tahap Initial"){
            System.out.println(counterplay);
            counter = counterplay;
        }
        Timer timer = new Timer();
            
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                   label_matchtime.setText(Integer.toString(counter));
                   counter--;
                   if (namatahap == "Tahap Play"){
                        counterready=counter;
                    }
                    else if (namatahap == "Tahap Initial"){
                        counterplay=counter;
                    }
                   if (counter == -1){
                       timer.cancel();
                   }
                   else if (isstopped){
                       timer.cancel();
                   }
                }
            };
        timer.scheduleAtFixedRate(task, 1000, 1000);
        
    }//GEN-LAST:event_time_continueActionPerformed

    private void button_pelanggaran2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_pelanggaran2ActionPerformed
        sem_waktutim1 = waktupelanggaran;
        Timer timer = new Timer();
            
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                   label_tim1time.setText(Integer.toString(sem_waktutim1));
                   sem_waktutim1--;
                   
                   if (sem_waktutim1 == -1){
                       timer.cancel();
                   }
                  
                }
            };
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }//GEN-LAST:event_button_pelanggaran2ActionPerformed

    private void button_pelanggaran1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_pelanggaran1ActionPerformed
        sem_waktutim2 = waktupelanggaran;
        Timer timer = new Timer();
            
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                   label_tim2time.setText(Integer.toString(sem_waktutim2));
                   sem_waktutim2--;
                   
                   if (sem_waktutim2 == -1){
                       timer.cancel();
                   }
                  
                }
            };
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }//GEN-LAST:event_button_pelanggaran1ActionPerformed

    private void button_tim1timeoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_tim1timeoutActionPerformed
        button_tim1timeout.setVisible(false);
        button_tim2timeout.setVisible(false);
        time_pauseActionPerformed(evt);
        Timer timer = new Timer();
            
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                   label_timeout.setText(Integer.toString(timeout));
                   timeout--;
                   if (timeout == -1){
                       timer.cancel();
                       timeout = 30;
                       button_tim1timeout.setVisible(true);
                        button_tim2timeout.setVisible(true);
                        time_continueActionPerformed(evt);
                   }
                }
            };
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }//GEN-LAST:event_button_tim1timeoutActionPerformed

    private void button_tim2timeoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_tim2timeoutActionPerformed
        button_tim1timeout.setVisible(false);
        button_tim2timeout.setVisible(false);
        
        Timer timer = new Timer();
            time_pauseActionPerformed(evt);
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                   label_timeout.setText(Integer.toString(timeout));
                   timeout--;
                   if (timeout == -1){
                       timer.cancel();
                       timeout = 30;
                       button_tim1timeout.setVisible(true);
                        button_tim2timeout.setVisible(true);
                        time_continueActionPerformed(evt);
                   }
                }
            };
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }//GEN-LAST:event_button_tim2timeoutActionPerformed

    private void button_droppedballActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_droppedballActionPerformed
        time_pauseActionPerformed(evt);
        Timer timer = new Timer();
            
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                   label_stoppedtime.setText(Integer.toString(stoppedtime));
                   stoppedtime--;
                   if (stoppedtime == -1){
                       timer.cancel();
                       stoppedtime = 10;
                       time_continueActionPerformed(evt);
                   }
                }
            };
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }//GEN-LAST:event_button_droppedballActionPerformed

    private void button_outActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_outActionPerformed
        time_pauseActionPerformed(evt);
        Timer timer = new Timer();
            
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                   label_stoppedtime.setText(Integer.toString(stoppedtime));
                   stoppedtime--;
                   if (stoppedtime == -1){
                       timer.cancel();
                       stoppedtime = 10;
                       time_continueActionPerformed(evt);
                   }
                }
            };
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }//GEN-LAST:event_button_outActionPerformed
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HalamanUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HalamanUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HalamanUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HalamanUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HalamanUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Babak;
    private javax.swing.JLabel Tahap;
    private javax.swing.JLabel a;
    private javax.swing.JButton button_addscoretim1;
    private javax.swing.JButton button_addscoretim2;
    private javax.swing.JButton button_droppedball;
    private javax.swing.JButton button_out;
    private javax.swing.JButton button_pelanggaran1;
    private javax.swing.JButton button_pelanggaran2;
    private javax.swing.JButton button_tim1robot1incapable;
    private javax.swing.JButton button_tim1robot2incapable;
    private javax.swing.JButton button_tim1timeout;
    private javax.swing.JButton button_tim2robot1incapable;
    private javax.swing.JButton button_tim2robot2incapable;
    private javax.swing.JButton button_tim2timeout;
    private javax.swing.JComboBox<String> combo_pelanggaran1;
    private javax.swing.JComboBox<String> combo_pelanggaran2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel label_matchtime;
    private javax.swing.JLabel label_stoppedtime;
    private javax.swing.JLabel label_tim1robot1incapabletime;
    private javax.swing.JLabel label_tim1robot2incapabletime;
    private javax.swing.JLabel label_tim1time;
    private javax.swing.JLabel label_tim2robot1incapabletime;
    private javax.swing.JLabel label_tim2robot2incapabletime;
    private javax.swing.JLabel label_tim2time;
    private javax.swing.JLabel label_timeout;
    private javax.swing.JLabel labelnamakategori;
    private javax.swing.JLabel labelnamamode;
    private javax.swing.JLabel labeltim1;
    private javax.swing.JLabel labeltim1robot1;
    private javax.swing.JLabel labeltim1robot2;
    private javax.swing.JLabel labeltim1skor;
    private javax.swing.JLabel labeltim2;
    private javax.swing.JLabel labeltim2robot1;
    private javax.swing.JLabel labeltim2robot2;
    private javax.swing.JLabel labeltim2skor;
    private javax.swing.JButton nextbutton;
    private javax.swing.JButton persiapantim1;
    private javax.swing.JComboBox<String> tim1_robot1;
    private javax.swing.JComboBox<String> tim1_robot2;
    private javax.swing.JComboBox<String> tim2_robot1;
    private javax.swing.JComboBox<String> tim2_robot2;
    private javax.swing.JButton time_continue;
    private javax.swing.JButton time_pause;
    // End of variables declaration//GEN-END:variables
}
