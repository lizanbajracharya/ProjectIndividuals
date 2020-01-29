package com.example.hamrobook_ebookstore;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.example.hamrobook_ebookstore.Admin.Setting.SettingFragment;
import com.example.hamrobook_ebookstore.Admin.dashboard.BookFragment;
import com.example.hamrobook_ebookstore.Admin.home.HomeFragment;
import com.example.hamrobook_ebookstore.Admin.notifications.FavoriteFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);
        loadFragment(new HomeFragment());
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        fragment = new HomeFragment();
                        loadFragment(fragment);
                        break;
                    case R.id.navigation_dashboard:
                        fragment = new BookFragment();
                        loadFragment(fragment);
                        break;
                    case R.id.navigation_notifications:
                        fragment=new FavoriteFragment();
                        loadFragment(fragment);
                        break;
                    case R.id.navigation_setting_bar:
                        fragment = new SettingFragment();
                        loadFragment(fragment);
                        break;
                }
                return true;
            }
        });
}
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_host_fragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}

