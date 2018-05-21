package com.library.oc.library.webapp.action;

import com.library.oc.library.business.contract.ManagerFactory;
import com.opensymphony.xwork2.ActionSupport;

import com.library.oc.library.model.bean.utilisateur.Utilisateur;
import com.library.oc.library.model.exception.NotFoundException;
import com.library.oc.library.webapp.WebappHelper;

import javax.inject.Inject;


/**
 * Action de gestion des {@link Utilisateur}
 */
public class GestionUtilisateurAction extends ActionSupport {


    // ==================== Attributs ====================
    // ----- Paramètres en entrée
    private Integer id;

    // ----- Eléments en sortie
    private Utilisateur utilisateur;

    @Inject
    private ManagerFactory managerFactory;


    // ==================== Getters/Setters ====================
    public Integer getId() {
        return id;
    }
    public void setId(Integer pId) {
        id = pId;
    }
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }


    // ==================== Méthodes ====================
    /**
     * Action affichant les détails d'un {@link Utilisateur}
     * @return success / error
     */
    public String doDetail() {
        if (id == null) {
            this.addActionError("Vous devez indiquer un id d'utilisateur");
        } else {
            try {
                utilisateur = managerFactory.getUtilisateurManager().getUtilisateur(id);
            } catch (NotFoundException pE) {
                this.addActionError("Utilisateur non trouvé. ID = " + id);
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }
}