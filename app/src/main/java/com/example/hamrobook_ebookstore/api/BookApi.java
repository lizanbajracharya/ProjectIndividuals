package com.example.hamrobook_ebookstore.api;

import com.example.hamrobook_ebookstore.model.Book;
import com.example.hamrobook_ebookstore.model.Product;
import com.example.hamrobook_ebookstore.serverresponse.BookResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BookApi {
    @GET("book")
    Call<List<Book>> getProduct();

    @FormUrlEncoded
    @POST("book/update/")
    Call<BookResponse> checkUser(@Field("mobileNumber") String number, @Field("password") String password);
}
