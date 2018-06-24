package com.library.oc.library.model.bean.author;

public class Author {

    // ==================== Attributs ====================
    private Integer id;
    private String nom;
    private String prenom;


    // ==================== Constructeurs ====================
    /**
     * Constructeur.
     */
    public Author() {
    }


    /**
     * Constructeur.
     *
     * @param pId -
     */
    public Author(Integer pId) {
        id = pId;
    }


    // ==================== Getters/Setters ====================
    public Integer getId() {
        return id;
    }
    public void setId(Integer pId) {
        id = pId;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String pNom) {
        nom = pNom;
    }

    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String pPrenom) {
        prenom = pPrenom;
    }


    // ==================== Méthodes ====================
    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = ", ";
        vStB.append(" {")
            .append("id=").append(id)
            .append(vSEP).append("nom=\"").append(nom).append('"')
            .append(vSEP).append("prenom=\"").append(prenom).append('"')
            .append("}");
        return vStB.toString();
    }
}
