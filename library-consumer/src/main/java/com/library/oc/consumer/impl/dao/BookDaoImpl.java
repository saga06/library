package com.library.oc.consumer.impl.dao;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.library.oc.consumer.contract.dao.BookDao;
import com.library.oc.consumer.contract.dao.UserDao;
/*
import com.library.oc.consumer.contract.dao.BookStatutDao;
*/
import com.library.oc.library.model.bean.book.Book;
import com.library.oc.consumer.impl.rowmapper.BookRM;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Classe d'implémentation de {@link BookDao}.
 */
@Named
public class BookDaoImpl extends AbstractDao implements BookDao {

    //----- INJECTION DES DEPENDANCES -----
/*    @Inject
    BookStatutDao bookStatutDaoImpl;*/
    @Inject
    UserDao userDaoImpl;
    @Inject
    BookRM bookRM;

    //----- IMPLEMENTATION DES METHODES -----

    @Override
    public boolean create(Book obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Book read(int numero) {
        String vSQL = "SELECT * FROM book WHERE id="+numero;

        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        List<Book> listBook = jdbcTemplate.query(vSQL, bookRM);
        Book vBook = listBook.get(0);

        return vBook;
    }

    @Override
    public Book read(String code) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Book> readAll() {
        String vSQL = "SELECT * FROM book";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Book> vListBook = vJdbcTemplate.query(vSQL, bookRM);

        return vListBook;
    }

    @Override
    public List<Book> readAll(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(Book obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Book obj) {
        // TODO Auto-generated method stub
        return false;
    }

    // ...

    @Override
    public int getCountBook() {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        int vNbrBook = vJdbcTemplate.queryForObject( "SELECT COUNT(*) FROM book", Integer.class);

        return vNbrBook;
    }
}