package org.zlasu.validation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/validarorTest")
public class ValidatorTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String number = request.getParameter("number");

        if (!Validator.isPositiveNumber(number)) {
          response.sendRedirect("/error?message=No to slabo");
            System.out.println("WRONG");
        }
        System.out.println("GOOD");
    }
}
