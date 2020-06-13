package com.nbchen.dao.filter;

import com.nbchen.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("TransactionFilter.doFilter ===>");
        try {
            filterChain.doFilter(servletRequest,servletResponse);
            JdbcUtils.commitAndClose(); // 提交事务
        } catch (Exception e) {
            JdbcUtils.rollBackAndClose(); // 回滚事务
            e.printStackTrace();
            throw new RuntimeException(e); // 把异常抛给tomcat管理展示友好的错误页面
        }
        System.out.println("TransactionFilter.doFilter <===");
    }

    @Override
    public void destroy() {

    }
}
