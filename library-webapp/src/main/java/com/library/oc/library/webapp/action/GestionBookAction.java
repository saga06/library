package com.library.oc.library.webapp.action;

import java.util.Collections;
import java.util.Date;
import java.util.List;


import com.library.oc.library.business.contract.ManagerFactory;
import com.library.oc.library.model.bean.book.Author;
import com.library.oc.library.model.bean.book.Book;
import com.library.oc.library.model.bean.book.Editor;
import com.library.oc.library.model.bean.book.Theme;
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
    private Integer idEditor;
    private Integer idUser;

    // ----- Eléments en sortie
    private List<Book> listBook;
    private Book book;
    private User user;
    private List<User> listUser;
    private List<Book> listEditor;
    private List<Author> authors;
    private List<Theme> themes;
    private Editor editor;


    @Inject
    private ManagerFactory managerFactory;



    // ==================== Getters/Setters ====================
    public Integer getId() { return id; }
    public void setId(Integer pId) { id = pId; }

    public Integer getIdEditor() { return idEditor; }
    public void setIdEditor(Integer idEditor) { this.idEditor = idEditor; }

    public List<Book> getListBook() { return listBook; }
    public void setListBook(List<Book> listBook) { this.listBook = listBook; }

    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }

    public void setListUser(List<User> listUser) { this.listUser = listUser; }
    public List<User> getListUser() { return listUser; }

    public List<Book> getListEditor() { return listEditor; }
    public void setListEditor(List<Book> listEditor) { this.listEditor = listEditor; }

    public List<Author> getAuthors() { return authors; }
    public void setAuthors(List<Author> authors) { this.authors = authors; }

    public List<Theme> getThemes() {
        return themes;
    }
    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }

    public Editor getEditor() {return editor;}
    public void setEditor(Editor pEditor) {editor=pEditor;}

    public Integer getIdUser() { return idUser; }
    public void setIdUser(Integer idUser) { this.idUser = idUser; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    // ==================== Méthodes ====================
    /**
     * Action listant les {@link Book}
     * @return success
     */


    public String doList() throws NotFoundException {
        listBook = managerFactory.getBookManager().displayAllBooks();
/*
        listEditor = managerFactory.getBookManager().getEditorBook(idEditor);
*/
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
                //                this.addActionError("Ouvrage non trouvé. ID = " + id);
                this.addActionError(getText("error.book.notfound", Collections.singletonList(id)));
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    /**
     * Action permettant d'effectuer un emprunt de {@link Book}
     * @return input / success / erreur
     *
     */
    public String doBorrow() {

        //Par défaut, le result est "input"
        String vResult = ActionSupport.INPUT;

        if (id == null) {
            this.addActionError("livre non renseigné");
        } else {
            if (idUser == null) {
                this.addActionError("identifiant utilisateur non renseigné");
            }
            else {
                try {
                    book = managerFactory.getBookManager().getBook(id);
                    user = managerFactory.getUserManager().getUser(idUser);
                    managerFactory.getBookManager().borrowBook(user, book);
                }
                catch (NotFoundException e) {
                    this.addActionError("Une erreur s'est produite");
                }
            }
        }
        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    /**
     * Action permettant de prolonger un prêt d'un {@link Book}
     * @return input / success / erreur
     *
     */
    public String doExtend() {

        //Par défaut, le result est "input"
        String vResult = ActionSupport.INPUT;

        if (id == null) {
            this.addActionError("livre non renseigné");
        } else {
            managerFactory.getBookManager().extendBorrow(id);
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
