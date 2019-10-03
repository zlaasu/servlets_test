package pl.coderslab;

import pl.coderslab.dao.ProductDao;
import pl.coderslab.domain.CartItem;
import pl.coderslab.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/shop")
public class ServletShop extends HttpServlet {

    ProductDao productDao = new ProductDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idS = request.getParameter("id");
        String qtyS = request.getParameter("qty");
        if(idS!=null && !idS.isEmpty() && qtyS!=null && !qtyS.isEmpty()){
            try {
                Long id = Long.valueOf(idS);
                int qty = Integer.parseInt(qtyS);
                Product product = productDao.findProduct(id);
                if(product!=null){
                    CartItem item = new CartItem(product,qty);
                    List<CartItem> basket = (List<CartItem>)request.getSession().getAttribute("basket");
                    if(basket==null){
                        basket = new ArrayList<>();
                    }
                    basket.add(item);
                    request.getSession().setAttribute("basket",basket);
                }

            }catch (NumberFormatException e){
                //przeniesie nas do GET /shop
            }

        }
        response.sendRedirect("/shop");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("products",productDao.getProducts());
        request.getRequestDispatcher("/shop.jsp").forward(request, response);
    }
}
