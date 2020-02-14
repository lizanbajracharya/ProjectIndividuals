package com.example.hamrobookwear;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hamrobookwear.strictmode.StrictModeClass;

public class MainActivity extends WearableActivity {

   EditText etWearUser,etWearPassword;
    Button btnWearLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etWearUser=findViewById(R.id.etWearUser);
        etWearPassword=findViewById(R.id.etWearPassword);
        btnWearLogin=findViewById(R.id.btnWearLog);

        btnWearLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        // Enables Always-on
        setAmbientEnabled();
    }

    private void login() {
        if(TextUtils.isEmpty(etWearUser.getText())){
            etWearUser.setError("Enter Username");
        }
        else if(TextUtils.isEmpty(etWearPassword.getText())){
            etWearPassword.setError("Enter Password");
        }
        else{
            String username = etWearUser.getText().toString();
            String password = etWearPassword.getText().toString();

            LoginBll loginBLL = new LoginBll();

            StrictModeClass.StrictMode();
            if (loginBLL.checkUser(username, password)) {
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Either username or password is incorrect", Toast.LENGTH_SHORT).show();
                etWearUser.requestFocus();
            }
        }
    }
}
