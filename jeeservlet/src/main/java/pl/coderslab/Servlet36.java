package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlet36")
public class Servlet36 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String[] numsStr = request.getParameterValues("num");
        int[] nums = new int[numsStr.length];
        Double sum = 0.0;
        Double avg = 0.0;
        Double ratio = 1.0;

        response.getWriter().append("Liczby:</br>");
        for (int i = 0; i < numsStr.length; i++) {
            nums[i] = Integer.parseInt(numsStr[i]);
            ratio *= nums[i];
            sum += nums[i];
            response.getWriter().append("- ").append(nums[i] + "").append("</br>");
        }
        response.getWriter().append("Srednia:</br>- ").append("" + (sum / nums.length)).append("</br>");
        response.getWriter().append("Suma:</br>- ").append("" + sum).append("</br>");
        response.getWriter().append("Iloczyn:</br>- ").append("" + ratio).append("</br>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/servlet36.html").forward(request, response);
    }
}
