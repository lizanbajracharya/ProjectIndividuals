package com.example.hamrobook_ebookstore.api;

import com.example.hamrobook_ebookstore.model.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoryApi {
    @GET("category")
    Call<List<Category>> getCategory();
}
