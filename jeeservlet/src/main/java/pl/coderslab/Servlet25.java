package pl.coderslab;

import org.apache.commons.lang3.ArrayUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

@WebServlet(name = "Servlet25", urlPatterns = {"/servlet25"})
public class Servlet25 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/ser").forward(request, response);
    }

    private static void printArray(Integer[] numbers, HttpServletResponse response) throws IOException {
        response.getWriter().append("<table border='1px'>");
        for (int i = 0; i < numbers.length; i++) {
            response.getWriter().append("<tr><td>").append(numbers[i].toString()).append("</td></tr>");
        }
        response.getWriter().append("</table>");
    }
}
