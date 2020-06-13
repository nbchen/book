package com.nbchen.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@WebFilter(urlPatterns = {"/*"},initParams = {@WebInitParam(name = "encoding",value = "UTF-8",description = "字符集编码")})
public class CharacterFilter implements Filter {
    String encoding = null;  //字符编码
    
    public void destroy() {
        encoding = null;

    }

    public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
        System.out.println("CharacterFilter.doFilter ===> ");
        // 静态资源过滤器,直接放行,防止CSS等因为编码过滤器被拦截
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        StringBuffer url = ((HttpServletRequest) request).getRequestURL();
        String uri = ((HttpServletRequest) request).getRequestURI();
        System.out.println("url = " + url.toString());
        System.out.println("uri = " + uri);
        System.out.println(uri.endsWith(".css") || uri.endsWith(".js")|| uri.endsWith(".gif") || uri.endsWith(".png") || uri.endsWith(".bmp") || uri.endsWith(".ico"));
        if (uri.endsWith(".css") || uri.endsWith(".js")
            || uri.endsWith(".gif") || uri.endsWith(".png")
            || uri.endsWith(".bmp") || uri.endsWith(".ico")) {
            chain.doFilter(request,response);
        } else {
            // 给费静态文件设置编码
            if(encoding != null){
                request.setCharacterEncoding(encoding);  //设置request的编码格式
                response.setContentType("text/html;charset="+encoding); //设置response字符编码
            }
            chain.doFilter(request, response);  //传递给下一个过滤器
            System.out.println("CharacterFilter.doFilter <== ");
        }
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding"); //获取初始化参数
    }
}