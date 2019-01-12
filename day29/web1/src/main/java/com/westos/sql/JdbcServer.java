package com.westos.sql;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import sun.misc.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @ClassName JdbcServer
 * @Author zhang-peng-zhan
 * @Date 2019/1/11 18:10
 */
@WebServlet(urlPatterns = "/myform")
public class JdbcServer extends HttpServlet {
    static String  username = null;
    static String  password = null;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        username = req.getParameter("username");
        password = req.getParameter("password");

        try( Connection connection = JDBCutils.getConnection2()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement
                    ("insert into data(ID,username,password) values (null,?,?)")){
                preparedStatement.setString(1,username);
                preparedStatement.setString(2,password);
                boolean execute = preparedStatement.execute();
                if (!execute){
                    System.out.println("添加成功");
                    req.getRequestDispatcher("/formsuccess.jsp").forward(req, resp);
                }else {
                    System.out.println("添加失败");
                    req.getRequestDispatcher("/formfail.jsp").forward(req, resp);
                }
            }
        }catch (MySQLIntegrityConstraintViolationException e){
            req.getRequestDispatcher("/formfail.jsp").forward(req, resp);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
