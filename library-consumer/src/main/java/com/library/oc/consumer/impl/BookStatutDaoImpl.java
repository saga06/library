package com.library.oc.consumer.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.library.oc.consumer.impl.dao.AbstractDao;
import com.library.oc.consumer.impl.dao.BookStatutDao;
import com.library.oc.library.model.bean.book.BookStatut;
import com.library.oc.consumer.contract.dao.BookStatutDao;
import com.library.oc.consumer.impl.rowmapper.BookStatutRM;
import com.library.oc.model.bean.book.BookStatut;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Classe d'implémentation de {@link BookStatutDao}.
 */
@Named
public class BookStatutDaoImpl extends AbstractDao implements BookStatutDao {

    //----- INJECTION DES DEPENDANCES -----
    @Inject
    BookStatutRM bookStatutRM;

    //----- IMPLEMENTATION DES METHODES -----

    @Override
    public boolean create(BookStatut obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public BookStatut read(int id) {
        String vSQL = "SELECT * FROM book WHERE id="+id;

        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        List<BookStatut> listBookStatut = jdbcTemplate.query(vSQL, bookStatutRM);
        BookStatut bookStatut = listBookStatut.get(0);

        return bookStatut;
    }


    @Override
    public BookStatut read(String code) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<BookStatut> readAll() {
        String vSQL = "SELECT * FROM statut";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        List<BookStatut> listBookStatut = jdbcTemplate.query(vSQL, bookStatutRM);

        return listBookStatut;
    }

    @Override
    public List<BookStatut> readAll(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(BookStatut obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(BookStatut obj) {
        // TODO Auto-generated method stub
        return false;
    }

    // ...

    @Override
    public int getCountBookStatut() {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        int vNbrStatus = vJdbcTemplate.queryForObject( "SELECT COUNT(*) FROM book", Integer.class);

        return vNbrStatus;
    }
}