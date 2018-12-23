/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zsobe31
 */
@Entity
@Table(name = "termekek")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Termekek.findAll", query = "SELECT t FROM Termekek t")
    , @NamedQuery(name = "Termekek.findById", query = "SELECT t FROM Termekek t WHERE t.id = :id")
    , @NamedQuery(name = "Termekek.findByNev", query = "SELECT t FROM Termekek t WHERE t.nev = :nev")
    , @NamedQuery(name = "Termekek.findByKep", query = "SELECT t FROM Termekek t WHERE t.kep = :kep")})
public class Termekek implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nev")
    private String nev;
    @Basic(optional = false)
    @Lob
    @Column(name = "leiras")
    private String leiras;
    @Basic(optional = false)
    @Column(name = "kep")
    private String kep;

    public Termekek() {
    }

    public Termekek(Integer id) {
        this.id = id;
    }

    public Termekek(Integer id, String nev, String leiras, String kep) {
        this.id = id;
        this.nev = nev;
        this.leiras = leiras;
        this.kep = kep;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    public String getKep() {
        return kep;
    }

    public void setKep(String kep) {
        this.kep = kep;
    }
    
    // az adatok listázása
    public static List<Termekek> getAllTermekekById(EntityManager em){
        List<Termekek> elemek = new ArrayList();
        StoredProcedureQuery spq = em.createStoredProcedureQuery("getAllTermekekById");
        List<Object[]> lista = spq.getResultList();
        for(Object[] elem : lista){
            Termekek e = new Termekek();
            e = em.find(Termekek.class, elem[0]);
            elemek.add(e);
        }
        return elemek;
    } 
    
    // módosítás
    public static Termekek findTermekekById(EntityManager em, int id){
        List<Termekek> elemek = Termekek.getAllTermekekById(em);
        Termekek e = em.find(Termekek.class, id);
        return e;
    }
    
    public static void updateTermekek(EntityManager em, int id, String nev, String leiras, String kep){
        Termekek e = Termekek.findTermekekById(em, id);
        em.getTransaction().begin();
        e.setNev(nev);
        e.setLeiras(leiras);
        e.setKep(kep);
        em.getTransaction().commit();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Termekek)) {
            return false;
        }
        Termekek other = (Termekek) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "backend.Termekek[ id=" + id + " ]";
    }
    
}
