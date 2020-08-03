package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.crud.MealsDao;
import ru.javawebinar.topjava.crud.MealsDaoFromMemory;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.MealsUtil;
import ru.javawebinar.topjava.util.TimeUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

import static org.slf4j.LoggerFactory.getLogger;

@WebServlet("/meal")
public class MealUpdateServlet extends HttpServlet {
    private static final Logger log = getLogger(MealUpdateServlet.class);
    private MealsDao mealsDao;

    @Override
    public void init() throws ServletException {
        mealsDao = new MealsDaoFromMemory();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("redirect to mealsUpdate");

        String id = request.getParameter("id");
        if(id != null) {
            request.setAttribute("meal", mealsDao.find(Long.parseLong(id)));
        }

        request.getRequestDispatcher("/jsp/mealsUpdate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        LocalDateTime dateTime = LocalDateTime.parse(req.getParameter("dateTime"));
        String description = req.getParameter("description");
        int calories = Integer.parseInt(req.getParameter("calories"));
        String id = req.getParameter("id");

        Meal meal = new Meal(dateTime, description, calories);

        if(!id.isEmpty())
            meal.setId(Long.parseLong(id));

        mealsDao.save(meal);

        resp.sendRedirect(req.getContextPath() + "/meals");
    }
}
