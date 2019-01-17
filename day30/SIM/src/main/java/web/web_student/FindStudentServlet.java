package web.web_student;

import dao.StudentDao;
import domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/findStudent")
public class FindStudentServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> list = StudentDao.findAll();
        if (!list.isEmpty()){
            req.setAttribute("list", list);
            req.getRequestDispatcher("student/ChackStudentS.jsp").forward(req, resp);
        }else {
            req.getRequestDispatcher("student/ChackStudentF.jsp").forward(req, resp);
        }

    }
}
