package Controller;

import Bean.Account;
import Bean.StudyClass;
import Bean.Teacher;
import DAO.LoginDAO;
import DAO.RegisterDAO;
import DAO.RegisterdClassDAO;
import DAO.TeacherDAO;
import DB.DBConnection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "LoginController", value = "/LoginController")
public class LoginController extends HttpServlet {
    private LoginDAO loginDAO = new LoginDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String destPage = "/WEB-INF/View/Home.jsp";

        try {
            Teacher teacher = loginDAO.checkLogin(username,password);
            if(teacher != null){
                String user = teacher.getUsername();
                System.out.println(user);
                String pass = teacher.getPassword();
                System.out.println(pass);
                String tenGiangVien = teacher.getName();
                System.out.println(tenGiangVien);
                request.setAttribute("tenGiangVien",tenGiangVien);
                if(username.equalsIgnoreCase(user) && password.equalsIgnoreCase(pass)){



                    destPage = "/WEB-INF/View/Home.jsp";

                    Connection conn = DBConnection.CreateConnection();
                    List<StudyClass> list = RegisterDAO.listClass(conn);
                    request.setAttribute("list_class",list);
                    Teacher teacher1 = TeacherDAO.getTeacherID(tenGiangVien);
                    int teacher_id = teacher1.getId();
                    List<StudyClass> list1 = RegisterdClassDAO.listRegisterdClass(conn,String.valueOf(teacher_id));
                    request.setAttribute("list_class2",list1);


                    HttpSession session = request.getSession();
                    session.setAttribute("teacher", teacher);
                    destPage = "/WEB-INF/View/Home.jsp";

                    RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
                    dispatcher.forward(request, response);


            }}else {
                String destPage2 = "/WEB-INF/View/Login.jsp";
                String message = "Sai tên tài khoản hoặc mật khẩu!";
                request.setAttribute("message", message);

                RequestDispatcher dispatcher = request.getRequestDispatcher(destPage2);
                dispatcher.forward(request, response);
            }






        } catch ( ClassNotFoundException | SQLException ex) {
            throw new ServletException(ex);
        }
    }
    }

