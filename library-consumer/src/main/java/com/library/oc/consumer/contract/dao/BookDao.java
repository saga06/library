package com.library.oc.consumer.contract.dao;
import java.util.List;

import com.library.oc.library.model.bean.book.Book;
import com.library.oc.library.model.bean.book.BookBorrowed;
import com.library.oc.library.model.bean.user.User;

/**
 * Les méthodes CRUD nécessaires pour manipuler le bean "Book" / La table "book"
 * @author sga
 *
 */

public interface BookDao {


    //-- CRUD : Les méthodes nécessaires

/*    *//**
     * Méthode de création
     * @param obj
     * @return boolean
     *//*
    boolean create(Book obj);*/

    /**
     * Méthode de recherche des informations
     * @param id
     * @return T
     */
    Book read(int id);
    List<Book> findAllBooks();
    List<BookBorrowed> findAllBooksBorrowed(int id);

/*
    List<Book> getEditorBook(int idEditor);

*/
    /**
     * Méthode de mise à jour
     * @param obj
     * @return boolean
     */
    boolean update(Book obj);

    /**
     * Méthode pour effacer
     * @param obj
     * @return boolean
     */
    boolean delete(Book obj);

    /**
     * Retourne le nombre de Book
     * @param pRechercheBook
     * @return Le nombre de Book
     */
    int getCountBook();


}

