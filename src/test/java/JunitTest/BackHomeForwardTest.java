package JunitTest;


import Bean.StudyClass;
import Bean.Teacher;
import DAO.RegisterdClassDAO;
import DAO.StudyClassDAO;
import DAO.TeacherDAO;
import DB.DBConnection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;


public class BackHomeForwardTest {
    Connection conn;
    Teacher teacher;
    int check_id ;
    StudyClassDAO studyClassDAO;
    @BeforeEach
    void initData(){
        conn = DBConnection.CreateConnection();
        teacher = new Teacher();
        check_id = 1;
        studyClassDAO = new StudyClassDAO();
    }

    @Test
    @DisplayName("Test lấy id của giáo viên qua tên giáo viên nhập đúng")
    void getTeacherIdByName() throws SQLException, ClassNotFoundException {
        teacher.setName("Mai Đắc Việt");
        Teacher teacher1 = TeacherDAO.getTeacherID(teacher.getName());
        assertNotNull(teacher1);
        assertEquals(check_id,teacher1.getId());
    }

    @Test
    @DisplayName("Test lấy id của giáo viên qua tên giáo viên nhập sai")
    void getTeacherIdByName1() throws SQLException, ClassNotFoundException {
        teacher.setName("abasdasdasasd");
        Teacher teacher1 = TeacherDAO.getTeacherID(teacher.getName());
        assertNull(teacher1);
    }

    @Test
    @DisplayName("Test lấy id của giáo viên qua tên giáo viên để null")
    void getTeacherIdByName2() throws SQLException, ClassNotFoundException {
        teacher.setName(null);
        Teacher teacher1 = TeacherDAO.getTeacherID(teacher.getName());
        assertNull(teacher1);
    }

    @Test
    @DisplayName("Test lấy id của giáo viên qua tên giáo viên để đúng nhưng chưa chuẩn hóa tên còn dấu cách ")
    void getTeacherIdByName3() throws SQLException, ClassNotFoundException {
        teacher.setName("   Mai Đắc Việt    ");
        Teacher teacher1 = TeacherDAO.getTeacherID(teacher.getName());
        assertNull(teacher1);
    }

    @Test
    @DisplayName("Test lấy toàn bộ dữ liệu lớp học phần cho giáo viên tham khảo")
    void getClassAll() throws SQLException, ClassNotFoundException {
         List<StudyClass> list = new ArrayList<>();
         list = studyClassDAO.selectAllClass();
         assertNotNull(list);
         int output_expect = 12;
         assertEquals(12,list.size());
    }

    @Test
    @DisplayName("Test lấy toàn bộ dữ liệu lớp học phần đã đăng ký")
    void getClassRegisteredAll() throws SQLException, ClassNotFoundException {
        teacher.setName("Mai Đắc Việt");
        Teacher teacher1 = TeacherDAO.getTeacherID(teacher.getName());
         List<StudyClass> list = new ArrayList<>();
          list = RegisterdClassDAO.listRegisterdClass(conn,String.valueOf(teacher1.getId()));
          int count = list.size();
          System.out.println(count);
         assertEquals(3,count);
    }


}
