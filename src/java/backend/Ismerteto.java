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
@Table(name = "ismerteto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ismerteto.findAll", query = "SELECT i FROM Ismerteto i")
    , @NamedQuery(name = "Ismerteto.findById", query = "SELECT i FROM Ismerteto i WHERE i.id = :id")
    , @NamedQuery(name = "Ismerteto.findByLogo", query = "SELECT i FROM Ismerteto i WHERE i.logo = :logo")
    , @NamedQuery(name = "Ismerteto.findByLeirt", query = "SELECT i FROM Ismerteto i WHERE i.leirt = :leirt")
    , @NamedQuery(name = "Ismerteto.findByLeiras", query = "SELECT i FROM Ismerteto i WHERE i.leiras = :leiras")})
public class Ismerteto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "logo")
    private String logo;
    @Basic(optional = false)
    @Column(name = "leirt")
    private String leirt;
    @Basic(optional = false)
    @Column(name = "leiras")
    private String leiras;

    public Ismerteto() {
    }

    public Ismerteto(Integer id) {
        this.id = id;
    }

    public Ismerteto(Integer id, String logo, String leirt, String leiras) {
        this.id = id;
        this.logo = logo;
        this.leirt = leirt;
        this.leiras = leiras;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLeirt() {
        return leirt;
    }

    public void setLeirt(String leirt) {
        this.leirt = leirt;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }
    
    // az adatok listázása
    public static List<Ismerteto> getAllIsmertetoById(EntityManager em){
        List<Ismerteto> ismertetok = new ArrayList();
        StoredProcedureQuery spq = em.createStoredProcedureQuery("getAllIsmertetoById");
        List<Object[]> lista = spq.getResultList();
        for(Object[] ismer : lista){
            Ismerteto i = new Ismerteto();
            i = em.find(Ismerteto.class, ismer[0]);
            ismertetok.add(i);
        }
        return ismertetok;
    }
    
    // módosítás
    public static Ismerteto findIsmertetoById(EntityManager em, int id){
        List<Ismerteto> elemek = Ismerteto.getAllIsmertetoById(em);
        Ismerteto e = em.find(Ismerteto.class, id);
        return e;
    }
    
    public static void 	updateIsmerteto(EntityManager em, int id, String logo, String leirt, String leiras){
        Ismerteto e = Ismerteto.findIsmertetoById(em, id);
        em.getTransaction().begin();
        e.setLogo(logo);
        e.setLeirt(leirt);
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
        if (!(object instanceof Ismerteto)) {
            return false;
        }
        Ismerteto other = (Ismerteto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "backend.Ismerteto[ id=" + id + " ]";
    }
    
}
