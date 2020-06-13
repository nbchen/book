package com.nbchen.web;

import com.nbchen.pojo.Book;
import com.nbchen.pojo.Page;
import com.nbchen.service.BookService;
import com.nbchen.service.impl.BookServiceImpl;
import com.nbchen.utils.WebUtils;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet("/client/bookServlet")
public class ClientBookServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        log.info("===============经过前台client的servlet程序=====================");
        // 根据请求的参数pageNo和pageSize查询数据库,封装Page对象保存到request域,请求转发到列表页面
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);// 如果没有pageNo,默认为第1页
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE_DEFAULT); // 如果没有pageSize,则使用默认每页4条
        Page<Book> page = bookService.page(pageNo,pageSize);
        page.setUrl("client/bookServlet?action=page");
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }

    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        log.info("===============经过前台client的servlet程序=====================");
        // 根据请求的参数pageNo和pageSize查询数据库,封装Page对象保存到request域,请求转发到列表页面
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);// 如果没有pageNo,默认为第1页
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE_DEFAULT); // 如果没有pageSize,则使用默认每页4条
        int min = WebUtils.parseInt(req.getParameter("min"), 0); // 如果没有pageSize,则使用默认每页4条
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE); // 如果没有pageSize,则使用默认每页4条
        Page<Book> page = bookService.pageByPrice(pageNo,pageSize,min,max);
        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");
        // 价格参数不为空,则追加到分页条的参数地址中
        if (req.getParameter("min") != null) {
            sb.append("&min=").append(req.getParameter("min"));
        }
        if (req.getParameter("max") != null) {
            sb.append("&max=").append(req.getParameter("max"));
        }
        page.setUrl(sb.toString());
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }

}
