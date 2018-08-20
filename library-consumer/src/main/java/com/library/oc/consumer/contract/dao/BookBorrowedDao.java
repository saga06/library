package com.library.oc.consumer.contract.dao;

import com.library.oc.library.model.bean.book.BookBorrowed;

import java.util.List;

public interface BookBorrowedDao {

    List<BookBorrowed> findAllBooksBorrowed(int id);

}
