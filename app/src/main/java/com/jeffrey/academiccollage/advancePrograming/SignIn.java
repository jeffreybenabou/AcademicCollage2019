package com.jeffrey.academiccollage.advancePrograming;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.VideoView;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.jeffrey.academiccollage.MainActivity;
import com.jeffrey.academiccollage.R;
import com.jeffrey.academiccollage.basicPrograming.Person;

import java.util.Collections;
import java.util.List;

public class SignIn extends AppCompatActivity {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private List<AuthUI.IdpConfig> providers = Collections.singletonList(
            new AuthUI.IdpConfig.GoogleBuilder().build()
    );
    private VideoView videov;
    private EditText userInput;
    private         FirebaseUser user ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        videov=findViewById(R.id.login_video);
        userInput=findViewById(R.id.user_name_input);
        user = FirebaseAuth.getInstance().getCurrentUser();
        onPressButton();
        checkIfUserIsLogIn();




    }

    private void checkIfUserIsLogIn(){
        if (user != null)
        {
            startMainActivity();
        }

        videoPlay();
    }

    private void onPressButton() {
        findViewById(R.id.log_in_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(userInput.getText().toString().length()>4)
                {
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setAvailableProviders(providers)
                                    .build(),
                            0);
                }else
                {
                    ObjectAnimator animation;
                    userInput.setError("יש להזין שם מלא בעל 4 ספרות ומעלה");
                    animation = ObjectAnimator.ofFloat(view,  "rotation", 0f, 10f,0f);
                    animation.setDuration(100);
                    animation.setRepeatCount(1);

                    animation.start();
                }


            }
        });
    }

    private void saveUserDataOnFireBase(){
        user = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(this, new OnSuccessListener<InstanceIdResult>() {
            @Override
            public void onSuccess(InstanceIdResult instanceIdResult) {
                String newToken = instanceIdResult.getToken();
                try {
                    db.collection("users").document(user.getEmail()).set(new Person(userInput.getText().toString(),newToken,0,user.getEmail())).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            startMainActivity();
                        }
                    });

                }catch (Exception e)
                {
                    System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaa"+e);
                }

            }
        });


    }

    private void startMainActivity(){
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
    public void videoPlay(){
        String videopath =
                "android.resource://"+getPackageName()+"/"+R.raw.video ;
        Uri uri = Uri.parse(videopath);
        videov.setVideoURI(uri);

        videov.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                videov.start();
                mediaPlayer.setLooping(true);
            }
        });
}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                saveUserDataOnFireBase();

            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
            }
        }
    }

}
