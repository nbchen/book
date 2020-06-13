package com.nbchen.test;

import com.nbchen.dao.BookDao;
import com.nbchen.dao.impl.BookDaoImpl;
import com.nbchen.pojo.Book;
import com.nbchen.pojo.Page;
import com.nbchen.service.BookService;
import com.nbchen.service.impl.BookServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
public class BookServiceTest {

    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        Book book = Book.builder().name("陈志杰自传").author("陈志杰").price(new BigDecimal("100.00")).sales(10000).stock(0).build();
        System.out.println("book = " + book);
        bookService.addBook(book);
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(25);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(Book.builder().id(23).name("陈志杰自传").author("陈志杰").price(new BigDecimal("100.00")).sales(1000000).stock(0).build());
    }

    @Test
    public void queryBookById() {
        Book book = bookService.queryBookById(22);
        log.info("查询到的单行本:{}",book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookService.queryBooks();
        books.forEach(System.out::println);
    }

    @Test
    public void page() {
        Page<Book> page = bookService.page(1, 4);
        log.info("分页对象: {}",page);
    }

}