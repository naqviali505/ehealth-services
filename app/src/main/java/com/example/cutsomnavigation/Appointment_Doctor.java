package com.example.cutsomnavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Appointment_Doctor extends AppCompatActivity {

    RecyclerView mrecyclerView;
    LinearLayoutManager layoutManager;
    List<ModelClass> userList;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_doctor);
        initData();
        initRecyclerView();
    }

    private void initRecyclerView() {
        mrecyclerView=findViewById(R.id.RecyclerView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        mrecyclerView.setLayoutManager(layoutManager);
        adapter=new Adapter(userList);
        mrecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private void initData() {

        userList = new ArrayList<>();

        userList.add(new ModelClass(R.drawable.p1_p,"Razi Ahmed","26-March-2012","11:08 PM","_______________________________________"));

        userList.add(new ModelClass(R.drawable.p2_p,"Faiq Mahamood","28-April-2020","12:08 PM","_______________________________________"));

        userList.add(new ModelClass(R.drawable.p3_p,"Salman Amir","30-May-2021","01:08 PM","_______________________________________"));

        userList.add(new ModelClass(R.drawable.p1_p,"Fazan Malik","1-January-2020","11:08 AM","_______________________________________"));

        userList.add(new ModelClass(R.drawable.p2_p,"Talha Nadeem","1-June-2022","12:08 PM","_______________________________________"));

    }

}