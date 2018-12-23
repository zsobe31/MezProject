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
@Table(name = "meztermek")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Meztermek.findAll", query = "SELECT m FROM Meztermek m")
    , @NamedQuery(name = "Meztermek.findById", query = "SELECT m FROM Meztermek m WHERE m.id = :id")
    , @NamedQuery(name = "Meztermek.findByNev", query = "SELECT m FROM Meztermek m WHERE m.nev = :nev")
    , @NamedQuery(name = "Meztermek.findByMennyiseg", query = "SELECT m FROM Meztermek m WHERE m.mennyiseg = :mennyiseg")
    , @NamedQuery(name = "Meztermek.findByAr", query = "SELECT m FROM Meztermek m WHERE m.ar = :ar")})
public class Meztermek implements Serializable {

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

    public Meztermek() {
    }

    public Meztermek(Integer id) {
        this.id = id;
    }

    public Meztermek(Integer id, String nev, String mennyiseg, String ar) {
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
    public static List<Meztermek> getAllMeztermekByNev(EntityManager em){
        List<Meztermek> mezek = new ArrayList();
        StoredProcedureQuery spq = em.createStoredProcedureQuery("getAllMeztermekByNev");
        List<Object[]> lista = spq.getResultList();
        for(Object[] mez : lista){
            Meztermek m = new Meztermek();
            m = em.find(Meztermek.class, mez[0]);
            mezek.add(m);
        }
        return mezek;
    }
    
    // felvitel
    public static void addNewMeztermek(EntityManager em, String nev, String mennyiseg, String ar){
        StoredProcedureQuery spq = em.createStoredProcedureQuery("addNewMeztermek");
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
    public static void deleteMeztermek(EntityManager em, int id){
        StoredProcedureQuery spq = em.createStoredProcedureQuery("deleteMeztermek");
        em.getTransaction().begin();
        spq.registerStoredProcedureParameter("idIN", Integer.class, ParameterMode.IN);
        spq.setParameter("idIN", id);    
        spq.execute();
        em.getTransaction().commit();
    }
    
    // módosítás
    public static Meztermek findMetermekById(EntityManager em, int id){
        List<Meztermek> elemek = Meztermek.getAllMeztermekByNev(em);
        Meztermek e = em.find(Meztermek.class, id);
        return e;
    }
    
    public static void updateMeztermek(EntityManager em, int id, String nev, String mennyiseg, String ar){
        Meztermek e = Meztermek.findMetermekById(em, id);
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
        if (!(object instanceof Meztermek)) {
            return false;
        }
        Meztermek other = (Meztermek) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "backend.Meztermek[ id=" + id + " ]";
    }
    
}
