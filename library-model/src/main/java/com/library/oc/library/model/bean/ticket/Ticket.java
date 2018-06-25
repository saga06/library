package com.library.oc.library.model.bean.ticket;

import java.util.Date;

import com.library.oc.library.model.bean.book.Book;


/**
 * Bean représentant un Ticket.
 *
 * @user sga
 */
public abstract class Ticket {

    // ==================== Attributs ====================
    private Long numero;
    private String titre;
    private Date date;
    private String description;
    private Book book;
    private TicketStatut statut;


    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut.
     */
    protected Ticket() {
    }


    /**
     * Constructeur.
     *
     * @param pNumero -
     */
    protected Ticket(Long pNumero) {
        numero = pNumero;
    }


    // ==================== Getters/Setters ====================
    public Long getNumero() {
        return numero;
    }
    public void setNumero(Long pNumero) {
        numero = pNumero;
    }
    public String getTitre() {
        return titre;
    }
    public void setTitre(String pTitre) {
        titre = pTitre;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date pDate) {
        date = pDate;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String pDescription) {
        description = pDescription;
    }
    public Book getBook() {
        return book;
    }
    public void setBook(Book pBook) {
        book = pBook;
    }
    public TicketStatut getStatut() {
        return statut;
    }
    public void setStatut(TicketStatut pStatut) {
        statut = pStatut;
    }


    // ==================== Méthodes ====================
    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = ", ";
        vStB.append(" {")
            .append("numero=").append(numero)
            .append(vSEP).append("titre=\"").append(titre).append('"')
            .append(vSEP).append("date=").append(date)
            .append(vSEP).append("description=\"").append(description).append('"')
            .append(vSEP).append("ouvrage=").append(book)
            .append(vSEP).append("statut=").append(statut)
            .append("}");
        return vStB.toString();
    }
}
