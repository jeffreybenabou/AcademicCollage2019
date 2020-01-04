package com.jeffrey.academiccollage.advancePrograming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.jeffrey.academiccollage.R;
import com.jeffrey.academiccollage.basicPrograming.AskMessageObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class AnswerQestion extends AppCompatActivity {

    private ArrayList<AskMessageObject> allMessage=new ArrayList<>();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comment_section);
        initRecyclerView();
        addMessage();
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

        db.collection("answerQuestion").add(allMessage.get(allMessage.size()-1)).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                initRecyclerView();
            }
        });

    }

    public void initRecyclerView() {

// TODO: 15/12/2018 איתחול של אובייקט מסוג recycelviev
        // TODO: 15/12/2018 אשר תפקידו הוא להציג לנו כמות מידע מסויימת לפי תבנית שהגדרנו מראש
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        layoutManager.setSmoothScrollbarEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.recycler_view_message);
        recyclerView.setLayoutManager(layoutManager);
        ReceyclerViewMessageOnEachPage adapter = new ReceyclerViewMessageOnEachPage("answerQuestion");
        recyclerView.setAdapter(adapter);
    }

}
