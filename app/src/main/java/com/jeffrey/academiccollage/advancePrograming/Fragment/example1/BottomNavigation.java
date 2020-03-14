package com.jeffrey.academiccollage.advancePrograming.Fragment.example1;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jeffrey.academiccollage.BasicActivity;
import com.jeffrey.academiccollage.R;

public class BottomNavigation extends BasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttom_navigation);
        setTheFragmentManger();
    }

    private void setTheFragmentManger() {
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragmant=null;
                switch (item.getItemId())
                {
                    case R.id.fragment1:
                        selectedFragmant=new FirstFragment();
                        break;
                    case R.id.fragment2:
                        selectedFragmant=new SecondFragment();
                        break;
                    case R.id.fragment3:
                        selectedFragmant=new ThirdFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_view,selectedFragmant).commit();
                return true;
            }
        });
    }
}
