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
@Table(name = "velemeny")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Velemeny.findAll", query = "SELECT v FROM Velemeny v")
    , @NamedQuery(name = "Velemeny.findById", query = "SELECT v FROM Velemeny v WHERE v.id = :id")
    , @NamedQuery(name = "Velemeny.findByLeiras", query = "SELECT v FROM Velemeny v WHERE v.leiras = :leiras")
    , @NamedQuery(name = "Velemeny.findBySzerzo", query = "SELECT v FROM Velemeny v WHERE v.szerzo = :szerzo")})
public class Velemeny implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "leiras")
    private String leiras;
    @Basic(optional = false)
    @Column(name = "szerzo")
    private String szerzo;

    public Velemeny() {
    }

    public Velemeny(Integer id) {
        this.id = id;
    }

    public Velemeny(Integer id, String leiras, String szerzo) {
        this.id = id;
        this.leiras = leiras;
        this.szerzo = szerzo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    public String getSzerzo() {
        return szerzo;
    }

    public void setSzerzo(String szerzo) {
        this.szerzo = szerzo;
    }
    
    // az adatok listázása
    public static List<Velemeny> getAllVelemenyById(EntityManager em){
        List<Velemeny> velemenyek = new ArrayList();
        StoredProcedureQuery spq = em.createStoredProcedureQuery("getAllVelemenyById");
        List<Object[]> lista = spq.getResultList();
        for(Object[] velemeny : lista){
            Velemeny v = new Velemeny();
            v = em.find(Velemeny.class, velemeny[0]);
            velemenyek.add(v);
        }
        return velemenyek;
    }
    
    // módosítás
    public static Velemeny findVelemenyById(EntityManager em, int id){
        List<Velemeny> elemek = Velemeny.getAllVelemenyById(em);
        Velemeny e = em.find(Velemeny.class, id);
        return e;
    }
    
    public static void updateVelemeny(EntityManager em, int id, String leiras, String szerzo){
        Velemeny e = Velemeny.findVelemenyById(em, id);
        em.getTransaction().begin();
        e.setLeiras(leiras);
        e.setSzerzo(szerzo);
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
        if (!(object instanceof Velemeny)) {
            return false;
        }
        Velemeny other = (Velemeny) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "backend.Velemeny[ id=" + id + " ]";
    }
    
}
