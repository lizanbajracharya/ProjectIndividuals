package com.example.hamrobook_ebookstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.hamrobook_ebookstore.Url.Url;
import com.example.hamrobook_ebookstore.adapter.BookAdapter;
import com.example.hamrobook_ebookstore.adapter.OrderAdapter;
import com.example.hamrobook_ebookstore.api.OrderApi;
import com.example.hamrobook_ebookstore.model.Order;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_order);

        recyclerView=findViewById(R.id.recyclerViewOrder);
        OrderApi orderApi= Url.getInstance().create(OrderApi.class);
        Call<List<Order>> listCall=orderApi.getOrder(Url.token);
        listCall.enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                if(response.code()==200){
                    Toast.makeText(OrderActivity.this, "Toast" + response.code(), Toast.LENGTH_SHORT).show();
                }
                OrderAdapter orderAdapter =new OrderAdapter(OrderActivity.this,response.body());
                recyclerView.setAdapter(orderAdapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(OrderActivity.this));
                orderAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {
                Toast.makeText(OrderActivity.this, "Error" +t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
