package com.library.oc.library.webapp.action;

import java.util.Collections;
import java.util.Date;
import java.util.List;


import com.library.oc.library.business.contract.ManagerFactory;
import com.library.oc.library.model.bean.book.Book;
import com.library.oc.library.model.bean.book.Author;
import com.library.oc.library.model.bean.user.User;
import com.library.oc.library.model.exception.FunctionalException;
import com.library.oc.library.model.exception.NotFoundException;
import com.library.oc.library.model.exception.TechnicalException;
import com.opensymphony.xwork2.ActionSupport;
import javax.inject.Inject;


public class GestionAuthorAction extends ActionSupport {


    // ==================== Attributs ====================
    // ----- Paramètres en entrée
    private Integer id;

    // ----- Eléments en sortie
    private List<Author> listAuthor;
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

    public List<Author> getListAuthor() {
        return listAuthor;
    }

    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author pAuthor) {
        author = pAuthor;
    }


    // ==================== Méthodes ====================

    /**
     * Action listant les {@link Author}
     *
     * @return success
     */


    public String doList() {
        listAuthor = managerFactory.getAuthorManager().getListAuthor();
        return ActionSupport.SUCCESS;
    }


    /**
     * Action affichant les détails d'un {@link Author}
     *
     * @return success / error
     */
    public String doDetail() {
        if (id == null) {
            this.addActionError(getText("error.book.missing.id"));
        } else {
            try {
                author = managerFactory.getAuthorManager().getAuthor(id);
            } catch (NotFoundException pE) {
                //                this.addActionError("Auteur non trouvé. ID = " + id);
                this.addActionError(getText("error.book.notfound", Collections.singletonList(id)));
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }
    /**
     * Action permettant de créer un nouveau {@link Author}
     * @return input / success / error
     */

    /*public String doCreate(Object pId) {
        // Si (this.book == null) c'est que l'on entre dans l'ajout de book
        // Sinon, c'est que l'on vient de valider le formulaire d'ajout

        // Par défaut, le result est "input"
        String vResult = ActionSupport.INPUT;

        // ===== Validation de l'ajout de book (book != null)
        if (this.book != null) {
            // Récupération du user
            if (this.book.getUser() == null
                    || this.book.getUser().getId() == null) {
                this.addFieldError("book.user.id", "ne doit pas être vide");
            } else {
                try {
                    User vUser
                            = managerFactory.getUserManager()
                            .getUser(this.book.getUser().getId());
                    this.book.setUser(vUser);
                } catch (NotFoundException pEx) {
                    this.addFieldError("book.user.id", pEx.getMessage());
                }
            }
            // Date de création
            this.book.setDateCreation(new Date());

            // Si pas d'erreur, ajout du book...
            if (!this.hasErrors()) {
                try {
                    managerFactory.getBookManager().insertBook(this.book);
                    // Si ajout avec succès -> Result "success"
                    vResult = ActionSupport.SUCCESS;
                    this.addActionMessage("Ouvrage ajouté avec succès");

                } catch (FunctionalException pE) {
                    // Sur erreur fonctionnelle on reste sur la page de saisie
                    // et on affiche un message d'erreur
                    this.addActionError(pE.getMessage());

                } catch (TechnicalException pE) {
                    // Sur erreur technique on part sur le result "error"
                    this.addActionError(pE.getMessage());
                    vResult = ActionSupport.ERROR;
                }
            }
        }

        // Si on doit aller sur le formulaire de saisie, il faut ajouter les info nécessaires
        if (vResult.equals(ActionSupport.INPUT)) {
            this.listUser = managerFactory.getUserManager().getListUser(pId);
        }

        return vResult;
    }*/

}
