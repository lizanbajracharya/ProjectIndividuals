package com.example.hamrobook_ebookstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hamrobook_ebookstore.Url.Url;
import com.example.hamrobook_ebookstore.adapter.BookAdapter;
import com.example.hamrobook_ebookstore.adapter.SearchAdapter;
import com.example.hamrobook_ebookstore.api.BookApi;
import com.example.hamrobook_ebookstore.model.Book;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {
    ImageButton imgBack,imgSearch;
    TextView tvSearch;
    RecyclerView recyclerView;
    String name = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_search);

        imgBack=findViewById(R.id.imgBack);
        imgSearch=findViewById(R.id.imgSearch);
        tvSearch=findViewById(R.id.tvSearch);
        recyclerView=findViewById(R.id.recyclerViewSearch);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SearchActivity.this,DashboardActivity.class);
                startActivity(intent);
            }
        });

        imgSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BookApi bookApi= Url.getInstance().create(BookApi.class);

                Call<List<Book>> voidCall=bookApi.searchBook(tvSearch.getText().toString());

                voidCall.enqueue(new Callback<List<Book>>() {
                    @Override
                    public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(SearchActivity.this, "Toast"+response.code(), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        SearchAdapter itemAdapter=new SearchAdapter(getApplicationContext(),response.body());
                        recyclerView.setAdapter(itemAdapter);
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        itemAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<List<Book>> call, Throwable t) {
                        Toast.makeText(SearchActivity.this, "Error " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
