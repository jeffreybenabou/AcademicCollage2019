package com.jeffrey.academiccollage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.jeffrey.academiccollage.basicPrograming.ImplicitIntentExample;
import com.jeffrey.academiccollage.basicPrograming.LifeCycle;
import com.jeffrey.academiccollage.basicPrograming.Liseners;
import com.jeffrey.academiccollage.basicPrograming.MoveBetweenScreens;
import com.jeffrey.academiccollage.basicPrograming.ObjectsExample;
import com.jeffrey.academiccollage.basicPrograming.SharedPreferencesExample;
import com.jeffrey.academiccollage.style.BasicComponents;
import com.jeffrey.academiccollage.style.Layouts;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* try {
            Log.i("getIntent().getExtras()",""+getIntent().getExtras());
            if(getIntent().getExtras().getString("BasicComponents")!=null)
            {
                Intent intent=new Intent(this,BasicComponents.class);
                startActivity(intent);
            }

        }catch (Exception e)
        {
            Log.i("error",""+ Arrays.toString(e.getStackTrace()));
        }*/
    }

    public String getEmojiByUnicode(int unicode){
        return new String(Character.toChars(unicode));
    }

    public void onButtonClick(View view )
    {
        /*
        * מתודה זו מחוברת אל כל הכפתורים שמאזינים לonClick בתבנית העיצוב
        * */
        Intent intentToStart=null;
        switch (view.getId())
        {
            case R.id.basic_component:
                intentToStart=new Intent(this, BasicComponents.class);

                break;
            case R.id.shared_preferences:
                intentToStart=new Intent(this, SharedPreferencesExample.class);

                break;
            case R.id.objects_example_button:
                intentToStart=new Intent(this, ObjectsExample.class);

                break;
            case R.id.basic_layout:
                intentToStart=new Intent(this, Layouts.class);

                break;
            case R.id.liseners:
                intentToStart=new Intent(this, Liseners.class);
                break;
            case R.id.life_cycle:
                intentToStart=new Intent(this, LifeCycle.class);
                break;
            case R.id.implicit_intent:
                intentToStart=new Intent(this, ImplicitIntentExample.class);
                break;
            case R.id.instegram:
            Toast.makeText(this,"תלוי רק בכם"+getEmojiByUnicode(0x1F60A),Toast.LENGTH_LONG).show();
            break;
            case R.id.move_between_screens:
            intentToStart=new Intent(this, MoveBetweenScreens.class);
            break;

        }
        if(intentToStart!=null)
        startActivity(intentToStart);
    }
}
