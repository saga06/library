package com.library.oc.library.webapp.action;

import com.library.oc.library.business.contract.ManagerFactory;
import com.opensymphony.xwork2.ActionSupport;

import com.library.oc.library.model.bean.author.Author;
import com.library.oc.library.model.exception.NotFoundException;
import com.library.oc.library.webapp.WebappHelper;

import javax.inject.Inject;


/**
 * Action de gestion des {@link Author}
 */
public class GestionAuthorAction extends ActionSupport {


    // ==================== Attributs ====================
    // ----- Paramètres en entrée
    private Integer id;

    // ----- Eléments en sortie
    private Author author;

    @Inject
    private ManagerFactory managerFactory;


    // ==================== Getters/Setters ====================
    public Integer getId() {
        return id;
    }
    public void setId(Integer pId) {
        id = pId;
    }
    public Author getAuthor() {
        return author;
    }


    // ==================== Méthodes ====================
    /**
     * Action affichant les détails d'un {@link Author}
     * @return success / error
     */
    public String doDetail() {
        if (id == null) {
            this.addActionError("Vous devez indiquer un id d'author");
        } else {
            try {
                author = managerFactory.getAuthorManager().getAuthor(id);
            } catch (NotFoundException pE) {
                this.addActionError("Author non trouvé. ID = " + id);
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }
}