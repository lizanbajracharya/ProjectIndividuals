package com.example.hamrobook_ebookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hamrobook_ebookstore.Url.Url;
import com.example.hamrobook_ebookstore.api.OrderApi;
import com.example.hamrobook_ebookstore.model.Order;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BuyActivity extends AppCompatActivity {
    TextView tvProduct,tvRate;
    EditText etAddress,etMobile;
    Button btnOrder,btnCancel;
    String Address,Productname,Rate,Contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_buy);

        tvProduct=findViewById(R.id.tvProduct);
        tvRate=findViewById(R.id.tvRate);
        etAddress=findViewById(R.id.etAddress);
        etMobile=findViewById(R.id.etPhone);
        btnOrder=findViewById(R.id.btnOrder);
        btnCancel=findViewById(R.id.btnCancellation);
        Intent intent=getIntent();
        Productname=intent.getExtras().getString("name");
        Rate=intent.getExtras().getString("rate");

        tvProduct.setText(Productname);
        tvRate.setText(Rate);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etAddress.getText())) {
                    etAddress.setError("Please Enter Address");
                    etAddress.requestFocus();
                } else if (TextUtils.isEmpty(etMobile.getText())) {
                    etMobile.setError("Please Enter Contact Information");
                    etMobile.requestFocus();
                } else {
                    Address = etAddress.getText().toString();
                    Contact = etMobile.getText().toString();
                    Order order = new Order(Productname, Rate, Address, Contact);
                    OrderApi orderApi = Url.getInstance().create(OrderApi.class);
                    Call<Void> voidCall = orderApi.order(Url.token, order);
                    voidCall.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            if (!response.isSuccessful()) {
                                Toast.makeText(BuyActivity.this, "Code " + response.code(), Toast.LENGTH_SHORT).show();
                                return;
                            }
                            Toast.makeText(BuyActivity.this, "Bought Successfully", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            Toast.makeText(BuyActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    finish();
                }
            }
        });
    }
}
