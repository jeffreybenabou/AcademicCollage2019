package com.jeffrey.academiccollage.advancePrograming.RecyclerExample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jeffrey.academiccollage.BasicActivity;
import com.jeffrey.academiccollage.R;

public class RecyclerViewExample extends BasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_example);
        findViewById(R.id.recycler_example_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecyclerViewExample.this,RecyclerExampleVacation.class));

            }
        });

    }
}
