package com.nbchen.test;

import com.nbchen.dao.BookDao;
import com.nbchen.dao.impl.BookDaoImpl;
import com.nbchen.pojo.Book;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@Slf4j
public class BookDaoTest {

    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        Book book = Book.builder().name("陈志杰自传").author("陈志杰").price(new BigDecimal("100.00")).sales(10000).stock(0).build();
        System.out.println("book = " + book);
        bookDao.addBook(book);
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(25);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(Book.builder().id(23).name("陈志杰自传").author("陈志杰").price(new BigDecimal("100.00")).sales(1000000).stock(0).build());
    }

    @Test
    public void queryBookById() {
        Book book = bookDao.queryBookById(22);
        log.info("查询到的单行本:{}",book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookDao.queryBooks();
        books.forEach(System.out::println);
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        List<Book> books = bookDao.queryForPageItems(0,4);
        books.forEach(System.out::println);
    }
}