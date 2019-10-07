package org.zlasu.libs.validation;
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
        Validator v = new Validator();

        if (!v.isDouble(number, number)) {
            request.setAttribute("errorMesage", v.getErrorMessage());
            System.out.println("WRONG - " + v.getErrorMessage());
        } else {
            System.out.println("GOOD - " + v.getErrorMessage());
        }

        request.getRequestDispatcher("validatorTest.jsp").forward(request, response);
    }
}
