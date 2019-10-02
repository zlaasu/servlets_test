package pl.coreslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "Get3", urlPatterns = {"/get3"})
public class Get3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        int width = 5;
        int height = 10;

        String widthStr = request.getParameter(("width"));
        String heightStr = request.getParameter(("height"));

        if (widthStr == null || heightStr == null || widthStr.isEmpty() || heightStr.isEmpty()) {
            response.getWriter().append("<h3>Nie podałeś wartości</h3>");
        } else {
            try {
                width = Integer.parseInt(widthStr);
                height = Integer.parseInt(heightStr);
            } catch (NumberFormatException e) {
                response.getWriter().append("<h3>Niepoprawne wartości Przyjmuję domyślne.</h3>");
            }
        }

        response.getWriter().append("<table><tbody>");
        for (int i = 1; i < width; i++) {
            response.getWriter().append("<tr>");
            for (int j = 1; j < height; j++) {
                response.getWriter().append("<td>")
                        .append(String.format("%s * %s = %s", i, j, (i * j)))
                        .append("</td>");
            }
            response.getWriter().append("</tr>");
        }
        response.getWriter().append("</tbody></table>");
    }
}
