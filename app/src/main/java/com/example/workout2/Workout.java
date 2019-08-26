package com.example.workout2;

public class Workout {

    String name,description;

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

    //Workout 的字串表示式就是“名稱“
    @Override
    public String toString() {
        return this.name;
    }

    public static final Workout[] workouts = {
            new Workout("The Limb Loosener","5 Handstand push-ups\n10 1-legged squets\n15 Pull-ups"),
            new Workout("Core Agony","100 Pull-ups\n100 Push-ups\n100 Sit-ups\n100 Squats"),
            new Workout("The Wimp Special","5 Pull-ups\n10 Push-ups\n15 Squats"),
            new Workout("Strength and Length","500 meter run\n21x1.5 pood kettleball swing\n21 x pill-ups")
    };


}
