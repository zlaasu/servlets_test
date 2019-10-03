package pl.coderslab;

import pl.coderslab.domain.CartItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/basket")
public class ServletBasket extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CartItem> basket = (List<CartItem>)request.getSession().getAttribute("basket");
        if(basket==null){
            basket = new ArrayList<>();
        }
        float totalPrice = 0f;
        for(CartItem item: basket){
            totalPrice+=item.getQty()*item.getProduct().getPrice();
        }

        request.setAttribute("basket",basket);
        request.setAttribute("totalPrice",totalPrice);
        request.getRequestDispatcher("/basket.jsp").forward(request, response);
    }
}
