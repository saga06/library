package com.library.oc.consumer.impl.dao;

import com.library.oc.consumer.contract.dao.LibraryDao;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

public abstract class AbstratDaoImpl implements LibraryDao {

    @Inject
    @Named("dataSourceLibrary")
    private DataSource datasource;

    protected DataSource getDatasource() {
        return datasource;
    }
}
