package com.library.oc.consumer.impl.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.inject.Named;

import com.library.oc.consumer.contract.dao.AuthorDao;
import com.library.oc.consumer.contract.dao.UserDao;


import com.library.oc.library.model.bean.book.Editor;

import org.springframework.jdbc.core.RowMapper;


@Named
public class EditorRM implements RowMapper<Editor> {


    @Inject
    AuthorDao authorDaoImpl;


    @Inject
    UserDao userDaoImpl;


    @Override
    public Editor mapRow(ResultSet pRS, int pRowNum) throws SQLException {

        Editor editor = new Editor(pRS.getInt("id"));
        editor.setName(pRS.getString("name"));


            /*BookStatut vBookNumberOfCopies= BookStatutDaoImpl.read(pRS.getInt("book_number_of_copies"));
            book.setNumberOfCopies(vBookNumberOfCopies);*/

        //-- Récupérer l'auteur du book
            /*Author vAuthor = authorDaoImpl.read(pRS.getInt("author_name"));
            vAuthor.setName(vAuthor);
*/
            /*Book vBook= BookDaoImpl.read(pRS.getInt("book_id"));
            book.setId(vBook);*/

        return editor;
    }
}
