package com.jeffrey.academiccollage.basicPrograming;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.jeffrey.academiccollage.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FirebaseMessageOnEachScreen {

   private FirebaseFirestore db = FirebaseFirestore.getInstance();
   private ArrayList<AskMessageObject> allMessage=new ArrayList<>();
  private   Map<String, Object> messageMap = new HashMap<>();
  private Activity context;

    public ArrayList<AskMessageObject> getListOfMessage(String screenName){



        db.collection("qeustionOnScreen").document(screenName).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
            }
        });
        return  allMessage;
    }

    public void saveMessageOnFireBase(AskMessageObject message, String screenName, final Activity context){
        this.context=context;
        allMessage.add(message);
        messageMap.put("allMessage",allMessage);
        db.collection("qeustionOnScreen").document(screenName).set(messageMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                LinearLayout linearLayout=context.findViewById(R.id.all_comment);
                linearLayout.removeAllViews();
                for (AskMessageObject message:allMessage) {

                    TextView messageToShow=new TextView(context);
                    messageToShow.setText(message.getTextToShow());
                    messageToShow.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

                    linearLayout.addView(messageToShow);
                }
            }
        });

    }

    public ArrayList<AskMessageObject> getAllMessage() {
        return allMessage;
    }

    public void setAllMessage(ArrayList<AskMessageObject> allMessage) {
        this.allMessage = allMessage;
    }
}
