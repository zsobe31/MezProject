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
@Table(name = "partner")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partner.findAll", query = "SELECT p FROM Partner p")
    , @NamedQuery(name = "Partner.findById", query = "SELECT p FROM Partner p WHERE p.id = :id")
    , @NamedQuery(name = "Partner.findByNev", query = "SELECT p FROM Partner p WHERE p.nev = :nev")
    , @NamedQuery(name = "Partner.findByIcon", query = "SELECT p FROM Partner p WHERE p.icon = :icon")
    , @NamedQuery(name = "Partner.findByUrl", query = "SELECT p FROM Partner p WHERE p.url = :url")})
public class Partner implements Serializable {

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

    public Partner() {
    }

    public Partner(Integer id) {
        this.id = id;
    }

    public Partner(Integer id, String nev, String icon, String url) {
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
    public static List<Partner> getAllPartnerById(EntityManager em){
        List<Partner> elemek = new ArrayList();
        StoredProcedureQuery spq = em.createStoredProcedureQuery("getAllPartnerById");
        List<Object[]> lista = spq.getResultList();
        for(Object[] elem : lista){
            Partner p = new Partner();
            p = em.find(Partner.class, elem[0]);
            elemek.add(p);
        }
        return elemek;
    }
    
    // módosítás
    public static Partner findPartnerById(EntityManager em, int id){
        List<Partner> elemek = Partner.getAllPartnerById(em);
        Partner e = em.find(Partner.class, id);
        return e;
    }
    
    public static void 	updatePartner(EntityManager em, int id, String nev, String icon, String url){
        Partner e = Partner.findPartnerById(em, id);
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
        if (!(object instanceof Partner)) {
            return false;
        }
        Partner other = (Partner) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "backend.Partner[ id=" + id + " ]";
    }
    
}
