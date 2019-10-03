package pl.coreslab.mvc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/mvc14")
public class Mvc14 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] title = request.getParameterValues("title");
        String[] author = request.getParameterValues("author");
        String[] isbn = request.getParameterValues("isbn");

        List<Book> books = new ArrayList<>();

        for (int i = 0; i < title.length; i++) {
            books.add(new Book(title[i], author[i], isbn[i]));
            System.out.println(i);
        }

        request.setAttribute("books", books);
        request.getRequestDispatcher("/mvc/resultList.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/mvc/form.jsp").forward(request, response);
    }
}
