/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamecontroller.View;

import gamecontroller.Controller.ControllerPersiapan;
import gamecontroller.Entity.ModePertandingan;
import java.util.ArrayList;
import javax.swing.ButtonGroup;

/**
 *
 * @author EVAN
 */
public class HalamanPersiapan extends javax.swing.JFrame {

    /**
     * Creates new form HalamanPersiapan
     */
    //ModePertandingan modepertandingan = new ModePertandingan();
    ModePertandingan modepertandingan = new ModePertandingan();
    String namamode;
    
    public HalamanPersiapan() {
        ControllerPersiapan controllerPersiapan = new ControllerPersiapan();
        String[] modes;
        String[] teams;
        initComponents();
        groupButton();
        teams = controllerPersiapan.getTim();
        modes = controllerPersiapan.getMode();
        for (int i=0 ; i< teams.length ; i++){
            tim1.addItem(teams[i]);
            tim2.addItem(teams[i]);
        }
        for (int i=0 ; i<modes.length ; i++){
            mode.addItem(modes[i]);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playButton = new javax.swing.JButton();
        mode = new javax.swing.JComboBox<>();
        tim1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tim2 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        playButton.setText("Start");
        playButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playButtonMouseClicked(evt);
            }
        });
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });

        mode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modeActionPerformed(evt);
            }
        });

        tim1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tim1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Mode Pertandingan");

        jLabel2.setText("Tim 1");

        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jLabel3.setText("Kategori Pertandingan");

        jLabel4.setText("Tim 2");

        tim2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tim2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1)
                    .addComponent(playButton)
                    .addComponent(mode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4))
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tim1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(tim2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(241, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton3)
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tim1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tim2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(playButton)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_playButtonActionPerformed

    private void playButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playButtonMouseClicked
        String namakategori = "";
        String namamode = mode.getSelectedItem().toString();
        String namatim1 = tim1.getSelectedItem().toString();
        String namatim2 = tim2.getSelectedItem().toString();
        if (jRadioButton1.isSelected()){
            namakategori = jRadioButton2.getText();
        }
        else if (jRadioButton2.isSelected()){
            namakategori = jRadioButton2.getText();
        }
        else if (jRadioButton3.isSelected()){
            namakategori = jRadioButton3.getText();
        }
        if (namatim1 == null ? namatim2 == null : namatim1.equals(namatim2)){
            jLabel5.setText("Tim Tidak Boleh Sama");
            return;
        }
        if ("".equals(namakategori)) {
            jLabel5.setText("Kategori harus dipilih");
            return;
        }
        
        ControllerPersiapan controllerPersiapan = new ControllerPersiapan();
        controllerPersiapan.PlayButtonClicked(namamode, namatim1, namatim2, namakategori);
        this.setVisible(false);
    }//GEN-LAST:event_playButtonMouseClicked

    private void tim1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tim1ActionPerformed

    }//GEN-LAST:event_tim1ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
    
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
          
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void modeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modeActionPerformed
        if (mode.getSelectedItem() != null){
            String kategories[] = null;
            ControllerPersiapan controllerPersiapan = new ControllerPersiapan();
            kategories = controllerPersiapan.getKategori(mode.getSelectedItem().toString());
            jRadioButton1.setText(kategories[0]);
            jRadioButton2.setText(kategories[1]);
            jRadioButton3.setText(kategories[2]);
        }
        
        
//        if (null != mode.getSelectedItem().toString())switch (mode.getSelectedItem().toString()) {
//            case "Easy":
//                jRadioButton1.setText("Easy A");
//                jRadioButton2.setText("Easy B");
//                jRadioButton3.setText("Easy C");
//                break;
//            case "Medium":
//                jRadioButton1.setText("Medium A");
//                jRadioButton2.setText("Medium B");
//                jRadioButton3.setText("Medium C");
//                break;
//            case "Hard":
//                jRadioButton1.setText("Hard A");
//                jRadioButton2.setText("Hard B");
//                jRadioButton3.setText("Hard C");
//                break;
//            default:
//                break;
//        }
    }//GEN-LAST:event_modeActionPerformed

    private void tim2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tim2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tim2ActionPerformed
  
    private void groupButton(){
        ButtonGroup bg1 = new ButtonGroup();
        
       
        bg1.add(jRadioButton1);
        bg1.add(jRadioButton2);
        bg1.add(jRadioButton3);
    }
    
   
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
            java.util.logging.Logger.getLogger(HalamanPersiapan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HalamanPersiapan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HalamanPersiapan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HalamanPersiapan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HalamanPersiapan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JComboBox<String> mode;
    private javax.swing.JButton playButton;
    private javax.swing.JComboBox<String> tim1;
    private javax.swing.JComboBox<String> tim2;
    // End of variables declaration//GEN-END:variables
}