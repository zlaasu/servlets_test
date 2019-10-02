package pl.coreslab.sessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/session2")
public class Session2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        List<Integer> grades;
        if (session.getAttribute("grades") == null) {
            grades = new ArrayList<>();
        } else {
            grades = (List<Integer>) session.getAttribute("grades");
        }
        String gradeStr = request.getParameter("grade");
        if (gradeStr != null && !gradeStr.isEmpty()) {
            try {
                Integer grade = Integer.parseInt(gradeStr);
                grades.add(grade);
                session.setAttribute("grades", grades);
            } catch (NumberFormatException e) {
            }
        }
        response.sendRedirect("/session2");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().append("<form method='post'>")
                .append("<input type='text' name='grade'/>")
                .append("<input type='submit' value='zapisz'/>")
                .append("</form>");
        HttpSession session = request.getSession();
        if (session.getAttribute("grades") != null) {
            response.getWriter().append("<h4>Oceny</h4>");
            List<Integer> grades = (List<Integer>) session.getAttribute("grades");
            response.getWriter().append("<ul>");
            Integer sum = 0;
            for (Integer grade : grades) {
                response.getWriter().append("<li>" + grade + "</li>");
                sum += grade;
            }
            response.getWriter().append("</ul>");
            response.getWriter().append("<h4>Średnia tego delikwenta to: " + (double) sum / grades.size() + "</h4>");
        }

    }
}
