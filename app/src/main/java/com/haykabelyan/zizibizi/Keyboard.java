package com.haykabelyan.zizibizi;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class Keyboard extends AppCompatActivity implements View.OnClickListener {

    Button[] buttons;
    Button enter, space, back;
    CheckBox checkBox;
    EditText textArea;
    boolean doubleBackToExitPressedOnce;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard);
        textArea = (EditText) findViewById(R.id.textArea);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
//        checkBoxSystem = (CheckBox) findViewById(R.id.checkBoxSystem);
        enter = (Button) findViewById(R.id.buttonenter);
        space = (Button) findViewById(R.id.buttonspace);
        back = (Button) findViewById(R.id.buttonback);
        enter.setOnClickListener(this);
        space.setOnClickListener(this);
        back.setOnClickListener(this);
        buttons = new Button[51];
        buttons[0] = (Button) findViewById(R.id.buttona);
        buttons[1] = (Button) findViewById(R.id.buttonb);
        buttons[2] = (Button) findViewById(R.id.buttong);
        buttons[3] = (Button) findViewById(R.id.buttond);
        buttons[4] = (Button) findViewById(R.id.buttone);
        buttons[5] = (Button) findViewById(R.id.buttonz);
        buttons[6] = (Button) findViewById(R.id.buttonee);
        buttons[7] = (Button) findViewById(R.id.buttoneee);
        buttons[8] = (Button) findViewById(R.id.buttonth);
        buttons[9] = (Button) findViewById(R.id.buttonzh);
        buttons[10] = (Button) findViewById(R.id.buttoni);
        buttons[11] = (Button) findViewById(R.id.buttonl);
        buttons[12] = (Button) findViewById(R.id.buttonkh);
        buttons[13] = (Button) findViewById(R.id.buttonts);
        buttons[14] = (Button) findViewById(R.id.buttonk);
        buttons[15] = (Button) findViewById(R.id.buttonh);
        buttons[16] = (Button) findViewById(R.id.buttondz);
        buttons[17] = (Button) findViewById(R.id.buttongh);
        buttons[18] = (Button) findViewById(R.id.buttontsh);
        buttons[19] = (Button) findViewById(R.id.buttonm);
        buttons[20] = (Button) findViewById(R.id.buttony);
        buttons[21] = (Button) findViewById(R.id.buttonn);
        buttons[22] = (Button) findViewById(R.id.buttonsh);
        buttons[23] = (Button) findViewById(R.id.buttono);
        buttons[24] = (Button) findViewById(R.id.buttonch);
        buttons[25] = (Button) findViewById(R.id.buttonp);
        buttons[26] = (Button) findViewById(R.id.buttonj);
        buttons[27] = (Button) findViewById(R.id.buttonrr);
        buttons[28] = (Button) findViewById(R.id.buttons);
        buttons[29] = (Button) findViewById(R.id.buttonv);
        buttons[30] = (Button) findViewById(R.id.buttont);
        buttons[31] = (Button) findViewById(R.id.buttonr);
        buttons[32] = (Button) findViewById(R.id.buttonc);
        buttons[33] = (Button) findViewById(R.id.buttonu);
        buttons[34] = (Button) findViewById(R.id.buttonph);
        buttons[35] = (Button) findViewById(R.id.buttonq);
        buttons[36] = (Button) findViewById(R.id.buttonev);
        buttons[37] = (Button) findViewById(R.id.buttonoo);
        buttons[38] = (Button) findViewById(R.id.buttonf);
        buttons[39] = (Button) findViewById(R.id.buttonuu);
        buttons[40] = (Button) findViewById(R.id.buttonverjaket);
        buttons[41] = (Button) findViewById(R.id.buttonstoraket);
        buttons[42] = (Button) findViewById(R.id.buttonket);
        buttons[43] = (Button) findViewById(R.id.buttonharcakan);
        buttons[44] = (Button) findViewById(R.id.buttonbacakanchakan);
        buttons[45] = (Button) findViewById(R.id.buttonshesht);
        buttons[46] = (Button) findViewById(R.id.buttonbut);
        buttons[47] = (Button) findViewById(R.id.buttonch1);
        buttons[48] = (Button) findViewById(R.id.buttonch2);
        buttons[49] = (Button) findViewById(R.id.buttonp1);
        buttons[50] = (Button) findViewById(R.id.buttonp2);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                int start = Math.max(textArea.getSelectionStart(), 0);
                int end = Math.max(textArea.getSelectionEnd(), 0);
                textArea.getText().replace(Math.min(start, end), Math.max(start, end),
                        button.getText().toString(), 0, 1);
            }
        };

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                switch (buttons[0].getText().toString()) {
                    case "ա":
                        for (int i = 0; i < 40; i++)
                            if (i != 36)
                                buttons[i].setText(buttons[i].getText().toString().toUpperCase());
                        break;
                    case "Ա":
                        for (int i = 0; i < 40; i++)
                            if (i != 36)
                                buttons[i].setText(buttons[i].getText().toString().toLowerCase());
                        break;
                }
            }
        });

//        checkBoxSystem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (checkBoxSystem.isChecked()) {
//                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                    imm.showSoftInput(textArea, InputMethodManager.SHOW_IMPLICIT);
//                    textArea.setSelection(textArea.getText().length());
//                    textArea.setMinLines(5);
//                    textArea.setLines(5);
//                    textArea.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
//                } else {
//                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                    imm.hideSoftInputFromWindow(textArea.getWindowToken(), 0);
//                    textArea.setMinLines(5);
//                    textArea.setLines(5);
//                    textArea.setInputType(InputType.TYPE_NULL);
//                }
//            }
//        });

        for (int i = 0; i < 51; i++)
            buttons[i].setOnClickListener(onClickListener);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonspace:
                int start = Math.max(textArea.getSelectionStart(), 0);
                int end = Math.max(textArea.getSelectionEnd(), 0);
                textArea.getText().replace(Math.min(start, end), Math.max(start, end), "\r", 0, 1);
                break;
            case R.id.buttonenter:
                int start1 = Math.max(textArea.getSelectionStart(), 0);
                int end1 = Math.max(textArea.getSelectionEnd(), 0);
                textArea.getText().replace(Math.min(start1, end1), Math.max(start1, end1), "\n", 0, 1);
                break;
            case R.id.buttonback:
                int pos = textArea.getSelectionStart();
                if (pos > 0) {
                    if (textArea.getSelectionStart() < textArea.getSelectionEnd()) {
                        text = textArea.getText().delete(textArea.getSelectionStart(), textArea.getSelectionEnd()).toString();
                        textArea.setSelection(textArea.getSelectionStart());
                    } else {
                        text = textArea.getText().delete(pos - 1, pos).toString();
                        textArea.setText(text);
                        textArea.setSelection(pos - 1);
                    }
                }
                break;
        }
    }
}