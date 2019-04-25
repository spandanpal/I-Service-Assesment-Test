package com.test.assesment.i_service_assesment_test;

/**
 * Created by vyomaPC1 on 4/19/2019.
 */

public class ShiftSearchModel {
    private String shift_search;
    private String engineer_search;

    public ShiftSearchModel(String shift_search, String engineer_search) {
        this.shift_search = shift_search;
        this.engineer_search = engineer_search;
    }

    public ShiftSearchModel() {

    }

    public String getShift_search() {
        return shift_search;
    }

    public void setShift_search(String shift_search) {
        this.shift_search = shift_search;
    }

    public String getEngineer_search() {
        return engineer_search;
    }

    public void setEngineer_search(String engineer_search) {
        this.engineer_search = engineer_search;
    }
}
