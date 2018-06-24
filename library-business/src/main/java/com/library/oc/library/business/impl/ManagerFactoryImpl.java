package com.library.oc.library.business.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.library.oc.library.business.contract.ManagerFactory;
import com.library.oc.library.business.contract.manager.BookManager;
import com.library.oc.library.business.contract.manager.AuthorManager;


/**
 * Implémentation de la {@link ManagerFactory}.
 */
//Bean pouvant être injecté grâce à @Named
@Named("managerFactory")
public class ManagerFactoryImpl implements ManagerFactory {

    @Inject
    private BookManager bookManager;
    @Override
    public BookManager getBookManager() {
        return this.bookManager;
    }
    public void setBookManager(BookManager pBookManager) {
        bookManager = pBookManager;
    }


    @Inject
    private AuthorManager authorManager;
    @Override
    public AuthorManager getAuthorManager() {
        return this.authorManager;
    }
    public void setAuthorManager(AuthorManager pAuthorManager) {
        authorManager = pAuthorManager;
    }
}
