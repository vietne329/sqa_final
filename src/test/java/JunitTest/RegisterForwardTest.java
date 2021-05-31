package JunitTest;

import Bean.RegisterdClass;
import Bean.StudyClass;
import Bean.Teacher;
import static org.junit.Assert.*;

import DAO.RegisterdClassDAO;

import DB.DBConnection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterForwardTest {

    // khởi tạo cái biến toàn cục trước khi test

    Connection conn= DBConnection.CreateConnection(); ;
    RegisterdClass rc;
    StudyClass sc;
    Teacher teacher;

    @BeforeEach

    void initData() throws SQLException, ClassNotFoundException {
        teacher = new Teacher();
        sc = new StudyClass();
        rc = new RegisterdClass();
    }


    //  test trong miền hợp lệ
    @Test
    @DisplayName("Test giáo viên đăng ký lớp học phần có trong database")
    void registerClass() throws SQLException {
        conn.setAutoCommit(false);
        try {
            // trong db hiện tại có lớp học phần có id = 3 chưa ai đăng ký. Nên em sẽ test cho giáo viên đăng ký lớp học phần này
            // giảng viên này có id = 1
            teacher.setId(1);
            //set id cho lớp học phần
            sc.setId(3);
            rc.setGiaovien_id(teacher.getId());
            rc.setClass_id(sc.getId());
            boolean check = false;
            check = RegisterdClassDAO.addRegisterdClass(conn,rc);
            assertEquals(true,check);


            StudyClass studyClass_check = RegisterdClassDAO.getId(conn,rc.getGiaovien_id(),rc.getClass_id());
            assertEquals(studyClass_check.getId(),rc.getClass_id());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            conn.rollback();
            conn.close();
        }
    }

    //  test biên có lớp học phần id tại biên trên id = 12
    @Test
    @DisplayName("Test giáo viên đăng ký lớp học phần có trong database tại biên trên")
    void registerClass1() throws SQLException {
        conn.setAutoCommit(false);
        try {
            // trong db hiện tại có lớp học phần có id = 12 chưa ai đăng ký. Nên em sẽ test cho giáo viên đăng ký lớp học phần này
            // giảng viên này có id = 1
            teacher.setId(1);
            //set id cho lớp học phần
            sc.setId(12);
            rc.setGiaovien_id(teacher.getId());
            rc.setClass_id(sc.getId());
            boolean check = false;
            check = RegisterdClassDAO.addRegisterdClass(conn,rc);
            assertEquals(true,check);


            StudyClass studyClass_check = RegisterdClassDAO.getId(conn,rc.getGiaovien_id(),rc.getClass_id());
            assertEquals(studyClass_check.getId(),rc.getClass_id());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            conn.rollback();
            conn.close();
        }
    }

    //  test biên có lớp học phần id tại biên dưới id = 1
    @Test
    @DisplayName("Test giáo viên đăng ký lớp học phần có trong database tại biên dưới")
    void registerClass2() throws SQLException {
        conn.setAutoCommit(false);
        try {
            // trong db hiện tại có lớp học phần có id = 12 chưa ai đăng ký. Nên em sẽ test cho giáo viên đăng ký lớp học phần này
            // giảng viên này có id = 1
            teacher.setId(1);
            //set id cho lớp học phần
            sc.setId(12);
            rc.setGiaovien_id(teacher.getId());
            rc.setClass_id(sc.getId());
            boolean check = false;
            check = RegisterdClassDAO.addRegisterdClass(conn,rc);
            assertEquals(true,check);


            StudyClass studyClass_check = RegisterdClassDAO.getId(conn,rc.getGiaovien_id(),rc.getClass_id());
            assertEquals(studyClass_check.getId(),rc.getClass_id());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            conn.rollback();
            conn.close();
        }
    }



    //  test trong miền không hợp lệ biên dưới
    @Test
    @DisplayName("Test giáo viên đăng ký lớp học phần không có trong database nhỏ hơn biên dưới ")
    void registerClass3() throws SQLException {
        conn.setAutoCommit(false);
        try {

            // giảng viên này có id = 1
            teacher.setId(1);
            //set id cho lớp học phần
            sc.setId(-1);
            rc.setGiaovien_id(teacher.getId());
            rc.setClass_id(sc.getId());
            boolean check = false;
            check = RegisterdClassDAO.addRegisterdClass(conn,rc);
            assertEquals(false,check);


        } finally {
            conn.rollback();
            conn.close();
        }
    }


    //  test trong miền không hợp lệ biên trên
    @Test
    @DisplayName("Test giáo viên đăng ký lớp học phần không có trong database quá biên trên")
    void registerClass4() throws SQLException {
        conn.setAutoCommit(false);
        try {

            // giảng viên này có id = 1
            teacher.setId(1);
            //set id quá biên trên cho lớp học phần
            sc.setId(13);
            rc.setGiaovien_id(teacher.getId());
            rc.setClass_id(sc.getId());
            boolean check = false;
            check = RegisterdClassDAO.addRegisterdClass(conn,rc);
            assertEquals(false,check);


        } finally {
            conn.rollback();
            conn.close();
        }
    }

}
