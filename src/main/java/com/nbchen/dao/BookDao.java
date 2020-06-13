package com.nbchen.dao;

import com.nbchen.pojo.Book;

import java.util.List;

public interface BookDao {
    int addBook(Book book);
    int deleteBookById(Integer id);
    int updateBook(Book book);
    Book queryBookById(Integer id);
    List<Book> queryBooks();

    Integer queryForPageTotalCount();

    List<Book> queryForPageItems(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queryForPageItemsByPrice(int min, int max, int begin, int pageSize);
}
