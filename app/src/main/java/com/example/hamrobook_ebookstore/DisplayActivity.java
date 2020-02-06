package com.example.hamrobook_ebookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    private TextView tvtitle,tvdescription,tvcategory;
    private ImageView img;
    private ImageButton imgRead,imgFavorite;
    ImageButton imgReverse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_display);

        tvtitle =  findViewById(R.id.txttitle);
        tvdescription =  findViewById(R.id.txtDesc);
        tvcategory =  findViewById(R.id.txtCat);
        img =  findViewById(R.id.bookthumbnail);
        imgReverse=findViewById(R.id.imgReverse);
        imgRead=findViewById(R.id.btnRead);
        imgFavorite=findViewById(R.id.btnFavorites);

        // Recieve data
        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        String Description = intent.getExtras().getString("Description");
        int image = intent.getExtras().getInt("Thumbnail") ;

        // Setting values

        tvtitle.setText(Title);
        tvdescription.setText(Description);
        img.setImageResource(image);
    }
}
