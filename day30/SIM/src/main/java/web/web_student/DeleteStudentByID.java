package web.web_student;

import dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName DeleteStudentByID
 * @Author zhang-peng-zhan
 * @Date 2019/1/14 23:49
 */
@WebServlet(urlPatterns = "/DeleteStudentByID")
public class DeleteStudentByID extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("sid");
        boolean delete = StudentDao.delete(Integer.parseInt(sid));
        if (delete){
            System.out.println("删除成功");
            req.getRequestDispatcher("student/DeleteStudentS.jsp").forward(req,resp);
        }else {
            System.out.println("删除失败");
            req.getRequestDispatcher("student/DeleteStudentF.jsp").forward(req,resp);
        }
    }
}
