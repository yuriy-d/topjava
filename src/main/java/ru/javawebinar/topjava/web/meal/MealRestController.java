package ru.javawebinar.topjava.web.meal;

import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.to.MealWithExceed;

import java.util.List;

@Controller
public class MealRestController extends AbstractMealController{

    @Override
    public List<MealWithExceed> getAll() {
        return super.getAll();
    }

    @Override
    public Meal get(int id, int userId) {
        return super.get(id, userId);
    }

    @Override
    public Meal create(Meal meal, int userId) {
        return super.create(meal, userId);
    }

    @Override
    public void delete(int id) {
        super.delete(id);
    }

    @Override
    public void update(Meal meal, int userId) {
        super.update(meal, userId);
    }
}