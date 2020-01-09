package com.jeffrey.academiccollage.basicPrograming;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.jeffrey.academiccollage.BasicActivity;
import com.jeffrey.academiccollage.R;

public class DialogExample extends BasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_example);
        setTheDialogButtonsLiseners();

    }

    private void setTheDialogButtonsLiseners() {
        findViewById(R.id.button_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DialogExample.this);
                builder.setMessage("הודעה כלשהיא")
                        .setTitle("כותרת להודעה")
                .setPositiveButton("אשר", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogExample.this,"לחצת על כפתור אשר",Toast.LENGTH_LONG).show();

                    }
                }).setNegativeButton("ביטול", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogExample.this,"לחצת על כפתור ביטול",Toast.LENGTH_LONG).show();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        findViewById(R.id.normal_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DialogExample.this);
                builder.setMessage("הודעה כלשהיא")
                        .setTitle("כותרת להודעה");
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });

        findViewById(R.id.design_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = DialogExample.this.getLayoutInflater();

                AlertDialog.Builder builder = new AlertDialog.Builder(DialogExample.this);
                builder.setView(inflater.inflate(R.layout.dialog, null))
                        .setPositiveButton("יפה", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(DialogExample.this,"אני יודע.",Toast.LENGTH_LONG).show();

                            }
                        }).setNegativeButton("מכוער", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogExample.this,"הלוגו הכי יפה שיש.",Toast.LENGTH_LONG).show();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}
