package org.zlasu.controler.group;

import org.zlasu.model.userGroup.UserGroupDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userGroups")
public class UserGroupsControler extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserGroupDao userGroupDao = new UserGroupDao();

        request.setAttribute("userGroups", userGroupDao.findAll());
        request.getRequestDispatcher("/userGroups.jsp").forward(request, response);
    }
}
