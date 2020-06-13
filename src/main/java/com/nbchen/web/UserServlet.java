package com.nbchen.web;

import com.google.code.kaptcha.Constants;
import com.google.gson.Gson;
import com.nbchen.pojo.User;
import com.nbchen.service.UserService;
import com.nbchen.service.impl.UserServiceImpl;
import com.nbchen.utils.WebUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

@Slf4j
@WebServlet("/userServlet")
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 判断用户名是否可用,返回JSON字符串
        boolean isExist = userService.existsUsername(req.getParameter("username"));
        Map<String,Object> map = new HashMap<>();
        map.put("isExist",isExist);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(map);
        resp.getWriter().write(jsonStr);
    }

    // 登录
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        // 3.检查用户名是否可用
        User loginUser = userService.login(new User(null, username, password, null));
        if (loginUser==null) {
            // 把错误信息和回显的表单项信息,保存到request域中
            log.info("用户名或密码,登录失败");
            req.setAttribute("msg","用户名或密码错误！");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        } else {
            log.info("登录成功");
            // 登录成功后,将用户信息保存到session域,因为不同页面都需要用户信息,保存到request域不合适
            req.getSession().setAttribute("user",loginUser);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }

    // 注册
    public void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取session中的验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        // 删除session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        // 1.获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

        // 2.检查验证码是否正确 === 写死,要求验证码为: adbce
        if (token != null && token.equalsIgnoreCase(code)) {
            // 3.检查用户名是否可用
            if (userService.existsUsername(username)) {
                log.info("用户名[{}]不可用,返回注册页面",username);
                req.setAttribute("msg","用户名已存在");
                req.setAttribute("username",username);
                req.setAttribute("email",email);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            } else {
                System.out.println("用户名可用,保存到数据库");
                userService.registerUser(new User(null,username,password,email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }
        } else {
            log.info("验证码[{}]不正确,返回注册页面",code);
            req.setAttribute("msg","验证码错误");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }

    public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 销毁session中的用户登录信息/销毁session,并重定向到首页/登录页
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }

}
