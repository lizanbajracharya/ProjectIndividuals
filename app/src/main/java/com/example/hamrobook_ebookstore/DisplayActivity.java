package com.example.hamrobook_ebookstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hamrobook_ebookstore.channel.CreateChannel;

public class DisplayActivity extends AppCompatActivity {
    NotificationManagerCompat notificationManagerCompat;
    private TextView tvtitle,tvdescription,tvcategory,tvWriter;
    private ImageView img;
    private ImageButton imgRead,imgFavorite;
    ImageButton imgReverse;
    int id=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_display);

        notificationManagerCompat=NotificationManagerCompat.from(this);
        CreateChannel channel=new CreateChannel(this);
        channel.createChannel();

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

        imgFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayNotication();
                imgFavorite.setVisibility(View.INVISIBLE);
            }
        });
    }

    public void DisplayNotication(){
       Notification notification=new NotificationCompat.Builder(this,CreateChannel.CHANNEL_1)
               .setSmallIcon(R.drawable.ic_notification)
               .setContentTitle("Favorite")
               .setContentText("Added to Favorite Successful")
               .setCategory(NotificationCompat.CATEGORY_MESSAGE)
               .build();
       notificationManagerCompat.notify(id,notification);
       id++;
    }
}
