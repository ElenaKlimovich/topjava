package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.AbstractBaseEntity;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;

public class MealTestData {
    public static final int USER_ID = START_SEQ;
    public static final int USER_MEAL_ID = AbstractBaseEntity.START_SEQ + 2;
    public static final int ADMIN_MEAL_ID = AbstractBaseEntity.START_SEQ + 6;

    public static final Meal USER_MEAL_1 = new Meal(USER_MEAL_ID, LocalDateTime.of(2020, Month.JANUARY, 15, 10, 0), "Breakfast", 500);
    public static final Meal USER_MEAL_2 = new Meal(USER_MEAL_ID + 1, LocalDateTime.of(2020, Month.JANUARY, 15, 12, 0), "Dinner", 500);
    public static final Meal USER_MEAL_3 = new Meal(USER_MEAL_ID + 2, LocalDateTime.of(2020, Month.JANUARY, 15, 16, 0), "Lunch", 500);
    public static final Meal USER_MEAL_4 = new Meal(USER_MEAL_ID + 3, LocalDateTime.of(2020, Month.JANUARY, 15, 20, 0), "Supper", 400);

    public static final Meal ADMIN_MEAL_1 = new Meal(ADMIN_MEAL_ID, LocalDateTime.of(2020, Month.JANUARY, 17, 11, 0), "Breakfast", 700);
    public static final Meal ADMIN_MEAL_2 = new Meal(ADMIN_MEAL_ID + 1, LocalDateTime.of(2020, Month.JANUARY, 17, 15, 0), "Lunch", 800);
    public static final Meal ADMIN_MEAL_3 = new Meal(ADMIN_MEAL_ID + 2, LocalDateTime.of(2020, Month.JANUARY, 17, 21, 0), "Supper", 900);

    public static final List<Meal> ALL_USER_MEAL = Arrays.asList(USER_MEAL_4, USER_MEAL_3, USER_MEAL_2, USER_MEAL_1);

    public static Meal getNewMeal() {
        return new Meal(null, LocalDateTime.of(2020, Month.MAY, 10, 12, 0), "NewMeal", 1000);
    }

    public static Meal getUpdatedMeal() {
        Meal updated = new Meal(USER_MEAL_1);
        updated.setDateTime(LocalDateTime.of(2015, Month.DECEMBER, 1, 12, 0));
        updated.setDescription("UPDATED MEAL");
        updated.setCalories(111);
        return updated;
    }
}
