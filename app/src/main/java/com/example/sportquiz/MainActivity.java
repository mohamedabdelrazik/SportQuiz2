package com.example.sportquiz;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int finalScore = 0;
    CheckBox ques1ch1 , ques1ch2 , ques1ch3 , ques4yes , ques4no;
    RadioButton ques2ch1;
    EditText favTeam , ques3 , ques5;
    TextView displayAnswer;
    RatingBar rating;
    String lang , answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView(){
//vvvv
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        ques1ch1 = findViewById(R.id.ques1_cho1);
        ques1ch2 = findViewById(R.id.ques1_cho2);
        ques1ch3 = findViewById(R.id.ques1_cho3);
        ques4yes = findViewById(R.id.ques4_cho1);
        ques4no = findViewById(R.id.ques4_cho2);
        ques2ch1 = findViewById(R.id.ques2_cho1);
        favTeam = findViewById(R.id.favourite_team_name);
        ques3 = findViewById(R.id.ques3_answer);
        ques5 = findViewById(R.id.ques5_answer);
        rating = findViewById(R.id.rating);
        displayAnswer = findViewById(R.id.scoreOfAnswer);
        lang = getIntent().getStringExtra("lang");

        effectOfSelection();
    }

    public void answer(View view) {

        // score answer of every question
        int a1 , a2 , a3 , a4 , a5;

        // question 1
        if (!ques1ch1.isChecked()&&ques1ch2.isChecked()&&!ques1ch3.isChecked()) { a1 = 1; }else { a1 = 0; }

        // question 2
        if (ques2ch1.isChecked()){ a2 = 1; } else { a2 = 0; }

        // question 3
        if (lang.equals("ar")){
            if (ques3.getText().toString().toLowerCase().equals("يوفنتوس")){
                a3 = 1;
            }else {
                a3 = 0;
            }
        }else {
            if (ques3.getText().toString().toLowerCase().equals("juventus")){
                a3 = 1;
            }else {
                a3 = 0;
            }
        }

        // question 4
        if (!ques4yes.isChecked()&&ques4no.isChecked()){
            a4 = 1;
        }else {
            a4 = 0;
        }

        // question 5
        if (lang.equals("ar")){
            if (ques5.getText().toString().toLowerCase().equals("ايطاليا")){
                a5 = 1;
            }else {
                a5 = 0;
            }
        }else {
            if (ques5.getText().toString().toLowerCase().equals("italy")){
                a5 = 1;
            }else {
                a5 = 0;
            }
        }


        finalScore = a1+a2+a3+a4+a5;

        switch (finalScore){
            case 5:
                displayFinalScore(finalScore);
                break;

            case 4:
                displayFinalScore(finalScore);
                break;

            case 3:
                displayFinalScore(finalScore);
                break;

            case 2:
                displayFinalScore(finalScore);
                break;

            case 1:
                displayFinalScore(finalScore);
                break;

                default:
                 displayFinalScore(finalScore);
                break;

        }
    }


    public void hideSoft(View view) {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }

    private void displayFinalScore(int score){
        displayAnswer.setVisibility(View.VISIBLE);
        rating.setVisibility(View.VISIBLE);
        if (favTeam.getText().toString().equals("")) {
            answer =  getResources().getText(R.string.yourScore) + " " + String.valueOf(score);
        }else {
            answer = getResources().getText(R.string.favTeam) + " " + favTeam.getText().toString() +
                    "\n" + getResources().getText(R.string.yourScore) + " " + String.valueOf(score);
        }
        displayAnswer.setText(answer);
        rating.setRating(score);
    }

    private void effectOfSelection(){
        checked(ques1ch1,ques1ch2,ques1ch3);
        checked(ques1ch2,ques1ch3,ques1ch1);
        checked(ques1ch3,ques1ch2,ques1ch1);
        checked(ques4yes,ques4no);
        checked(ques4no,ques4yes);
    }

    private void checked (final CheckBox checkBox , final CheckBox checkBox1 , final CheckBox checkBox2){
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox.isChecked()){
                    checkBox1.setVisibility(View.GONE);
                    checkBox2.setVisibility(View.GONE);
                }else {
                    checkBox1.setVisibility(View.VISIBLE);
                    checkBox2.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void checked (final CheckBox checkBox , final CheckBox checkBox1){
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox.isChecked()){
                    checkBox1.setVisibility(View.GONE);
                }else {
                    checkBox1.setVisibility(View.VISIBLE);
                }
            }
        });
    }


}
