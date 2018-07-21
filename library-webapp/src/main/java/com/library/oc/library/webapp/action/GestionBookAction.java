package com.library.oc.library.webapp.action;

import java.util.Collections;
import java.util.Date;
import java.util.List;


import com.library.oc.library.business.contract.ManagerFactory;
import com.library.oc.library.model.bean.book.Author;
import com.library.oc.library.model.bean.book.Book;
import com.library.oc.library.model.bean.book.Editor;
import com.library.oc.library.model.bean.user.User;
import com.library.oc.library.model.exception.FunctionalException;
import com.library.oc.library.model.exception.NotFoundException;
import com.library.oc.library.model.exception.TechnicalException;
import com.opensymphony.xwork2.ActionSupport;


import javax.inject.Inject;


public class GestionBookAction extends ActionSupport {


    // ==================== Attributs ====================
    // ----- Paramètres en entrée
    private Integer id;

    // ----- Eléments en sortie
    private List<Book> listBook;
    private Book book;
    private List<User> listUser;
    private List<Author> listAuthor;
    private Author author;
    private Editor editor;

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

    public Author getAuthor() {return author;}
    public void setAuthor(Author pAuthor) {author=pAuthor;}

    public Editor getEditor() {return editor;}
    public void setEditor(Editor pEditor) {editor=pEditor;}

    public List<User> getListUser() {
        return listUser;
    }
    // ==================== Méthodes ====================
    /**
     * Action listant les {@link Book}
     * @return success
     */


    public String doList() {
        listBook = managerFactory.getBookManager().getListBook();
        listAuthor = managerFactory.getAuthorManager().getListAuthor();
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
                //                this.addActionError("Projet non trouvé. ID = " + id);
                this.addActionError(getText("error.book.notfound", Collections.singletonList(id)));
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    /**
     * Action permettant de créer un nouveau {@link Book}
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
