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
import com.library.oc.consumer.impl.rowmapper.BorrowRM;
import com.library.oc.library.model.bean.user.User;
import org.springframework.dao.EmptyResultDataAccessException;
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
    @Inject
    BorrowRM borrowRM;

    //----- IMPLEMENTATION DES METHODES -----


    @Override
    public Book read(int numero) {
        String vSQL = "SELECT * FROM book WHERE id="+numero;

        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        List<Book> listBook = jdbcTemplate.query(vSQL, bookRM);
        Book vBook = listBook.get(0);

        return vBook;
    }



    @Override
    public List<Book> findAllBooks() {
        //String vSQL = "SELECT * FROM book INNER JOIN editor ON book.editor_id = editor.id";
        String vSQL = "SELECT * FROM book " +
                "LEFT JOIN editor ON book.editor_id = editor.id ";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Book> vListBook = vJdbcTemplate.query(vSQL, bookRM);

        return vListBook;
    }

    @Override
    public  List<Book> findAllBooksBorrowed(int id) {
        try
        {
            String vSQL =
                    "SELECT * FROM book " +
                    "INNER JOIN borrow ON borrow.id_book = book.id \n " +
                    "LEFT JOIN editor ON book.editor_id = editor.id \n " +
                    "WHERE id_borrower = "+id;

            JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
            List<Book> vListBook = jdbcTemplate.query(vSQL, bookRM);
            return vListBook;

        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }


   /* @Override
    public void BookDependencies(Book book)
    {book.setAuthor(getDaoFactory().getAuthorDao().findAllByBook(book));
        book.setTheme(getDaoFactory().getThemeDao().findAllByBook(book));
        book.setEditor(getDaoFactory().getEditorDao().findAllByBook(book));
        for(Author author : book.getAuthors())
        {author.setId(getDaoFactory().getWayDao().findAllByAuthor(sector));

        */

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