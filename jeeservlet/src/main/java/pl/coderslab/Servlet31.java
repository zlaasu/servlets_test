package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet31", urlPatterns = {"/servlet31"})
public class Servlet31 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");

        Double nbp[] = new Double[]{1.093, 0.914, 4.368, 0.228, 3.996, 0.250};


        Double exchange = nbp[Integer.parseInt(request.getParameter("exchange"))];
        Double value = Double.valueOf(request.getParameter("value")) * exchange;

        response.getWriter().append("Przelicznik: ").append(exchange.toString()).append(" = ").append(value.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/servlet31.html").forward(request, response);
    }
}
