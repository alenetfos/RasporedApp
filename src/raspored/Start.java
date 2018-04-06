/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raspored;

import raspored.pomocno.HibernateUtil;
import raspored.view.Izbornik;


public class Start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        HibernateUtil.getSession();
        new Izbornik().setVisible(true);
        
    }
    
}
