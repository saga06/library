package com.library.oc.consumer.contract.dao;

import com.library.oc.library.model.bean.book.Editor;

import java.util.List;

public interface EditorDao {

    //-- CRUD : Les méthodes nécessaires

    /**
     * Méthode de création
     * @param obj
     * @return boolean
     */
    boolean create(Editor obj);

    /**
     * Méthode de recherche des informations
     * @param id
     * @return T
     */
    Editor read(int id);
    Editor read(String code);
    List<Editor> readAll();
    List<Editor> readAll(int id);

    /**
     * Méthode de mise à jour
     * @param obj
     * @return boolean
     */
    boolean update(Editor obj);

    /**
     * Méthode pour effacer
     * @param obj
     * @return boolean
     */
    boolean delete(Editor obj);

    /**
     * Retourne le nombre de Editor
     * @param pRechercheEditor
     * @return Le nombre de Editor
     */
    int getCountEditor();
}
