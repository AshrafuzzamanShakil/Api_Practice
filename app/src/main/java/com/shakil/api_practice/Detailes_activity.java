package com.shakil.api_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Detailes_activity extends AppCompatActivity {

    TextView textView;
    String Body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailes_activity);
        textView=findViewById(R.id.detailtextid);
        Intent intent=getIntent();
        Body=intent.getStringExtra(RecycleAdapter.Body_text);
        textView.setText(Body);
    }
}