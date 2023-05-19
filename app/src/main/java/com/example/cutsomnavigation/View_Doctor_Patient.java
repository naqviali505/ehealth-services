package com.example.cutsomnavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class View_Doctor_Patient extends AppCompatActivity {

    RecyclerView mrecyclerView;
    LinearLayoutManager layoutManager;
    List<ModelClass> userList;
    Adapter_doctor adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_doctor_patient);
        initData();
        initRecyclerView();
    }

    private void initRecyclerView() {
        mrecyclerView=findViewById(R.id.RecyclerView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        mrecyclerView.setLayoutManager(layoutManager);
        adapter=new Adapter_doctor(userList);
        mrecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private void initData() {

        userList = new ArrayList<>();

        userList.add(new ModelClass(R.drawable.p1_d,"Anjali","Anjali@gmail.com","0323-1212414","_______________________________________"));

        userList.add(new ModelClass(R.drawable.p2_d,"Brijesh","Brijesh@gmail.com","0325-1212414","_______________________________________"));

        userList.add(new ModelClass(R.drawable.p3_d,"Sam","Sam@gmail.com","0220-1212414","_______________________________________"));

        userList.add(new ModelClass(R.drawable.p1_d,"Divya","Divya@gmail.com","0340-1212414","_______________________________________"));

        userList.add(new ModelClass(R.drawable.p2_d,"Simran","Simran@gmail.com","0520-1212414","_______________________________________"));

    }

}