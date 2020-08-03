package ru.javawebinar.topjava.crud;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDate;
import java.util.List;

public interface MealsDao extends CrudDao<Meal> {
    List<Meal> findAllByDate(LocalDate date);
}
