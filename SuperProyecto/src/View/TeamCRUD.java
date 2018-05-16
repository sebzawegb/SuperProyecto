/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import ModelUML.Team;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Sebas
 */
public class TeamCRUD extends javax.swing.JDialog {

    /**
     * A return status code - returned if Cancel button has been pressed
     */
    public static final int RET_CANCEL = 0;
    /**
     * A return status code - returned if OK button has been pressed
     */
    public static final int RET_OK = 1;
    /**
     * El modo de la ventana, que determina qué función del CRUD se supone que
     * realice.
     */
    private static byte mode;

    private static ArrayList<Team> teams;
    private static boolean[] errors = {false, false};

    /**
     * Creates new form TeamCRUD
     *
     * @param parent el elemento padre
     * @param modal modal
     * @param mode mode
     */
    public TeamCRUD(java.awt.Frame parent, boolean modal, byte mode) {
        super(parent, modal);
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

        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
        this.mode = mode;
        mode();
    }

    /**
     * @return the return status of this dialog - one of RET_OK or RET_CANCEL
     */
    public int getReturnStatus() {
        return returnStatus;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();

        jScrollPane1.setViewportView(jEditorPane1);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        okButton.setText("Aceptar");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre del Equipo");

        jLabel4.setText("Nacionalidad (Opcional)");

        jLabel5.setText("Dueño");

        jTextField2.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField2CaretUpdate(evt);
            }
        });

        jTextField1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField1CaretUpdate(evt);
            }
        });

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField2)
                            .addComponent(jTextField1)))
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        getRootPane().setDefaultButton(okButton);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        doClose(RET_CANCEL);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed

        if (!errors[0] || !errors[1]) {
            if (validar()) {
                switch (mode) {//cdru
                    case 0:
                        try {
                            if (jTextField1.getText().isEmpty()) {
                                ViewController.insertTeam(jTextField2.getText(), jComboBox1.getSelectedItem().toString());
                            } else {
                                ViewController.insertTeam(jTextField2.getText(), jTextField1.getText().toUpperCase(), jComboBox1.getSelectedItem().toString());
                            }
                            JOptionPane.showMessageDialog(this, "Equipo insertado.");
                            clear();
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(TeamCRUD.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(TeamCRUD.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    case 1:
                        try {
                            ViewController.deleteTeam(jTextField2.getText());
                            JOptionPane.showMessageDialog(this, "Equipo '" + jComboBox2.getSelectedItem() + "' eliminado.");
                            clear();
                            mode();
                            jComboBox2.setSelectedIndex(-1);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(TeamCRUD.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(TeamCRUD.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    case 2:
                        dispose();
                        break;
                    case 3:
                        try {
                            if (jTextField1.getText().isEmpty()) {
                                ViewController.updateTeam(jComboBox2.getSelectedItem().toString(), jTextField2.getText(), jComboBox1.getSelectedItem().toString());
                            } else {
                                ViewController.updateTeam(jComboBox2.getSelectedItem().toString(), jTextField2.getText(), jTextField1.getText().toUpperCase(), jComboBox1.getSelectedItem().toString());
                            }
                            JOptionPane.showMessageDialog(this, "Equipo '" + jComboBox2.getSelectedItem() + "' modificado.");
                            clear();
                            mode();
                            jComboBox2.setSelectedIndex(-1);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(TeamCRUD.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(TeamCRUD.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                }

            } else {
                JOptionPane.showMessageDialog(this, "Por favor rellena todos los datos");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Uno de los campos es demasiado largo.");
        }

    }//GEN-LAST:event_okButtonActionPerformed
    /**
     * Verifica la validez del campo.
     *
     * @param evt
     */
    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        teams.stream().filter(p -> p.getTeamName().equals((String) jComboBox2.getSelectedItem())).findFirst().ifPresent(c -> { //juro por todos los santos que esto no lo busqué en google
            jTextField2.setText(c.getTeamName());
            String s = (String) c.getTeamOwner().getUserName();
            jComboBox1.setSelectedItem(s);
            jTextField1.setText(c.getNationality());
        });
    }//GEN-LAST:event_jComboBox2ActionPerformed
    /**
     * Verifica la validez del campo.
     *
     * @param evt
     */
    private void jTextField2CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField2CaretUpdate
        if (jTextField2.getText().length() > 12) {
            jTextField2.setBackground(Color.RED);
            errors[0] = true;
        } else {
            jTextField2.setBackground(Color.WHITE);
            errors[0] = false;
        }
    }//GEN-LAST:event_jTextField2CaretUpdate
    /**
     * Verifica la validez del campo.
     *
     * @param evt
     */
    private void jTextField1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField1CaretUpdate
        if (jTextField1.getText().length() > 2) {
            jTextField1.setBackground(Color.RED);
            errors[1] = true;
        } else {
            jTextField1.setBackground(Color.WHITE);
            errors[1] = false;
        }
    }//GEN-LAST:event_jTextField1CaretUpdate

    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TeamCRUD dialog = new TeamCRUD(new javax.swing.JFrame(), true, mode);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables

    private int returnStatus = RET_CANCEL;

    /**
     * Valida que los campos esten llenos
     *
     * @return true si estan llenos, false si estan vacios
     */
    private boolean validar() {
        if (jTextField2.getText().isEmpty() || jComboBox1.getSelectedIndex() == -1) {
            return false;
        }
        return true;
    }

    private void clear() {
        jComboBox1.setSelectedIndex(-1);
        jTextField1.setText("");
        jTextField2.setText("");
    }

    private void mode() {
        jComboBox2.removeAllItems();
        try {
            if (mode != 0) {
                teams = ViewController.selectDBTeams();
                teams.forEach(e -> jComboBox2.addItem(e.getTeamName()));
                if (mode != 3) {
                    jComboBox1.setEnabled(false);
                    jTextField1.setEnabled(false);
                    jTextField2.setEnabled(false);
                }
                jComboBox2.setSelectedIndex(-1);

            } else {
                jComboBox2.setVisible(false);
                pack();
            }
            //jComboBox1.addItem("Ninguno");
            ViewController.selectDBOwners().forEach(e -> jComboBox1.addItem(e.getUserName()));
            jComboBox1.setSelectedIndex(-1);
        } catch (SQLException ex) {
            Logger.getLogger(UserCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        clear();
    }
}
