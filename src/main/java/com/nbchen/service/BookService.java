package com.nbchen.service;

import com.nbchen.pojo.Book;
import com.nbchen.pojo.Page;

import java.util.List;

public interface BookService {
    int addBook(Book book);
    int deleteBookById(Integer id);
    int updateBook(Book book);
    Book queryBookById(Integer id);
    List<Book> queryBooks();

    Page<Book> page(int pageNo, int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
