package com.example.hamrobook_ebookstore.api;

import com.example.hamrobook_ebookstore.model.User;
import com.example.hamrobook_ebookstore.serverresponse.SignUpResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserApi {
    @POST("user/signup")
    Call<SignUpResponse> registerUser(@Body User users);

    @FormUrlEncoded
    @POST("user/login")
    Call<SignUpResponse> checkUser(@Field("username") String number, @Field("password") String password);

    @GET("user/me")
    Call<User> getUserDetails(@Header("Authorization")String token);
}
