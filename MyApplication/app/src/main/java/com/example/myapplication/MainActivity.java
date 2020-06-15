package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView btmNavView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btmNavView = findViewById(R.id.bottom_nav_view);

        getFragment(new HomeFragment());

        btmNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.nav_home :
                        Toast.makeText(MainActivity.this, "You are in home", Toast.LENGTH_SHORT).show();
                        getFragment(new HomeFragment());
                        return true;
                    case R.id.schedule :
                        Toast.makeText(MainActivity.this, "You are in schedule", Toast.LENGTH_SHORT).show();
                        getFragment(new ScheduleFragment());
                        return true;
                    case R.id.profile :
                        Toast.makeText(MainActivity.this, "You are in profile", Toast.LENGTH_SHORT).show();
                        getFragment(new ProfileFragment());
                        return true;
                    case R.id.tasks :
                        Toast.makeText(MainActivity.this, "You are in tasks", Toast.LENGTH_SHORT).show();
                        getFragment(new TaskFragment());
                        return true;
                }
                return false;
            }
        });

    }

    private void getFragment(Fragment fragment)
    {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
