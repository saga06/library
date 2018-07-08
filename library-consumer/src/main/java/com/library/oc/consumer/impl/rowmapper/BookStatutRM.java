/*
package com.library.oc.consumer.impl.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Named;

import com.library.oc.library.model.bean.book.BookStatut;
import org.springframework.jdbc.core.RowMapper;

*/
/**
 * RowMapper dédié à la table "statut"
 * @author sga
 *
 *//*

@Named
public class BookStatutRM implements RowMapper<BookStatut> {

    @Override
    public BookStatut mapRow(ResultSet pRS, int pRowNum) throws SQLException {

        BookStatut statut = new BookStatut(pRS.getInt("id"));
        statut.setLibelle(pRS.getString("libelle"));

        return statut;
    }

}
*/
