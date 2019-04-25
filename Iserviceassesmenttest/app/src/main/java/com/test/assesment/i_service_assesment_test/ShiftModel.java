package com.test.assesment.i_service_assesment_test;

import java.util.ArrayList;

/**
 * Created by vyomaPC1 on 4/18/2019.
 */

public class ShiftModel {
    private String shift_name;
    private String engineer_name;

    public ShiftModel(String shift_name, String engineer_name) {
        this.shift_name = shift_name;
        this.engineer_name = engineer_name;
    }

    public ShiftModel() {

    }

    public String getShift_name() {
        return shift_name;
    }

    public void setShift_name(String shift_name) {
        this.shift_name = shift_name;
    }

    public String getEngineer_name() {
        return engineer_name;
    }

    public void setEngineer_name(String engineer_name) {
        this.engineer_name = engineer_name;
    }
}
