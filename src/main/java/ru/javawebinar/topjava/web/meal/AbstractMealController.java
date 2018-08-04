package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.to.MealWithExceed;
import ru.javawebinar.topjava.service.MealService;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;
import static ru.javawebinar.topjava.util.ValidationUtil.checkNew;

public abstract class AbstractMealController {
    private static final Logger log = getLogger(AbstractMealController.class);

    @Autowired
    private MealService service;

    public List<MealWithExceed> getAll(){
        log.info("getAll");
        return service.getAll();
    }

    public Meal get(int id, int userId){
        log.info("get {}", id);
        return service.get(id, userId);
    }

    public Meal create(Meal meal, int userId){
        log.info("create {}",meal);
        checkNew(meal);
        return service.save(meal, userId);
    }

    public void delete(int id){
        log.info("delete {}", id);
        service.delete(id);
    }

    public void update(Meal meal, int userId){
        log.info("update {}", meal);
        service.save(meal, userId);
    }

}
