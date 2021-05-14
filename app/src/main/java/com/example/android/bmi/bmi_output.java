package com.example.android.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class bmi_output extends AppCompatActivity {
TextView result;
ImageView backg;
    @SuppressLint("LongLogTag")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_output);
        backg = (ImageView)findViewById(R.id.img);
        result =(TextView) findViewById(R.id.result);
        String val = getIntent().getStringExtra("bmi");
        Log.d("bmi value is   mbjggbhikb:",val);
        float bmi = Float.parseFloat(val);
        String cat="";
        if(bmi<18.5){
            cat=cat+"YOU ARE UNDERWEIGHT.";
            backg.setImageDrawable(getDrawable(R.drawable.under));
            result.setTextColor(getResources().getColor(R.color.red));
        }else if(bmi<24.9){
            backg.setImageDrawable(getDrawable(R.drawable.normal));
            cat=cat+"YOU ARE NORMAL.";
            result.setTextColor(getResources().getColor(R.color.green));
        }else if(bmi<29.9){
            backg.setImageDrawable(getDrawable(R.drawable.losing));
            cat=cat+"YOU ARE OVERWEIGHT.";
            result.setTextColor(getResources().getColor(R.color.red));
        }else{
            backg.setImageDrawable(getDrawable(R.drawable.obis));

            cat=cat+"YOU ARE SUFFERING FROM OBESITY.";
            result.setTextColor(getResources().getColor(R.color.darkred));
        }
        result.setText("YOUR BMI IS: "+bmi+" \n\n" +cat);

    }
}