package Controller;

import Bean.StudyClass;
import Bean.TeachPlan;
import DAO.CreatePlanDAO;
import DAO.StudyClassDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ViewPlanController", value = "/viewplan")
public class ViewPlanController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str_id = request.getParameter("scid");
        int lophoc_id = Integer.parseInt(str_id);

        CreatePlanDAO createPlanDAO = new CreatePlanDAO();

        List<TeachPlan> list = new ArrayList<TeachPlan>();

        list = createPlanDAO.getTeachPlan(lophoc_id);
        request.setAttribute("list",list);

        request.getRequestDispatcher("/WEB-INF/View/ViewPlan.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
