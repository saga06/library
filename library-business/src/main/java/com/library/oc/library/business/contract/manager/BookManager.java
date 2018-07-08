package com.library.oc.library.business.contract.manager;

import java.util.List;

import com.library.oc.library.model.bean.book.Book;

import com.library.oc.library.model.exception.NotFoundException;


/**
 * Manager du package « book »
 */
public interface BookManager {

    /**
     * Renvoie le book demandé
     *
     * @param pId l'identifiant du book
     * @return Le {@link Book}
     * @throws NotFoundException Si le book n'est pas trouvé
     */
    Book getBook(Integer pId) throws NotFoundException;

    /**
     * Renvoie la liste des {@link Book}
     * @return List
     */
    List<Book> getListBook();


    /**
     * Détermine le nombre de book en base de données.
     *
     * @return Le nombre de book en base de données
     */
    int getNbBook();


}
