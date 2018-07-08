package com.library.oc.consumer.impl;


import javax.inject.Inject;
import javax.inject.Named;

import com.library.oc.consumer.contract.DaoFactory;
import com.library.oc.consumer.contract.dao.AuthorDao;
import com.library.oc.consumer.contract.dao.BookDao;
import com.library.oc.consumer.contract.dao.UserDao;
/*
import com.library.oc.consumer.contract.dao.BookStatutDao;
*/


@Named("daoFactory")
public class DaoFactoryImpl implements DaoFactory {


    @Inject
    BookDao bookDaoImpl;
    @Inject
    UserDao userDaoImpl;
    @Inject
    AuthorDao authorDaoImpl;


    //----- UTLISATEUR -----
    @Override
    public UserDao getUserDao() { return userDaoImpl; }
    @Override
    public void setUserDao(UserDao pUserDao) { userDaoImpl = pUserDao; }



    //----- BOOK -----
    @Override
    public BookDao getBookDao() { return bookDaoImpl; }
    @Override
    public void setBookDao(BookDao pBookDao) { this.bookDaoImpl = pBookDao; }

    //----- Author -----

    @Override
    public AuthorDao getAuthorDao() { return authorDaoImpl; }
    @Override
    public void setAuthorDao(AuthorDao pAuthorDao) { this.authorDaoImpl = pAuthorDao; }



 /*   //----- Book STATUT -----
    @Override
    public void setBookStatutDao(BookStatutDao pBookStatutDao) {
        this.bookStatutDaoImpl = pBookStatutDao;
    }
    @Override
    public BookStatutDao getBookStatutDao() {
        return bookStatutDaoImpl;
    }

*/

}

