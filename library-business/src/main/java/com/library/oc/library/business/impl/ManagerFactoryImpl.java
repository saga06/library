package com.library.oc.library.business.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.library.oc.library.business.contract.ManagerFactory;
import com.library.oc.library.business.contract.manager.ProjetManager;
import com.library.oc.library.business.contract.manager.UtilisateurManager;


/**
 * Implémentation de la {@link ManagerFactory}.
 */
@Named("managerFactory")
public class ManagerFactoryImpl implements ManagerFactory {

    @Inject
    private ProjetManager projetManager;
    @Override
    public ProjetManager getProjetManager() {
        return this.projetManager;
    }
    public void setProjetManager(ProjetManager pProjetManager) {
        projetManager = pProjetManager;
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
