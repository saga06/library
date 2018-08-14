package com.library.oc.consumer.impl.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

public abstract class AbstractDao {

    @Inject
    @Named("dataSourceLibrary")
    private DataSource dataSource;

    protected DataSource getDataSource() {
        return dataSource;
    }

    private MapSqlParameterSource vParams;

    protected MapSqlParameterSource getvParams() {
        return vParams;
    }

    private NamedParameterJdbcTemplate vNamedParameterJdbcTemplate;

    protected NamedParameterJdbcTemplate getvNamedParameterJdbcTemplate() {
        return vNamedParameterJdbcTemplate;
    }

    // ...
}
