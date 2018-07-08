package com.library.oc.consumer.impl.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.inject.Named;

import com.library.oc.consumer.contract.dao.UserDao;
import com.library.oc.consumer.contract.dao.AuthorDao;
/*
import com.library.oc.consumer.contract.dao.BookStatutDao;
*/
import com.library.oc.library.model.bean.book.Author;
import com.library.oc.library.model.bean.book.Book;


import org.springframework.jdbc.core.RowMapper;

    @Named
    public class BookRM implements RowMapper<Book> {

    /*    @Inject
        BookStatutDao bookStatutDaoImpl;*/

        @Inject
        AuthorDao authorDaoImpl;


        @Inject
        UserDao userDaoImpl;


        @Override
        public Book mapRow(ResultSet pRS, int pRowNum) throws SQLException {

            Book book = new Book(pRS.getInt("book_id"));
            book.setNumberOfCopies(pRS.getInt("book_number_of_copies"));
            book.setTitle(pRS.getString("book_title"));
            book.setEditorId(pRS.getInt("editor_id"));
            book.setIsbn(pRS.getString("book_ISBN"));

            /*BookStatut vBookNumberOfCopies= BookStatutDaoImpl.read(pRS.getInt("book_number_of_copies"));
            book.setNumberOfCopies(vBookNumberOfCopies);*/

            //-- Récupérer l'auteur du book
            /*Author vAuthor = authorDaoImpl.read(pRS.getInt("author_name"));
            vAuthor.setName(vAuthor);
*/
            /*Book vBook= BookDaoImpl.read(pRS.getInt("book_id"));
            book.setId(vBook);*/

            return book;

        }

    }

