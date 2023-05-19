package com.example.cutsomnavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class View_Presciption_Details_Doctor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_presciption_details_doctor);
        TextView text=(TextView) findViewById(R.id.textView);
        text.setMovementMethod(LinkMovementMethod.getInstance());

    }
}