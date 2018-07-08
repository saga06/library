package com.library.oc.consumer.impl.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.inject.Named;

import com.library.oc.library.model.bean.user.User;
import org.springframework.jdbc.core.RowMapper;


    @Named
    public class UserRM implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet pRS, int pRowNum) throws SQLException {

            User vUser = new User(pRS.getInt("id"));
            vUser.setLastname(pRS.getString("nom"));
            vUser.setSurname(pRS.getString("prenom"));

            return vUser;
        }
    }

