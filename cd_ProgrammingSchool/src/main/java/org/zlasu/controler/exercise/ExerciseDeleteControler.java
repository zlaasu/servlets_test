package org.zlasu.controler.exercise;

import org.zlasu.libs.validation.Validator;
import org.zlasu.model.exercise.ExerciseDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/exercise/delete")
public class ExerciseDeleteControler extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Validator v = new Validator();
        String idStr = request.getParameter("id");
        ExerciseDao exerciseDao = new ExerciseDao();

        if (v.isNotInt(idStr)) {
            response.sendRedirect("/exercises?errorMessage=" +  v.getErrorMessage());
        } else {
            exerciseDao.delete(Integer.parseInt(idStr));
            response.sendRedirect("/exercises?errorMessage=Row " + idStr + " has been DELETED");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/");
    }
}
