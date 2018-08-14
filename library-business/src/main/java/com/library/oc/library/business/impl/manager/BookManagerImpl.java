package com.library.oc.library.business.impl.manager;

import java.util.List;
import javax.inject.Named;

import com.library.oc.library.business.contract.manager.BookManager;
import com.library.oc.library.model.bean.book.Author;
import com.library.oc.library.model.bean.book.Theme;
import com.library.oc.library.model.bean.book.Book;
import com.library.oc.library.model.exception.NotFoundException;


@Named
public class BookManagerImpl extends AbstractManager implements BookManager {

    /*@Override
    public List<Book> getListBook() { return getDaoFactory().getBookDao().readAll(); }*/

    @Override
    public List<Book> displayAllBooks() {
        List<Book> books = getDaoFactory().getBookDao().findAllBooks();
        for(Book book : books)
        {
            buildBookDependencies(book);
        }
        return books;
    }

    @Override
    public void buildBookDependencies(Book book)

    {
        book.setAuthors(getDaoFactory().getAuthorDao().findAuthorsByBook(book));
        book.setThemes(getDaoFactory().getThemeDao().findThemesByBook(book));

    }




/*    @Override
    public List<Book> getEditorBook(int idEditor) throws NotFoundException { return getDaoFactory().getBookDao().getEditorBook(idEditor); }*/


    @Override
    public Book getBook(Integer pId) throws NotFoundException { return getDaoFactory().getBookDao().read(pId); }


    @Override
    public int getNbBook() { return getDaoFactory().getBookDao().getCountBook(); }



}
