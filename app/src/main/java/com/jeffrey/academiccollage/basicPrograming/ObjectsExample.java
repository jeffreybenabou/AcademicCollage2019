package com.jeffrey.academiccollage.basicPrograming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

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

public class ObjectsExample extends BasicActivity {

    private ArrayList<Person> persons = new ArrayList<>();
    private LinearLayout scrollView;
    private ArrayList<AskMessageObject> allMessage=new ArrayList<>();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objects_example);
        Random random = new Random();
         scrollView=findViewById(R.id.person_scroll_view);

        for (int i = 0; i < 5; i++) {
            persons.add(new Person("שם פרטי: ג׳פרי " + i+1, "מספר פלאפון:" + random.nextInt(), R.drawable.ic_launcher_background, "כסף בבנק:" + random.nextInt(80000)+2000));
            addViewToScrollView(persons.get(i).getName(),persons.get(i).getPhoneNumber(),persons.get(i).getImageId(),persons.get(i).getMoneyInBank());

        }

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
        ReceyclerViewMessageOnEachPage adapter = new ReceyclerViewMessageOnEachPage("ObjectsExample");
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

        db.collection("ObjectsExample").add(allMessage.get(allMessage.size()-1)).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                initRecyclerView();
            }
        });

    }
    public void addViewToScrollView(String name,String phone,int photoId,String moneyInBank){


        TextView nameOfUser = new TextView(this);
        nameOfUser.setText(name);
        nameOfUser.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        nameOfUser.setTextColor(Color.parseColor("#ffffff"));


        TextView phoneNumber = new TextView(this);
        phoneNumber.setText(phone);
        phoneNumber.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        phoneNumber.setTextColor(Color.parseColor("#ffffff"));

        TextView userPhoto = new TextView(this);
        userPhoto.setText("תמונת המשתמש");
        userPhoto.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        userPhoto.setTextColor(Color.parseColor("#ffffff"));
        userPhoto.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);


        TextView moneyInBankText = new TextView(this);
        moneyInBankText.setText(moneyInBank);
        moneyInBankText.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        moneyInBankText.setTextColor(Color.parseColor("#ffffff"));

        ImageView imageView=new ImageView(this);
        imageView.setImageResource(photoId);
        moneyInBankText.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));


        View v = new View(this);
        v.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                5
        ));
        v.setBackgroundColor(Color.parseColor("#B3B3B3"));


        scrollView.addView(userPhoto);
        scrollView.addView(imageView);
        scrollView.addView(nameOfUser);
        scrollView.addView(phoneNumber);
        scrollView.addView(moneyInBankText);
        scrollView.addView(v);

    }
}
