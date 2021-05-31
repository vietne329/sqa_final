package JunitTest;

import Bean.StudyClass;
import DAO.StudyClassDAO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import java.util.List;

public class SearchControllerTest {

    StudyClass studyClass;

    @BeforeEach
    void initData(){
        studyClass = new StudyClass();
    }

    @Test
    @DisplayName("Test tìm kiếm gần đúng lớp học phần theo tên môn học chuẩn")
    void searchClassByName(){
        // trong db có 3 lớp học phần có tên môn học là SQA
        StudyClassDAO studyClassDAO=  new StudyClassDAO();
        studyClass.setTenmonhoc("SQA");
        List<StudyClass> list = studyClassDAO.searchClassByName(studyClass.getTenmonhoc());
        int count = list.size();
        assertEquals(3,count);
    }


    @Test
    @DisplayName("Test tìm kiếm gần đúng lớp học phần theo tên môn học sai")
    void searchClassByName1(){
        StudyClassDAO studyClassDAO=  new StudyClassDAO();
        studyClass.setTenmonhoc("aaaaaaaaaaaaa");
        List<StudyClass> list = studyClassDAO.searchClassByName(studyClass.getTenmonhoc());
        int count = list.size();
        assertEquals(0,count);
    }

    @Test
    @DisplayName("Test tìm kiếm gần đúng lớp học phần theo tên môn học để rỗng")
    void searchClassByName2(){
        // output trở về tất cả các môn của các lớp học phần cho người dùng có thể xem lại đầy đủ các lớp học phần khi đã tìm kiếm trước đó
        // bản ghi hiện tại ở db có 12 lớp học phần liên quan đến tất cả các môn
        //output expected = 12;
        StudyClassDAO studyClassDAO=  new StudyClassDAO();
        studyClass.setTenmonhoc("");
        List<StudyClass> list = studyClassDAO.searchClassByName(studyClass.getTenmonhoc());
        int count = list.size();
        assertEquals(12,count);
    }

    @Test
    @DisplayName("Test tìm kiếm gần đúng lớp học phần theo tên môn học để dấu cách")
    void searchClassByName3(){
        // out khi người dùng để dấu cách khi tìm kiếm sẽ không có môn học nào liên quan tới các lớp học phần
        //output expected = 0
        StudyClassDAO studyClassDAO=  new StudyClassDAO();
        studyClass.setTenmonhoc(" ");
        List<StudyClass> list = studyClassDAO.searchClassByName(studyClass.getTenmonhoc());
        int count = list.size();
        assertEquals(0,count);
    }

}
