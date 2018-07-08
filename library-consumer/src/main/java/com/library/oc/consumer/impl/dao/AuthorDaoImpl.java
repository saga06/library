package com.library.oc.consumer.impl.dao;


import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.library.oc.consumer.contract.dao.AuthorDao;
import com.library.oc.consumer.contract.dao.UserDao;
import com.library.oc.consumer.impl.rowmapper.AuthorRM;
import com.library.oc.consumer.impl.rowmapper.BookRM;
import com.library.oc.library.model.bean.book.Author;
import org.springframework.jdbc.core.JdbcTemplate;

@Named
public class AuthorDaoImpl  extends AbstractDao implements AuthorDao {

    //----- INJECTION DES DEPENDANCES -----

    @Inject
    BookRM bookRM;
    @Inject
    AuthorRM authorRM;


    @Override
    public boolean create(Author obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Author read(int id) {
        String vSQL = "SELECT author_name FROM author WHERE author_id="+id;

        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        List<Author> listAuthor = jdbcTemplate.query(vSQL, authorRM);
        Author vAuthor = listAuthor.get(0);

        return vAuthor;
    }


    @Override
    public List<Author> readAll() {
        String vSQL = "SELECT * FROM author";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        List<Author> listAuthor = jdbcTemplate.query(vSQL, authorRM);

        return listAuthor;
    }


    @Override
    public List<Author> readAll(int id) {
        return null;
    }


    @Override
    public boolean update(Author obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Author obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getNbAuthor() {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        int vNbrAuthor = vJdbcTemplate.queryForObject( "SELECT COUNT(*) FROM author", Integer.class);
        return vNbrAuthor;
    }




}
