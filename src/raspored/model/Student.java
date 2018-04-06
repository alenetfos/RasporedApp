/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raspored.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author FeritApostol
 */
@Entity
@Table
public class Student implements Serializable {
    
    @Id
    @GeneratedValue
    private int idStudent;
    private String brojIndexa; 
    private String ime;
    private String prezime;
    private int brojDolaznosti;
    private BigDecimal postotak;
    
    
     
    @ManyToMany(mappedBy = "studenti")
    private List<Predmet> predmeti=new ArrayList<>(); 
    
      public List<Predmet> getPredmeti() {
        return predmeti;
    }

    public void setPredmeti(List<Predmet> predmeti) {
        this.predmeti = predmeti;
    }
    
    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getBrojDolaznosti() {
        return brojDolaznosti;
    }

    public void setBrojDolaznosti(int brojDolaznosti) {
        this.brojDolaznosti = brojDolaznosti;
    }

    public String getBrojIndexa() {
        return brojIndexa;
    }

    public void setBrojIndexa(String brojIndexa) {
        this.brojIndexa = brojIndexa;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public BigDecimal getPostotak() {
        return postotak;
    }

    public void setPostotak(BigDecimal postotak) {
        this.postotak = postotak;
    }

    @Override
    public String toString() {
       return getIme()+" "+ getBrojDolaznosti();
    }
 
}
