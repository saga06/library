package com.library.oc.consumer.contract;

import com.library.oc.consumer.contract.dao.UserDao;
import com.library.oc.consumer.contract.dao.BookDao;
/*
import com.library.oc.consumer.contract.dao.BookStatutDao;
*/


public interface DaoFactory {

    //----- UTILISATEUR -----
    UserDao getUserDao();
    void setUserDao(UserDao pUserDao);

    //----- BOOK -----
    BookDao getBookDao();
    void setBookDao(BookDao pBookDao);

    //----- Statut BOOK -----
 /*   BookStatutDao getBookStatutDao();
    void setBookStatutDao(BookStatutDao pBookStatutDao);
*/





}
