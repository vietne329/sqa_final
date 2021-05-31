package JunitTest;

import Bean.RegisterdClass;
import Bean.StudyClass;
import Bean.TeachPlan;
import Bean.Teacher;
import DAO.CreatePlanDAO;
import DAO.StudyClassDAO;
import DB.DBConnection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;


public class CreatePlanControllerTest {

    Connection conn;
    RegisterdClass rc;
    StudyClass sc;
    CreatePlanDAO createPlanDAO;
    Teacher teacher;
    TeachPlan teachPlan;

    @BeforeEach
    void initData() {
        conn = DBConnection.CreateConnection();
        sc = new StudyClass();
        createPlanDAO = new CreatePlanDAO();
        teachPlan = new TeachPlan();
    }

    @Test
    @DisplayName("Test tạo lịch giảng dạy hợp lệ")
    void createPlan() throws SQLException {

        // Test thêm kế hoạch dạy học cho lớp học phần nào đó của giảng viên.
        // ở đây em thêm kế hoạch dạy học cho lớp học phần có id = 1
        // set kíp học cho lớp học phần đó = 3

        conn.setAutoCommit(false);
        try {

            StudyClassDAO studyClassDAO = new StudyClassDAO();
            sc.setId(1);
            teachPlan = new TeachPlan();
            teachPlan.setKip(3);
            teachPlan.setTenbaihoc("Báo cáo btl");
            teachPlan.setLoai("Lý thuyết");
            teachPlan.setGhichu("kiem tra nửa lớp");
            teachPlan.setLophoc_id(sc.getId());
            boolean check = createPlanDAO.insertTeachPlan(conn,teachPlan);
            assertEquals(true, check);

        } finally {
            conn.rollback();
            conn.close();
        }
    }

    @Test
    @DisplayName("Test tạo lịch giảng dạy có kíp quá tổng số kíp học của lớp đó")
    void createPlan1() throws SQLException {

        // ở đấy số kíp của lớp có id = 1 là 60, em nhập 61 để test

        conn.setAutoCommit(false);
        try {

            StudyClassDAO studyClassDAO = new StudyClassDAO();
            sc.setId(1);
            teachPlan = new TeachPlan();
            teachPlan.setKip(61);
            teachPlan.setTenbaihoc("Báo cáo btl");
            teachPlan.setLoai("Lý thuyết");
            teachPlan.setGhichu("kiem tra nửa lớp");
            teachPlan.setLophoc_id(sc.getId());
            boolean check = createPlanDAO.insertTeachPlan(conn,teachPlan);
            assertEquals(false, check);

        } finally {
            conn.rollback();
            conn.close();
        }
    }

    @Test
    @DisplayName("Test tạo lịch giảng dạy có kíp bị âm")
    void createPlan2() throws SQLException {

        // ở đấy số kíp của lớp có id = 1 là 60, em nhập 61 để test

        conn.setAutoCommit(false);
        try {

            StudyClassDAO studyClassDAO = new StudyClassDAO();
            sc.setId(1);
            teachPlan = new TeachPlan();
            teachPlan.setKip(-1);
            teachPlan.setTenbaihoc("Báo cáo btl");
            teachPlan.setLoai("Lý thuyết");
            teachPlan.setGhichu("kiem tra nửa lớp");
            teachPlan.setLophoc_id(sc.getId());
            boolean check = createPlanDAO.insertTeachPlan(conn,teachPlan);
            assertEquals(false, check);

        } finally {
            conn.rollback();
            conn.close();
        }
    }

}
