package DAO;

import Bean.Teacher;
import DB.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDAO {
    public static Teacher getTeacherID(String name) throws SQLException,
            ClassNotFoundException {

        Connection connection = DBConnection.CreateConnection();
        String sql = "select giangvien.id from giangvien where ten =?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);


        ResultSet result = statement.executeQuery();
        Teacher teacher =null;

        if (result.next()) {
            teacher = new Teacher();
            teacher.setId(result.getInt("id"));
        }

        connection.close();
        return teacher;
    }

}
