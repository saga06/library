package com.library.oc.consumer.impl.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.library.oc.consumer.contract.dao.BookBorrowedDao;
import com.library.oc.consumer.contract.dao.BookDao;
import com.library.oc.consumer.contract.dao.UserDao;
/*
import com.library.oc.consumer.contract.dao.BookStatutDao;
*/
import com.library.oc.library.model.bean.book.Book;
import com.library.oc.consumer.impl.rowmapper.BookRM;
import com.library.oc.consumer.impl.rowmapper.BookBorrowedRM;
import com.library.oc.library.model.bean.book.BookBorrowed;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;


/**
 * Classe d'implémentation de {@link BookBorrowedDao}.
 */
@Named
public class BookBorrowedDaoImpl extends AbstractDao implements BookBorrowedDao {

    //----- INJECTION DES DEPENDANCES -----

    @Inject
    UserDao userDaoImpl;
    @Inject
    BookRM bookRM;
    @Inject
    BookBorrowedRM bookBorrowedRM;

    //----- IMPLEMENTATION DES METHODES -----


    @Override
    public List<BookBorrowed> findAllBooksBorrowed(int id) {
        try
        {
            String vSQL =
                    "SELECT * FROM book " +
                            "INNER JOIN borrow ON borrow.id_book = book.id \n " +
                            "LEFT JOIN editor ON book.editor_id = editor.id \n " +
                            "WHERE id_borrower = "+id;

            JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
            List<BookBorrowed> vListBook = jdbcTemplate.query(vSQL, bookBorrowedRM);
            return vListBook;

        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }
}
