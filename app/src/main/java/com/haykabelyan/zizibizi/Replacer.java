package com.haykabelyan.zizibizi;

import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Replacer extends AppCompatActivity {

    EditText editText2, editText3, textArea1, textArea2;
    ImageView imageView;
    boolean doubleBackToExitPressedOnce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replacer);
        imageView = (ImageView) findViewById(R.id.imageView);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        textArea1 = (EditText) findViewById(R.id.textArea1);
        textArea2 = (EditText) findViewById(R.id.textArea2);

        imageView.setOnClickListener(new View.OnClickListener() {
            int count;

            @Override
            public void onClick(View v) {
                if (textArea1.getText().length() > 0 && editText2.getText().length() > 0) {
                    for (int i = 0; i < textArea1.getText().length() - editText2.getText().length() + 1; i++)
                        for (int j = i + editText2.getText().length(); j <= textArea1.getText().length(); j++)
                            if (textArea1.getText().toString().substring(i, j).equals(editText2.getText().toString()))
                                count++;
                    if (count == 0) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(Replacer.this);
                        builder.setTitle("Վերջ")
                                .setMessage("Տեքստը չի գտնվել:")
                                .setIcon(getResources().getDrawable(R.drawable.text))
                                .setCancelable(false)
                                .setNegativeButton("Լավ",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                textArea2.setText(textArea1.getText());
                                            }
                                        });
                        AlertDialog alert = builder.create();
                        alert.show();
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(Replacer.this);
                        builder.setTitle("Վերջ")
                                .setMessage("Կատարվել է " + count + " փոփոխություն:")
                                .setIcon(getResources().getDrawable(R.drawable.text))
                                .setCancelable(false)
                                .setNegativeButton("Լավ",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                textArea2.setText(textArea1.getText().toString().replaceAll(editText2.getText().toString(),
                                                        editText3.getText().toString()));
                                            }
                                        });
                        AlertDialog alert = builder.create();
                        alert.show();
                        count = 0;
                    }
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Դուրս գալու համար ևս մեկ անգամ սեղմեք:", Toast.LENGTH_LONG).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 5000);
    }
}