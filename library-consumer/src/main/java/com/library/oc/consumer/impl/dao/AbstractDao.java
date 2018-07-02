package com.library.oc.consumer.impl.dao;

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

    // ...
}
