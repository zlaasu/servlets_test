package pl.coreslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "Get4", urlPatterns = {"/get4"})
public class Get4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");

        String company = request.getParameter("company");
        String learn = request.getParameter("learn");

        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            response.getWriter().append(entry.getKey()).append(":</br>");
            for (int i = 0; i < entry.getValue().length; i++) {
                response.getWriter().append("-").append(entry.getValue()[i]).append("</br>");
            }
        }
    }
}
