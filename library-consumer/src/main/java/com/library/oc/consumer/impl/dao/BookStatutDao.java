package com.library.oc.consumer.impl.dao;

import java.util.List;

import com.library.oc.library.model.bean.book.BookStatut;

/**
 * Les méthodes CRUD nécessaires pour manipuler le bean "Statut" / La table "statut"
 * @author sga
 *
 */
public interface BookStatutDao {

    //-- CRUD : Les méthodes nécessaires

    /**
     * Méthode de création
     * @param obj
     * @return boolean
     */
    boolean create(BookStatut obj);

    /**
     * Méthode de recherche des informations
     * @param id
     * @return T
     */
    BookStatut read(int id);
    BookStatut read(String code);
    List<BookStatut> readAll();
    List<BookStatut> readAll(int id);

    /**
     * Méthode de mise à jour
     * @param obj
     * @return boolean
     */
    boolean update(BookStatut obj);

    /**
     * Méthode pour effacer
     * @param obj
     * @return boolean
     */
    boolean delete(BookStatut obj);

    /**
     * Retourne le nombre de book
     * @param pRechercheBook
     * @return Le nombre de book
     */
    int getCountBookStatut();
}
