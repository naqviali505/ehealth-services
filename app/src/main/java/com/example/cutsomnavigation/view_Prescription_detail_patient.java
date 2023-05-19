package com.example.cutsomnavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class view_Prescription_detail_patient extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_prescription_detail_patient);
        TextView text=(TextView) findViewById(R.id.textView);
        text.setMovementMethod(LinkMovementMethod.getInstance());
    }
}