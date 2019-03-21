package com.example.sportquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Locale;

public class Language extends AppCompatActivity {
    String lang;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
    }

    public void btn_arabic(View view) {

        lang = "ar";

        Locale locale =new Locale(lang);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getResources().updateConfiguration(configuration,getResources().getDisplayMetrics());

        intent = new Intent(Language.this,MainActivity.class);
        intent.putExtra("lang",lang);
        startActivity(intent);


    }

    public void btn_english(View view) {

        lang = "en";

        Locale locale =new Locale(lang);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getResources().updateConfiguration(configuration,getResources().getDisplayMetrics());

        intent = new Intent(Language.this,MainActivity.class);
        intent.putExtra("lang",lang);
        startActivity(intent);

    }
}
