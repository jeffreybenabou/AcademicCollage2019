package com.jeffrey.academiccollage.basicPrograming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.jeffrey.academiccollage.BasicActivity;
import com.jeffrey.academiccollage.R;

import org.w3c.dom.Text;

import java.util.Map;

public class SharedPreferencesExample extends BasicActivity {

    private SharedPreferences colorSharedPreferences;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences_example);
        setTheSharedPreferencesFile();
        setTheTextToShow();
        setTheLisenersToInput();
        deleteData();
    }

    private void setTheTextToShow() {
        LinearLayout linearLayout=findViewById(R.id.layout_to_add_text);
        linearLayout.removeAllViews();

        String values="";
        String keysToShow="";
        Map<String,?> keys = colorSharedPreferences.getAll();

        int index=0;
        for(Map.Entry<String,?> entry : keys.entrySet()){

            LinearLayout column=new LinearLayout(this);
            column.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout left =new LinearLayout(this);
            LinearLayout right =new LinearLayout(this);
            left.setLayoutParams(new LinearLayout.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT,1f));
            right.setLayoutParams(new LinearLayout.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT,1f));
            column.setLayoutParams(new LinearLayout.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT,1f));

            if(index%2==0)
            {
                right.setBackgroundColor(Color.WHITE);
                left.setBackgroundColor(Color.WHITE);
            }
            else
            {
                right.setBackgroundColor(Color.LTGRAY);
                left.setBackgroundColor(Color.LTGRAY);
            }


            index++;
            values= entry.getValue().toString();
            keysToShow=entry.getKey();

            TextView valueTextView=new TextView(this);
            valueTextView.setText(values);
            valueTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            TableRow.LayoutParams params = new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT,1f);
            valueTextView.setLayoutParams(params);

            TextView keyTextView=new TextView(this);
            keyTextView.setText(keysToShow);
            keyTextView.setLayoutParams(params);
            keyTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            left.addView(valueTextView);
            right.addView(keyTextView);
            column.addView(left);
            column.addView(right);
            linearLayout.addView(  column);

        }

    }

    private void deleteData(){
        Button button=findViewById(R.id.delete_data);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colorSharedPreferences.edit().clear().apply();
                /*
                * מחיקת כל המידע שקיים בקובץ
                * */
                setTheTextToShow();
            }
        });
    }

    private void setTheLisenersToInput() {
        final EditText editText=findViewById(R.id.data_to_save_from_user);
        Button button =findViewById(R.id.save_data_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveTheData(editText.getText().toString());
                setTheTextToShow();
            }
        });
    }

    private void saveTheData(String texttoSaveOnPhone) {
        editor.putString(""+colorSharedPreferences.getAll().size(),texttoSaveOnPhone);
        editor.apply();
        /*
        * שמירת נתונים על גבי הקובץ שלנו הפרמטרים שהוא מצפה לקבל הוא מזהה ולאחר מכן איזה ערך להוסיף
        * */


    }

    private void setTheSharedPreferencesFile() {
        /*

       * מתודה זו מאתחל את האובייקט של שמירת הנתונים באמצעות getSharedPreferences
      המתודה מקבלת שני פרמטרים - האחד שם הקובץ והשני פרמטר שמגדיר לנו את הקובץ כפרטי
      במידה והקובץ כבר קיים במערכת הוא רק יקשר אותנו אל הקובץ במידה והוא לא קיים הוא ייצור קובץ חדש
        * */
        colorSharedPreferences = getSharedPreferences("text", MODE_PRIVATE);
        editor = colorSharedPreferences.edit();
        /*
        * האובייקט מסוג Editor
        * הוא אובייקט אשר מאפשר לנו לערוך את הקובץ שלנו ולשמור  עליו נתונים
        * */
        editor.apply();
        /*
        * חובה לקרוא למתודה הזו על מנת לאפשר לעשות שינויים בקובץ
        * */
    }

}
