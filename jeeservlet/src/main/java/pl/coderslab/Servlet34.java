package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlet34")
public class Servlet34 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        Cookie cookie = null;
        Cookie[] cookies = request.getCookies();

        for (Cookie c : cookies) {
            if (c.getName().equals("visits")) {
                cookie = c;
            }
        }

        if (cookie == null) {
            response.getWriter().append("Witaj pierwszy raz na naszej stronie.");
            cookie = new Cookie("visits", "1");
            cookie.setMaxAge(365 * 24 * 60 * 60);
            cookie.setPath("/");
        } else {
            int visits = Integer.parseInt(cookie.getValue()) + 1;
            cookie = new Cookie("visits", visits + "");
            response.getWriter()
                    .append("Witaj, odwiedziłeś nas już ")
                    .append(visits + "")
                    .append(" razy.");
        }

        response.addCookie(cookie);
    }
}
