package com.test.assesment.i_service_assesment_test;

/**
 * Created by vyomaPC1 on 4/25/2019.
 */

public class DayShiftModel {
    private String name_one;
    private String name_two;
    private String week;

    private String day;
    private String shift_one;
    private String shift_two;

    private int viewType =0;

    public DayShiftModel(String name_one, String name_two, String week, String day,
                         String shift_one, String shift_two, int viewType) {
        this.name_one = name_one;
        this.name_two = name_two;
        this.week = week;
        this.day = day;
        this.shift_one = shift_one;
        this.shift_two = shift_two;
        this.viewType = viewType;
    }

    public DayShiftModel() {

    }

    public String getName_one() {
        return name_one;
    }

    public void setName_one(String name_one) {
        this.name_one = name_one;
    }

    public String getName_two() {
        return name_two;
    }

    public void setName_two(String name_two) {
        this.name_two = name_two;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getShift_one() {
        return shift_one;
    }

    public void setShift_one(String shift_one) {
        this.shift_one = shift_one;
    }

    public String getShift_two() {
        return shift_two;
    }

    public void setShift_two(String shift_two) {
        this.shift_two = shift_two;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }
}
