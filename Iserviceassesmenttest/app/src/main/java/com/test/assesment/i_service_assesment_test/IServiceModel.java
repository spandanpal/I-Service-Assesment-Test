package com.test.assesment.i_service_assesment_test;

import java.util.ArrayList;



/**
 * Created by vyomaPC1 on 11/16/2018.
 */

public class IServiceModel {

    private static IServiceModel ourInstance = new IServiceModel();

    public static IServiceModel getInstance() {
        return ourInstance;
    }

    private IServiceModel() {

    }

    public String url_local = "";

    public String stream_id = "";
    public String gender = "";
    public String status_radio = "";
    public String chapter_id = "";
    public String subject_id = "";
    public String chapter_name = "";
    public String subject_name = "";
    public String subjectquiz_id = "";
    public String u_id = "";
    public String picturePath = "";
    public String video_id = "";
    public String filenname = "";
    public int offline_video_position = 0;
    public String video_click = "";



    public EngineerModel engineerModel=new EngineerModel();

    public ArrayList<EngineerModel> engineerModelArrayList = new ArrayList<EngineerModel>();
    public ArrayList<DayModel> dayModelArrayList = new ArrayList<DayModel>();
    public ArrayList<ShiftModel> shiftModelArrayList = new ArrayList<ShiftModel>();
    public ArrayList<WeekModel> weekModelArrayList = new ArrayList<WeekModel>();
    public ArrayList<DaySearchModel> daySearchModelArrayList = new ArrayList<DaySearchModel>();
    public ArrayList<DayShiftModel> dayShiftModelsArrayList = new ArrayList<DayShiftModel>();




}
