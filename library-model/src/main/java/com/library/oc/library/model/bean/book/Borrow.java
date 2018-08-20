package com.library.oc.library.model.bean.book;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * Objet métier représentant un emprunt
 *
 * @author sga
 */
public class Borrow {

// ==================== Attributs ====================
    private Integer id;

    private Date dateStart;

    private Date dateEnd;

    private boolean alreadyExtended;

    private Integer idBorrower;

    private Integer idBook;

    private List<Book> books = new ArrayList<Book>();


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

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
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
