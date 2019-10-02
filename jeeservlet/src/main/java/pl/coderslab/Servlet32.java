package pl.coderslab;

import javafx.css.Match;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet32", urlPatterns = {"/servlet32"})
public class Servlet32 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");

        String numberStr = request.getParameter("value");
        char[] chars;
        int[] ints;

        if (numberStr == null || numberStr.isEmpty() || !numberStr.matches("^[01]*$")) {
            response.getWriter().append("Nie podałeś liczby binarnej");
        } else {
            chars = numberStr.toCharArray();
            ints = new int[chars.length];
            for (int i = 0; i < chars.length; i++) {
                ints[i] = (int) chars[i];
            }
            response.getWriter().append(convertBinaryToHex(numberStr) + "");
        }
    }

    public static int convertBinaryToHex(String str) {
        double j = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                j += Math.pow(2, str.length() - 1 - i);
            }
        }
        return (int) j;
    }

//    private int convertBinaryToHex(int[] ints) {
//        int result = 0;
//
//        for (int i = 0; i < ints.length ; i++) {
//            result += Match.pow(2,i);
//        }
//
//        return result;
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/servlet32.html").forward(request, response);
    }
}
