package com.library.oc.library.webapp.action;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;


import com.library.oc.library.model.bean.projet.Projet;
import com.library.oc.library.model.bean.utilisateur.Utilisateur;
import com.library.oc.library.model.exception.FunctionalException;
import com.library.oc.library.model.exception.NotFoundException;
import com.library.oc.library.model.exception.TechnicalException;
import com.library.oc.library.webapp.WebappHelper;
import com.opensymphony.xwork2.ActionSupport;


/**
 * Action de gestion des {@link Projet}
 */
public class GestionProjetAction extends ActionSupport {


    // ==================== Attributs ====================
    // ----- Paramètres en entrée
    private Integer id;

    // ----- Eléments en sortie
    private List<Projet> listProjet;
    private Projet projet;
    private List<Utilisateur> listUtilisateur;


    // ==================== Getters/Setters ====================
    public Integer getId() {
        return id;
    }
    public void setId(Integer pId) {
        id = pId;
    }
    public List<Projet> getListProjet() {
        return listProjet;
    }
    public Projet getProjet() {
        return projet;
    }
    public void setProjet(Projet pProjet) {projet=pProjet;}

    public List<Utilisateur> getListUtilisateur() {
        return listUtilisateur;
    }
    // ==================== Méthodes ====================
    /**
     * Action listant les {@link Projet}
     * @return success
     */
    public String doList() {
        listProjet = WebappHelper.getManagerFactory().getProjetManager().getListProjet();
        return ActionSupport.SUCCESS;
    }


    /**
     * Action affichant les détails d'un {@link Projet}
     * @return success / error
     */
    public String doDetail() {
        if (id == null) {
            this.addActionError(getText("error.book.missing.id"));
        } else {
            try {
                projet = WebappHelper.getManagerFactory().getProjetManager().getProjet(id);
            } catch (NotFoundException pE) {
                this.addActionError(getText("error.book.notfound", Collections.singletonList(id)));
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }
    /**
     * Action permettant de créer un nouveau {@link Projet}
     * @return input / success / error
     */
    public String doCreate() {
        // Si (this.projet == null) c'est que l'on entre dans l'ajout de projet
        // Sinon, c'est que l'on vient de valider le formulaire d'ajout

        // Par défaut, le result est "input"
        String vResult = ActionSupport.INPUT;

        // ===== Validation de l'ajout de projet (projet != null)
        if (this.projet != null) {
            // Récupération du responsable
            if (this.projet.getResponsable() == null
                    || this.projet.getResponsable().getId() == null) {
                this.addFieldError("projet.responsable.id", "ne doit pas être vide");
            } else {
                try {
                    Utilisateur vResponsable
                            = WebappHelper.getManagerFactory().getUtilisateurManager()
                            .getUtilisateur(this.projet.getResponsable().getId());
                    this.projet.setResponsable(vResponsable);
                } catch (NotFoundException pEx) {
                    this.addFieldError("projet.responsable.id", pEx.getMessage());
                }
            }
            // Date de création
            this.projet.setDateCreation(new Date());

            // Si pas d'erreur, ajout du projet...
            if (!this.hasErrors()) {
                try {
                    WebappHelper.getManagerFactory().getProjetManager().insertProjet(this.projet);
                    // Si ajout avec succès -> Result "success"
                    vResult = ActionSupport.SUCCESS;
                    this.addActionMessage("Projet ajouté avec succès");

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
            this.listUtilisateur = WebappHelper.getManagerFactory().getUtilisateurManager().getListUtilisateur();
        }

        return vResult;
    }
}