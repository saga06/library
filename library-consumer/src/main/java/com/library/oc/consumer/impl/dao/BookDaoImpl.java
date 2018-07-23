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

    @Inject
    UserDao userDaoImpl;
    @Inject
    BookRM bookRM;

    //----- IMPLEMENTATION DES METHODES -----


    @Override
    public Book read(int numero) {
        String vSQL = "SELECT * FROM book WHERE id="+numero;

        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        List<Book> listBook = jdbcTemplate.query(vSQL, bookRM);
        Book vBook = listBook.get(0);

        return vBook;
    }

  /*  @Override
    public List<Book> getEditorBook(int idEditor) {
        String vSQL = "SELECT editor.id, editor.name FROM book INNER JOIN editor ON book.editor_id = editor.id WHERE book.id ="+idEditor;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        List<Book> listBook = jdbcTemplate.query(vSQL, bookRM);
        Book eBook = listBook.get(0);

        return eBook;
    }
*/


    @Override
    public List<Book> readAll() {
        //String vSQL = "SELECT * FROM book INNER JOIN editor ON book.editor_id = editor.id";
        String vSQL = "SELECT * FROM book " +
                "INNER JOIN editor ON book.book_editor_id = editor.editor_id " +
                "INNER JOIN book_author ON book.book_id = book_author.book_author_book_id " +
                "INNER JOIN author ON book_author.book_author_author_id = author.author_id " +
                "INNER JOIN book_theme ON book.book_id = book_theme.book_theme_book_id " +
                "INNER JOIN theme ON book_theme.book_theme_theme_id = theme.theme_id";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Book> vListBook = vJdbcTemplate.query(vSQL, bookRM);

        return vListBook;
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