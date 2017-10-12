package com.haykabelyan.zizibizi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Generator extends AppCompatActivity {

    EditText editText;
    Button button;
    Spinner spinner;
    TextView textView;
    int length = 6;
    boolean capitals, numbers, smalls;
    String[] lengths = {"  6", "  7", "  8", "  9", " 10", " 11", " 12"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generator);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button4);
        spinner = (Spinner) findViewById(R.id.spinner);
        textView = (TextView) findViewById(R.id.textView3);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.simple_spinner_item, lengths);
        adapter.setDropDownViewResource(R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                length = 6 + position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            double def;

            @Override
            public void onClick(View v) {
                capitals = false;
                numbers = false;
                smalls = false;
                char[] parol = new char[length];
                for (int i = 0; i < length; i++) {
                    def = Math.random();
                    if (def < 0.33) {
                        parol[i] = (char) (48 + (int) (Math.random() * 10));
                        numbers = true;
                    }
                    if (def >= 0.33 && def <= 0.67) {
                        parol[i] = (char) (97 + (int) (Math.random() * 26));
                        smalls = true;
                    }
                    if (def > 0.67) {
                        parol[i] = (char) (65 + (int) (Math.random() * 26));
                        capitals = true;
                    }
                }
                if (!numbers)
                    parol[length - 1] = (char) (48 + (int) (Math.random() * 10));
                if (!capitals) {
                    parol[0] = (char) (65 + (int) (Math.random() * 26));
                    parol[1] = (char) (97 + (int) (Math.random() * 26));
                    parol[length - 1] = (char) (48 + (int) (Math.random() * 10));
                }
                if (!smalls) {
                    parol[0] = (char) (97 + (int) (Math.random() * 26));
                    parol[1] = (char) (65 + (int) (Math.random() * 26));
                    parol[length - 1] = (char) (48 + (int) (Math.random() * 10));
                }
                String password = new String(parol);
                editText.setText(password);
                textView.setText("   Հիմա կարող եք գրել, մտապահել, կամ պատճենել գաղտնաբառը՝ " +
                        "երկար սեղմած պահելով այն: Եթե գաղտնաբառը Ձեր դուրը չի եկել, " +
                        "նորից գեներացրեք");
            }
        });
    }
}