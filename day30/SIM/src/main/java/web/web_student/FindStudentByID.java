package web.web_student;

import dao.StudentDao;
import domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName FindStudentByID
 * @Author zhang-peng-zhan
 * @Date 2019/1/14 22:24
 */
@WebServlet(urlPatterns = "/FindStudentByID")
public class FindStudentByID extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("sid");
        Student student = StudentDao.findById(Integer.parseInt(sid));
        if (student != null){
            System.out.println("查询成功");
            req.setAttribute("s",student);
            req.getRequestDispatcher("student/FindStudentByIdS.jsp").forward(req,resp);
        }else {
            System.out.println("查询失败");
            req.getRequestDispatcher("student/FindStudentByIdF.jsp").forward(req,resp);
        }

    }
}
