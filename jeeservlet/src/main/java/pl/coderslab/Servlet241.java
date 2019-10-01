package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet241", urlPatterns = {"/Servlet241"})
public class Servlet241 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        response.getWriter().append("<p><a href='/Servlet242?id=0'>ID 0</a></p>");
        response.getWriter().append("<p><a href='/Servlet242?id=1'>ID 1</a></p>");
        response.getWriter().append("<p><a href='/Servlet242?id=2'>ID 2</a></p>");
        response.getWriter().append("<p><a href='/Servlet242?id=3'>ID 3</a></p>");
        response.getWriter().append("<p><a href='/Servlet242?id=4'>ID 4</a></p>");
        response.getWriter().append("<p><a href='/Servlet242?id=5'>ID 5</a></p>");
        response.getWriter().append("<p><a href='/Servlet242?id=6'>ID 6</a></p>");
        response.getWriter().append("<p><a href='/Servlet242?id=7'>ID 7</a></p>");
    }
}
