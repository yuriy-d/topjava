package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.to.MealWithExceed;

import java.util.List;

public interface MealService {
    Meal save(Meal meal, int userId);

    void delete(int id);

    Meal get(int id, int userId);

    List<MealWithExceed> getAll();
}