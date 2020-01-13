package com.example.hamrobook_ebookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etUsername,etPassword;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        btnLogin=findViewById(R.id.btnLogin);
        etUsername=findViewById(R.id.etUsername);
        etPassword=findViewById(R.id.etPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=etUsername.getText().toString();
                String Password=etPassword.getText().toString();
                if(username.equals("admin") && Password.equals("admin"))
                {
                    Intent intent=new Intent(MainActivity.this,DashboardActivity.class);
                    startActivity(intent);
                    SaveUsernamePassword();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void SaveUsernamePassword(){
        SharedPreferences sharedPreferences=getSharedPreferences("User",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();

        editor.putString("username",etUsername.getText().toString().trim());
        editor.putString("password",etPassword.getText().toString().trim());
        editor.commit();

        Toast.makeText(this, "Successfully Saved", Toast.LENGTH_SHORT).show();
    }
}
