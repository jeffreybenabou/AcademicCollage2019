package com.jeffrey.academiccollage;


import android.os.Bundle;
import android.view.MenuItem;


import androidx.appcompat.app.AppCompatActivity;


public class BasicActivity extends AppCompatActivity {
static int imageToShow=0;
    /*
    *
    *
    * מחלקה זו מורישה לכל פעילות במערכת על מנת לממש את עניין כפתור החזור שמופיע למעלה בבר
    * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /*
        * שורה זו אחראית להציג את כפתור החזור במסך למעלה
        *
        * */



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*
        * מתודה שמיממשתי שאחראית על פעולה בעת לחיצה על החץ למעלה
        * */
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
