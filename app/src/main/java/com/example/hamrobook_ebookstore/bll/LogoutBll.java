package com.example.hamrobook_ebookstore.bll;

import com.example.hamrobook_ebookstore.Url.Url;
import com.example.hamrobook_ebookstore.api.UserApi;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class LogoutBll {
    boolean isSuccess = false;

    public boolean logout(String token) {
        UserApi usersApi = Url.getInstance().create(UserApi.class);
        Call<Void> logoutResponseCall = usersApi.logout(token);
        try{
            Response<Void> logoutResponse = logoutResponseCall.execute();
            if(logoutResponse.code() == 200) {
                Url.token = ("");
                isSuccess = true;
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }


}
