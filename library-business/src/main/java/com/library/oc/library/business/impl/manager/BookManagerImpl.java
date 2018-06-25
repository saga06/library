package com.library.oc.library.business.impl.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import com.library.oc.library.business.contract.manager.BookManager;
import com.library.oc.library.business.contract.manager.UserManager;
import com.library.oc.library.model.bean.book.Book;
import com.library.oc.library.model.bean.book.Version;
import com.library.oc.library.model.exception.FunctionalException;
import com.library.oc.library.model.exception.NotFoundException;


@Named
public class BookManagerImpl extends AbstractManager implements BookManager {

    @Inject
    private UserManager userManager;

    // Je stocke les books en mémoire car je n'ai pas codé de persistance
    private final List<Book> listBook = new ArrayList<>();


    @Override
    public Book getBook(Integer pId) throws NotFoundException {
        // Je n'ai pas codé la DAO, je mets juste un code pour le cours...
        Book vBook
                = this.listBook.stream()
                .filter(p -> p.getId().equals(pId))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Ouvrage non trouvé : ID=" + pId));
        return vBook;
    }


    @Override
    public List<Book> getListBook() {
        // Je n'ai pas codé la DAO, je mets juste un code pour le cours...
        return this.listBook;
    }


    /**
     * Initialise et peuple la liste de {@link Book}
     */
    @PostConstruct
    private void initListBook() {
        for (int vId = 0; vId < 9; vId++) {
            Book vBook = new Book(vId);
            vBook.setNom("Ouvrage n°" + vId);
            vBook.setCloture(false);
            vBook.setDateCreation(new Date());
            try {
                vBook.setUser(userManager.getUser(vId % 4));
            } catch (NotFoundException vEx) {
                vBook.setUser(null);
            }

            this.listBook.add(vBook);
        }
    }


    @Override
    public void insertBook(Book pBook) throws FunctionalException {
        if (pBook == null) {
            throw new FunctionalException("L'objet Ouvrage ne doit pas être null !");
        }

        Set<ConstraintViolation<Book>> vViolations = getConstraintValidator().validate(pBook);
        if (!vViolations.isEmpty()) {
            throw new FunctionalException("L'objet Ouvrage est invalide",
                    new ConstraintViolationException(vViolations));
        }

        // TODO Persistance
        pBook.setId(999);
        this.listBook.add(pBook);
    }


    @Override
    public List<Version> getListVersion(Book pBook) {
        // Je n'ai pas codé la DAO, je mets juste un code pour le cours...
        List<Version> vListVersion = new ArrayList<>();
        Version vVersion;
        for (int vI = 0; vI < 5; vI++) {
            vVersion = new Version();
            vVersion.setBook(pBook);
            vVersion.setNumero("1." + pBook.getId() + '.' + vI);
            vListVersion.add(vVersion);
        }
        return vListVersion;
    }


    @Override
    public void insertVersion(Version pVersion) throws FunctionalException {
        if (pVersion == null) {
            throw new FunctionalException("L'objet Version ne doit pas être null !");
        }

        Set<ConstraintViolation<Version>> vViolations = getConstraintValidator().validate(pVersion);
        if (!vViolations.isEmpty()) {
            throw new FunctionalException("L'objet Version est invalide",
                    new ConstraintViolationException(vViolations));
        }

        // TODO Persistance
    }

}
