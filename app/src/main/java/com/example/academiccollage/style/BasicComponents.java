package com.example.academiccollage.style;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.academiccollage.BasicActivity;
import com.example.academiccollage.R;

public class BasicComponents extends BasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_components);


    }

    public void showMenu(View view){
        View v = null;
        Button b;
        switch (view.getId())
        {
            case R.id.attribute:
                 v=findViewById(R.id.all_atribute);

                break;

            case R.id.basic_component:
                 v=findViewById(R.id.all_basic_component);

                break;


        }
        v.setVisibility(v.getVisibility()==View.VISIBLE?View.GONE:View.VISIBLE);
        b= (Button) view;
        b.setCompoundDrawablesWithIntrinsicBounds( v.getVisibility()==View.VISIBLE?R.drawable.ic_arrow_drop_up_black_24dp:R.drawable.ic_arrow_drop_down_black_24dp, 0, 0, 0);

    }


}
