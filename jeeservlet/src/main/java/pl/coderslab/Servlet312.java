package pl.coderslab;

import org.zlasu.validation.Validator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/servlet312")
public class Servlet312 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pickedLang = request.getParameter("lang");

        if (Validator.isEmpty(pickedLang)) {
            response.sendRedirect("/servlet311");
        }

        Cookie cookie = new Cookie("lang", pickedLang);
        cookie.setMaxAge(3600);
        cookie.setPath("/");

        response.addCookie(cookie);
        response.sendRedirect("/servlet311");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
