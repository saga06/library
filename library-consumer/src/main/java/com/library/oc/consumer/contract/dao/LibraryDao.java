package com.library.oc.consumer.contract.dao;

import com.library.oc.library.model.recherche.RechercheBook;

public interface LibraryDao {
    public int getCountBook(RechercheBook pRechercheBook);
}
