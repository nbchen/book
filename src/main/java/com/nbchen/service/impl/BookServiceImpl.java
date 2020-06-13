package com.nbchen.service.impl;

import com.nbchen.dao.BookDao;
import com.nbchen.dao.impl.BookDaoImpl;
import com.nbchen.pojo.Book;
import com.nbchen.pojo.Page;
import com.nbchen.service.BookService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();
    @Override
    public int addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public int deleteBookById(Integer id) {
        return bookDao.deleteBookById(id);
    }

    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        // 求总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        // 求总页码数
        Integer pageTotal = pageTotalCount % pageSize > 0 ? (pageTotalCount / pageSize) + 1 : pageTotalCount / pageSize;
        // 边界值有效检查
        pageNo = pageNo < 1 ? 1 : pageNo > pageTotal ? pageTotal : pageNo;
        // 求当前页数据
        List<Book> items = bookDao.queryForPageItems((pageNo - 1) * pageSize,pageSize);

        return Page.<Book>builder()
                .pageNo(pageNo) // 设置当前页码
                .pageSize(pageSize) // 设置每页显示条数
                .pageTotalCount(pageTotalCount) // 设置总记录数
                .pageTotal(pageTotal) // 设置总页码数
                .items(items) // 设置当前页数据
                .build();
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        // 求总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min,max);
        // 求总页码数
        Integer pageTotal = pageTotalCount % pageSize > 0 ? (pageTotalCount / pageSize) + 1 : pageTotalCount / pageSize;
        // 边界值有效检查
        pageNo = pageNo < 1 ? 1 : pageNo > pageTotal ? pageTotal : pageNo;
        // 求当前页数据
        List<Book> items = bookDao.queryForPageItemsByPrice(min,max,(pageNo - 1) * pageSize,pageSize);

        return Page.<Book>builder()
                .pageNo(pageNo) // 设置当前页码
                .pageSize(pageSize) // 设置每页显示条数
                .pageTotalCount(pageTotalCount) // 设置总记录数
                .pageTotal(pageTotal) // 设置总页码数
                .items(items) // 设置当前页数据
                .build();
    }
}
