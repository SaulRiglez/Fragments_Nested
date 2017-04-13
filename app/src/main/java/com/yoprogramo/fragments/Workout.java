package com.yoprogramo.fragments;

/**
 * Created by User on 4/10/2017.
 */

public class Workout {

    private String name;
    private String description;

    public static final Workout[] workouts ={
            new Workout("The Limb Loosener","5 Handstand push-ups\n10 1- legged squats\n Pull-ups"),
            new Workout("Core Agony","5 Handstand push-ups\n10 1- legged squats\n Pull-ups"),
            new Workout("The Winmp Special","5 Handstand push-ups\n10 1- legged squats\n Pull-ups"),
            new Workout("Strenth and Length","500 meter run\n21 x 1.5 pood kettleball swing\n21 x pull-ups")
    };

    public Workout(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
