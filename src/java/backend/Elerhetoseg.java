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
@Table(name = "elerhetoseg")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Elerhetoseg.findAll", query = "SELECT e FROM Elerhetoseg e")
    , @NamedQuery(name = "Elerhetoseg.findById", query = "SELECT e FROM Elerhetoseg e WHERE e.id = :id")
    , @NamedQuery(name = "Elerhetoseg.findByNev", query = "SELECT e FROM Elerhetoseg e WHERE e.nev = :nev")
    , @NamedQuery(name = "Elerhetoseg.findByIcon", query = "SELECT e FROM Elerhetoseg e WHERE e.icon = :icon")
    , @NamedQuery(name = "Elerhetoseg.findByUrl", query = "SELECT e FROM Elerhetoseg e WHERE e.url = :url")})
public class Elerhetoseg implements Serializable {

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
    @Column(name = "icon")
    private String icon;
    @Basic(optional = false)
    @Column(name = "url")
    private String url;

    public Elerhetoseg() {
    }

    public Elerhetoseg(Integer id) {
        this.id = id;
    }

    public Elerhetoseg(Integer id, String nev, String icon, String url) {
        this.id = id;
        this.nev = nev;
        this.icon = icon;
        this.url = url;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    // az adatok listázása
    public static List<Elerhetoseg> getAllElerhetosegById(EntityManager em){
        List<Elerhetoseg> elemek = new ArrayList();
        StoredProcedureQuery spq = em.createStoredProcedureQuery("getAllElerhetosegById");
        List<Object[]> lista = spq.getResultList();
        for(Object[] elem : lista){
            Elerhetoseg e = new Elerhetoseg();
            e = em.find(Elerhetoseg.class, elem[0]);
            elemek.add(e);
        }
        return elemek;
    } 
    
    // módosítás
    public static Elerhetoseg findElerhetosegById(EntityManager em, int id){
        List<Elerhetoseg> elemek = Elerhetoseg.getAllElerhetosegById(em);
        Elerhetoseg e = em.find(Elerhetoseg.class, id);
        return e;
    }
    
    public static void updateElerhetoseg(EntityManager em, int id, String nev, String icon, String url){
        Elerhetoseg e = Elerhetoseg.findElerhetosegById(em, id);
        em.getTransaction().begin();
        e.setNev(nev);
        e.setIcon(icon);
        e.setUrl(url);
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
        if (!(object instanceof Elerhetoseg)) {
            return false;
        }
        Elerhetoseg other = (Elerhetoseg) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "backend.Elerhetoseg[ id=" + id + " ]";
    }
    
}
