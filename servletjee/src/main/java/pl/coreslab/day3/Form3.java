package pl.coreslab.day3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.StringTokenizer;

@WebServlet(name = "Form3", urlPatterns = "/getForm3")
public class Form3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String pageStr = request.getParameter("page");
        int page = 0;

        if (pageStr == null || pageStr.isEmpty()) {
            request.getRequestDispatcher("/form3.html").forward(request, response);
        } else {
            try {
                page = Integer.parseInt(pageStr);
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
            response.getWriter().append("<p>").append(String.valueOf(page)).append("</p>");
            response.getWriter().append("<p>").append(getTotalDivider(page)).append("</p>");
        }
    }

    private static String getTotalDivider(int numbler) {
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 1; i < (numbler / 2); i++) {
            if (numbler % i == 0) {
                stringBuffer.append(i).append(", ");
            }
        }
        stringBuffer.append(numbler);
        return stringBuffer.toString();
    }
}
