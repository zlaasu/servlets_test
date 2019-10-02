package pl.coreslab.sessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

@WebServlet("/showAllSessions")
public class Session3All extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        //Set<String> keysSet = new HashSet<String>();

        Enumeration<String> sessionKeys = session.getAttributeNames();
        response.getWriter().append("<table>");
        while (sessionKeys.hasMoreElements()) {
            String key = sessionKeys.nextElement();
            response.getWriter()
                    .append("<tr><td>")
                    .append(key)
                    .append("</td><td>")
                    .append((String) session.getAttribute(key))
                    .append("</td></tr>");
        }
        response.getWriter().append("</table>");
    }
}
