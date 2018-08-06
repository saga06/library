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

            User vUser = new User();
            vUser.setId(pRS.getInt("user_id"));
            vUser.setLastname(pRS.getString("user_lastname"));
            vUser.setSurname(pRS.getString("user_surname"));
            vUser.setEmail(pRS.getString("user_email"));
            vUser.setPassword(pRS.getString("user_pass"));

            return vUser;
        }
    }

