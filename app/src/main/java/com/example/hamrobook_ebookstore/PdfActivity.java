package com.example.hamrobook_ebookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.hamrobook_ebookstore.Url.Url;
import com.github.barteksc.pdfviewer.PDFView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Stream;

public class PdfActivity extends AppCompatActivity {

    PDFView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        webView=findViewById(R.id.webView);
        Intent intent=getIntent();
        String pdf=intent.getExtras().getString("PDF");
        new RetreivePDFStream().execute(Url.pdf+pdf);
    }

    class RetreivePDFStream extends AsyncTask<String,Void,InputStream>
    {
        @Override
        protected InputStream doInBackground(String... strings){
            InputStream inputStream=null;
            try{
                 URL url=new URL(strings[0]);
                HttpURLConnection urlConnection=(HttpURLConnection) url.openConnection();
                if(urlConnection.getResponseCode()==200){
                    inputStream=new BufferedInputStream(urlConnection.getInputStream());
                }
            }
            catch (IOException e){
                return null;
            }
            return inputStream;
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            webView.fromStream(inputStream)
                    .enableSwipe(true) // allows to block changing pages using swipe
                    .swipeHorizontal(true)
                    .enableDoubletap(true)
                    .defaultPage(0)
                    .password(null)
                    .scrollHandle(null)
                    .enableAntialiasing(true)
                    .spacing(0)
                    .enableAnnotationRendering(false)
                    .load();
        }
    }
}
