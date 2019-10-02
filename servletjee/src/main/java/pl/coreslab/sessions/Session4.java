package pl.coreslab.sessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/session4")
public class Session4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        List<CartItem> cartItems = new ArrayList<>();

        CartItem cartItem = new CartItem(request.getParameter("name"), Integer.parseInt(request.getParameter(
                "quantity")), Double.valueOf(request.getParameter("price")));

        if (session.getAttribute("cartItem") == null) {
            cartItems.add(cartItem);
        } else {
            cartItems = (List<CartItem>) session.getAttribute("cartItem");
            cartItems.add(cartItem);
        }
        session.setAttribute("cartItem", cartItems);

        for (int i = 0; i < cartItems.size(); i++) {
            response.getWriter().append(cartItems.get(i).toString()).append("</br>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/session4.html").forward(request, response);
    }
}
