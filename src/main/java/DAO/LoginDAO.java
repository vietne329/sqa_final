package DAO;

import Bean.Account;
import Bean.Teacher;
import DB.DBConnection;
import com.sun.deploy.net.HttpRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO {
    public Teacher checkLogin(String username, String password) throws SQLException,
            ClassNotFoundException {

        Connection connection = DBConnection.CreateConnection();
        String sql = "SELECT ten,Tentaikhoan,Matkhau FROM giangvien, taikhoan WHERE `giangvien`.taikhoan_id = `taikhoan`.id AND `taikhoan`.Tentaikhoan = ? AND `taikhoan`.Matkhau = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);

        ResultSet result = statement.executeQuery();
        Teacher teacher =null;

        if (result.next()) {
            teacher = new Teacher();
            System.out.println("RESULT: " + result.getString("ten"));
            teacher.setName(result.getString("ten"));
            teacher.setUsername(result.getString("Tentaikhoan"));
            teacher.setPassword(result.getString("Matkhau"));
        }

        connection.close();
        return teacher;
    }


}
