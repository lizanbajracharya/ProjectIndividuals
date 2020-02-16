package com.example.hamrobook_ebookstore.bll;

import com.example.hamrobook_ebookstore.Url.Url;
import com.example.hamrobook_ebookstore.api.OrderApi;
import com.example.hamrobook_ebookstore.model.Order;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class OrderBll {
    boolean isSuccess = false;
    public boolean orderadd(Order order) {
        OrderApi orderApi = Url.getInstance().create(OrderApi.class);
        Call<Void> voidCall = orderApi.order(Url.token,order);
        try {
            Response<Void> voidResponse = voidCall.execute();
            if (voidResponse.isSuccessful()) {
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
