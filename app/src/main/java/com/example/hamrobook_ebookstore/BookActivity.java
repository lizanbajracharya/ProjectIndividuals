package com.example.hamrobook_ebookstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hamrobook_ebookstore.Url.Url;
import com.squareup.picasso.Picasso;

public class BookActivity extends AppCompatActivity {
    Toolbar toolbar;
    ImageButton imgBk;
    TextView title,description,price;
    Button cart_button;
    private ImageView img;

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

        imgBk=findViewById(R.id.imgBk);
        title=findViewById(R.id.booktitle);
        description=findViewById(R.id.tvdescription);
        price=findViewById(R.id.price);
        cart_button=findViewById(R.id.cart_button);
        img=findViewById(R.id.fragranceImage);

        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        String Description = intent.getExtras().getString("Description");
        String image = intent.getExtras().getString("Thumbnail") ;
        String prices = intent.getExtras().getString("Price") ;

        // Setting values

        title.setText(Title);
        description.setText(Description);
        price.setText(prices);
        Picasso.get().load(Url.base_url_image+image).into(img);
    }
}
