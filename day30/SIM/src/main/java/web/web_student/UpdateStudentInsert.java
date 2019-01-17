package web.web_student;

import dao.StudentDao;
import domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(urlPatterns = "/UpdateStudentInsert")
public class UpdateStudentInsert extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = new Student();
        student.setSid(Integer.parseInt(req.getParameter("Sid")));
        student.setSname(req.getParameter("Sname"));
        try {
            student.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("Sbrithday")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        student.setSex(req.getParameter("Ssex"));
        if (StudentDao.insert(student)){
            System.out.println("更新成功");
            req.getRequestDispatcher("student/InsertStudentSuccess.jsp").forward(req,resp);
        }else {
            System.out.println("更新失败");
            req.getRequestDispatcher("student/InsertStudentFail.jsp").forward(req,resp);
        }
    }
}
