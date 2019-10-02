package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/rememberMe")
public class Cookie37 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String name = request.getParameter("name");
        String remember = request.getParameter("remember");

        response.getWriter().append("Cześć ").append(name).append(".");
        if (remember != null) {
            Cookie cookie = new Cookie("name", name);
            cookie.setPath("/");
            cookie.setMaxAge(3600);
            response.addCookie(cookie);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;
        for (Cookie c : cookies) {
            if (c.getName().equals("name")) {
                cookie = c;
            }
        }

        if (cookie == null) {
            response.getWriter().append("<form method='post'>");
            response.getWriter().append("<input type='text' name='name'/></br>");
            response.getWriter().append("<input type='checkbox' name='remember'/></br>");
            response.getWriter().append("<input type='submit' value='SEND'></form>");
        } else {
            response.getWriter().append("Cześć ").append(cookie.getValue()).append(". Twoje dane zostały wczytane z " +
                    "ciasteczka.");
        }
    }
}
