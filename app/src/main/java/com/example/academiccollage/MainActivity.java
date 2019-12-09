package com.example.academiccollage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.academiccollage.basicPrograming.LifeCycle;
import com.example.academiccollage.basicPrograming.Liseners;
import com.example.academiccollage.style.BasicComponents;
import com.example.academiccollage.style.Layouts;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onButtonClick(View view )
    {
        /*
        * מתודה זו מחוברת אל כל הכפתורים שמאזינים לonClick בתבנית העיצוב
        * */
        Intent intentToStart=new Intent(this,this.getClass());
        switch (view.getId())
        {
            case R.id.basic_component:
                intentToStart=new Intent(this, BasicComponents.class);

                break;
            case R.id.basic_layout:
                intentToStart=new Intent(this, Layouts.class);

                break;
            case R.id.liseners:
                intentToStart=new Intent(this, Liseners.class);
                break;
            case R.id.life_cycle:
                intentToStart=new Intent(this, LifeCycle.class);
                break;
        }
        startActivity(intentToStart);
    }
}
