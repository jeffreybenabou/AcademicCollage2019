package com.jeffrey.academiccollage.advancePrograming.RecyclerExample;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.jeffrey.academiccollage.BasicActivity;
import com.jeffrey.academiccollage.R;

import java.util.ArrayList;

public class RecyclerExampleVacation extends BasicActivity {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private EditText title,description,price;
    private View dialogView;
private Adapter adapter;
    private ArrayList<Vacation> vacations=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_example_vacation);
        loadRecyclerView();
        loadListOfUsers();

        findViewById(R.id.add_new_user).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(RecyclerExampleVacation.this);
// ...Irrelevant code for customizing the buttons and title
                LayoutInflater inflater = RecyclerExampleVacation.this.getLayoutInflater();
                 dialogView = inflater.inflate(R.layout.input_dialog, null);
                dialogBuilder.setView(dialogView);

                dialogBuilder.setPositiveButton("הוסף יעד", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Vacation vacation = new Vacation(title.getText().toString(), description.getText().toString(), price.getText().toString());


                        db.collection("vacation").add(vacation).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {

                                adapter.notifyItemChanged(vacations.size());

                            }
                        });


                    }
                }).setNegativeButton("בטל", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                 title = (EditText) dialogView.findViewById(R.id.title_of_vacation);
                description = (EditText) dialogView.findViewById(R.id.description_of_vacation);
                price = (EditText) dialogView.findViewById(R.id.price_of_vacation);
                AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();
            }
        });


    }

    private void loadListOfUsers(){
        db.collection("vacation").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (int i = 0; i <queryDocumentSnapshots.getDocuments().size() ; i++) {
                    vacations.add(queryDocumentSnapshots.getDocuments().get(i).toObject(Vacation.class));
                    adapter.notifyItemChanged(i);
                }


            }
        });
    }


    private void loadRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        layoutManager.setSmoothScrollbarEnabled(true);
        RecyclerView recyclerView = findViewById(R.id.vacation_recycler);
        recyclerView.setLayoutManager(layoutManager);
         adapter = new Adapter(vacations);
        recyclerView.setAdapter(adapter);
    }


}
