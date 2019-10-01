package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

@WebServlet(name = "Servlet23", urlPatterns = {"/servlet23"})
public class Servlet23 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String path = getServletContext().getRealPath("WEB-INF\\opp.txt");
        File file = new File(path);
        Scanner scanner = new Scanner(file);

        System.out.println(file.exists());

        while (scanner.hasNextLine()) {
            response.getWriter().append(scanner.nextLine()).append("</br>");
        }
    }
}
