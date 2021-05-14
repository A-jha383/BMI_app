package com.example.android.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //TextView result;
EditText heightv,weightv;
Button calculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        heightv =(EditText)findViewById(R.id.height);
        weightv =(EditText)findViewById(R.id.weight);
//result =(TextView)findViewById(R.id.result);
        calculate =(Button)findViewById(R.id.cal);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hei = heightv.getText().toString();
                String wei = weightv.getText().toString();
               if(hei!=null&&wei!=null&&!hei.equals("")&&!wei.equals("")){
                   Float ht = Float.parseFloat(hei);
                   Float wt = Float.parseFloat(wei);
                   Float bmi = wt/(ht*ht);
                   Intent i = new Intent(MainActivity.this,bmi_output.class);
                   i.putExtra("bmi",bmi.toString());
                   startActivity(i);
                   //result.setText("YOUR BMI IS: "+bmi+" " +cat);
               }
               else{
                   Toast.makeText(MainActivity.this,"please enter valid no",Toast.LENGTH_LONG).show();
               }
            }
        });
    }
}