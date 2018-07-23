/*
package com.library.oc.consumer.impl.dao;

import com.library.oc.consumer.contract.dao.EditorDao;
import com.library.oc.library.model.bean.book.Editor;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import java.util.List;

public class EditorDaoImpl  extends AbstractDao implements EditorDao {

    //----- INJECTION DES DEPENDANCES -----
*/
/*    @Inject
    EditorStatutDao editorStatutDaoImpl;*//*

    @Inject
    EditorDao userDaoImpl;
    @Inject
    EditorRM editorRM;

    //----- IMPLEMENTATION DES METHODES -----

    @Override
    public boolean create(Editor obj) {
        // TODO Auto-generated method stub
        return false;
    }

    */
/*@Override
    public Editor read(int numero) {
        String vSQL = "SELECT * FROM editor WHERE id="+numero;

        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        //List<Editor> listEditor = jdbcTemplate.query(vSQL, editorRM);
        //Editor vEditor = listEditor.get(0);

        //return vEditor;
    }*//*


    @Override
    public Editor read(String code) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Editor> readAll() {
        String vSQL = "SELECT * FROM editor";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        //List<Editor> vListEditor = vJdbcTemplate.query(vSQL, editorRM);

        //return vListEditor;
    }

    @Override
    public List<Editor> readAll(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(Editor obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Editor obj) {
        // TODO Auto-generated method stub
        return false;
    }

    // ...

    @Override
    public int getCountEditor() {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        int vNbrEditor = vJdbcTemplate.queryForObject("SELECT COUNT(*) FROM editor", Integer.class);

        return vNbrEditor;
    }


}
*/
