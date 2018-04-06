/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raspored.pomocno;

import raspored.controller.Obrada;
import raspored.model.Godina;
import raspored.model.Smjer;

/**
 *
 * @author Polaznik
 */
public class Test {
    
    public static void main(String[] args) {
        
        Smjer s = new Smjer();
        s.setNaziv("Informatika");
        s.setOpis("Stručni Studij");
        
        Obrada<Smjer> os = new Obrada<>();
        
        s = os.save(s);
        
        Godina g = new Godina();
        g.setBrojGodine("1.godina");
        
        Obrada<Godina> os1 = new Obrada<>();
        
        g = os1.save(g);
    }
    
}
