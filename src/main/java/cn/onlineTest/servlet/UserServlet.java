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

@WebServlet(name = "UserServlet", urlPatterns = "/UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
//        response.getWriter().print("11111");
        if(request.getParameter("method").equals("select")){
            select(request, response);
        }
    }

    private void select(HttpServletRequest request, HttpServletResponse response) {
        try {
            UserBean userBean = new UserBean();

            userBean.setUser_name(request.getParameter("userid"));
            userBean.setUser_pwd(request.getParameter("userpwd"));
//            userBean.setUser_identity("教师");
            UserService userService = new UserServiceImpl();
            List<Map<String,Object>> list=new ArrayList<>();
            list=userService.select(userBean);
            if(list.size()>0&&list!=null){
                //设置session存储登录用户
                request.getSession().setAttribute("username",userBean.getUser_name());
//                response.getWriter().print("1");
                JSONArray jsonArray=JSONArray.fromObject(list);
                response.getWriter().print(jsonArray);
            }else {
                response.getWriter().print("0");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
