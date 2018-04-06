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
import raspored.model.Profesor;

/**
 *
 * @author FeritApostol
 */
public class ProfesorRenderer extends JLabel implements ListCellRenderer<Profesor> {
 
    @Override
    public Component getListCellRendererComponent(JList<? extends Profesor> list, Profesor profesor, int index,
        boolean isSelected, boolean cellHasFocus) {
        
       
        String p = profesor.getIme()+ "                                   ";
        setOpaque(true);
       
        setText(p.substring(0,25) + "|        " +  profesor.getPrezime().toString() );
        if(isSelected){
            setBackground(Color.GREEN);
        }else{
            setBackground(list.getBackground());
        }    
        return this;
    }
    
}
