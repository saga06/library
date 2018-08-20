package com.library.oc.consumer.impl.rowmapper;

import com.library.oc.consumer.contract.dao.AuthorDao;
import com.library.oc.consumer.contract.dao.UserDao;
import com.library.oc.library.model.bean.book.Borrow;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
import com.library.oc.consumer.contract.dao.BookStatutDao;
*/

@Named
public class BorrowRM implements RowMapper<Borrow> {


    @Inject
    AuthorDao authorDaoImpl;


    @Inject
    UserDao userDaoImpl;



    @Override
    public Borrow mapRow(ResultSet pRS, int pRowNum) throws SQLException {

        Borrow borrow = new Borrow(pRS.getInt("id"));
        borrow.setDateStart(pRS.getDate("date_start"));
        borrow.setDateEnd(pRS.getDate("date_end"));
        borrow.setAlreadyExtended(pRS.getBoolean("already_extended"));
        borrow.setIdBorrower(pRS.getInt("id_borrower"));
        borrow.setIdBook(pRS.getInt("id_book"));

        return borrow;

    }

}

