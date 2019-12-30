package com.jeffrey.academiccollage.basicPrograming;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.jeffrey.academiccollage.BasicActivity;
import com.jeffrey.academiccollage.R;

import java.io.InputStream;
import java.util.Date;

public class ImplicitIntentExample extends BasicActivity {

    public int IMAGE_ADD=1;
    private FirebaseMessageOnEachScreen firebaseMessageOnEachScreen=new FirebaseMessageOnEachScreen();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent_example);
       /* loadMessage();
        addMessage();*/

    }

    private void addMessage(){
        Button button=findViewById(R.id.add_comment_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText commentText=findViewById(R.id.comment_add);
                EditText nameOfPerson=findViewById(R.id.name_of_person);
                firebaseMessageOnEachScreen.saveMessageOnFireBase(new AskMessageObject(nameOfPerson.getText().toString(),commentText.getText().toString(),new Date().toString()),"ImplicitIntentExample",ImplicitIntentExample.this);

            }
        });

    }
    private void loadMessage() {
        firebaseMessageOnEachScreen.getListOfMessage("ImplicitIntentExample",this);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==IMAGE_ADD&& resultCode == Activity.RESULT_OK)
        {
            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
              ImageView imageView= findViewById(R.id.add_images_example);
                imageView.setImageBitmap(selectedImage);
            }catch (Exception e)
            {

            }


        }
    }

    public void implicitIntentLiseners(View view){
        View v = null;
        Button b;
        switch (view.getId()) {
            case R.id.gmail:
                v=findViewById(R.id.gmail_scroll);

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
                v=findViewById(R.id.facebook_scroll);
                break;
            case R.id .image_pick:
                v=findViewById(R.id.images_scroll);
                break;
            case R.id.alarm:
                v=findViewById(R.id.alarm_scroll);

                break;
            case R.id.youtube:
                v=findViewById(R.id.youtube_scroll);

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

            case R.id.gmail_example:
                setTheGmailIntent();
                break;
            case R.id.youtube_example:
                setTheYoutubeIntent();
                break;
            case R.id.alarm_with_ui_example:
                setTheAlarmIntent(true);
                break;
            case R.id.alarm_without_ui_example:
                setTheAlarmIntent(false);
                break;
            case R.id.facebook_example:
                setTheFacebookIntent();
                break;
            case R.id.add_images_example:
                setTheImagePickIntent();
                break;
        }
        try {
            v.setVisibility(v.getVisibility()==View.VISIBLE?View.GONE:View.VISIBLE);
            b= (Button) view;
            b.setCompoundDrawablesWithIntrinsicBounds( v.getVisibility()==View.VISIBLE?R.drawable.ic_arrow_drop_up_black_24dp:R.drawable.ic_arrow_drop_down_black_24dp, 0, 0, 0);

        }catch (Exception e)
        {

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

    private void setTheAlarmIntent(boolean showUI) {


        Log.i("showUI",""+showUI);
        Intent alarm = new Intent(AlarmClock.ACTION_SET_ALARM);



        if(!showUI)
        {
            alarm .putExtra(AlarmClock.EXTRA_MESSAGE, "הודעה לשעון מעורר");
            alarm .putExtra(AlarmClock.EXTRA_HOUR, 10);
            alarm .putExtra(AlarmClock.EXTRA_MINUTES, 10);
            alarm.putExtra(AlarmClock.EXTRA_SKIP_UI, true);
        }


        try
        {
            startActivity(alarm);


        }catch (Exception e)
        {
            showError(e);
        }

    }

    private void setTheImagePickIntent() {

        Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        pickIntent.setType("image/*");
        try {
            startActivityForResult(Intent.createChooser(pickIntent, "Select Picture"), IMAGE_ADD);
        }catch (Exception e)
        {

        }



    }

    private void setTheFacebookIntent() {


        try
        {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/100000645632898"));

            startActivity(intent);

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