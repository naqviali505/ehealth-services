package com.example.cutsomnavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class chat_admin extends AppCompatActivity {

    RecyclerView mrecyclerView;
    LinearLayoutManager layoutManager;
    List<Model_Chat> userList;
    Adapter_Chat adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_admin);
        initData();
        initRecyclerView();
    }

    private void initRecyclerView() {
        mrecyclerView=findViewById(R.id.RecyclerView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        mrecyclerView.setLayoutManager(layoutManager);
        adapter=new Adapter_Chat(userList);
        mrecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private void initData() {

        userList = new ArrayList<>();

        userList.add(new Model_Chat("A","Anjali","Razi Ahmed","Hey! Razi is disease cure","_______________________________________"));

        userList.add(new Model_Chat("B","Brijesh","Faiq Mahamood","Hey! Faiq are you ok","_______________________________________"));

        userList.add(new Model_Chat("C","Sam","Salman Amir","Hey! Salman meet me soon","_______________________________________"));

        userList.add(new Model_Chat("D","Divya","Fazan Malik","Hey! Fazan remind to take the medicine","_______________________________________"));

        userList.add(new Model_Chat("E","Simran","Talha Nadeem","Hey! Talha are you well","_______________________________________"));

    }

}