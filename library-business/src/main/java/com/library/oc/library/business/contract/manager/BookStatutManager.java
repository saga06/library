package com.library.oc.library.business.contract.manager;

import java.util.List;

import com.library.oc.library.model.bean.book.BookStatut;
import com.library.oc.library.model.exception.NotFoundException;

public interface BookStatutManager {

    /**
     * Retourne le book ciblé.
     * @param pNumero
     * @return
     * @throws NotFoundException
     */
    BookStatut getBookStatut(Integer pId) throws NotFoundException;

    /**
     * Retourne la liste des book en base de données.
     *
     * @param pRechercheBook
     * @return La liste des objets Book présents en base de données
     */
    List<BookStatut> getListBookStatut();

    /**
     * Détermine le nombre de book en base de données.
     *
     * @return Le nombre de book en base de données (Entier)
     */
    int getNbBookStatut();
}
