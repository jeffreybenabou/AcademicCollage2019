package com.jeffrey.academiccollage.basicPrograming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

public class MoveBetweenScreens extends BasicActivity {

    private ArrayList<AskMessageObject> allMessage=new ArrayList<>();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    /*
    * נגדיר את האובייקטים שלנו פה בגלל שאנחנו רוצים לגשת לטקסט שלו בהמשך
    * */
    private EditText firstName;
    private EditText lastName;
    private EditText moreText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_between_screens);
        firstName=findViewById(R.id.first_name);
        lastName=findViewById(R.id.last_name);
        moreText=findViewById(R.id.more_text);
        findViewById(R.id.go_to_next_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToOtherScreen();
                finish();
            }
        });


        addMessage();
        initRecyclerView();
    }


    public void initRecyclerView() {

// TODO: 15/12/2018 איתחול של אובייקט מסוג recycelviev
        // TODO: 15/12/2018 אשר תפקידו הוא להציג לנו כמות מידע מסויימת לפי תבנית שהגדרנו מראש
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        layoutManager.setSmoothScrollbarEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.recycler_view_message);
        recyclerView.setLayoutManager(layoutManager);
        ReceyclerViewMessageOnEachPage adapter = new ReceyclerViewMessageOnEachPage("MoveBetweenScreens");
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

        db.collection("MoveBetweenScreens").add(allMessage.get(allMessage.size()-1)).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                initRecyclerView();
            }
        });

    }


    private void moveToOtherScreen(){
        Intent intent=new Intent(this,ScreenToMoveTo.class);
        intent.putExtra("firstName",firstName.getText().toString());
        intent.putExtra("lastName",lastName.getText().toString());
        intent.putExtra("moreText",moreText.getText().toString());
        startActivity(intent);
    }



}
