package com.nbchen.dao.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 使用 Filter 过滤器拦截/pages/manager/所有内容，实现权限检查
 */
public class ManagerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("ManagerFilter.doFilter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        // 如果未登录,则请求转发到登录页面,如果已登录,则继续访问资源
        Object user = request.getSession().getAttribute("user");
        if (user == null) {
            request.getRequestDispatcher("/pages/user/login.jsp").forward(servletRequest,servletResponse);
        } else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
