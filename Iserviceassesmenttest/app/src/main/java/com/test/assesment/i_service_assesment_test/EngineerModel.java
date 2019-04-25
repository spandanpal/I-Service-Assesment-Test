package com.test.assesment.i_service_assesment_test;

import java.io.Serializable;
import java.util.List;

/**
 * Created by vyomaPC1 on 4/18/2019.
 */

public class EngineerModel implements Serializable{
    private String id;
    private String name;
    private String created_at;
    private String day;
    private String shift;

    private int viewType =0;

    public EngineerModel(String id, String name, String created_at, String day, String shift, int viewType) {
        this.id = id;
        this.name = name;
        this.created_at = created_at;
        this.day = day;
        this.shift = shift;
        this.viewType = viewType;
    }

    public EngineerModel() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
}
