package dao;

import domain.Student;
import util.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 数据访问对象
public class StudentDao {

    // 查询所有
    public static List<Student> findAll() {
        try(Connection conn = JdbcUtils.getConnection()) {
            try(PreparedStatement stmt = conn.prepareStatement("select * from student")){
                ResultSet rs = stmt.executeQuery();
                List<Student> list = new ArrayList<>();
                while(rs.next()) {
                    Student stu = new Student();
                    stu.setSid(rs.getInt("sid"));
                    stu.setSname(rs.getString("sname"));
                    stu.setBirthday(rs.getDate("birthday"));
                    stu.setSex(rs.getString("sex"));
                    list.add(stu);
                }
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
    // 添加学生
    public static boolean insert(Student student) {
            try (Connection conn = JdbcUtils.getConnection()){
                try(PreparedStatement stmt = conn.prepareStatement("insert into student(Sid , Sname , birthday,sex)values (?,?,?,?)")){
                    stmt.setInt(1,student.getSid());
                    stmt.setString(2,student.getSname());
                    stmt.setDate(3,new java.sql.Date(student.getBirthday().getTime()));
                    stmt.setString(4,student.getSex());

                    int execute = stmt.executeUpdate();
                    if (execute==1){
                        return true;
                    }else {
                        return false;
                    }
                }
            }catch (SQLException e){
                e.printStackTrace();
                return false;
            }
    }
    // 根据 id 查询
    public static Student findById(int sid) {
        try (Connection conn = JdbcUtils.getConnection()){
            try(PreparedStatement stmt =conn.prepareStatement("SELECT * from student where Sid = ?")){
                stmt.setInt(1, sid);

                ResultSet resultSet = stmt.executeQuery();
                while (resultSet.next()){
                    int id = resultSet.getInt("sid");
                    String name = resultSet.getString("sname");
                    Date brithday = resultSet.getDate("birthday");
                    String sex = resultSet.getString("sex");
                    Student student = new Student(id,name,brithday,sex);
                    return student;
                }
                return null;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    // 修改学生
    public void update(Student student) {

    }
    // 删除学生
    public static boolean delete(int sid) {
        try (Connection conn = JdbcUtils.getConnection()){
            try(PreparedStatement stmt =conn.prepareStatement("delete from student where Sid = ?")){
                stmt.setInt(1,sid);
                int i = stmt.executeUpdate();
                if (i == 1){
                    return true;
                }else {
                    return false;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
