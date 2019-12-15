package cn.onlineTest.servlet;

import cn.onlineTest.entity.Answer;
import cn.onlineTest.service.AnswerService;
import cn.onlineTest.service.ServiceImpl.AnswerServiceImpl;

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

@WebServlet(name = "AnswerServlet",urlPatterns = "/AnswerServlet")
public class AnswerServlet extends HttpServlet {
    private Object uri;
    AnswerService answerService = new AnswerServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
//        response.getWriter().print("11111");
        if (request.getParameter("method").equals("addAnswer")) {
            addAnswer(request, response);}
            else if(request.getParameter("method").equals("selectAnswer")){
            selectAnswer(request,response);

        }
    }
    private void addAnswer(HttpServletRequest request, HttpServletResponse response) {
        try {
            Answer answer = new Answer();
            answer.setAnswer(request.getParameter("answer"));
            if(answerService.add(answer)){
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
    private void selectAnswer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        list = answerService.select();
        request.setAttribute("list", list);
        uri = request.getRequestDispatcher("/studentPage/answer.jsp");
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



