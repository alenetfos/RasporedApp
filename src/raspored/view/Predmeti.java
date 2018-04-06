/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raspored.view;

import com.sun.org.apache.xerces.internal.impl.dtd.models.CMBinOp;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.math.BigDecimal;
import java.util.List;
import static java.util.logging.Level.parse;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import raspored.controller.Obrada;
import raspored.model.Godina;
import raspored.model.Predmet;
import raspored.pomocno.HibernateUtil;
import raspored.pomocno.PredmetRenderer;

/**
 *
 * @author FeritApostol
 */
public class Predmeti extends javax.swing.JFrame {

    private Obrada<Predmet> obrada;
     
    private Border obrub;
    /**
     * Creates new form Predmeti
     */
    public Predmeti() {
        initComponents();
        
        obrada = new Obrada<>();
        
        lista.setCellRenderer(new PredmetRenderer());
        
        napuniGodinu();
             
        ucitajPodatke();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        btnDodaj = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        btnPromjeni = new javax.swing.JButton();
        txtNazivPredmeta = new javax.swing.JTextField();
        txtBrojSati = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        cmbGodina = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(436, 345));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        lista.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lista);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel1.setText("PREDMETI");

        btnDodaj.setBackground(new java.awt.Color(0, 0, 0));
        btnDodaj.setForeground(new java.awt.Color(0, 255, 0));
        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnObrisi.setBackground(new java.awt.Color(0, 0, 0));
        btnObrisi.setForeground(new java.awt.Color(255, 0, 0));
        btnObrisi.setText("Obriši");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
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

        jLabel2.setText("Naziv Predmeta");

        jLabel3.setText("Broj sati");

        btnBack.setBackground(new java.awt.Color(0, 0, 0));
        btnBack.setForeground(new java.awt.Color(255, 255, 0));
        btnBack.setText("<Povratak>");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtNazivPredmeta, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnPromjeni))
                                    .addComponent(btnObrisi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBack, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBrojSati, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addComponent(cmbGodina, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbGodina)
                            .addComponent(txtNazivPredmeta, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBrojSati, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDodaj)
                            .addComponent(btnPromjeni))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnObrisi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(btnBack))
                    .addComponent(jScrollPane1))
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
        
        Predmet p = new Predmet();
        p = napuniObjekt(p);
        obrada.save(p);
        ucitajPodatke();
    }//GEN-LAST:event_btnDodajActionPerformed

    private void listaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaValueChanged

                evt.getValueIsAdjusting();
    }//GEN-LAST:event_listaValueChanged

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed

        Predmet p = lista.getSelectedValue();
        if (p == null) {
            JOptionPane.showMessageDialog(getRootPane(), "Prvo odaberite stavku");
            return;
        }
        
        obrada.delete(p);
        ucitajPodatke();
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnPromjeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniActionPerformed

        Predmet p = lista.getSelectedValue();
        if (p == null) {
            JOptionPane.showMessageDialog(getRootPane(), "Prvo odaberite stavku");
            return;
        }

        if (txtNazivPredmeta.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(getRootPane(), "Obavezno naziv");
            return;
        }
        if (txtBrojSati.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(getRootPane(), "Obavezno broj sati");
            return;
        }
        
        if (!kontrola()) {
            return;
        }
        napuniObjekt(p);
        obrada.save(p);
        ucitajPodatke();
    }//GEN-LAST:event_btnPromjeniActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

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

    private Predmet napuniObjekt(Predmet p) {
        p.setBrojSati(Integer.parseInt(txtBrojSati.getText().toString()));
        p.setNaziv(txtNazivPredmeta.getText());
        p.setGodina(cmbGodina.getItemAt(cmbGodina.getSelectedIndex()));
        return p;
    }
    
    private void napuniGodinu(){
        DefaultComboBoxModel<Godina> model = new DefaultComboBoxModel<>();

        List<Godina> lista = HibernateUtil.getSession().createQuery(
                "from Godina").list();

        for (Godina g : lista) {
            model.addElement(g);
        }

        this.cmbGodina.setModel(model);
    }
    private void ucitajPodatke() {
        
        DefaultListModel<Predmet> model = new DefaultListModel<>();

        List<Predmet> lista = HibernateUtil.getSession().createQuery(
                "from Predmet").list();

        for (Predmet p : lista) {
            model.addElement(p);
        }
        this.lista.setModel(model);

    }
    
    private void resetirajGreske() {
        txtBrojSati.setBorder(obrub);
        txtNazivPredmeta.setBorder(obrub);
    }
    
    private void oznaciGresku(JTextField polje) {
        polje.setBorder(BorderFactory.createLineBorder(Color.decode("#FF0000")));
        polje.requestFocus();
    }
    
    private boolean kontrola() {
        if (txtNazivPredmeta.getText().trim().length() == 0) {
            oznaciGresku(txtNazivPredmeta);
            return false;
        }

        if (txtBrojSati.getText().trim().length() == 0) {
            oznaciGresku(txtBrojSati);
            return false;
        }
        try {
            Integer.parseInt(txtBrojSati.getText());
        } catch (Exception e) {
            oznaciGresku(txtBrojSati);
            JOptionPane.showMessageDialog(getRootPane(), "Unesite broj!");
            return false;
        }
        return true;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JComboBox<Godina> cmbGodina;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Predmet> lista;
    private javax.swing.JTextField txtBrojSati;
    private javax.swing.JTextField txtNazivPredmeta;
    // End of variables declaration//GEN-END:variables
}
