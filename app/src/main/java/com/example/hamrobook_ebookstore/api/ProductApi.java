package com.example.hamrobook_ebookstore.api;

import com.example.hamrobook_ebookstore.model.Product;
import com.example.hamrobook_ebookstore.model.User;
import com.example.hamrobook_ebookstore.serverresponse.ProductResponse;
import com.example.hamrobook_ebookstore.serverresponse.SignUpResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ProductApi {
    @GET("product")
    Call<List<Product>> getProduct();
}
