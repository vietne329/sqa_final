package JunitTest;

import Bean.StudyClass;
import Bean.TeachPlan;
import DAO.CreatePlanDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class ViewPlanControllerTest {
    CreatePlanDAO createPlanDAO;

    @BeforeEach
    void init(){
        createPlanDAO = new CreatePlanDAO();
    }


    @Test
    @DisplayName("Test lấy toàn bộ dữ liệu kế hoạch dạy học của lớp học phần và giáo viên tương ứng")
    void getPlanAll() throws SQLException, ClassNotFoundException {
        // em lấy toàn bộ kế hoạch giảng dạy của lớp học phần có id = 1
        //trong db hiện tại có 3 kế hoạch cho lớp học phần có id = 1
        List<TeachPlan> teachPlanList = new ArrayList<>();
        teachPlanList = createPlanDAO.getTeachPlan(1);
        assertNotNull(teachPlanList);
        assertEquals(3,teachPlanList.size());
    }
}
