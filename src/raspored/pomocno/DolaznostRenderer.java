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
import raspored.model.Student;

/**
 *
 * @author Polaznik
 */
public class DolaznostRenderer extends JLabel implements ListCellRenderer<Student> {
 
    @Override
    public Component getListCellRendererComponent(JList<? extends Student> list, Student student, int index,
        boolean isSelected, boolean cellHasFocus) {
        
       
        String s = student.getIme()+ "                                   ";
        setOpaque(true);
       
        setText(s.substring(0,25) + "|        " +  student.getPrezime().toString() + ": " + student.getBrojDolaznosti() );
        if(isSelected){
            setBackground(Color.GREEN);
        }else{
            setBackground(list.getBackground());
        }    
        return this;
    }
    
}