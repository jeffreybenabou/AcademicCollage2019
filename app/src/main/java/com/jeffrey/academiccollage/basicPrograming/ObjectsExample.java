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
