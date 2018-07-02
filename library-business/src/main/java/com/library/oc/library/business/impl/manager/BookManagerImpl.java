package com.library.oc.library.business.impl.manager;

import java.util.ArrayList;
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

    @Override
    public Book getBook(Integer pId) throws NotFoundException { return getDaoFactory().getBookDao().read(pId); }


    @Override
    public List<Book> getListBook() { return getDaoFactory().getBookDao().readAll(); }

    @Override
    public int getNbBook() { return getDaoFactory().getBookDao().getCountBook(); }

}
