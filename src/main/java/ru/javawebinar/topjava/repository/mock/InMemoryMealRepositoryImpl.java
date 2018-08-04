package ru.javawebinar.topjava.repository.mock;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.to.MealWithExceed;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class InMemoryMealRepositoryImpl implements MealRepository {
    private Map<Integer, Meal> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        MealsUtil.MEALS.forEach(meal -> repository.put(meal.getId(), meal));
    }

    @Override
    public Meal save(Meal meal, int userId) {
        if (meal.isNew()) {
            meal.setId(counter.incrementAndGet());
            repository.put(meal.getId(), meal);
            return meal;
        }
        // treat case: update, but absent in storage
        return repository.computeIfPresent(meal.getId(), (id, oldMeal) -> meal);
    }

    @Override
    public void delete(int id) {
        repository.remove(id);
    }

    @Override
    public Meal get(int id, int userId) {
        return repository.get(id).getUserId() == userId ? repository.get(id) : null;
    }

    @Override
    public List<MealWithExceed> getAll() {
        List<MealWithExceed> meals = MealsUtil.getWithExceeded(repository.values(), MealsUtil.DEFAULT_CALORIES_PER_DAY);
        meals.sort(new Comparator<MealWithExceed>(){
            @Override
            public int compare(MealWithExceed o1, MealWithExceed o2) {
                return o2.getDateTime().isAfter(o1.getDateTime())? 1: o2.getDateTime().isBefore(o1.getDateTime())? -1 : 0;
            }
        });
        return meals;
    }
}

