package Controller;

import Bean.StudyClass;
import Bean.TeachPlan;
import DAO.CreatePlanDAO;
import DAO.StudyClassDAO;
import DB.DBConnection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "CreatePlanController", value = "/createplan")
public class CreatePlanController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_str = request.getParameter("scid");
        int id = Integer.parseInt(id_str);

        StudyClassDAO studyClassDAO = new StudyClassDAO();
        StudyClass sc = new StudyClass();
        sc = studyClassDAO.selectClassById(id);
        request.setAttribute("sc",sc);

        request.getRequestDispatcher("/WEB-INF/View/CreatePlan.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String kip = request.getParameter("kip");
        String tenbaihoc = request.getParameter("tenbaihoc");
        String loai = request.getParameter("loai");
        String ghichu = request.getParameter("ghichu");
        String id_lophoc = request.getParameter("id_lophoc");

        TeachPlan tp = new TeachPlan(Integer.parseInt(kip), tenbaihoc,loai,ghichu,Integer.parseInt(id_lophoc));
        CreatePlanDAO createPlanDAO = new CreatePlanDAO();
        try {
            Connection conn = DBConnection.CreateConnection();
            boolean check = createPlanDAO.insertTeachPlan(conn,tp);
            if(check){
                request.setAttribute("create_sucess","Thêm thành công!");
                request.getRequestDispatcher("/WEB-INF/View/CreatePlan.jsp").forward(request,response);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
