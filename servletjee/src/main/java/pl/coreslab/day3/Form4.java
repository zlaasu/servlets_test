package pl.coreslab.day3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Form4", urlPatterns = "/post4")
public class Form4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String aStr = request.getParameter("a");
        String bStr = request.getParameter("b");
        String cStr = request.getParameter("c");
        int a = 0;
        int b = 0;
        int c = 0;
        double delta;
        double[] result;

        if (aStr == null || bStr == null || cStr == null || aStr.isEmpty() || bStr.isEmpty() || cStr.isEmpty()) {
            request.getRequestDispatcher("/form4.html").forward(request, response);
        } else {
            try {
                a = Integer.parseInt(aStr);
                b = Integer.parseInt(bStr);
                c = Integer.parseInt(cStr);
            } catch (NumberFormatException e) {
                response.getWriter().append("To nie są liczby.");
                System.out.println(e);
            }
            delta = countDelta(a, b, c);
            if (delta < 0) {
                response.getWriter().append("Delta ")
                        .append(delta + "")
                        .append(" jest mniejsza od zera. To równanie nie ma rozwiązań rzeczywistych.");
            } else {
                result = countXForPositiveDelta(a, b, c, delta);
                response.getWriter().append("x1 = ").append(result[0] + "</br>");
                response.getWriter().append("x2 = ").append(result[1] + "</br>");
            }
        }
    }

    private static double countDelta(int a, int b, int c) {
        return (b * b) - (4 * a * c);
    }

    private static double[] countXForPositiveDelta(int a, int b, int c, double delta) throws IllegalArgumentException {
        if (delta < 0) {
            throw new IllegalArgumentException("This method only take positive delta. You use delta = " + delta);
        }
        double x1 = (((-1) * b) - Math.sqrt(delta)) / (2 * a);
        double x2 = (((-1) * b) + Math.sqrt(delta)) / (2 * a);
        return new double[]{x1, x2};
    }
}
