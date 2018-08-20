package com.library.oc.consumer.contract;

import com.library.oc.consumer.contract.dao.*;
import com.library.oc.library.model.bean.book.BookBorrowed;
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

    //----- BOOK -----
    BookBorrowedDao getBookBorrowedDao();
    void setBookBorrowedDao(BookBorrowedDao pBookBorrowedDao);


    //------Author ------
    AuthorDao getAuthorDao();
    void setAuthorDao(AuthorDao pAuthorDao);

    //------Theme -----
    ThemeDao getThemeDao();
    void setThemeDao (ThemeDao pThemeDao);



    //----- Statut BOOK -----
 /*   BookStatutDao getBookStatutDao();
    void setBookStatutDao(BookStatutDao pBookStatutDao);
*/





}
