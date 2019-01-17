package web.web_student;

import dao.StudentDao;
import domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/UpdateStudentByID")
public class UpdateStudentByID extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("sid");
        //修改  - 先删除再添加
        boolean delete = StudentDao.delete(Integer.parseInt(sid));
        if (delete){
            System.out.println("删除成功");
            //添加 跳转添加页面
            req.getRequestDispatcher("student/UpdateStudentInsert.jsp").forward(req,resp);
        }else {
            System.out.println("删除失败");
            //查无此人
            req.getRequestDispatcher("").forward(req,resp);

        }

    }
}
