package com.fitnessapp.Models;

public class DaysOfWeek {
    private String nameOfDay;

    public DaysOfWeek(String nameOfDay) {
        this.nameOfDay = nameOfDay;
    }

    public String getNameOfDay() {
        return nameOfDay;
    }

    public void setNameOfDay(String nameOfDay) {
        this.nameOfDay = nameOfDay;
    }

    @Override
    public String toString() {
        return "DaysOfWeek{" +
                "nameOfDay='" + nameOfDay + '\'' +
                '}';
    }
}
