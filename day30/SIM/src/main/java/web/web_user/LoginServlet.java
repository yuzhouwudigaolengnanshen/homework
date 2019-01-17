package web.web_user;

import dao.UserDao;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private UserDao userDao = new UserDao();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = userDao.findByUsername(username);
        // 数据库没有此用户
        if (user == null) {
            req.setAttribute("error", "用户不存在");
            req.getRequestDispatcher("user/login.jsp")
                    .forward(req, resp);
            return;
        }

        // 如果数据库的密码 不等于 输入密码
        if (!user.getPassword().equals(password)) {
            req.setAttribute("error", "密码错误");
            req.getRequestDispatcher("user/login.jsp")
                    .forward(req, resp);
            return;
        }


        // 实现未登录先登录功能
        // 拿到 session 对象
        HttpSession session = req.getSession();
        // 存储信息
        session.setAttribute("user", user);


        //自动登录
        String auto_login = req.getParameter("auto_login");
        if (auto_login != null && auto_login.equals("ture")){
            Cookie cookie = new Cookie("up", username + ":" + password);
            cookie.setMaxAge(24*3600);
            resp.addCookie(cookie);
        }

        // 通过验证
        /*req.getRequestDispatcher("/student/StudentMenu.jsp")
                .forward(req, resp);*/
        resp.sendRedirect("/student/StudentMenu.jsp");

    }
}
