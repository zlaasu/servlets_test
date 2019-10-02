package pl.coreslab.sessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/session1Get")
public class Session1Get extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        if (session.getAttribute("counter") != null) {
            response.getWriter().append("Counter is set");
            int counter = (int) session.getAttribute("counter");
            counter++;
            response.getWriter().append("Counter now is: " + counter);
            session.setAttribute("counter", counter);
        } else {
            response.getWriter().append("EMPTY");
        }
    }
}
