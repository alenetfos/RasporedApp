/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raspored.pomocno;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import raspored.model.Predmet;

/**
 *
 * @author FeritApostol
 */
public class PredmetRenderer extends JLabel implements ListCellRenderer<Predmet> {
 
    @Override
    public Component getListCellRendererComponent(JList<? extends Predmet> list, Predmet predmet, int index,
        boolean isSelected, boolean cellHasFocus) {
        
       
        String p = predmet.getNaziv() + "                                                                 ";
        setOpaque(true);
       
        setText(p.substring(0,25) + "|        " +  predmet.getBrojSati());
        if(isSelected){
            setBackground(Color.GREEN);
        }else{
            setBackground(list.getBackground());
        }    
        return this;
    }
    
}
