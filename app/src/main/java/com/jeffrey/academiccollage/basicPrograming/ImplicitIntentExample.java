package com.jeffrey.academiccollage.basicPrograming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import com.jeffrey.academiccollage.R;

public class ImplicitIntentExample extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent_example    );

    }





    public void implicitIntentLiseners(View view){
        switch (view.getId()) {
            case R.id.gmail:
                setTheGmailIntent();
                break;
            case R.id.send_text:
                setTheTextIntent();
                break;
            case R.id.phone_call:
                setThePhoneCallIntent();
                break;
            case R.id.instegram:
                setTheInstegramIntent();
                break;
            case R.id.facebook:
                setTheFacebookIntent();
                break;
            case R.id .image_pick:
                setTheImagePickIntent();
                break;
            case R.id.alarm:
                setTheAlarmIntent();
                break;
            case R.id.youtube:
                setTheYoutubeIntent();
                break;
            case R.id.calander:
                setTheCalenderIntent();
                break;
            case R.id.maps:
                setTheMapIntent();
                break;
            case R.id.camera:
                setTheCameraIntent();
                break;
        }
    }


    private void setTheMapIntent() {

        Uri uri = Uri.parse("geo:0,0?q=Ashqelon+collage%2C");
        Intent map = new Intent(Intent.ACTION_VIEW);
        map.setData(uri);

        try {
            startActivity(map);

        } catch (Exception e) {
            showError(e);
        }


    }

    private void setTheCameraIntent() {


        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        try
        {
            startActivity(camera);


        }catch (Exception e)
        {
            showError(e);
        }


    }

    private void setTheCalenderIntent() {

        Intent calander = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, 0)
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, 5000)
                .putExtra(CalendarContract.Events.TITLE, "תזכורת")
                .putExtra(CalendarContract.Events.DESCRIPTION, "אין על אנדרואיד")
                .putExtra(CalendarContract.Events.EVENT_LOCATION, "מכללת אשקלון")
                .putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY);
        try
        {
            startActivity(calander);

        }catch (Exception e)
        {
            showError(e);
        }

    }

    private void setTheYoutubeIntent() {

        Intent youtube = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + "fTbzkT6lOdw"));
        try {
            startActivity(youtube);

        } catch (Exception e) {
            showError(e);
        }

    }

    private void setTheAlarmIntent() {


        Intent alarm = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "הודעה לשעון מעורר")
                .putExtra(AlarmClock.EXTRA_HOUR, 10)
                .putExtra(AlarmClock.EXTRA_MINUTES, 10);
        try
        {
            startActivity(alarm);


        }catch (Exception e)
        {
            showError(e);
        }

    }

    private void setTheImagePickIntent() {

        Intent  pickImage = new Intent(Intent.ACTION_PICK);
        pickImage.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, false);
        pickImage.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
        pickImage.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        pickImage.setType("image/*");
        try
        {
            startActivity(pickImage);

        }catch (Exception e)
        {
            showError(e);
        }

    }

    private void setTheFacebookIntent() {

        Intent facebook = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/21212121"));
        try
        {
            startActivity(facebook);


        }catch (Exception e)
        {
            showError(e);
        }






    }

    private void showError(Exception e) {
        Toast.makeText(this,"אין אפשרות להפעיל פעילות זו במכשיר זה.",Toast.LENGTH_LONG).show();
        e.printStackTrace();
    }

    private void setTheInstegramIntent() {

        Intent instegram = new Intent(Intent.ACTION_VIEW,  Uri.parse("http://instagram.com/_u/android"));
        instegram.setPackage("com.instagram.android");

        try {
            startActivity(instegram);
        } catch (Exception e) {
            showError(e);
        }



    }

    private void setThePhoneCallIntent() {

        Intent phoneCall = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "0500000000", null));
        try
        {
            startActivity(phoneCall);
        }catch (Exception e)
        {
            showError(e);
        }


    }

    private void setTheTextIntent() {



        Intent textMessage = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:0500000000"));
        textMessage.putExtra("sms_body", "כאן תיהיה הודעה כלשהיא כמובן להשתמש בשדות ולא כמו שעשיתי פה ");
        try
        {
            startActivity(textMessage);
        }catch (Exception e)
        {
            showError(e);
        }



    }

    private void setTheGmailIntent(){
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", "jeffreybenabou@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,"נושא");
        emailIntent.putExtra(Intent.EXTRA_TEXT,"מלל מובנה כלשהוא שנרצה לתת למשתמש כברירת מחדל ");

        try
        {
            startActivity(emailIntent);
        }catch (Exception e)
        {
            showError(e);

        }
    }



}