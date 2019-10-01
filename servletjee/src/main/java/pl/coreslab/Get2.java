package pl.coreslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Pattern;

@WebServlet(name = "Get2", urlPatterns = {"/get2"})
public class Get2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");

        Map<String, String[]> parameterMap = request.getParameterMap();
        for(Map.Entry<String, String[]> entry: parameterMap.entrySet()) {
            //System.out.println("key: " + entry.getKey() + " | value: " + entry.getValue().toString());
        }

        parameterMap.forEach((key, value) -> {
            try {
                response.getWriter().append("<h3>" + key + "</h3><hl>");
                for (String item : value) {
                    response.getWriter().append("<p style'color:grey'>").append(item).append("</p>");
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        });
    }
}
