package com.example.hamrobook_ebookstore.bll;

import com.example.hamrobook_ebookstore.Url.Url;
import com.example.hamrobook_ebookstore.api.UserApi;
import com.example.hamrobook_ebookstore.serverresponse.SignUpResponse;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class LoginBll {
    boolean isSuccess = false;

    public boolean checkUser(String username, String password) {
        UserApi usersAPI = Url.getInstance().create(UserApi.class);
        Call<SignUpResponse> usersCall = usersAPI.checkUser(username, password);
        try {
            Response<SignUpResponse> loginResponse = usersCall.execute();
            if (loginResponse.isSuccessful()) {

                Url.token += loginResponse.body().getToken();
                // Url.Cookie = imageResponseResponse.headers().get("Set-Cookie");
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
