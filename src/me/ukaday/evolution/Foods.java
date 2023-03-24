package me.ukaday.evolution;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static me.ukaday.evolution.Evolution.WINDOW_H;
import static me.ukaday.evolution.Evolution.WINDOW_W;
import static me.ukaday.evolution.Level.r;
import static me.ukaday.evolution.Settings.SPAWN_BEZEL;

public class Foods {

    private long prevFoodTime = 0;
    public static final long FOOD_SPAWN_DELAY = 200;
    private final Collection<Food> foodContainer = new CopyOnWriteArrayList<>();

    public Foods() {
    }

    public void add(Food food) {
        foodContainer.add(food);
    }

    public void remove(Food food) {
        foodContainer.remove(food);
    }

    public Collection<Food> getFoodContainer() {
        return foodContainer;
    }

    public void update() {
        long time = System.currentTimeMillis();
        if (time - prevFoodTime < FOOD_SPAWN_DELAY) {
            return;
        }
        int x = r.nextInt(SPAWN_BEZEL,WINDOW_W - SPAWN_BEZEL);
        int y = r.nextInt(SPAWN_BEZEL,WINDOW_H - SPAWN_BEZEL);
        int energy = r.nextInt(1, 3);
        add(new Food(x, y, energy));
        prevFoodTime = time;


    }

    public void paint(Graphics g, double xOffSet, double yOffSet, double zoom) {
        for (Food food : foodContainer) {
            food.paint(g, xOffSet, yOffSet, zoom);
        }
    }
}
