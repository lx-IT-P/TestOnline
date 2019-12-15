package cn.onlineTest.servlet;

import cn.onlineTest.entity.ExamBean;
import cn.onlineTest.entity.StudentBean;
import cn.onlineTest.service.ServiceImpl.StudentServcieImpl;
import cn.onlineTest.service.ServiceImpl.TeacherServiceImpl;
import cn.onlineTest.service.StudentService;
import cn.onlineTest.service.TeacherService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "StudentServlet" ,urlPatterns = "/StudentServlet")
public class StudentServlet extends HttpServlet {
    private Object uri;
    StudentService studentService = new StudentServcieImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        if(request.getParameter("method").equals("addStudent")){
            addStudent(request,response);
        }else if(request.getParameter("method").equals("selectStudent")){
            selectStudent(request,response);
        }
    }

    private void selectStudent(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        list = studentService.select();
        request.setAttribute("list", list);
        uri = request.getRequestDispatcher("/teacherPage/StudentList.jsp");
        goTo(request, response, uri);
    }

    private void addStudent(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{

            StudentBean studentBean = new StudentBean();
            studentBean.setStu_age(Integer.parseInt(request.getParameter("age")));
            studentBean.setStu_name(request.getParameter("name"));
            studentBean.setStu_email(request.getParameter("email"));
            studentBean.setStu_phone(request.getParameter("phone"));
            studentBean.setStu_sex(request.getParameter("sex"));
            StudentService studentService = new StudentServcieImpl();
            studentService.add(studentBean);
        uri = request.getRequestDispatcher("/teacherPage/StudentList.jsp");
        goTo(request, response, uri);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
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
