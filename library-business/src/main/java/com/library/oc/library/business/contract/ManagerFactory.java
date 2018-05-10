package com.library.oc.library.business.contract;

import com.library.oc.library.business.contract.manager.ProjetManager;
import com.library.oc.library.business.contract.manager.UtilisateurManager;


/**
 * Factory des Managers
 */
public interface ManagerFactory {

    ProjetManager getProjetManager();

    UtilisateurManager getUtilisateurManager();
}
