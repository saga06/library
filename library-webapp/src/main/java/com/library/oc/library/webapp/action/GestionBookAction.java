package com.library.oc.library.webapp.action;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;


import com.library.oc.library.business.contract.ManagerFactory;
import com.library.oc.library.model.bean.book.Book;
import com.library.oc.library.model.bean.utilisateur.Utilisateur;
import com.library.oc.library.model.exception.FunctionalException;
import com.library.oc.library.model.exception.NotFoundException;
import com.library.oc.library.model.exception.TechnicalException;
import com.library.oc.library.webapp.WebappHelper;
import com.opensymphony.xwork2.ActionSupport;

import javax.inject.Inject;


/**
 * Action de gestion des {@link Book}
 */
public class GestionBookAction extends ActionSupport {


    // ==================== Attributs ====================
    // ----- Paramètres en entrée
    private Integer id;

    // ----- Eléments en sortie
    private List<Book> listBook;
    private Book book;
    private List<Utilisateur> listUtilisateur;

    @Inject
    private ManagerFactory managerFactory;


    // ==================== Getters/Setters ====================
    public Integer getId() {
        return id;
    }
    public void setId(Integer pId) {
        id = pId;
    }
    public List<Book> getListBook() {
        return listBook;
    }
    public Book getBook() {
        return book;
    }
    public void setBook(Book pBook) {book=pBook;}

    public List<Utilisateur> getListUtilisateur() {
        return listUtilisateur;
    }
    // ==================== Méthodes ====================
    /**
     * Action listant les {@link Book}
     * @return success
     */
    public String doList() {
        listBook = managerFactory.getBookManager().getListBook();
        return ActionSupport.SUCCESS;
    }


    /**
     * Action affichant les détails d'un {@link Book}
     * @return success / error
     */
    public String doDetail() {
        if (id == null) {
            this.addActionError(getText("error.book.missing.id"));
        } else {
            try {
                book = managerFactory.getBookManager().getBook(id);
            } catch (NotFoundException pE) {
                this.addActionError(getText("error.book.notfound", Collections.singletonList(id)));
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }
    /**
     * Action permettant de créer un nouveau {@link Book}
     * @return input / success / error
     */
    public String doCreate() {
        // Si (this.book == null) c'est que l'on entre dans l'ajout de book
        // Sinon, c'est que l'on vient de valider le formulaire d'ajout

        // Par défaut, le result est "input"
        String vResult = ActionSupport.INPUT;

        // ===== Validation de l'ajout de book (book != null)
        if (this.book != null) {
            // Récupération du author
            if (this.book.getAuthor() == null
                    || this.book.getAuthor().getId() == null) {
                this.addFieldError("book.author.id", "ne doit pas être vide");
            } else {
                try {
                    Utilisateur vAuthor
                            = managerFactory.getUtilisateurManager()
                            .getUtilisateur(this.book.getAuthor().getId());
                    this.book.setAuthor(vAuthor);
                } catch (NotFoundException pEx) {
                    this.addFieldError("book.author.id", pEx.getMessage());
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
            this.listUtilisateur = managerFactory.getUtilisateurManager().getListUtilisateur();
        }

        return vResult;
    }
}