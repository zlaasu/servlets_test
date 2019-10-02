package pl.coreslab.day3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showCookie")
public class Cookie1Get extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();

        if (cookies == null || cookies.length == 0) {
            response.getWriter().append("BRAK");
        } else {
            boolean found = false;
            for (Cookie c : cookies) {
                if (c.getName().equals("User")) {
                    response.getWriter().append("Wartosc cistareczka: ").append(c.getValue());
                    found = true;
                }
            }
            if (!found) {
                response.getWriter().append("brak cisteczka User");
            }
        }

    }
}
