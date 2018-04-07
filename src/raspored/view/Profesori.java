/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raspored.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import raspored.controller.Obrada;
import raspored.model.Predmet;
import raspored.model.Profesor;
import raspored.pomocno.HibernateUtil;
import raspored.pomocno.ProfesorRenderer;

/**
 *
 * @author FeritApostol
 */
public class Profesori extends javax.swing.JFrame {

    private Obrada<Profesor> obrada;
     
    private Border obrub;

    public Profesori() {
        initComponents();
        
        obrada = new Obrada<>();
                
        lista.setCellRenderer(new ProfesorRenderer());
        
        napuniPredmet();
        
        ucitajPodatke();
    }
    
    private void napuniPredmet(){
        DefaultComboBoxModel<Predmet> model = new DefaultComboBoxModel<>();

        List<Predmet> lista = HibernateUtil.getSession().createQuery(
                "from Predmet").list();

        for (Predmet p : lista) {
            model.addElement(p);
        }

        this.cmbPredmet.setModel(model);
    }

    private Profesor napuniObjekt(Profesor p) {
        p.setOib(Integer.parseInt(txtOib.getText()));
        p.setIme(txtIme.getText());
        p.setPrezime(txtPrezime.getText());
        //Pukne zbog linije 65
        p.setPredmeti((List<Predmet>) cmbPredmet.getItemAt(cmbPredmet.getSelectedIndex()));
        return p;
    }
    
    private void ucitajPodatke() {
        
        DefaultListModel<Profesor> model = new DefaultListModel<>();

        List<Profesor> lista = HibernateUtil.getSession().createQuery(
                "from Profesor").list();

        for (Profesor p : lista) {
            model.addElement(p);
        }
        this.lista.setModel(model);

    }
    
    private void oznaciGresku(JTextField polje) {
        polje.setBorder(BorderFactory.createLineBorder(Color.decode("#FF0000")));
        polje.requestFocus();
    }
    
    private void resetirajGreske() {
         txtOib.setBorder(obrub); 
         txtIme.setBorder(obrub);
         txtPrezime.setBorder(obrub);
    }
     
    private boolean kontrola() {
        if (txtOib.getText().trim().length() == 0) {
            oznaciGresku(txtOib);
            return false;
        }
        if (txtIme.getText().trim().length() == 0) {
            oznaciGresku(txtIme);
            return false;
        }
        if (txtPrezime.getText().trim().length() == 0) {
            oznaciGresku(txtPrezime);
            return false;
        }
        return true;
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
        lista = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        btnDodaj = new javax.swing.JButton();
        btnPromjeni = new javax.swing.JButton();
        btnIzbrisi = new javax.swing.JButton();
        btnPovratak = new javax.swing.JButton();
        txtOib = new javax.swing.JTextField();
        txtIme = new javax.swing.JTextField();
        txtPrezime = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbPredmet = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        lista.setBackground(new java.awt.Color(240, 240, 240));
        lista.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lista);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel1.setText("PROFESORI");

        btnDodaj.setBackground(new java.awt.Color(0, 0, 0));
        btnDodaj.setForeground(new java.awt.Color(0, 255, 0));
        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnPromjeni.setBackground(new java.awt.Color(0, 0, 0));
        btnPromjeni.setForeground(new java.awt.Color(0, 0, 255));
        btnPromjeni.setText("Promjeni");
        btnPromjeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjeniActionPerformed(evt);
            }
        });

        btnIzbrisi.setBackground(new java.awt.Color(0, 0, 0));
        btnIzbrisi.setForeground(new java.awt.Color(255, 0, 0));
        btnIzbrisi.setText("Izbriši");
        btnIzbrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzbrisiActionPerformed(evt);
            }
        });

        btnPovratak.setBackground(new java.awt.Color(0, 0, 0));
        btnPovratak.setForeground(new java.awt.Color(255, 255, 0));
        btnPovratak.setText("<Povratak>");
        btnPovratak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPovratakActionPerformed(evt);
            }
        });

        jLabel2.setText("Oib");

        jLabel3.setText("Ime");

        jLabel4.setText("Prezime");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(0, 261, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtOib, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtIme, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtPrezime, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(btnIzbrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(btnPovratak))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(btnPromjeni, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(18, 18, 18)
                                        .addComponent(cmbPredmet, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(176, 176, 176))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbPredmet)
                            .addComponent(txtOib, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPromjeni)
                            .addComponent(btnDodaj))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnIzbrisi)
                            .addComponent(btnPovratak))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed

        resetirajGreske();
        if (!kontrola()) {
            return;
        }
        
        Profesor p = new Profesor();
        p = napuniObjekt(p);
        obrada.save(p);
        ucitajPodatke();
    }//GEN-LAST:event_btnDodajActionPerformed

    private void listaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaValueChanged

        evt.getValueIsAdjusting();
    }//GEN-LAST:event_listaValueChanged

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        // Determine the new location of the window
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;

        // Move the window
        this.setLocation(x, y);
    }//GEN-LAST:event_formWindowActivated

    private void btnPromjeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniActionPerformed

        Profesor p = lista.getSelectedValue();
        if (p == null) {
            JOptionPane.showMessageDialog(getRootPane(), "Prvo odaberite stavku");
            return;
        }

        if (txtOib.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(getRootPane(), "Obavezno Oib");
            return;
        }
        if (txtIme.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(getRootPane(), "Obavezno Ime");
            return;
        }
        if (txtPrezime.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(getRootPane(), "Obavezno Prezime");
            return;
        }
        
        if (!kontrola()) {
            return;
        }
        napuniObjekt(p);
        obrada.save(p);
        ucitajPodatke();
    }//GEN-LAST:event_btnPromjeniActionPerformed

    private void btnIzbrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzbrisiActionPerformed

        resetirajGreske();
        if (!kontrola()) {
            return;
        }
        
        Profesor p = new Profesor();
        p = napuniObjekt(p);
        obrada.save(p);
        ucitajPodatke();
    }//GEN-LAST:event_btnIzbrisiActionPerformed

    private void btnPovratakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPovratakActionPerformed

        this.dispose();
    }//GEN-LAST:event_btnPovratakActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzbrisi;
    private javax.swing.JButton btnPovratak;
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JComboBox<Predmet> cmbPredmet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Profesor> lista;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtOib;
    private javax.swing.JTextField txtPrezime;
    // End of variables declaration//GEN-END:variables
}
