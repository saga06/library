package com.library.oc.library.webapp.action;

import com.opensymphony.xwork2.ActionSupport;

import com.library.oc.library.model.bean.utilisateur.Utilisateur;
import com.library.oc.library.model.exception.NotFoundException;
import com.library.oc.library.webapp.WebappHelper;


/**
 * Action de gestion des {@link Utilisateur}
 */
public class GestionUtilisateurAction extends ActionSupport {


    // ==================== Attributs ====================
    // ----- Paramètres en entrée
    private Integer id;

    // ----- Eléments en sortie
    private Utilisateur utilisateur;


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
                utilisateur = WebappHelper.getManagerFactory().getUtilisateurManager().getUtilisateur(id);
            } catch (NotFoundException pE) {
                this.addActionError("Utilisateur non trouvé. ID = " + id);
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }
}