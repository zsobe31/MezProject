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
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zsobe31
 */
@Entity
@Table(name = "bemutatkozas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bemutatkozas.findAll", query = "SELECT b FROM Bemutatkozas b")
    , @NamedQuery(name = "Bemutatkozas.findById", query = "SELECT b FROM Bemutatkozas b WHERE b.id = :id")
    , @NamedQuery(name = "Bemutatkozas.findByKep", query = "SELECT b FROM Bemutatkozas b WHERE b.kep = :kep")})
public class Bemutatkozas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "kep")
    private String kep;
    @Basic(optional = false)
    @Lob
    @Column(name = "leiras")
    private String leiras;

    public Bemutatkozas() {
    }

    public Bemutatkozas(Integer id) {
        this.id = id;
    }

    public Bemutatkozas(Integer id, String kep, String leiras) {
        this.id = id;
        this.kep = kep;
        this.leiras = leiras;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKep() {
        return kep;
    }

    public void setKep(String kep) {
        this.kep = kep;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }
    
    // az adatok listázása
    public static List<Bemutatkozas> getAllBemutatkozasById(EntityManager em){
        List<Bemutatkozas> bemutat = new ArrayList();
        StoredProcedureQuery spq = em.createStoredProcedureQuery("getAllBemutatkozasById");
        List<Object[]> lista = spq.getResultList();
        for(Object[] bemut : lista){
            Bemutatkozas b = new Bemutatkozas();
            b = em.find(Bemutatkozas.class, bemut[0]);
            bemutat.add(b);
        }
        return bemutat;
    }
    
    // módosít
    
    public static Bemutatkozas findBemutatkozasById (EntityManager em, int id){
        List<Bemutatkozas> elem = Bemutatkozas.getAllBemutatkozasById(em);
        Bemutatkozas e = em.find(Bemutatkozas.class, id);
        return e;
    }
    
    public static void updateBemutatkozas(EntityManager em, int id, String kep, String leiras){
        Bemutatkozas e = Bemutatkozas.findBemutatkozasById(em, id);
        em.getTransaction().begin();
        e.setKep(kep);
        e.setLeiras(leiras);
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
        if (!(object instanceof Bemutatkozas)) {
            return false;
        }
        Bemutatkozas other = (Bemutatkozas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "backend.Bemutatkozas[ id=" + id + " ]";
    }
    
}
