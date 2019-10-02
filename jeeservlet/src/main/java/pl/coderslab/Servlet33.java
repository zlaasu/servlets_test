package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/servlet33")
public class Servlet33 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String data1 = request.getParameter("data1");
        String data2 = request.getParameter("data2");
        String data3 = request.getParameter("data3");
        String data4 = request.getParameter("data4");
        String data5 = request.getParameter("data5");

        session.setAttribute("data1", data1);
        session.setAttribute("data2", data2);
        session.setAttribute("data3", data3);
        session.setAttribute("data4", data4);
        session.setAttribute("data5", data5);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        String data1 = ifExists((String) session.getAttribute("data1"));
        String data2 = ifExists((String) session.getAttribute("data2"));
        String data3 = ifExists((String) session.getAttribute("data3"));
        String data4 = ifExists((String) session.getAttribute("data4"));
        String data5 = ifExists((String) session.getAttribute("data5"));

        response.getWriter().append("<form method='post'>");
        response.getWriter()
                .append("<label><input type='text' name='data1' value='")
                .append(data1)
                .append("'/>Data 1</label></br>");
        response.getWriter()
                .append("<label><input type='text' name='data2' value='")
                .append(data2)
                .append("'/>Data 2</label></br>");
        response.getWriter()
                .append("<label><input type='text' name='data3' value='")
                .append(data3)
                .append("'/>Data 3</label></br>");
        response.getWriter()
                .append("<label><input type='text' name='data4' value='")
                .append(data4)
                .append("'/>Data 4</label></br>");
        response.getWriter()
                .append("<label><input type='text' name='data5' value='")
                .append(data5)
                .append("'/>Data 5</label></br>");
        response.getWriter().append("<input type='submit' value='SEND'></form>");
    }

    private static String ifExists(String string) {
        if (string == null || string.isEmpty()) {
            return "";
        }
        return string;
    }
}
