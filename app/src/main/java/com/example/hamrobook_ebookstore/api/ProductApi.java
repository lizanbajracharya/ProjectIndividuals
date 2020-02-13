package com.example.hamrobook_ebookstore.api;

import com.example.hamrobook_ebookstore.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductApi {
    @GET("product")
    Call<List<Product>> getProduct();
}
