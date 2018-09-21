package com.library.oc.library.business.contract.manager;

import java.util.List;

import com.library.oc.library.model.bean.user.User;
import com.library.oc.library.model.exception.NotFoundException;


/**
 * Manager du package « user »
 */
public interface UserManager {

    /**
     * Renvoie la liste des {@link User}
     *
     * @return List
     * @param pId
     */
    List<User> getListUser(Object pId);

    /**
     * Renvoie  l'objet User ciblé.
     * @param pId l'identifiant de l'User
     * @return Un objet User.
     * @throws NotFoundException
     */
    User getUser(Integer pId) throws NotFoundException;


    /**
     * Retourne le nombre de User dans la base de données.
     * @return Le nombre de user en base de données
     */
    Integer getNbUser();

    String hashPassword(String password);
    User getEmailUser(String username);
    boolean validateLogin(User user, String password);
}