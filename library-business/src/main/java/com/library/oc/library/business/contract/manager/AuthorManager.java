package com.library.oc.library.business.contract.manager;

import java.util.List;

import com.library.oc.library.model.bean.book.Author;
import com.library.oc.library.model.bean.book.Book;

import com.library.oc.library.model.exception.NotFoundException;

/**
 * Manager du package « author »
 */
public interface AuthorManager {
    /**
     * Renvoie l'auteur demandé
     *
     * @param pId l'identifiant de l'auteur
     * @return Le {@link Author}
     * @throws NotFoundException Si l'auteur n'est pas trouvé
     */
    Author getAuthor(Integer pId) throws NotFoundException;

    /**
     * Renvoie la liste des {@link Author}
     * @return List
     */
    List<Author> getListAuthor();


    /**
     * Détermine le nombre d'auteur en base de données.
     *
     * @return Le nombre d'auteur en base de données
     */
    int getNbAuthor();
}
