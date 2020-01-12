package com.jeffrey.academiccollage.advancePrograming;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.jeffrey.academiccollage.R;
import com.jeffrey.academiccollage.basicPrograming.AskMessageObject;

import java.util.ArrayList;

public class ReceyclerViewMessageOnEachPage extends RecyclerView.Adapter<ReceyclerViewMessageOnEachPage.ViewHolder>{

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private ArrayList<AskMessageObject> allMessageOnPage=new ArrayList<>();
    private String nameOfScreen;


    public ReceyclerViewMessageOnEachPage(String nameOfScreen){
        this.nameOfScreen=nameOfScreen;
        loadMessage();
    }

    private void loadMessage() {
        db.collection(nameOfScreen).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (int i = 0,j=queryDocumentSnapshots.getDocuments().size()-1; i <queryDocumentSnapshots.getDocuments().size() ; i++,j--) {
                    allMessageOnPage.add(queryDocumentSnapshots.getDocuments().get(j).toObject(AskMessageObject.class));
                    notifyItemChanged(i);
                }

            }
        });

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_message_object,viewGroup,false);

        /// TODO: 10/02/2019   תפקיד המתודה הזו היא להגדיר לנו את תבנית העיצוב שתשמש אותנו לייצוג נתונים של אובייקט כלשהוא
        // TODO: 10/02/2019 יש לבנות תבנית עיצוב כלשהיא שתייצג לנו א האובייקט שנרצה להציג
        // TODO: 12/02/2019 במקרה הזה תבנית העיצוב שמייצגת היא התבנית הבאה:
        // TODO: 12/02/2019     R.layout.recycler_view_example
        return new ViewHolder(view);

    }




    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i)
    {
        // TODO: 12/02/2019 מתודה זו תפקידה היא להכיל את המידע מתוך ייצוג נתונים כלשהוא אל תוך תבנית העיצוב
        // TODO: 12/02/2019 במקרה הזה ייצוג הנתונים הוא מערך שלוקח מידע מתוך שרת ושומר אותו במערך
        viewHolder.name.setText(allMessageOnPage.get(i).getNameOfSender());
        viewHolder.textToShow.setText(allMessageOnPage.get(i).getTextToShow());
        viewHolder.timeCommented.setText(allMessageOnPage.get(i).getTimeCommented());

    }

    @Override
    public int getItemCount() {
        return allMessageOnPage.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name,textToShow,timeCommented;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.writer_of_message);
            textToShow=itemView.findViewById(R.id.content_of_message);
            timeCommented=itemView.findViewById(R.id.time_of_message);
        }
    }

}
