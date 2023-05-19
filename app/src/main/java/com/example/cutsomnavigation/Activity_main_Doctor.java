package com.example.cutsomnavigation;

//import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.transition.Slide;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Activity_main_Doctor extends AppCompatActivity
{
    NavigationView nav1;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_doctor);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        nav1=(NavigationView)findViewById(R.id.navmenu_doctor);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);

        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        nav1.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem)
            {


                switch (menuItem.getItemId())
                {
                    case R.id.ManageProfile1:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent1 = new Intent(Activity_main_Doctor.this, Manage_Profile_Doctor.class);
                        startActivity(intent1);
                        break;

                    case R.id.Appointment1:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent2 = new Intent(Activity_main_Doctor.this, Appointment_Doctor.class);
                        startActivity(intent2);
                        break;


                    case R.id.view_p_detail1s:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent3 = new Intent(Activity_main_Doctor.this, View_Presciption_Details_Doctor.class);
                        startActivity(intent3);
                        break;

                    case R.id.chat1:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent4 = new Intent(Activity_main_Doctor.this, Chat_Doctor.class);
                        startActivity(intent4);
                        break;
                }

                return true;
            }
        });
    }
}
