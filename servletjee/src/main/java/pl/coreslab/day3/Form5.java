package pl.coreslab.day3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Form5", urlPatterns = "/post5")
public class Form5 extends HttpServlet {

    private static final String CELC_TO_FAHR = "celcToFahr";
    private static final String FAHR_TO_CELC = "FahrToCelc";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String degreesStr = request.getParameter("degrees");
        String convertionType = request.getParameter("convertionType");
        double degree;

        if (degreesStr == null || convertionType == null || degreesStr.isEmpty() || convertionType.isEmpty()) {
            request.getRequestDispatcher("/form4.html").forward(request, response);
        } else {
            try {
                degree = Double.valueOf(degreesStr);

                if (convertionType.equals(CELC_TO_FAHR)) {
                    response.getWriter().append(degree + "").append(" to FAHR = ").append(celcToFahr(degree) + "");
                }
                if (convertionType.equals(FAHR_TO_CELC)) {
                    response.getWriter().append(degree + "").append(" to CELC = ").append(fahrToCelc(degree) + "");
                }

            } catch (NumberFormatException e) {
                System.out.println(e);
            }
        }
    }

    private double fahrToCelc(double degree) {
        return (5.0 / 9) * (degree - 32);
    }

    private double celcToFahr(double degree) {
        return 32.0 + (9.0 / 5) * degree;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/form5.html").forward(request, response);
    }
}
