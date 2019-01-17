package web.Filter.LoginFilter;


import dao.UserDao;
import domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/*" )
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //强制转换
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        //拿到session
        HttpSession session = req.getSession();

        //当前路径
        String uri = req.getRequestURI();
        //如果是特殊页面 放行
        if (uri.equals("/user/login.jsp")||uri.equals("/login")){
            chain.doFilter(req,resp);
            return;
        }


        //否则跳转到登录页面 提示未登录
        Object username = session.getAttribute("user"); //拿到user对象
        if (username != null){
            //如果登录  放行
            chain.doFilter(req,resp);
        }else {//没有登录
            //找到cookie
            Cookie[] cookies = req.getCookies();
            Cookie cookie = null;
            for (Cookie cookie1 : cookies) {
                if (cookie1.getName().equals("up")){
                     cookie = cookie1;
                     break;
                }
            }

            if (cookie != null){
                String[] split = cookie.getValue().split(":");
                String name = split[0];
                String pass = split[1];
                System.out.println("cookie 中的用户名:" + name + " 密码:" + pass);
                //验证cookie 用户名密码是否正确
                User user = UserDao.findByUsername(name);
                if (user!= null&&user.getPassword().equals(pass)){
                    //正确了，向 session中存入登录标记并放行
                    req.getSession().setAttribute("user",user);
                    chain.doFilter(req,resp);
                    return;
                }
            }

            session.setAttribute("error","您尚未登录,请先登录");
            resp.sendRedirect("/user/login.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
