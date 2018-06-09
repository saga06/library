package com.library.oc.library.business.contract;

import com.library.oc.library.business.contract.manager.BookManager;
import com.library.oc.library.business.contract.manager.UtilisateurManager;


/**
 * Factory des Managers
 */
public interface ManagerFactory {

    BookManager getBookManager();

    UtilisateurManager getUtilisateurManager();
}
