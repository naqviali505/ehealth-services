package com.example.cutsomnavigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter_Chat extends RecyclerView.Adapter<Adapter_Chat.ViewHolder> {

    private List<Model_Chat> userList;

    public Adapter_Chat(List<Model_Chat>userList) {
        this.userList=userList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat,parent,false);
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //int resource = userList.get(position).getImageview();
        String imageView=userList.get(position).getImageview();
        String name=userList.get(position).getTextview1();
        String msg=userList.get(position).getTextview2();
        String time=userList.get(position).getTextview3();
        String line=userList.get(position).getDivider();

        holder.setData(imageView,name,msg,time);



    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    //view holder class



    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView imageView;
        private TextView textView;
        private TextView textView2;
        private TextView textview3;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //here use xml ids
            //give different name not like constructor
            imageView=itemView.findViewById(R.id.tvIcon);
            textView=itemView.findViewById(R.id.tvEmailSender);
            textView2=itemView.findViewById(R.id.tvEmailTitle);
            textview3=itemView.findViewById(R.id.tvEmailDetails);

        }

        public void setData(String resource, String name, String msg, String time) {

            imageView.setText(resource);
            textView.setText(name);
            textView2.setText(msg);
            textview3.setText(time);
        }
    }
}
