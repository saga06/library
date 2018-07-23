package com.library.oc.library.model.bean.book;

import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.library.oc.library.model.bean.user.User;


/**
 * Objet métier représentant un Book
 *
 * @author sga
 */
public class Book {

    // ==================== Attributs ====================
    private Integer id;

    @NotNull
    private Integer numberOfCopies;

    private String title;

    @NotNull
    private Integer editorId;

    @NotNull
    private String isbn;

    @NotNull
    private String editorName;

    @NotNull
    private String authorName;

    @NotNull
    private String themeName;


    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut.
     */
    public Book() {
    }

    /**
     * Constructeur.
     *
     * @param pId -
     */
    public Book(Integer pId) {
        id = pId;
    }


    // ==================== Getters/Setters ====================
    public Integer getId() {
        return id;
    }
    public void setId(Integer pId) {
        id = pId;
    }


    public Integer getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(Integer numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEditorId() {
        return editorId;
    }

    public void setEditorId(Integer editorId) {
        this.editorId = editorId;
    }

    public String getIsbn() { return isbn; }

    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getEditorName() { return editorName; }

    public void setEditorName(String editorName) { this.editorName = editorName; }

    public String getAuthorName() { return authorName; }

    public void setAuthorName(String authorName) { this.authorName = authorName; }

    public String getThemeName() { return themeName; }

    public void setThemeName(String themeName) { this.themeName = themeName; }

    // ==================== Méthodes ====================
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = ", ";
        vStB.append(" {")
                .append("id=").append(id)
                .append(vSEP).append("Titre=\"").append(title).append('"')
                .append(vSEP).append("Nombre d'exemplaire=").append(numberOfCopies)
                .append(vSEP).append("Editeur=").append(editorId)
                .append("}");
        return vStB.toString();
    }


}
