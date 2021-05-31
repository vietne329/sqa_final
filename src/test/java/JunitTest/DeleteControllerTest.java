package JunitTest;

import Bean.StudyClass;
import DAO.RegisterdClassDAO;
import DAO.StudyClassDAO;
import DB.DBConnection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DeleteControllerTest {
    StudyClass sc;
    Connection conn;

    @BeforeEach
    void initData(){
        sc = new StudyClass();
        conn = DBConnection.CreateConnection();
    }

    @Test
    @DisplayName("Test xóa lớp theo id")
    void deleteClass() throws SQLException {

        // hiện thời trong db có lớp học phần có id= 11 được đăng ký
        conn.setAutoCommit(false);
        try {

            StudyClassDAO studyClassDAO=  new StudyClassDAO();
            sc.setId(11);

            boolean check = studyClassDAO.deleteClass(conn,sc.getId());
            assertEquals(true,check);


        } finally {
            conn.rollback();
            conn.close();
        }
    }

}
