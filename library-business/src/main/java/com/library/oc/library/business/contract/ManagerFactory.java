package com.library.oc.library.business.contract;

import com.library.oc.library.business.contract.manager.AuthorManager;
import com.library.oc.library.business.contract.manager.BookManager;
import com.library.oc.library.business.contract.manager.UserManager;
import com.library.oc.library.model.bean.book.Author;


/**
 * Factory des Managers
 */
public interface ManagerFactory {


    UserManager getUserManager();
    void setUserManager(UserManager pUserManager);


    BookManager getBookManager();
    void setBookManager(BookManager pBookManager);

    AuthorManager getAuthorManager();
    void setAuthorManager(AuthorManager pAuthorManager);
}
