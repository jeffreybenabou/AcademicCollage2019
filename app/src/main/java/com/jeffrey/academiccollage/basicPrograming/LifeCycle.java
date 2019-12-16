package com.jeffrey.academiccollage.basicPrograming;


import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.jeffrey.academiccollage.BasicActivity;
import com.jeffrey.academiccollage.R;
import com.github.chrisbanes.photoview.PhotoView;

public class LifeCycle extends BasicActivity {
    PhotoView photoView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        Toast.makeText(this,"create",Toast.LENGTH_LONG).show();
       photoView= (PhotoView) findViewById(R.id.life_cycle_photo);
       findViewById(R.id.show_destro_method_button).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               finish();
           }
       });
    }
    /** Called when the activity is about to become visible. */
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"start",Toast.LENGTH_LONG).show();

    }

    /** Called when the activity has become visible. */
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"resume",Toast.LENGTH_LONG).show();

    }

    /** Called when another activity is taking focus. */
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"pause",Toast.LENGTH_LONG).show();

    }

    /** Called when the activity is no longer visible. */
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"stop",Toast.LENGTH_LONG).show();

    }

    /** Called just before the activity is destroyed. */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"destroy",Toast.LENGTH_LONG).show();
    }
}
