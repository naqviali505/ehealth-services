package com.example.cutsomnavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Manage_Patient_Admin extends AppCompatActivity {

    RecyclerView mrecyclerView;
    LinearLayoutManager layoutManager;
    List<ModelClass> userList;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_doctor_admin);
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

        userList.add(new ModelClass(R.drawable.p1_p,"Razi Ahmed","Razi@gmail.com","0123-1212414","_______________________________________"));

        userList.add(new ModelClass(R.drawable.p2_p,"Faiq Mahamood","Faiq@gmail.com","0456-1212414","_______________________________________"));

        userList.add(new ModelClass(R.drawable.p3_p,"Salman Amir","Salman@gmail.com","0789-1212414","_______________________________________"));

        userList.add(new ModelClass(R.drawable.p1_p,"Fazan Malik","Fazan@gmail.com","0101-1212414","_______________________________________"));

        userList.add(new ModelClass(R.drawable.p2_p,"Talha Nadeem","Talha@gmail.com","0102-1212414","_______________________________________"));

    }

}