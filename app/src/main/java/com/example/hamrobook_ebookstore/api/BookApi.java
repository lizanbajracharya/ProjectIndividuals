package com.example.hamrobook_ebookstore.api;

import com.example.hamrobook_ebookstore.model.Book;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BookApi {
    @GET("book")
    Call<List<Book>> getProduct();

    @GET("book/getByCategory/{id}")
    Call<List<Book>> getBookByID(@Path("id") String CategoryID);

    @GET("book/search/{bookName}")
    Call<List<Book>> searchBook(@Path("bookName") String BookName);

}
