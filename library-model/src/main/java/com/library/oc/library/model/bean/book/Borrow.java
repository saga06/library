package com.library.oc.library.model.bean.book;

import java.util.Calendar;

/**
 * Objet métier représentant un emprunt
 *
 * @author sga
 */
public class Borrow {

// ==================== Attributs ====================
    private Integer id;

    private Calendar dateStart;

    private Calendar dateEnd;

    private boolean alreadyExtended;

    private Integer idBorrower;

    private Integer idBook;

    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut.
     */
    public Borrow() {
    }

    /**
     * Constructeur.
     *
     * @param pId -
     */
    public Borrow(Integer pId) {
        id = pId;
    }

    // ==================== Getters/Setters ====================


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDateStart() {
        return dateStart;
    }

    public void setDateStart(Calendar dateStart) {
        this.dateStart = dateStart;
    }

    public Calendar getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Calendar dateEnd) {
        this.dateEnd = dateEnd;
    }

    public boolean isAlreadyExtended() {
        return alreadyExtended;
    }

    public void setAlreadyExtended(boolean alreadyExtended) {
        this.alreadyExtended = alreadyExtended;
    }

    public Integer getIdBorrower() {
        return idBorrower;
    }

    public void setIdBorrower(Integer idBorrower) {
        this.idBorrower = idBorrower;
    }

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }
}
