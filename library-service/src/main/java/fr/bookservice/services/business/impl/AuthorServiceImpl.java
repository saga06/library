package fr.bookservice.services.business.impl;

import fr.bookservice.services.business.contract.AuthorService;
import fr.bookservice.services.business.exception.AuthorNotFoundException;
import model.Author;
import model.Book;

import java.util.Date;
import java.util.List;

public class AuthorServiceImpl implements AuthorService {
    @Override
    public List<Book> getBooksFromAuthor(String authorFirstName, String authorLastName) throws AuthorNotFoundException {
        return null;
    }

    @Override
    public Author getAuthor(Long id) throws AuthorNotFoundException {
        return null;
    }

    @Override
    public List<Author> getAuthorsByName(String firstName, String lastName) throws AuthorNotFoundException {
        return null;
    }

    @Override
    public Long createAuthor(String firstName, String lastName, String nationality, Date dateOfBirth, Date dateOfDeath) {
        return null;
    }
}
