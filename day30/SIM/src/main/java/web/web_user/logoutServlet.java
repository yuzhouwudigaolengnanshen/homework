package web.web_user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/loginSerlet")
public class logoutServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //删除session
        req.getSession().invalidate();

        //删除cookie
        Cookie cookie = new Cookie("up", "");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);

        req.getRequestDispatcher("user/login.jsp").forward(req,resp);
    }
}
