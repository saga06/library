package com.library.oc.consumer.impl.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.library.oc.consumer.contract.dao.ThemeDao;
import com.library.oc.consumer.impl.rowmapper.ThemeRM;
import com.library.oc.library.model.bean.book.Book;
import com.library.oc.library.model.bean.book.Theme;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

@Named
public class ThemeDaoImpl extends AbstractDao implements ThemeDao {

    //----- INJECTION DES DEPENDANCES -----

    @Inject
    ThemeRM themeRM;

    @Override
    public List<Theme> findThemesByBook(Book book){
        try
        {
            String vSQL =
                    "SELECT theme_name, theme_id FROM theme \n" +
                     "INNER JOIN book_theme ON book_theme.book_theme_theme_id = theme.theme_id \n" +
                            "INNER JOIN book ON book.book_id = book_theme.book_theme_book_id \n" +
                            " WHERE book.book_id ="+book.getId();
            JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
            List<Theme> listTheme = jdbcTemplate.query(vSQL, themeRM);

            return listTheme;
        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }
}
