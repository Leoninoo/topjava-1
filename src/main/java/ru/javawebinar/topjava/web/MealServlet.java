package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.crud.MealsDao;
import ru.javawebinar.topjava.crud.MealsDaoFromMemory;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

@WebServlet("/meals")
public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);
    private MealsDao mealsDao;

    @Override
    public void init() throws ServletException {
        mealsDao = new MealsDaoFromMemory();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("redirect to meals");

        request.setAttribute("meals", MealsUtil.getFilteredMealsTo(mealsDao.findAll()));
        request.getRequestDispatcher("/jsp/meals.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        if(req.getParameter("delete") != null) {
            mealsDao.delete(Long.parseLong(id));
            resp.sendRedirect(req.getContextPath() + "/meals");
        }
        else
            resp.sendRedirect(req.getContextPath() + "/meal?id=" + id);
    }
}
