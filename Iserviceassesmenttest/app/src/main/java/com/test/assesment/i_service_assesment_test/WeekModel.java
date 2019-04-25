package com.test.assesment.i_service_assesment_test;

import java.util.ArrayList;

/**
 * Created by vyomaPC1 on 4/19/2019.
 */

public class WeekModel {
    private String week;
    private ArrayList<EngineerModel> engineerModelArrayList;
    private int viewType = 0;

    public WeekModel(String week, ArrayList<EngineerModel> engineerModelArrayList, int viewType) {
        this.week = week;
        this.engineerModelArrayList = engineerModelArrayList;
        this.viewType = viewType;
    }

    public WeekModel() {

    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public ArrayList<EngineerModel> getEngineerModelArrayList() {
        return engineerModelArrayList;
    }

    public void setEngineerModelArrayList(ArrayList<EngineerModel> engineerModelArrayList) {
        this.engineerModelArrayList = engineerModelArrayList;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}
