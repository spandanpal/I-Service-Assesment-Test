package com.test.assesment.i_service_assesment_test;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.test.assesment.i_service_assesment_test.retrofit.Constant;
import com.test.assesment.i_service_assesment_test.retrofit.RestInterface;
import com.test.assesment.i_service_assesment_test.retrofit.RetrofitError;
import com.test.assesment.i_service_assesment_test.retrofit.RetrofitUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

import dmax.dialog.SpotsDialog;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private Button bt_task_schdule;
    private RecyclerView rv_engineer_shift;
    String engineer_list= "";
    boolean checkperm = true;
    EngineerAdapter engineerAdapter;
    IServiceModel dataModel=IServiceModel.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        random_api(engineer_list);
        initView();
    }

    private void initView(){
        bt_task_schdule=(Button) findViewById(R.id.bt_task_schdule);
        rv_engineer_shift=(RecyclerView) findViewById(R.id.rv_engineer_shift);
        bt_task_schdule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SchduledShiftActivity.class);

                startActivity(intent);
            }
        });
    }

    public void random_api(String engineer_list) {
        final SpotsDialog pd = new SpotsDialog(MainActivity.this, R.style.CustomWaitDialog);
        pd.show();

        RestInterface service = RetrofitUtil.retrofit(Constant.BASE_URL);
        Call<ResponseBody> call = service.Random_Engineer(engineer_list);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                pd.dismiss();

                if (response.isSuccessful()) {
                    try {
                        String r = response.body().string();
                        Log.d("Response", r);
                        JSONObject jsonObject = new JSONObject(r);
                        if (jsonObject.getString("ack").equals(Constants.SUCCESS)){
                            JSONArray EngineerArray = jsonObject.getJSONArray("data");
                            ArrayList<EngineerModel> engineerModelArrayList = new ArrayList<EngineerModel>();
                            if (EngineerArray.length() > 0) {
                                for (int j = 0; j < EngineerArray.length(); j++) {
                                    JSONObject objectEngineer = EngineerArray.getJSONObject(j);
                                    EngineerModel engineerModel=new EngineerModel();
                                    engineerModel.setId(objectEngineer.getString("id"));
                                    engineerModel.setName(objectEngineer.getString("name"));
                                    engineerModel.setCreated_at(objectEngineer.getString("created_at"));
                                    engineerModel.setViewType(1);
                                    engineerModelArrayList.add(engineerModel);
                                }
                                dataModel.engineerModelArrayList.removeAll(dataModel.engineerModelArrayList);
                                dataModel.engineerModelArrayList.addAll(engineerModelArrayList);
                                getEngineerList();
                            }
                        }else {
                            Toast.makeText(MainActivity.this,jsonObject.getString("msg"),Toast.LENGTH_LONG);
                        }


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    String error = RetrofitError.codeToErrorMessage(response.code());
                    Toast.makeText(MainActivity.this,error,Toast.LENGTH_LONG);

                }
                pd.dismiss();

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                pd.dismiss();

                String str = RetrofitError.showErrorMessage(t);
                Toast.makeText(MainActivity.this,str,Toast.LENGTH_LONG);
            }
        });


    }

    private void getEngineerList(){
        LinearLayoutManager layoutManager=new LinearLayoutManager(MainActivity.this);
        rv_engineer_shift.setLayoutManager(layoutManager);
        rv_engineer_shift.setItemAnimator(new DefaultItemAnimator());
        engineerAdapter=new EngineerAdapter(dataModel.engineerModelArrayList,MainActivity.this);
        rv_engineer_shift.setAdapter(engineerAdapter);
    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onResume() {

        // set and check device permission

        if (checkperm) {
            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                MarshMallowPermission marshMallowPermission = new MarshMallowPermission(MainActivity.this);






                if (marshMallowPermission.checkPermissionForExternalStorage() == false) {
                    checkperm = true;
                    marshMallowPermission.requestPermissionForExternalStorage();
                } else {
                    checkperm = false;
                }


            }

        }
        super.onResume();
    }

}
