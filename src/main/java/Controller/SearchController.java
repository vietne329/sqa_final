package Controller;

import Bean.StudyClass;
import Bean.Teacher;
import DAO.RegisterdClassDAO;
import DAO.StudyClassDAO;
import DAO.TeacherDAO;
import DB.DBConnection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

@WebServlet(name = "SearchController", value = "/search")
public class SearchController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txtSearch = request.getParameter("txt");
        StudyClassDAO studyClassDAO = new StudyClassDAO();
        List<StudyClass> list =studyClassDAO.searchClassByName(txtSearch);
        request.setAttribute("list_class",list);

        HttpSession session = request.getSession();
        Teacher teacher1 = (Teacher) session.getAttribute("teacher");
        String teacher_name = teacher1.getName();
        Connection conn = DBConnection.CreateConnection();

        Teacher teacher = new Teacher();
        try {
            teacher = TeacherDAO.getTeacherID(teacher_name);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        List<StudyClass> list1 = RegisterdClassDAO.listRegisterdClass(conn,String.valueOf(teacher.getId()));
        request.setAttribute("list_class2",list1);

        RequestDispatcher rdd = request.getRequestDispatcher("/WEB-INF/View/Home.jsp");
        rdd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
