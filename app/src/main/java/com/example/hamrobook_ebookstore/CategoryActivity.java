package com.example.hamrobook_ebookstore;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hamrobook_ebookstore.Url.Url;
import com.example.hamrobook_ebookstore.adapter.BookAdapter;
import com.example.hamrobook_ebookstore.api.BookApi;
import com.example.hamrobook_ebookstore.model.Book;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    String categoryid;
    ImageButton btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_category);

        btnback=findViewById(R.id.imgBk);
        recyclerView=findViewById(R.id.MedicineRecyclerView);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Bundle bundle = getIntent().getExtras();


        if(bundle!=null){

            categoryid=bundle.getString("categoryid");
//            Toast.makeText(this, ""+categoryid, Toast.LENGTH_SHORT).show();
        }

        BookApi bookApi = Url.getInstance().create(BookApi.class);
        Call<List<Book>> listCall =bookApi.getBookByID(categoryid);
        listCall.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                BookAdapter itemAdapter =new BookAdapter(CategoryActivity.this,response.body());
                recyclerView.setAdapter(itemAdapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(CategoryActivity.this));
                itemAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Toast.makeText(CategoryActivity.this, "Error" +t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
