package fr.bookservice.services.business.impl;

import fr.bookservice.services.business.contract.BookService;
import fr.bookservice.services.business.exception.BookNotFoundException;
import model.Author;
import model.Book;
import model.BookType;

import javax.jws.WebParam;
import java.util.List;

public class BookServiceImpl implements BookService {
    @Override
    public Book getBook(Long id) throws BookNotFoundException {
        return null;
    }

    @Override
    public List<Book> getBooksByTitle(String title) {
        return null;
    }

    @Override
    public List<Author> getAuthorsFromBook(String bookTitle) throws BookNotFoundException {
        return null;
    }

    @Override
    public Long createBook(String title, BookType type, int year, Long authorsId) {
        return null;
    }
}
