package com.jeffrey.academiccollage.basicPrograming;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jeffrey.academiccollage.BasicActivity;
import com.jeffrey.academiccollage.R;

import java.util.Random;

public class Liseners extends BasicActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liseners);
        textView=findViewById(R.id.label_to_change);
    }
    public void onClick(View view){
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        switch (view.getId())
        {
            case R.id.background_color:

                textView.setBackgroundColor(color);
                break;
            case R.id.text_color:
                textView.setTextColor(color);
                break;

        }
    }
}
