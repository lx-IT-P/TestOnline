package cn.onlineTest.servlet;

import cn.onlineTest.entity.TeacherBean;
import cn.onlineTest.entity.UserBean;
import cn.onlineTest.service.ServiceImpl.TeacherServiceImpl;
import cn.onlineTest.service.ServiceImpl.UserServiceImpl;
import cn.onlineTest.service.TeacherService;
import cn.onlineTest.service.UserService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "TeacherServlet",urlPatterns = "/TeacherServlet")
public class TeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        if (request.getParameter("method").equals("addTeacher")) {
//            response.sendRedirect(request.getContextPath()+"/index.jsp");
            addTeacher(request, response);
        }
    }

    private void addTeacher(HttpServletRequest request, HttpServletResponse response) {
        try {

            //根据userid在user表中查询是否该用户名已被注册，若已注册则提示消息
            UserService userService = new UserServiceImpl();
            String userName= request.getParameter("userid");
            List<Map<String,Object>> list=new ArrayList<>();
            //根据username查询user信息
            list=userService.select(userName);
            if (list.size()>0&&list!=null) {
                 response.getWriter().print("0");

            }else {
                TeacherBean teacherBean = new TeacherBean();
                teacherBean.setTea_Name(request.getParameter("userid"));
                TeacherService teacherService = new TeacherServiceImpl();
                if (teacherService.add(teacherBean)) {
                    UserBean userBean = new UserBean();
                    userBean.setUser_name(request.getParameter("userid"));
                    userBean.setUser_pwd(request.getParameter("userpwd"));
                    userBean.setUser_identity("教师");

                    if (userService.add(userBean)) {
//                        JSONArray jsonArray = JSONArray.fromObject(userBean);
//                        response.getWriter().print(jsonArray);
                        response.getWriter().print("1");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
