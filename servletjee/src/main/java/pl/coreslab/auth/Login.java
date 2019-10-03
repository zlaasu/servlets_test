package pl.coreslab.auth;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    private final static String USER = "admin";
    private final static String PASSWORD = "coderslab";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        if (user.equals(USER) && pass.equals(PASSWORD)) {
            // dodaj dane do sesji pod kluczem: username
            // przekieruj na adres /admin
            request.getSession().setAttribute("username", USER);
            response.sendRedirect("/admin");
        } else {
            // wyświetl informacje o błędnych danych
            response.sendRedirect("/login?msg=bad_credentioal");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        if (request.getParameter("msg")!=null) {
//        }
        request.getRequestDispatcher("/auth/login.jsp").forward(request, response);
    }
}
