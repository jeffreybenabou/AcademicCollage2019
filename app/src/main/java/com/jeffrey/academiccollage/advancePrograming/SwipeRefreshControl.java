package com.jeffrey.academiccollage.advancePrograming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.jeffrey.academiccollage.BasicActivity;
import com.jeffrey.academiccollage.R;
import java.util.HashMap;

public class SwipeRefreshControl extends BasicActivity {
    private TextView textToShow;
    private EditText textToSendToServer;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private  SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh_control);
        setTheSwiperLiseners();
        setTheTextViewLiseners();
        setTheInputLiseners();
        setTheSnackBar();


    }

    private void setTheSnackBar() {

        Snackbar snackbar = Snackbar
                .make(swipeRefreshLayout, "www.journaldev.com", Snackbar.LENGTH_INDEFINITE).setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar snackbar1 = Snackbar.make(swipeRefreshLayout, "Message is restored!", Snackbar.LENGTH_SHORT);
                        snackbar1.show();
                    }
                });
        snackbar.setActionTextColor(Color.parseColor("#ffffff"));
        View snackBarView = snackbar.getView();

        snackBarView.setBackgroundColor(Color.parseColor("#ffffff"));
        snackbar.show();
    }

    private void setTheInputLiseners() {
        textToSendToServer=findViewById(R.id.input_to_send_to_server);
        final HashMap<String,String>hashMap=new HashMap<>();
        findViewById(R.id.send_message_to_server).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hashMap.put("textToSendToServer",textToSendToServer.getText().toString());

                db.collection("swipeExample").document("textToSendToServer").set(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(SwipeRefreshControl.this, "המידע התקבל בשרת, יש לבצע ריענון.", Toast.LENGTH_LONG).show();

                    }
                });

            }
        });
    }

    private void setTheTextViewLiseners() {
        textToShow=findViewById(R.id.server_text);

    }

    private void setTheSwiperLiseners() {
        swipeRefreshLayout=findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(SwipeRefreshControl.this,"ריענון נתונים בוצע בהצלחה",Toast.LENGTH_LONG).show();
                db.collection("swipeExample").document("textToSendToServer").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        textToShow.setText(""+task.getResult().get("textToSendToServer"));
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });

            }
        });

    }


}
