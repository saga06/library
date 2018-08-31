package com.library.oc.library.webapp.action;

import com.library.oc.library.business.contract.ManagerFactory;
import com.library.oc.library.model.bean.book.*;
import com.opensymphony.xwork2.ActionSupport;

import com.library.oc.library.model.bean.user.User;

import javax.inject.Inject;
import java.util.List;


/**
 * Action de gestion des {@link User}
 */
public class GestionUserAction extends ActionSupport {


    // ==================== Attributs ====================
    // ----- Paramètres en entrée
    private Integer id;

    // ----- Eléments en sortie
    private User user;
    // ----- Eléments en sortie
    private List<Book> listBook;
    private Book book;
    private List<User> listUser;
    private List<Book> listEditor;
    private List<Author> authors;
    private List<Theme> themes;
    private Editor editor;

    private List<BookBorrowed> listBookBorrowedByUser;


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

    public void setUser(User user) {
        this.user = user;
    }

    public List<Book> getListBook() {
        return listBook;
    }

    public void setListBook(List<Book> listBook) {
        this.listBook = listBook;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<User> getListUser() {
        return listUser;
    }

    public void setListUser(List<User> listUser) {
        this.listUser = listUser;
    }

    public List<Book> getListEditor() {
        return listEditor;
    }

    public void setListEditor(List<Book> listEditor) {
        this.listEditor = listEditor;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Theme> getThemes() {
        return themes;
    }

    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    public List<BookBorrowed> getListBookBorrowedByUser() {
        return listBookBorrowedByUser;
    }

    public void setListBookBorrowedByUser(List<BookBorrowed> listBookBorrowedByUser) {
        this.listBookBorrowedByUser = listBookBorrowedByUser;
    }


    // ==================== Méthodes ====================
    /**
     * Action affichant les détails d'un {@link User}
     * @return success / erreur
     */
    /*public String doDetail() {
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
    }*/

    /**
     * Action affichant les ouvrages emprunté par un {@Link User}
     *
     * @return success / erreur
     */
    public String doListBookBorrowedByUser() {
        if (id == null) {
            this.addActionError("No id user");
        } else {
            listBookBorrowedByUser = managerFactory.getBookManager().getListBookBorrowedByUser(id);
        }
        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }
}

