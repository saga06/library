package com.library.oc.library.business.contract.manager;

import java.util.List;

import com.library.oc.library.model.bean.projet.Projet;
import com.library.oc.library.model.bean.projet.Version;
import com.library.oc.library.model.exception.FunctionalException;
import com.library.oc.library.model.exception.NotFoundException;
import com.library.oc.library.model.exception.TechnicalException;


/**
 * Manager du package « projet »
 */
public interface ProjetManager {

    /**
     * Renvoie la liste des {@link Projet}
     *
     * @return List
     */
    List<Projet> getListProjet();

    /**
     * Renvoie le projet demandé
     *
     * @param pId l'identifiant du projet
     * @return Le {@link Projet}
     * @throws NotFoundException Si le projet n'est pas trouvé
     */
    Projet getProjet(Integer pId) throws NotFoundException;


    /**
     * Ajoute un nouveau {@link Projet}
     * @param pProjet -
     * @throws FunctionalException Projet invalide
     * @throws TechnicalException Erreur technique
     */
    void insertProjet(Projet pProjet) throws FunctionalException, TechnicalException;


    /**
     * Renvoie la liste des versions d'un projet
     * @param pProjet -
     * @return List
     */
    List<Version> getListVersion(Projet pProjet);


    /**
     * Ajoute une nouvelle {@link Version} de {@link Projet}
     * @param pVersion -
     * @throws FunctionalException Version invalide
     */
    void insertVersion(Version pVersion) throws FunctionalException;
}
