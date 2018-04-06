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
import raspored.model.Smjer;

/**
 *
 * @author Profesor
 */
public class SmjerRenderer extends JLabel implements ListCellRenderer<Smjer> {
 
    @Override
    public Component getListCellRendererComponent(JList<? extends Smjer> list, Smjer smjer, int index,
        boolean isSelected, boolean cellHasFocus) {
        
       
        String s = smjer.getNaziv() + "                                                                 ";
        setOpaque(true);
       
        setText(s.substring(0,25) + "|        " +  smjer.getOpis().toString() );
        if(isSelected){
            setBackground(Color.GREEN);
        }else{
            setBackground(list.getBackground());
        }    
        return this;
    }
    
}
