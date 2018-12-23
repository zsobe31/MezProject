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
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zsobe31
 */
@Entity
@Table(name = "diszcsomag")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diszcsomag.findAll", query = "SELECT d FROM Diszcsomag d")
    , @NamedQuery(name = "Diszcsomag.findById", query = "SELECT d FROM Diszcsomag d WHERE d.id = :id")
    , @NamedQuery(name = "Diszcsomag.findByNev", query = "SELECT d FROM Diszcsomag d WHERE d.nev = :nev")
    , @NamedQuery(name = "Diszcsomag.findByMennyiseg", query = "SELECT d FROM Diszcsomag d WHERE d.mennyiseg = :mennyiseg")
    , @NamedQuery(name = "Diszcsomag.findByAr", query = "SELECT d FROM Diszcsomag d WHERE d.ar = :ar")})
public class Diszcsomag implements Serializable {

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
    @Column(name = "mennyiseg")
    private String mennyiseg;
    @Basic(optional = false)
    @Column(name = "ar")
    private String ar;

    public Diszcsomag() {
    }

    public Diszcsomag(Integer id) {
        this.id = id;
    }

    public Diszcsomag(Integer id, String nev, String mennyiseg, String ar) {
        this.id = id;
        this.nev = nev;
        this.mennyiseg = mennyiseg;
        this.ar = ar;
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

    public String getMennyiseg() {
        return mennyiseg;
    }

    public void setMennyiseg(String mennyiseg) {
        this.mennyiseg = mennyiseg;
    }

    public String getAr() {
        return ar;
    }

    public void setAr(String ar) {
        this.ar = ar;
    }
    
    // az adatok listázása
    public static List<Diszcsomag> getAllDiszcsomagById(EntityManager em){
        List<Diszcsomag> elemek = new ArrayList();
        StoredProcedureQuery spq = em.createStoredProcedureQuery("getAllDiszcsomagById");
        List<Object[]> lista = spq.getResultList();
        for(Object[] elem : lista){
            Diszcsomag d = new Diszcsomag();
            d = em.find(Diszcsomag.class, elem[0]);
            elemek.add(d);
        }
        return elemek;
    }
    
    // felvitel
    public static void addNewDiszcsomag(EntityManager em, String nev, String mennyiseg, String ar){
        StoredProcedureQuery spq = em.createStoredProcedureQuery("addNewDiszcsomag");
        em.getTransaction().begin();
        spq.registerStoredProcedureParameter("nevIN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("mennyisegIN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("arIN", String.class, ParameterMode.IN);
        spq.setParameter("nevIN", nev);    
        spq.setParameter("mennyisegIN", mennyiseg);    
        spq.setParameter("arIN", ar);
        spq.execute();
        em.getTransaction().commit();
    }
    
    // törlés
    public static void 	deleteDiszcsomag(EntityManager em, int id){
        StoredProcedureQuery spq = em.createStoredProcedureQuery("deleteDiszcsomag");
        em.getTransaction().begin();
        spq.registerStoredProcedureParameter("idIN", Integer.class, ParameterMode.IN);
        spq.setParameter("idIN", id);    
        spq.execute();
        em.getTransaction().commit();
    }
    
    // módosítás
    public static Diszcsomag findDiszcsomagById(EntityManager em, int id){
        List<Diszcsomag> elemek = Diszcsomag.getAllDiszcsomagById(em);
        Diszcsomag e = em.find(Diszcsomag.class, id);
        return e;
    }
    
    public static void 	updateDiszcsomag(EntityManager em, int id, String nev, String mennyiseg, String ar){
        Diszcsomag e = Diszcsomag.findDiszcsomagById(em, id);
        em.getTransaction().begin();
        e.setNev(nev);
        e.setMennyiseg(mennyiseg);
        e.setAr(ar);
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
        if (!(object instanceof Diszcsomag)) {
            return false;
        }
        Diszcsomag other = (Diszcsomag) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "backend.Diszcsomag[ id=" + id + " ]";
    }
    
}
