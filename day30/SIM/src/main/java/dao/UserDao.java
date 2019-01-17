package dao;

import domain.User;
import util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    /**
     * 根据用户名查询用户对象
     * @param username 用户名
     * @return 查询到了，返回用户对象，如果用户不存在返回 null
     */
    public static User findByUsername(String username) {
        try(Connection conn = JdbcUtils.getConnection()) {
            try(PreparedStatement stmt = conn.prepareStatement("select * from user where username=?")) {
                stmt.setString(1, username);
                ResultSet rs = stmt.executeQuery();
                if(rs.next()) {
                    // 查询到了该用户
                    User user = new User();
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    return user;
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
