package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.to.MealWithExceed;

import java.util.List;

public interface MealRepository {
    Meal save(Meal meal, int userId);

    void delete(int id);

    Meal get(int id, int userId);

    List<MealWithExceed> getAll();
}
