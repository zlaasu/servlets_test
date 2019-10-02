package pl.coreslab.day3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showAllCookies")
public class Cookie4Show extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        Cookie[] cookies = request.getCookies();

        for (Cookie c : cookies) {

            response.getWriter()
                    .append("Wartosc cistareczka: ")
                    .append(c.getName())
                    .append(" = ")
                    .append(c.getValue())
                    .append(" | ")
                    .append(getDelLinkForCookie(c))
                    .append("</br>");
        }
    }

    private String getDelLinkForCookie(Cookie c) {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("<a href='/removeCookie?name=").append(c.getName()).append("'>DEL</a>");

        return stringBuffer.toString();
    }
}
