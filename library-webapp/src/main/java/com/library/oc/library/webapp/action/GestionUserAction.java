package com.library.oc.library.webapp.action;

import com.library.oc.library.business.contract.ManagerFactory;
import com.opensymphony.xwork2.ActionSupport;

import com.library.oc.library.model.bean.user.User;
import com.library.oc.library.model.exception.NotFoundException;
import com.library.oc.library.webapp.WebappHelper;

import javax.inject.Inject;


/**
 * Action de gestion des {@link User}
 */
public class GestionUserAction extends ActionSupport {


    // ==================== Attributs ====================
    // ----- Paramètres en entrée
    private Integer id;

    // ----- Eléments en sortie
    private User user;

    @Inject
    private ManagerFactory managerFactory;


    // ==================== Getters/Setters ====================
    public Integer getId() {
        return id;
    }
    public void setId(Integer pId) {
        id = pId;
    }
    public User getUser() {
        return user;
    }
    // ==================== Méthodes ====================
    /**
     * Action affichant les détails d'un {@link User}
     * @return success / erreur
     */
    public String doDetail() {
        if (id == null) {
            this.addActionError("Vous devez indiquer un id d'user");
        } else {
            try {
                user = managerFactory.getUserManager().getUser(id);
            } catch (NotFoundException pE) {
                this.addActionError("User non trouvé. ID = " + id);
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }
}