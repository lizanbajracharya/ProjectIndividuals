package com.example.hamrobookwear;


import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

public class LoginBll {
    boolean isSuccess = false;
    String id;
    public boolean checkUser(String username, String password) {
        UserApi usersAPI = Url.getInstance().create(UserApi.class);
        Call<SignUpResponse> usersCall = usersAPI.checkUser(username, password);
        try {
            Response<SignUpResponse> loginResponse = usersCall.execute();
            if (loginResponse.isSuccessful()) {
                Url.token += loginResponse.body().getToken();
                Url.userid=loginResponse.body().getUserid();
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
