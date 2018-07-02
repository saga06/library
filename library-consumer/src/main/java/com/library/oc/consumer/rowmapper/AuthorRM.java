package com.library.oc.consumer.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Named;

import com.library.oc.library.model.bean.book.Author;
import com.library.oc.library.model.bean.user.User;
import org.springframework.jdbc.core.RowMapper;


    @Named
    public class AuthorRM implements RowMapper<Author> {

        @Override
        public Author mapRow(ResultSet pRS, int pRowNum) throws SQLException {

            Author vAuthor = new Author(pRS.getInt("id"));
            vAuthor.setName(pRS.getString("author_name"));

            return vAuthor;
        }
    }


