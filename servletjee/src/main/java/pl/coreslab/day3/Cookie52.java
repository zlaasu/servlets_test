package pl.coreslab.day3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/cookie52")
public class Cookie52 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String message = "Nie odwiedziles jeszcze tej strony";

        Cookie[] cookies = request.getCookies();
        Cookie cookie;

        if (cookies == null || cookies.length == 0) {
            response.sendRedirect("cookie51?msg=" + URLEncoder.encode(message, "UTF-8"));
        } else {
            boolean cookieExist = false;
            for (Cookie c : cookies) {
                if (c.getName().equals("cookie51")) {
                    response.getWriter().append("Witamy na stronie Cookie52");
                    c.setMaxAge(0);
                    response.addCookie(c);
                    cookieExist = true;
                }
            }
            if (!cookieExist) {
                response.sendRedirect("cookie51?msg=" + URLEncoder.encode(message, "UTF-8"));
            }
        }
    }
}
