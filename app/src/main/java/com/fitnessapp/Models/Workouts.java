package com.fitnessapp.Models;

public class Workouts {
    private String exercise, description,time,reps,sets;;
    private boolean isCompleted;


    public Workouts(String exercise, String description, String time, String reps, String sets, boolean isCompleted) {
        this.exercise = exercise;
        this.description = description;
        this.time = time;
        this.reps = reps;
        this.sets = sets;
        this.isCompleted = isCompleted;
    }

    public Workouts(){}

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getReps() {
        return reps;
    }

    public void setReps(String reps) {
        this.reps = reps;
    }

    public String getSets() {
        return sets;
    }

    public void setSets(String sets) {
        this.sets = sets;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public String toString() {
        return "Workouts{" +
                "exercise='" + exercise + '\'' +
                ", description='" + description + '\'' +
                ", time='" + time + '\'' +
                ", reps='" + reps + '\'' +
                ", sets='" + sets + '\'' +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
