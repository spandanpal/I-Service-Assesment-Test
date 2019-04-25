package com.test.assesment.i_service_assesment_test;

import java.util.ArrayList;

/**
 * Created by vyomaPC1 on 4/19/2019.
 */

public class DaySearchModel {
    private String day_name;
    private ArrayList<ShiftSearchModel> shiftSearchModelArrayList;

    public DaySearchModel(String day_name, ArrayList<ShiftSearchModel> shiftSearchModelArrayList) {
        this.day_name = day_name;
        this.shiftSearchModelArrayList = shiftSearchModelArrayList;
    }

    public DaySearchModel() {

    }

    public String getDay_name() {
        return day_name;
    }

    public void setDay_name(String day_name) {
        this.day_name = day_name;
    }

    public ArrayList<ShiftSearchModel> getShiftSearchModelArrayList() {
        return shiftSearchModelArrayList;
    }

    public void setShiftSearchModelArrayList(ArrayList<ShiftSearchModel> shiftSearchModelArrayList) {
        this.shiftSearchModelArrayList = shiftSearchModelArrayList;
    }
}
