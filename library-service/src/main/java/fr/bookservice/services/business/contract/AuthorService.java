package fr.bookservice.services.business.contract;

import fr.bookservice.services.business.exception.AuthorNotFoundException;
import model.Author;
import model.Book;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Date;
import java.util.List;

@WebService(name="AuthorService", serviceName="AuthorService")
public interface AuthorService {

    List<Book> getBooksFromAuthor(@WebParam(name="authorFirstName") String authorFirstName,
                                  @WebParam(name="authorLastName") String authorLastName) throws AuthorNotFoundException;

    Author getAuthor(@WebParam(name="id") Long id) throws AuthorNotFoundException;

    List<Author> getAuthorsByName(@WebParam(name="firstName") String firstName,
                                  @WebParam(name="lastName") String lastName) throws AuthorNotFoundException;

    Long createAuthor(@WebParam(name="firstName") String firstName,
                      @WebParam(name="lastName") String lastName,
                      @WebParam(name="nationality") String nationality,
                      @WebParam(name="dateOfBirth") Date dateOfBirth,
                      @WebParam(name="dateOfDeath") Date dateOfDeath);
}