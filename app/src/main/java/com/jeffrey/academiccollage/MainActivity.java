package com.jeffrey.academiccollage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.jeffrey.academiccollage.basicPrograming.LifeCycle;
import com.jeffrey.academiccollage.basicPrograming.Liseners;
import com.jeffrey.academiccollage.style.BasicComponents;
import com.jeffrey.academiccollage.style.Layouts;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            Log.i("getIntent().getExtras()",""+getIntent().getExtras());
            if(getIntent().getExtras().getString("BasicComponents")!=null)
            {
                Intent intent=new Intent(this,BasicComponents.class);
                startActivity(intent);
            }

        }catch (Exception e)
        {
            Log.i("error",""+ Arrays.toString(e.getStackTrace()));
        }
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
