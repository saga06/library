package com.library.oc.library.business.contract.manager;

import com.library.oc.library.model.bean.user.User;
import com.library.oc.library.model.exception.NotFoundException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;


/**
 * Manager du package « user »
 */
@WebService(name="UserService", serviceName="UserService")
public interface UserManager {

    /**
     * Renvoie la liste des {@link User}
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

    @WebMethod
    boolean validateLogin(@WebParam(name = "user") User user,
                          @WebParam(name = "password") String password);
}