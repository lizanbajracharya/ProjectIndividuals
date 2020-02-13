package com.example.hamrobook_ebookstore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
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
    ImageView itemImage;
    String categoryid;
    ImageButton btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        btnback=findViewById(R.id.imgBk);
        recyclerView=findViewById(R.id.MedicineRecyclerView);
//        itemImage=findViewById(R.id.imgItem);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CategoryActivity.this,DashboardActivity.class);
                startActivity(intent);
            }
        });

        Bundle bundle = getIntent().getExtras();


        if(bundle!=null){

            categoryid=bundle.getString("categoryid");
//            Toast.makeText(this, ""+categoryid, Toast.LENGTH_SHORT).show();
        }

        BookApi bookApi = Url.getInstance().create(BookApi.class);
        Call<List<Book>> listCall =bookApi.getMedicineByID(categoryid);
        listCall.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                if(response.code()==200){
                    Toast.makeText(CategoryActivity.this, "Toast" + response.code(), Toast.LENGTH_SHORT).show();
                }
                BookAdapter itemAdapter =new BookAdapter(CategoryActivity.this,response.body());
                recyclerView.setAdapter(itemAdapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new GridLayoutManager(CategoryActivity.this,2));
                itemAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Toast.makeText(CategoryActivity.this, "Error" +t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
