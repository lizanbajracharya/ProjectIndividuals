package com.example.hamrobook_ebookstore.api;

import com.example.hamrobook_ebookstore.model.Book;
import com.example.hamrobook_ebookstore.model.Product;
import com.example.hamrobook_ebookstore.serverresponse.BookResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface BookApi {
    @GET("book")
    Call<List<Book>> getProduct();

    @POST("book/users/{id}")
    Call<Void> addUser(@Header("Authorization") String token, @Path("id") String bookID);

    @GET("book/getByCategory/{id}")
    Call<List<Book>> getMedicineByID(@Path("id") String CategoryID);

    @GET("book/search/{bookName}")
    Call<List<Book>> searchBook(@Path("bookName") String BookName);

}
