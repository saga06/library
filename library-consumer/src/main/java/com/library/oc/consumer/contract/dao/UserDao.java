package com.library.oc.consumer.contract.dao;

import java.util.List;

import com.library.oc.library.model.bean.user.User;

public interface UserDao {


    //-- CRUD : Les méthodes nécessaires

    /**
     * Méthode de création
     * @param obj
     * @return boolean
     */
    boolean create(User obj);

    /**
     * Méthode de recherche des informations
     * @param id
     * @return T
     */
    User read(int id);
    User read(String code);
    List<User> readAll();
    List<User> readAll(int id);

    /**
     * Méthode de mise à jour
     * @param obj
     * @return boolean
     */
    boolean update(User obj);

    /**
     * Méthode pour effacer
     * @param obj
     * @return boolean
     */
    boolean delete(User obj);

    /**
     * Retourne le nombre d'user
     * @param
     * @return Le nombre d'user
     */
    Integer getNbUser();

    /**
     * Méthode pour effacer
     * @param login
     * @param password
     * @return boolean
     */
    User login(String login, String password);

}

