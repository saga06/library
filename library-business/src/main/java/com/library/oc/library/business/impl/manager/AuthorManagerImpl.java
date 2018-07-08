package com.library.oc.library.business.impl.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import com.library.oc.library.business.contract.manager.AuthorManager;
import com.library.oc.library.business.contract.manager.UserManager;
import com.library.oc.library.model.bean.book.Author;
import com.library.oc.library.model.bean.book.Version;
import com.library.oc.library.model.exception.FunctionalException;
import com.library.oc.library.model.exception.NotFoundException;

@Named
public class AuthorManagerImpl extends AbstractManager implements  AuthorManager{

    @Override
    public Author getAuthor(Integer pId) throws NotFoundException {
        return getDaoFactory().getAuthorDao().read(pId);
    }

    @Override
    public List<Author> getListAuthor() {
        return getDaoFactory().getAuthorDao().readAll();
    }

    @Override
    public int getNbAuthor() {
        return getDaoFactory().getBookDao().getCountBook();
    }
}
