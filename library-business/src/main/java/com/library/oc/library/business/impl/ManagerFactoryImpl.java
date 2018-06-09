package com.library.oc.library.business.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.library.oc.library.business.contract.ManagerFactory;
import com.library.oc.library.business.contract.manager.BookManager;
import com.library.oc.library.business.contract.manager.BookManager;
import com.library.oc.library.business.contract.manager.UtilisateurManager;


/**
 * Implémentation de la {@link ManagerFactory}.
 */
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
    private UtilisateurManager utilisateurManager;
    @Override
    public UtilisateurManager getUtilisateurManager() {
        return this.utilisateurManager;
    }
    public void setTicketManager(UtilisateurManager pUtilisateurManager) {
        utilisateurManager = pUtilisateurManager;
    }
}
