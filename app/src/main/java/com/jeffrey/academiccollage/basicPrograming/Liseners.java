package com.jeffrey.academiccollage.basicPrograming;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.jeffrey.academiccollage.BasicActivity;
import com.jeffrey.academiccollage.R;
import com.jeffrey.academiccollage.advancePrograming.ReceyclerViewMessageOnEachPage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class Liseners extends BasicActivity {
    private ArrayList<AskMessageObject> allMessage=new ArrayList<>();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liseners);
        textView=findViewById(R.id.label_to_change);
        addMessage();
        initRecyclerView();
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


    public void initRecyclerView() {

// TODO: 15/12/2018 איתחול של אובייקט מסוג recycelviev
        // TODO: 15/12/2018 אשר תפקידו הוא להציג לנו כמות מידע מסויימת לפי תבנית שהגדרנו מראש
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        layoutManager.setSmoothScrollbarEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.recycler_view_message);
        recyclerView.setLayoutManager(layoutManager);
        ReceyclerViewMessageOnEachPage adapter = new ReceyclerViewMessageOnEachPage("Liseners");
        recyclerView.setAdapter(adapter);
    }

    private void addMessage() {
        Button button = findViewById(R.id.add_comment_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveMessageOnFireBase();
                initRecyclerView();
            }
        });

    }

    public void saveMessageOnFireBase(){
        EditText commentText = findViewById(R.id.comment_add);
        EditText nameOfPerson = findViewById(R.id.name_of_person);
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm");
        String date = df.format(Calendar.getInstance().getTime());
        allMessage.add(new AskMessageObject(nameOfPerson.getText().toString(),commentText.getText().toString(),date));

        db.collection("Liseners").add(allMessage.get(allMessage.size()-1)).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                initRecyclerView();
            }
        });

    }
}
