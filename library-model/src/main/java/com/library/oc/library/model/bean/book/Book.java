package com.library.oc.library.model.bean.book;

import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.library.oc.library.model.bean.user.User;


/**
 * Objet métier représentant un Book
 *
 * @author sga
 */
public class Book {

    // ==================== Attributs ====================
    private Integer id;

    @NotNull
    @Size(min = 1, max = 100)
    private String nom;

    @NotNull
    private Date dateCreation;

    private Boolean cloture;

    @NotNull
    private User user;


    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut.
     */
    public Book() {
    }

    /**
     * Constructeur.
     *
     * @param pId -
     */
    public Book(Integer pId) {
        id = pId;
    }


    // ==================== Getters/Setters ====================
    public Integer getId() {
        return id;
    }
    public void setId(Integer pId) {
        id = pId;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String pNom) {
        nom = pNom;
    }
    public Date getDateCreation() {
        return dateCreation;
    }
    public void setDateCreation(Date pDateCreation) {
        dateCreation = pDateCreation;
    }
    public Boolean getCloture() {
        return cloture;
    }
    public void setCloture(Boolean pCloture) {
        cloture = pCloture;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User pUser) {
        user = pUser;
    }


    // ==================== Méthodes ====================
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = ", ";
        vStB.append(" {")
                .append("id=").append(id)
                .append(vSEP).append("nom=\"").append(nom).append('"')
                .append(vSEP).append("dateCreation=").append(dateCreation)
                .append(vSEP).append("cloture=").append(cloture)
                .append("}");
        return vStB.toString();
    }
}
