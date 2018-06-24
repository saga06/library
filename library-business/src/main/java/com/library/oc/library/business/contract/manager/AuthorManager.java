package com.library.oc.library.business.contract.manager;

import java.util.List;

import com.library.oc.library.model.bean.author.Author;
import com.library.oc.library.model.exception.NotFoundException;
import com.library.oc.library.model.exception.FunctionalException;
import com.library.oc.library.model.exception.TechnicalException;


/**
 * Manager du package « author »
 */
public interface AuthorManager {

    /**
     * Renvoie la liste des {@link Author}
     *
     * @return List
     */
    List<Author> getListAuthor();

    /**
     * Renvoie l'{@link Author} demandé
     *
     * @param pId l'identifiant de l'Author
     * @return Le {@link Author}
     * @throws NotFoundException Si l'Author n'est pas trouvé
     */
    Author getAuthor(Integer pId) throws NotFoundException;


    /**
     * Renvoie l'{@link Author} correspondant au couple login / mot de passe
     *
     * @param pLogin le login de l'Author
     * @param pPassword le mot de passe de l'Author
     * @return Le {@link Author}
     * @throws NotFoundException Si l'Author n'est pas trouvé
     */
    Author getAuthor(String pLogin, String pPassword) throws NotFoundException;
}
