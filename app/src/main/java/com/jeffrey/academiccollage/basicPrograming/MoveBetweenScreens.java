package com.jeffrey.academiccollage.basicPrograming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.jeffrey.academiccollage.BasicActivity;
import com.jeffrey.academiccollage.R;

public class MoveBetweenScreens extends BasicActivity {

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
    }

    private void moveToOtherScreen(){
        Intent intent=new Intent(this,ScreenToMoveTo.class);
        intent.putExtra("firstName",firstName.getText().toString());
        intent.putExtra("lastName",lastName.getText().toString());
        intent.putExtra("moreText",moreText.getText().toString());
        startActivity(intent);
    }



}
