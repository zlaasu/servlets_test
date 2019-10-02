package pl.coreslab.day3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie3")
public class Cookie3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyStr = request.getParameter("key");
        String valueStr = request.getParameter("value");
        String timeStr = request.getParameter("time");

        Cookie cookie = new Cookie(keyStr, valueStr);
        cookie.setMaxAge(Integer.parseInt(timeStr) * 3600);
        cookie.setPath("/");

        System.out.println(keyStr);
        System.out.println(valueStr);
        System.out.println(timeStr);

        response.addCookie(cookie);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/cookie3.html").forward(request, response);
    }
}
