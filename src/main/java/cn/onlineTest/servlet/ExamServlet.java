package cn.onlineTest.servlet;

import cn.onlineTest.dao.TeacherDao;
import cn.onlineTest.entity.ExamBean;
import cn.onlineTest.service.ExamService;
import cn.onlineTest.service.ServiceImpl.ExamServiceImpl;
import cn.onlineTest.service.ServiceImpl.TeacherServiceImpl;
import cn.onlineTest.service.TeacherService;
import net.sf.json.JSONArray;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ExamServlet",urlPatterns = "/ExamServlet")
public class ExamServlet extends HttpServlet {
    private Object uri;
    ExamService examService=new ExamServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        if(request.getParameter("method").equals("addExam")){
            addExam(request,response);
        }else if(request.getParameter("method").equals("selectScore")){
            selectScore(request,response);
        }
    }

    private void addExam(HttpServletRequest request, HttpServletResponse response) {
        try {
            ExamBean examBean=new ExamBean();
            examBean.setExam_name(request.getParameter("examName"));
            //examBean.setScore(Float.parseFloat(request.getParameter("totalScore")));
            examBean.setScore(Float.parseFloat(request.getParameter("score")));
            examBean.setTest_id(request.getParameter("testsid"));
            String username= (String) request.getSession().getAttribute("username");
            TeacherService teacherService=new TeacherServiceImpl();
            List<Map<String,Object>> list=new ArrayList<>();
            list=teacherService.selectByusername(username);
//            JSONArray jsonArray=JSONArray.fromObject(list);
            if(list.size()>0&&list!=null){
               int teaid= (int) list.get(0).get("tea_id");
               examBean.setTea_id(teaid);
            }
            if(examService.add(examBean)){
                response.getWriter().print("1");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    private void selectScore(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        list = examService.select();
        request.setAttribute("list", list);
        uri = request.getRequestDispatcher("/studentPage/score.jsp");
        goTo(request, response, uri);
    }
    private void goTo(HttpServletRequest request, HttpServletResponse response,
                      Object uri) throws ServletException, IOException {
        if (uri instanceof RequestDispatcher) {
            ((RequestDispatcher) uri).forward(request, response);

        } else {
            response.sendRedirect(request.getContextPath() + (String) uri);
        }
    }
}
