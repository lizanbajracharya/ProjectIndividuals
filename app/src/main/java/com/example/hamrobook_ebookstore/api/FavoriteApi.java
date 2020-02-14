package com.example.hamrobook_ebookstore.api;

import com.example.hamrobook_ebookstore.model.Book;
import com.example.hamrobook_ebookstore.model.Favorite;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface FavoriteApi {
    @FormUrlEncoded
    @POST("favorite")
    Call<Void> addUser(@Header("Authorization") String token, @Field("bookid") String bookid);

    @GET("favorite")
    Call<List<Favorite>> getFavorite(@Header("Authorization") String token);

    @DELETE("favorite/{id}")
    Call<Void> removeFavorite(@Path("id") String id);
}
