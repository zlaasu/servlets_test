package pl.coreslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Get1", urlPatterns = {"/get1"})
public class Get1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");

        String startStc = request.getParameter("start");
        String endStc = request.getParameter("end");

        if (startStc == null || endStc == null || startStc.isEmpty() || endStc.isEmpty()) {
            response.getWriter().append("<h1> style='color: red'> BRAK DANYCH </h1>");
        } else {
            try {
                int start = Integer.parseInt(startStc);
                int stop = Integer.parseInt(endStc);
                if (start < stop) {
                    response.getWriter().append("<h3 style='color: red'> Liczby: </h3>");
                    for (int i = start; i < stop; i++) {
                        response.getWriter().append("<p>").append(String.valueOf(i)).append("</p>");
                    }
                } else {
                    response.getWriter().append("<h3 style='color: red'> START mniejsze od STOP </h3>");
                }

            }catch (NumberFormatException e) {
                response.getWriter().append("<h1> style='color: red'> Potrzebuje liczby całkowitej</h1>");
            }
        }
    }
}
