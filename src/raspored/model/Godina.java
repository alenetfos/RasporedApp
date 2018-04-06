/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raspored.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Polaznik
 */

@Entity
@Table
public class Godina implements Serializable {
    
    @Id
    @GeneratedValue
    private int idGodina;
    
    @ManyToOne
    private Smjer smjer;
    
    private String brojGodine;

    public Smjer getSmjer() {
        return smjer;
    }

    public void setSmjer(Smjer smjer) {
        this.smjer = smjer;
    }

    public int getIdGodina() {
        return idGodina;
    }

    public void setIdGodina(int idGodina) {
        this.idGodina = idGodina;
    }

    public String getBrojGodine() {
        return brojGodine;
    }

    public void setBrojGodine(String brojGodine) {
        this.brojGodine = brojGodine;
    }
    
    @Override
    public String toString() {
       return getBrojGodine();
    }

    
}
