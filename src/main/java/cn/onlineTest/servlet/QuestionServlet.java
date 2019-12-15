package cn.onlineTest.servlet;

import cn.onlineTest.entity.QuestionBean;
import cn.onlineTest.service.QuestionService;
import cn.onlineTest.service.ServiceImpl.QuestionServiceImpl;
import net.sf.json.JSONArray;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "QuestionServlet",urlPatterns = "/QuestionServlet")
public class QuestionServlet extends HttpServlet {
    private Object uri;
    QuestionService questionService=new QuestionServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
//        response.getWriter().print("11111");
        if(request.getParameter("method").equals("addQuestion")){
            addQuestion(request,response);
        }else if(request.getParameter("method").equals("selectQuestion")){
            selectQuestion(request,response);
        }else if(request.getParameter("method").equals("screen")){
            screen(request,response);
        }
    }

    private void screen(HttpServletRequest request, HttpServletResponse response) {
        try {
            String subid=request.getParameter("subid");
            List<Map<String,Object>> list=new ArrayList<>();
            list=questionService.selectTestBysubid(subid);
            JSONArray jsonArray=JSONArray.fromObject(list);
            response.getWriter().print(jsonArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void selectQuestion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
            List<Map<String,Object>> list=new ArrayList<>();
            list=questionService.select();
            request.setAttribute("list",list);
           uri =  request.getRequestDispatcher("/studentPage/request.jsp");
            goTo(request, response, uri);
           /*JSONArray jsonArray=JSONArray.fromObject(list);
            response.getWriter().print(jsonArray);*/

//            PrintWriter out=response.getWriter();
//            out.print(list);
            //request域
//            request.setAttribute("questionList",list);

    }

    private void addQuestion(HttpServletRequest request, HttpServletResponse response) {
        try {
            QuestionBean questionBean=new QuestionBean();
            questionBean.setSub_id(Integer.parseInt(request.getParameter("subject")));
            questionBean.setTest_name(request.getParameter("question"));
            questionBean.setOption1(request.getParameter("option1"));
            questionBean.setOption2(request.getParameter("option2"));
            questionBean.setOption3(request.getParameter("option3"));
            questionBean.setOption4(request.getParameter("option4"));
            questionBean.setCorrect(request.getParameter("trueOp"));
//            QuestionService questionService=new QuestionServiceImpl();
            if(questionService.add(questionBean)){
                response.getWriter().print("1");
            }else{
                response.getWriter().print("0");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
