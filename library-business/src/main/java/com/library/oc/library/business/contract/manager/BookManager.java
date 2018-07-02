package com.library.oc.library.business.contract.manager;

import java.util.List;

import com.library.oc.library.model.bean.book.Book;
import com.library.oc.library.model.bean.book.Version;
import com.library.oc.library.model.bean.user.User;
import com.library.oc.library.model.exception.FunctionalException;
import com.library.oc.library.model.exception.NotFoundException;
import com.library.oc.library.model.exception.TechnicalException;


/**
 * Manager du package « book »
 */
public interface BookManager {

    /**
     * Renvoie la liste des {@link Book}
     *
     * @return List
     */
    List<User> getListBook();

    /**
     * Renvoie le book demandé
     *
     * @param pId l'identifiant du book
     * @return Le {@link Book}
     * @throws NotFoundException Si le book n'est pas trouvé
     */
    Book getBook(Integer pId) throws NotFoundException;


    /**
     * Ajoute un nouveau {@link Book}
     * @param pBook -
     * @throws FunctionalException Book invalide
     * @throws TechnicalException Erreur technique
     */
    void insertBook(Book pBook) throws FunctionalException, TechnicalException;


    /**
     * Renvoie la liste des versions d'un book
     * @param pBook -
     * @return List
     */
    List<Version> getListVersion(Book pBook);


    /**
     * Ajoute une nouvelle {@link Version} de {@link Book}
     * @param pVersion -
     * @throws FunctionalException Version invalide
     */
    void insertVersion(Version pVersion) throws FunctionalException;
}
