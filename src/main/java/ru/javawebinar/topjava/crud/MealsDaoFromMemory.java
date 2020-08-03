package ru.javawebinar.topjava.crud;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.MealsUtil;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class MealsDaoFromMemory implements MealsDao {

    @Override
    public Meal find(Long id) {
        for(Meal meal : MealsUtil.getMeals()) {
            if(meal.getId().equals(id))
                return meal;
        }
        return null;
    }

    @Override
    public void save(Meal model) {
        if(model.getId() == null) {
            model.setId(MealsUtil.getCounter().incrementAndGet());
        }
        else {
            delete(model.getId());
        }

        MealsUtil.getMeals().add(model);
    }

    @Override
    public void delete(Long id) {
        MealsUtil.getMeals().remove(find(id));
    }

    @Override
    public List<Meal> findAll() {
        return MealsUtil.getMeals();
    }

    @Override
    public List<Meal> findAllByDate(LocalDate date) {
        return MealsUtil.getMeals().stream()
                .filter(meal -> meal.getDate().equals(date))
                .collect(Collectors.toList());
    }
}
