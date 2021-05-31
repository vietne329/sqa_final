package Controller;

import Bean.RegisterdClass;
import Bean.StudyClass;
import Bean.Teacher;
import DAO.RegisterDAO;
import DAO.RegisterdClassDAO;
import DAO.TeacherDAO;
import DB.DBConnection;
import com.mysql.cj.Session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "RegisterForward", value = "/RegisterForward")
public class RegisterForward extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/View/Register.jsp");
        String lophoc_id = request.getParameter("scid");
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

        RegisterdClass rc = new RegisterdClass();
        rc.setGiaovien_id(teacher.getId());
        rc.setClass_id(Integer.parseInt(lophoc_id));

        Boolean check;
        check = RegisterdClassDAO.addRegisterdClass(conn, rc);

        if (check) {
            request.setAttribute("regist","Đăng ký lớp học phần thành công!");
            List<StudyClass> list = RegisterDAO.listClass(conn);
            request.setAttribute("list_class",list);


            List<StudyClass> list1 = RegisterdClassDAO.listRegisterdClass(conn,String.valueOf(teacher.getId()));
            request.setAttribute("list_class2",list1);

            RequestDispatcher rdd = request.getRequestDispatcher("/WEB-INF/View/Home.jsp");
            rdd.forward(request, response);

        }else{
            request.setAttribute("regist","Lớp học này hết slot!");
            List<StudyClass> list = RegisterDAO.listClass(conn);
            request.setAttribute("list_class",list);

            List<StudyClass> list1 = RegisterdClassDAO.listRegisterdClass(conn,String.valueOf(teacher.getId()));
            request.setAttribute("list_class2",list1);

            RequestDispatcher rdd = request.getRequestDispatcher("/WEB-INF/View/Home.jsp");
            rdd.forward(request, response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
