package com.example.hamrobook_ebookstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hamrobook_ebookstore.Url.Url;
import com.example.hamrobook_ebookstore.api.UserApi;
import com.example.hamrobook_ebookstore.model.Book;
import com.example.hamrobook_ebookstore.model.User;
import com.example.hamrobook_ebookstore.serverresponse.SignUpResponse;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView title,description,price,tvId;
    Button cart_button;
    private ImageView img;
    ImageButton imgbk;
    String Id;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.cart:
                intent=new Intent(this, CartActivity.class);
                intent.putExtra("name","cart");
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_book);

        title=findViewById(R.id.booktitle);
        description=findViewById(R.id.tvdescription);
        price=findViewById(R.id.price);
        cart_button=findViewById(R.id.cart_button);
        tvId=findViewById(R.id.tvId);
        img=findViewById(R.id.fragranceImage);
        imgbk=findViewById(R.id.imgBk);

        imgbk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        Intent intent = getIntent();
        final String Title = intent.getExtras().getString("Title");
        String Description = intent.getExtras().getString("Description");
        String image = intent.getExtras().getString("Thumbnail") ;
        final String prices = intent.getExtras().getString("Price") ;
        String Bookid=intent.getExtras().getString("id");
        Id=tvId.getText().toString();
        // Setting values

        title.setText(Title);
        description.setText(Description);
        price.setText(prices);
        Picasso.get().load(Url.base_url_image+image).into(img);

        cart_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BookActivity.this,BuyActivity.class);
                intent.putExtra("name",Title);
                intent.putExtra("rate",prices);
                startActivity(intent);
            }
        });
        UserApi usersAPI = Url.getInstance().create(UserApi.class);
        final Call<User> userCall = usersAPI.getUserDetails(Url.token);
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                  tvId.setText(Url.userid);
                    return;
                }
                else {
                    Toast.makeText(BookActivity.this, "Error ", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(BookActivity.this, "Error " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
