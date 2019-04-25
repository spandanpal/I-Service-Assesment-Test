package com.test.assesment.i_service_assesment_test;


import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SchduledShiftActivity extends AppCompatActivity {

    private TextView tv_engineer_one_day_shift,tv_engineer_one_night_shift,tv_engineer_two_day_shift,tv_engineer_two_night_shift,
            tv_engineer_three_day_shift,tv_engineer_three_night_shift,tv_engineer_four_day_shift,tv_engineer_four_night_shift,
            tv_engineer_five_day_shift,tv_engineer_five_night_shift;
    private RecyclerView rv_shift_list;
    IServiceModel dataModel=IServiceModel.getInstance();
    ArrayList<EngineerModel> object;
    EngineerModel model;
    ShiftAdapter shiftAdapter;
    List<DayShiftModel> filterdayShiftModelsArraylist;

    ArrayList<DayModel> dayModelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schduled_shift);

        initView();
    }

    private void initView(){
        tv_engineer_one_day_shift=(TextView) findViewById(R.id.tv_engineer_one_day_shift);
        tv_engineer_one_night_shift=(TextView) findViewById(R.id.tv_engineer_one_night_shift);
        tv_engineer_two_day_shift=(TextView) findViewById(R.id.tv_engineer_two_day_shift);
        tv_engineer_two_night_shift=(TextView) findViewById(R.id.tv_engineer_two_night_shift);
        tv_engineer_three_day_shift=(TextView) findViewById(R.id.tv_engineer_three_day_shift);
        tv_engineer_three_night_shift=(TextView) findViewById(R.id.tv_engineer_three_night_shift);
        tv_engineer_four_day_shift=(TextView) findViewById(R.id.tv_engineer_four_day_shift);
        tv_engineer_four_night_shift=(TextView) findViewById(R.id.tv_engineer_four_night_shift);
        tv_engineer_five_day_shift=(TextView) findViewById(R.id.tv_engineer_five_day_shift);
        tv_engineer_five_night_shift=(TextView) findViewById(R.id.tv_engineer_five_night_shift);

        rv_shift_list=(RecyclerView) findViewById(R.id.rv_shift_list);

        dayModelList=new ArrayList<DayModel>();
        ArrayList<ShiftModel> shiftModelBlankArrayList=new ArrayList<ShiftModel>();
        dayModelList.add(new DayModel("Monday"));
        dayModelList.add(new DayModel("Tuesday"));
        dayModelList.add(new DayModel("Wednesday"));
        dayModelList.add(new DayModel("Thursday"));
        dayModelList.add(new DayModel("Friday"));
        ArrayList<ShiftModel> shiftModelArrayList=new ArrayList<ShiftModel>();
        shiftModelArrayList.add(new ShiftModel("Day",""));
        shiftModelArrayList.add(new ShiftModel("Night",""));
        ArrayList<EngineerModel> engineerModelArrayList = new ArrayList<EngineerModel>();
        engineerModelArrayList.addAll(dataModel.engineerModelArrayList);



                for(int j = 0;j<dataModel.engineerModelArrayList.size();j++){
                    for(int i = 0;i<dayModelList.size();i++){
                    for(int k = 0;k<shiftModelArrayList.size();k++){



                    if(j==0){
                        dataModel.engineerModelArrayList.set(j,new EngineerModel(dataModel.engineerModelArrayList.get(j).getId(),
                                dataModel.engineerModelArrayList.get(j).getName(),dataModel.engineerModelArrayList.get(j).getCreated_at(),
                                dayModelList.get(i).getDay_Name().toLowerCase(),shiftModelArrayList.get(k).getShift_name().toLowerCase(),1));
                    }else {
                        List<EngineerModel> filterengineerModelArrayList = new ArrayList<EngineerModel>();
                        filterengineerModelArrayList = filtermodel(dataModel.engineerModelArrayList,dayModelList.get(i).getDay_Name().toLowerCase(),
                                shiftModelArrayList.get(k).getShift_name().toLowerCase());

                        if(filterengineerModelArrayList.size()<=0){
                            dataModel.engineerModelArrayList.set(j,new EngineerModel(dataModel.engineerModelArrayList.get(j).getId(),
                                    dataModel.engineerModelArrayList.get(j).getName(),dataModel.engineerModelArrayList.get(j).getCreated_at(),
                                    dayModelList.get(i).getDay_Name().toLowerCase(),shiftModelArrayList.get(k).getShift_name().toLowerCase(),1));

                        }
                    }
                }


            }
        }
        Gson gson=new Gson();


        ArrayList<WeekModel> weekModelArrayList =new ArrayList<WeekModel>();
        weekModelArrayList.add(new WeekModel("First",dataModel.engineerModelArrayList,1));
        String gson_str = gson.toJson(weekModelArrayList);
        Log.e("gson_one",gson_str);
        Collections.reverse(dayModelList);
        Collections.reverse(engineerModelArrayList);
        for(int j = 0;j<engineerModelArrayList.size();j++){
            for(int i = 0;i<dayModelList.size();i++){
                for(int k = 0;k<shiftModelArrayList.size();k++){



                    if(j==0){
                        engineerModelArrayList.set(j,new EngineerModel(engineerModelArrayList.get(j).getId(),
                                engineerModelArrayList.get(j).getName(),engineerModelArrayList.get(j).getCreated_at(),
                                dayModelList.get(i).getDay_Name().toLowerCase(),shiftModelArrayList.get(k).getShift_name().toLowerCase(),1));
                    }else {
                        List<EngineerModel> filterengineerModelArrayList = new ArrayList<EngineerModel>();
                        filterengineerModelArrayList = filtermodel(engineerModelArrayList,dayModelList.get(i).getDay_Name().toLowerCase(),
                                shiftModelArrayList.get(k).getShift_name().toLowerCase());

                        if(filterengineerModelArrayList.size()<=0){
                            engineerModelArrayList.set(j,new EngineerModel(engineerModelArrayList.get(j).getId(),
                                    engineerModelArrayList.get(j).getName(),engineerModelArrayList.get(j).getCreated_at(),
                                    dayModelList.get(i).getDay_Name().toLowerCase(),shiftModelArrayList.get(k).getShift_name().toLowerCase(),1));

                        }
                    }
                }


            }

        }

        weekModelArrayList.add(new WeekModel("Second",engineerModelArrayList,1));
        /*ArrayList<DaySearchModel> dayModelInsertArrayList=new ArrayList<DaySearchModel>();
        ArrayList<WeekSearchModel> weekSearchModelArrayList=new ArrayList<WeekSearchModel>();

        for (int l=0;l<weekModelArrayList.size();l++){

            WeekSearchModel weekSearchModel=new WeekSearchModel();
            weekSearchModel.setWeek_search(weekModelArrayList.get(l).getWeek());
            for (int p=0;p<dayModelList.size();p++){
            for (int m=0;m<weekModelArrayList.get(l).getEngineerModelArrayList().size();m++){

                    DaySearchModel daySearchModel=new DaySearchModel();

                    List<EngineerModel> filterengineerModelArrayList = new ArrayList<EngineerModel>();

                    filterengineerModelArrayList=shiftsearch(weekModelArrayList.get(l).getEngineerModelArrayList(),
                            dayModelList.get(p).getDay_Name().toLowerCase());
                    daySearchModel.setDay_name(dayModelList.get(p).getDay_Name().toLowerCase());
                    ArrayList<ShiftSearchModel> shiftSearchModelArrayList=new ArrayList<ShiftSearchModel>();
                    if (filterengineerModelArrayList.size()>0){
                        for (int z=0;z<filterengineerModelArrayList.size();z++){
                            ShiftSearchModel shiftSearchModel=new ShiftSearchModel();
                            shiftSearchModel.setEngineer_search(filterengineerModelArrayList.get(z).getName());
                            shiftSearchModel.setShift_search(filterengineerModelArrayList.get(z).getShift());
                            shiftSearchModelArrayList.add(shiftSearchModel);
                        }
                    }
                    daySearchModel.setShiftSearchModelArrayList(shiftSearchModelArrayList);
                    dayModelInsertArrayList.add(daySearchModel);

                }

            }
            weekSearchModel.setDayModelInsertArrayList(dayModelInsertArrayList);
            weekSearchModelArrayList.add(weekSearchModel);
        }*/

         ArrayList<DayShiftModel> dayShiftModelsArrayList = new ArrayList<DayShiftModel>();
         for (int l=0;l<weekModelArrayList.size();l++){

             for (int p=0;p<dayModelList.size();p++){
                 filterdayShiftModelsArraylist = new ArrayList<DayShiftModel>();
                 filterdayShiftModelsArraylist= shiftsearch(weekModelArrayList.get(l).getEngineerModelArrayList(),dayModelList.get(p).getDay_Name().toLowerCase(),
                         weekModelArrayList.get(l).getWeek());
                 String filter_list=gson.toJson(filterdayShiftModelsArraylist);

                 for (DayShiftModel model : filterdayShiftModelsArraylist) {
                     dayShiftModelsArrayList.add(model);
                 }



             }
             String dayShiftModelsArray=gson.toJson(dayShiftModelsArrayList);
             Log.e("filter_list_gson",dayShiftModelsArray);
         }
         dataModel.dayShiftModelsArrayList.removeAll(dataModel.dayShiftModelsArrayList);
         Collections.reverse(dayShiftModelsArrayList);
         dataModel.dayShiftModelsArrayList.addAll(dayShiftModelsArrayList);
        getShiftRecyler();


        Log.e("size", String.valueOf(dayShiftModelsArrayList.size()));
        //String shift_gson=gson.toJson(weekSearchModelArrayList);
        String shift_gson=gson.toJson(dayShiftModelsArrayList);
        Log.e("shift_gson",shift_gson);
        try {
            File storageLogin;
            String myfolder = Environment.getExternalStorageDirectory() + "/Android/data/com.vyomainnovus.ismart/files/";
            storageLogin = new File(myfolder);

            FileOutputStream fout = new FileOutputStream(storageLogin + "/" + System.currentTimeMillis() + ".json");
            String s = shift_gson;
            byte b[] = s.getBytes();//converting string into byte array
            fout.write(b); //writing data into the file

            Log.e("patientlogin details", String.valueOf(fout));
            fout.close();

            FileOutputStream fout1 = new FileOutputStream(storageLogin + "/" + System.currentTimeMillis() + ".txt");
            String s1 = shift_gson;
            byte b1[] = s1.getBytes();//converting string into byte array
            fout1.write(b1); //writing data into the file

            Log.e("patientlogin details", String.valueOf(fout1));
            fout1.close();
            System.out.println("success...");


        } catch (Exception e) {
            System.out.println(e);
        }

        /*WeekModel weekModel =new WeekModel();
        if(weekModelArrayList.size()>0){
            for (int p=0;p<weekModelArrayList.size();p++){
                if (weekModelArrayList.get(p).getWeek().equals(dayModelList.get(p).getDay_Name().toLowerCase())){

                }
            }
        }*/




        String gson_str_two = gson.toJson(weekModelArrayList.get(1));
        Log.e("gson_two",gson_str_two);


    }
    private void getShiftRecyler(){
        LinearLayoutManager layoutManager=new LinearLayoutManager(SchduledShiftActivity.this);
        rv_shift_list.setLayoutManager(layoutManager);
        rv_shift_list.setItemAnimator(new DefaultItemAnimator());
        shiftAdapter=new ShiftAdapter(dataModel.dayShiftModelsArrayList,SchduledShiftActivity.this);
        rv_shift_list.setAdapter(shiftAdapter);
    }

    private List<EngineerModel> filtermodel(ArrayList<EngineerModel> models, String query,String query1) {
        query = query.toLowerCase();

        final List<EngineerModel> filteredModelList = new ArrayList<EngineerModel>();
        try {
            for (EngineerModel model : models) {
                String text = String.valueOf(model.getDay());
                String text1 = String.valueOf(model.getShift());
                if (text.equals(query)) {
                    if(text1.equals(query1)){
                        filteredModelList.add(model);
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filteredModelList;
    }
    private List<DayShiftModel> shiftsearch(ArrayList<EngineerModel> models, String query,String week) {
        query = query.toLowerCase();

        final List<DayShiftModel> filteredModelList = new ArrayList<DayShiftModel>();
        try {
            for (EngineerModel model : models) {
                String text = String.valueOf(model.getDay());

                if (text.equals(query)) {
                    if (filteredModelList.size()>0){
                        for (DayShiftModel name_search : filteredModelList) {
                            if (!name_search.getName_one().equals("")){
                                filteredModelList.set(0,new DayShiftModel(name_search.getName_one(),model.getName(),
                                        week,query,name_search.getShift_one(),model.getShift(),1));
                            }
                        }

                    }else {
                        filteredModelList.add(new DayShiftModel( model.getName(), "",week,query, model.getShift(), "", 1));
                    }



                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filteredModelList;
    }


}
