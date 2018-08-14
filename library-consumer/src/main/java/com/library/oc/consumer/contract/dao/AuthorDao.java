package com.library.oc.consumer.contract.dao;

import com.library.oc.library.model.bean.book.Author;
import com.library.oc.library.model.bean.book.Book;

import java.util.List;

public interface AuthorDao {


    //-- CRUD : Les méthodes nécessaires

    /**
     * Méthode de création
     * @param obj
     * @return boolean
     */
    boolean create(Author obj);

    /**
     * Méthode de recherche des informations
     * @param id
     * @return T
     */
    Author read(int id);
    List<Author> readAll();
    List<Author> readAll(int id);
    List<Author> findAuthorsByBook(Book book);


    /**
     * Méthode de mise à jour
     * @param obj
     * @return boolean
     */
    boolean update(Author obj);

    /**
     * Méthode pour effacer
     * @param obj
     * @return boolean
     */
    boolean delete(Author obj);

    /**
     * Retourne le nombre de author
     * @param
     * @return Le nombre de author
     */
    int getNbAuthor();
}

