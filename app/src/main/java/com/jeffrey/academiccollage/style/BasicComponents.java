package com.jeffrey.academiccollage.style;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.jeffrey.academiccollage.BasicActivity;
import com.jeffrey.academiccollage.R;
import com.jeffrey.academiccollage.advancePrograming.ReceyclerViewMessageOnEachPage;
import com.jeffrey.academiccollage.basicPrograming.AskMessageObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

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
