package com.library.oc.library.business.contract.manager;

import java.util.List;

import com.library.oc.library.model.bean.user.User;
import com.library.oc.library.model.exception.NotFoundException;
import com.library.oc.library.model.exception.FunctionalException;
import com.library.oc.library.model.exception.TechnicalException;


/**
 * Manager du package « user »
 */
public interface UserManager {

    /**
     * Renvoie la liste des {@link User}
     *
     * @return List
     */
    List<User> getListUser();

    /**
     * Renvoie l'{@link User} demandé
     *
     * @param pId l'identifiant de l'User
     * @return Le {@link User}
     * @throws NotFoundException Si l'User n'est pas trouvé
     */
    User getUser(Integer pId) throws NotFoundException;

    /**
     * Renvoie l'{@link User} correspondant au couple login / mot de passe
     *
     * @param pLogin le login de l'Utilisateur
     * @param pPassword le mot de passe de l'Utilisateur
     * @return Le {@link User}
     * @throws NotFoundException Si l'Utilisateur n'est pas trouvé
     */
    User getUser(String pLogin, String pPassword) throws NotFoundException;
}
