package com.test.assesment.i_service_assesment_test.retrofit;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


public interface RestInterface {


    @FormUrlEncoded
    @POST(Constant.RANDOM_ENGINEER)
    Call<ResponseBody> Random_Engineer(@Field(Constant.ENGINEER_SHIFT) String engineer_shift


    );






}

