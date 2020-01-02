package com.jeffrey.academiccollage.basicPrograming;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jeffrey.academiccollage.BasicActivity;
import com.jeffrey.academiccollage.R;

public class ScreenToMoveTo extends BasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_to_move_to);
        TextView firstName=findViewById(R.id.first_name_get);
        TextView lastName=findViewById(R.id.last_name_get);
        TextView moreText=findViewById(R.id.more_text_get);

            firstName.setText(getIntent().getExtras().getString("firstName","לא הועבר מידע"));



            lastName.setText(getIntent().getExtras().getString("lastName","לא הועבר מידע"));



            moreText.setText(getIntent().getExtras().getString("moreText","לא הועבר מידע"));


        findViewById(R.id.go_back_to_previous_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ScreenToMoveTo.this,MoveBetweenScreens.class));
                finish();
            }
        });

    }
}
