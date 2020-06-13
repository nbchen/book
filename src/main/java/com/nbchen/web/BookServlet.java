package com.nbchen.web;

import com.nbchen.pojo.Book;
import com.nbchen.pojo.Page;
import com.nbchen.service.BookService;
import com.nbchen.service.impl.BookServiceImpl;
import com.nbchen.utils.WebUtils;
import lombok.extern.slf4j.Slf4j;
import sun.misc.CharacterDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.events.Characters;
import java.io.IOException;
import java.util.Map;

@Slf4j
@WebServlet("/manager/bookServlet")
public class BookServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 将请求的参数封装为Book实体对象,保存到数据库,重定向到列表页面
        bookService.addBook(WebUtils.copyParamToBean(req.getParameterMap(), new Book()));
        // 添加完要跳到最后一个,我们逻辑有做边界值校验,所以这边可以将pageNO+1处理,这样就总是跳到最大页码
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+(WebUtils.parseInt(req.getParameter("pageNo"),0) + 1));
    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 根据请求的id删除数据库的记录,重定向到列表
        bookService.deleteBookById(WebUtils.parseInt(req.getParameter("id"),0));
        // 添加完要跳到最后一个,我们逻辑有做边界值校验,所以这边可以将pageNO+1处理,这样就总是跳到最大页码
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+(WebUtils.parseInt(req.getParameter("pageNo"),0) + 1));
    }
    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 根据id插叙当前图书信息并转发到编辑页面
        req.setAttribute("book",bookService.queryBookById(WebUtils.parseInt(req.getParameter("id"),0)));
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);

    }
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 将请求的参数封装为Book实体对象,保存到数据库,重定向到列表页面
        bookService.updateBook(WebUtils.copyParamToBean(req.getParameterMap(), new Book()));
        // 添加完要跳到最后一个,我们逻辑有做边界值校验,所以这边可以将pageNO+1处理,这样就总是跳到最大页码
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+(WebUtils.parseInt(req.getParameter("pageNo"),0) + 1));
    }
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 查询集合放到request域,请求转发携带数据返回给前端页面
        req.setAttribute("books",bookService.queryBooks());
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 根据请求的参数pageNo和pageSize查询数据库,封装Page对象保存到request域,请求转发到列表页面
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);// 如果没有pageNo,默认为第1页
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE_DEFAULT); // 如果没有pageSize,则使用默认每页4条
        Page<Book> page = bookService.page(pageNo,pageSize);
        page.setUrl("manager/bookServlet?action=page");
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }
}
