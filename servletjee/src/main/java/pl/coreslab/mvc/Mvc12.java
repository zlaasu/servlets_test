package pl.coreslab.mvc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mvc12")
public class Mvc12 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        int startValue = 10;
        int endValue = 20;

        if (start != null && end != null && !start.isEmpty() && !end.isEmpty()) {
            try {
                startValue = Integer.parseInt(start) + 10;
                endValue = Integer.parseInt(end) + 10;
            } catch (NumberFormatException e) {
                startValue = 10;
                endValue = 20;
            }
        }

        request.setAttribute("startVal", startValue);
        request.setAttribute("endVal", endValue);

        request.getRequestDispatcher("/mvc/jsp2.jsp").forward(request, response);
    }
}
