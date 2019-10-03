package org.zlasu.validation;

import com.google.common.net.HttpHeaders;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/error")
public class Error extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String referrer;
        referrer = request.getHeader(HttpHeaders.REFERER);
        String message = request.getParameter("message");

        response.getWriter().append("<h1>ERROR !!!</h1>");
        response.getWriter().append("<h1>").append(message).append("</h1>");
        response.getWriter().append("<h1>").append(referrer).append("</h1>");
        response.getWriter().append("<p><a href='").append(referrer).append("'>BACK</a></p>");
    }
}
