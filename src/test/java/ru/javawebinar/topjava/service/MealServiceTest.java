package ru.javawebinar.topjava.service;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.MealTestData;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertThrows;
import static ru.javawebinar.topjava.MealTestData.*;
import static ru.javawebinar.topjava.UserTestData.getNew;

@ContextConfiguration({"classpath:spring/spring-app.xml", "classpath:spring/spring-db.xml"})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class MealServiceTest {

    @Autowired
    private MealService service;

    @Test
    public void get() {
        Meal meal = service.get(USER_MEAL_ID, USER_ID);
        Assertions.assertThat(meal).isEqualTo(USER_MEAL_1);
    }

    @Test
    public void delete() {
        service.delete(USER_MEAL_ID, USER_ID);
        assertThrows(NotFoundException.class, () -> service.get(USER_MEAL_ID, USER_ID));
    }

    @Test
    public void getBetweenInclusive() {
        List<Meal> allFiltered = service.getBetweenInclusive(LocalDate.of(2020, 1, 15), LocalDate.of(2020, 1, 16), USER_ID);
        Assertions.assertThat(allFiltered).isEqualTo(ALL_USER_MEAL);
    }

    @Test
    public void getAll() {
        List<Meal> all = service.getAll(USER_ID);
        Assertions.assertThat(all)
//                .usingRecursiveComparison()
                .isEqualTo(ALL_USER_MEAL);
    }

    @Test
    public void update() {
        Meal updated = getUpdatedMeal();
        service.update(updated, USER_ID);
        Assertions.assertThat(service.get(USER_MEAL_ID, USER_ID)).isEqualTo(getUpdatedMeal());
    }

    @Test
    public void create() {
        Meal created = service.create(getNewMeal(), USER_ID);
        Integer newMealId = created.getId();
        Meal newMeal = getNewMeal();
        newMeal.setId(newMealId);
        Assertions.assertThat(created).isEqualTo(newMeal);
        Assertions.assertThat(service.get(newMealId, USER_ID)).isEqualTo(newMeal);
    }
}