package fr.bookservice.services.business.contract;

import fr.bookservice.services.business.exception.BookNotFoundException;
import model.Author;
import model.Book;
import model.BookType;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(name="BookService", serviceName="BookService")
public interface BookService {

    Book getBook(@WebParam(name="id") Long id) throws BookNotFoundException;

    List<Book> getBooksByTitle(@WebParam(name="title") String title);

    List<Author> getAuthorsFromBook(@WebParam(name="bookTitle") String bookTitle) throws BookNotFoundException;

    Long createBook(@WebParam(name="title") String title,
                    @WebParam(name="BookType") BookType type,
                    @WebParam(name="year") int year,
                    @WebParam(name="authorsId") Long authorsId);
}