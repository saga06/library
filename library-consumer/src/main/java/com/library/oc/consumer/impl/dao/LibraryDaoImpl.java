package com.library.oc.consumer.impl.dao;


import javax.inject.Named;
import com.library.oc.consumer.contract.dao.LibraryDao;
import com.library.oc.library.model.recherche.RechercheBook;
import org.springframework.jdbc.core.JdbcTemplate;

@Named
public class LibraryDaoImpl extends AbstratDaoImpl {

    @Override
    public int getCountBook(RechercheBook pRechercheBook) {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());
        int  vNbrBook = vJdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM book",
                Integer.class
        );
        return vNbrBook;
    }
}
