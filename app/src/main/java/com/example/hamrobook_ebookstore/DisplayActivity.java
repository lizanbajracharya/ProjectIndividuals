package com.example.hamrobook_ebookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hamrobook_ebookstore.Url.Url;
import com.example.hamrobook_ebookstore.model.Book;
import com.squareup.picasso.Picasso;

import java.io.Writer;
import java.util.Locale;

public class DisplayActivity extends AppCompatActivity {

    private TextView tvtitle,tvdescription,tvcategory,tvWriter;
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
        tvWriter=findViewById(R.id.tvWriter);
        img =  findViewById(R.id.bookthumbnail);
        imgReverse=findViewById(R.id.imgReverse);
        imgRead=findViewById(R.id.btnRead);
        imgFavorite=findViewById(R.id.btnFavorites);

        // Recieve data
        Intent intent = getIntent();
        final String Title = intent.getExtras().getString("BookName");
        String Description = intent.getExtras().getString("Category");
        String BookWriter = intent.getExtras().getString("Writer");
        final String content = intent.getExtras().getString("BookContent");

        // Setting values

        tvtitle.setText(Title);
        tvcategory.setText(Description);
        tvdescription.setText(Description);
        tvWriter.setText(BookWriter);

        imgRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DisplayActivity.this,PdfActivity.class);
                intent.putExtra("PDF",content);
                intent.putExtra("Name",Title);
                startActivity(intent);
            }
        });
    }
}
