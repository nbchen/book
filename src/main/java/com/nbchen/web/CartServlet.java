package com.nbchen.web;

import com.google.gson.Gson;
import com.nbchen.pojo.Book;
import com.nbchen.pojo.Cart;
import com.nbchen.pojo.CartItem;
import com.nbchen.service.BookService;
import com.nbchen.service.impl.BookServiceImpl;
import com.nbchen.utils.WebUtils;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@WebServlet("/cartServlet")
public class CartServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    /**
     * 添加商品到购物车 - 改为ajax形式
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("加入购物车");
        // 通过商品编号查询图书信息,转化为CartItem商品项,添加到Cart购物车,然后重定向会原来商品所在页面
        Book book = bookService.queryBookById(WebUtils.parseInt(req.getParameter("id"), 0));
        CartItem cartItem = CartItem.builder()
                .id(book.getId())
                .name(book.getName())
                .count(1)
                .price(book.getPrice())
                .totalPrice(book.getPrice())
                .build();
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);

        log.info("最新添加的一个商品项的名称");
        req.getSession().setAttribute("lastName",cartItem.getName());

        // log.info("添加购物车,{}\n重定向会商品列表的地址,{}",cart,req.getHeader("Referer"));
        // resp.sendRedirect(req.getHeader("Referer"));
        // 不使用重定向了,改用Ajax形式

        Map<String,Object> map = new HashMap<>();
        map.put("totalCount",cart.getTotalCount());
        map.put("lastName",cartItem.getName());
        Gson gson = new Gson();
        String jsonStr = gson.toJson(map);
        resp.getWriter().write(jsonStr);
    }


    /**
     * 伤处购物车商品
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("删除商品项");
        // 根据商品编号删除购物车中的商品项,然后返回购物车所在页
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.deletetem(WebUtils.parseInt(req.getParameter("id"), 0));
            if (cart.getTotalCount() == 0) {
                // 删除最后一个商品项,清除最近添加的商品
                req.getSession().removeAttribute("lastName");
            }
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 清空购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("清空购物车");
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.clear();
            // 清除最近添加的商品
            req.getSession().removeAttribute("lastName");
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 修改购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("修改商品数量");
        // 根据商品id和商品更新购物车信息,重定向会购物车页
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.updateItem(WebUtils.parseInt(req.getParameter("id"), 0),WebUtils.parseInt(req.getParameter("count"), 1));
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
}
