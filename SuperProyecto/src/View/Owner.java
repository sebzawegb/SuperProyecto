/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import ModelUML.*;
import DB.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import superproyecto.*;

/**
 * @author Sebastián Zawisza
 * @author Sergio Zulueta
 * @author Jon Maneiro
 * @version %I% %G%
 * @since 1.0
 */
public class Owner extends javax.swing.JFrame {

    private static byte mode, progress;
    private static boolean child;

    //
    Connection con;
    private ArrayList<Team> teamList;
    private ArrayList<Player> playersList;

    /**
     * Creates new form User
     */
    public Owner(boolean child) {
        initComponents();
        //<editor-fold defaultstate="collapsed" desc=" System look and feel setting code ">
        try {
            /* Set the System look and feel */
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //Para centrar la ventana
        setLocationRelativeTo(null);

        mode = 0;
        progress = 0;
        if (child) {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }

        teamList = new ArrayList<>();
        //query get teams, players. Despues llenar cbTeam
        try {
            con = DBController.createConnection();

            teamList = DBTeam.getTeams(con);
            playersList = DBPlayer.selectAllPlayers(con);
            fillTeamBox();
        } catch (Exception e) {
            System.out.println("excep");
        }

        jbConfirm.setEnabled(true);
    }

    public void fillTeamBox() {
        for (Team team : teamList) {
            cbTeam.addItem(team.getTeamName());
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        cbTeam = new javax.swing.JComboBox<>();
        jbUser = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbPlayer = new javax.swing.JComboBox<>();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jbConfirm = new javax.swing.JButton();
        jbFix = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Equipo");

        cbTeam.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTeamItemStateChanged(evt);
            }
        });
        cbTeam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTeamActionPerformed(evt);
            }
        });

        jbUser.setText("Vista de Usuario");
        jbUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUserActionPerformed(evt);
            }
        });

        jLabel2.setText("Jugador");

        cbPlayer.setMaximumRowCount(50);
        cbPlayer.setEnabled(false);
        cbPlayer.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbPlayerItemStateChanged(evt);
            }
        });
        cbPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPlayerActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Añadir");
        jRadioButton1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton1ItemStateChanged(evt);
            }
        });
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Restar");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jbConfirm.setText("Aceptar");
        jbConfirm.setEnabled(false);
        jbConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfirmActionPerformed(evt);
            }
        });

        jbFix.setText("Fijar Equipo");
        jbFix.setEnabled(false);
        jbFix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFixActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbFix, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton2)
                                    .addComponent(jRadioButton1)))
                            .addComponent(jbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jRadioButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton2)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbConfirm)
                    .addComponent(jbFix))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbUser)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
     * Realiza el cambio al equipo del jugador en cuestión.
     *
     * @param evt Generado automáticamente.
     */
    private void cbTeamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTeamActionPerformed
        // TODO add your handling code here:        
        buttonGroup1.clearSelection();
        refresh();
    }//GEN-LAST:event_cbTeamActionPerformed
    /**
     * Abre una ventana de confirmación, y si el usuario está seguro, fija el
     * estado del equipo para prevenir modificación.
     *
     * @param evt Generado automáticamente.
     */
    private void jbFixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFixActionPerformed
        JOptionPane.showConfirmDialog(rootPane, "Si desea revertir éste cambio necesitará contactar a su administrador.\n¿Está completamente seguro de que quiere fijar su equpo?");


    }//GEN-LAST:event_jbFixActionPerformed

    private void buttonConfirm(String buttonMode) {

        switch (buttonMode) {
            case "add":
                updatePlayerAdd();

                break;
            case "remove":
                updatePlayerRest();

        }

    }

    /**
     * El update para elminar al jugador del equipo
     */
    private void updatePlayerRest() {
        //llamar a a base de datos para UPDATE a ese jugador
        String playerName = cbPlayer.getSelectedItem().toString();
        Player player1 = new Player();
        String teamName = cbTeam.getSelectedItem().toString();

        Team team = new Team();

        for (Team tema : teamList) {
            if (tema.getTeamName().equalsIgnoreCase(teamName)) {
                team = tema;
            }
        }

        for (Player player : playersList) {
            if (player.getNickName().equalsIgnoreCase(playerName)) {
                player1 = player;
            }
        }
        //se va a ir del equipo
        try {
            DBPlayer.updatePlayerTeamEmpty(player1.getNickName(), con);
            //update arraylist team y player
            for (Player player : playersList) {
                if (player.getNickName().equalsIgnoreCase(playerName)) {
                    player.setTeam(new Team());
                }
            }
            for (Team t : teamList) {
                if (t.getTeamName().equalsIgnoreCase(teamName)) {
                    ArrayList<Player> p = t.getPlayers();
                    try {

                        for (int i = 0; i < t.getPlayers().size(); i++) {
                            if (p.get(i).getNickName().equalsIgnoreCase(playerName)) {
                                p.remove(i);

                                t.setPlayers(p);
                            }

                        }
                    } catch (NullPointerException e) {
                        System.out.println("");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("excepcion ");
        }
        cbPlayer.removeAllItems();

    }

    
    /**
     * El update para añadir un jugador a un equipo
     */
    private void updatePlayerAdd() {
        //llamar a a base de datos para UPDATE a ese jugador
        String playerName = cbPlayer.getSelectedItem().toString();
        Player player1 = new Player();
        String teamName = cbTeam.getSelectedItem().toString();

        Team team = new Team();

        for (Team tema : teamList) {
            if (tema.getTeamName().equalsIgnoreCase(teamName)) {
                team = tema;
            }
        }
        int teamID;
        try {
            teamID = DBTeam.searchTeam(teamName, con);
        } catch (SQLException ex) {
            System.out.println("excepcion searchtema, team = 0");
            teamID = 0;
        }

        for (Player player : playersList) {
            if (player.getNickName().equalsIgnoreCase(playerName)) {
                player1 = player;
            }
        }

        //se va a ir a un nuevo equipo
        try {
            DBPlayer.updatePlayerT(player1.getFullName(), player1.getNickName(), player1.getNickName(), player1.getSalary(), player1.getEmail(), teamID, con);
            //update arraylist team y player
            for (Player player : playersList) {
                if (player.getNickName().equalsIgnoreCase(playerName)) {
                    player.setTeam(team);
                }
            }
            for (Team t : teamList) {
                if (t.getTeamName().equalsIgnoreCase(teamName)) {
                    t.addPlayer(player1);
                }
            }

        } catch (Exception e) {
            System.out.println("excepcion ");
        }
        cbPlayer.removeAllItems();

    }

    /**
     * Actualiza el estado de la ventana de acuerdo al radiobutton seleccionado.
     *
     * @param evt
     */
    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        mode = 1;
        refresh();
        cbPlayer.removeAllItems();

        String team = "";

        if (jRadioButton1.isSelected()) {
            cbPlayer.setEnabled(true);

        } else {
            cbPlayer.setEnabled(false);

        }

        int teamNum = cbTeam.getItemCount();
        if (cbTeam.getSelectedIndex() != -1) {
            team = (String) cbTeam.getSelectedItem();
        }
        //con el nombre del equipo comprobar cada equipo al que esta cada jugador
        for (Player player : playersList) {

            String playersTeam = "";

            try {
                playersTeam = player.getTeam().getTeamName();
                if (playersTeam.equalsIgnoreCase("")) {
                    cbPlayer.addItem(player.getNickName());
                }
            } catch (NullPointerException e) {
                //equipoDelPlayer = "";
                cbPlayer.addItem(player.getNickName());
            }

        }


    }//GEN-LAST:event_jRadioButton1ActionPerformed

    /**
     * Actualiza el estado de la ventana de acuerdo al radiobutton seleccionado.
     *
     * @param evt
     */
    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        mode = 2;
        refresh();
        cbPlayer.removeAllItems();

        String team = "";

        if (jRadioButton2.isSelected()) {
            cbPlayer.setEnabled(true);
        } else {
            cbPlayer.setEnabled(false);
        }

        int teamNum = cbTeam.getItemCount();
        if (cbTeam.getSelectedIndex() != -1) {
            team = (String) cbTeam.getSelectedItem();
        }
        //con el nombre del equipo comprobar cada equipo al que esta cada jugador
        for (Player player : playersList) {
            String playersTeam = "";

            try {
                playersTeam = player.getTeam().getTeamName();

                if (playersTeam.equalsIgnoreCase(team)) {
                    cbPlayer.addItem(player.getNickName());
                }
            } catch (Exception e) {
                playersTeam = "";
            }
        }


    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void cbTeamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTeamItemStateChanged
        if (cbTeam.getSelectedIndex() != -1) {
            progress = 1;
            refresh();
        }
        cbPlayer.setEnabled(false);
    }//GEN-LAST:event_cbTeamItemStateChanged

    private void cbPlayerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbPlayerItemStateChanged
        if (cbPlayer.getSelectedIndex() != -1) {
            progress = 2;
            refresh();
        }

    }//GEN-LAST:event_cbPlayerItemStateChanged

    private void jbUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUserActionPerformed
        ViewController.user(true);
    }//GEN-LAST:event_jbUserActionPerformed

    private void cbPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPlayerActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cbPlayerActionPerformed


    private void jbConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfirmActionPerformed
        if (jRadioButton1.isSelected()) {
            buttonConfirm("add");
        } else if (jRadioButton2.isSelected()) {
            buttonConfirm("remove");
        }

        JOptionPane.showMessageDialog(this, "Los equipos han sido modificados correctamente.");
    }//GEN-LAST:event_jbConfirmActionPerformed

    private void jRadioButton1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton1ItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_jRadioButton1ItemStateChanged

    /**
     * El update para elminar al jugador del equipo
     */
    /**
     * Actualiza el estado de componentes en la ventana.
     */
    private void refresh() {
        //hace falta rellenar las combobox teniendo en cuenta el modo, pero eso requiere consultas a bases de datos y eso mejor luego
        if (progress != 0) {
            jbFix.setEnabled(true);
            if (progress == 2) {
                jbConfirm.setEnabled(true);
            }
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Owner(child).setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbPlayer;
    private javax.swing.JComboBox<String> cbTeam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbConfirm;
    private javax.swing.JButton jbFix;
    private javax.swing.JButton jbUser;
    // End of variables declaration//GEN-END:variables
}
