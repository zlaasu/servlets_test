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

@WebServlet("/servlet311")
public class Servlet311 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> lang = new HashMap<>();
        lang.put("en", "Hello");
        lang.put("pl", "Cześć");
        lang.put("de", "Ehre");
        lang.put("es", "Hola");
        lang.put("fr", "Bienvenue");

        Cookie[] cookies = request.getCookies();
        String cookieValue = null;
        for (Cookie c : cookies) {
            if (c.getName().equals("lang")) {
                cookieValue = c.getValue();
            }
        }

        String welcome = lang.get("pl");
        System.out.println(welcome);
        if (Validator.isNotEmpty(cookieValue)) {
            welcome = lang.get(cookieValue);
            System.out.println(welcome);
        }

        request.setAttribute("welcome", welcome);
        request.getRequestDispatcher("/servlet311.jsp").forward(request, response);
    }
}
