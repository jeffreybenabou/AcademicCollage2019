package com.jeffrey.academiccollage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.jeffrey.academiccollage.advancePrograming.AnimationExample;
import com.jeffrey.academiccollage.advancePrograming.AnswerQestion;
import com.jeffrey.academiccollage.advancePrograming.Fragment.example1.BottomNavigation;
import com.jeffrey.academiccollage.advancePrograming.RecyclerExample.RecyclerViewExample;
import com.jeffrey.academiccollage.advancePrograming.SwipeRefreshControl;
import com.jeffrey.academiccollage.advancePrograming.ThreadExample;
import com.jeffrey.academiccollage.basicPrograming.DialogExample;
import com.jeffrey.academiccollage.basicPrograming.GifExample;
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
            case R.id.fragment_example:
                intentToStart=new Intent(this, BottomNavigation.class);

                break;
            case R.id.gif_example:
                intentToStart=new Intent(this, GifExample.class);

                break;
            case R.id.animation_button:
                intentToStart=new Intent(this, AnimationExample.class);

                break;
            case R.id.thread_example:
                intentToStart=new Intent(this, ThreadExample.class);

                break;

            case R.id.recycler_example:
                intentToStart=new Intent(this, RecyclerViewExample.class);
                break;


            case R.id.swep_refresh_button:
                intentToStart=new Intent(this, SwipeRefreshControl.class);

                break;
            case R.id.dialog_example:
                intentToStart=new Intent(this, DialogExample.class);

                break;
            case R.id.answer_qeustion_button:
                intentToStart=new Intent(this, AnswerQestion.class);

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
